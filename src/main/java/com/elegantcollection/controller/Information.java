package com.elegantcollection.controller;

import com.elegantcollection.entity.Customer;
import com.elegantcollection.entity.Message;
import com.elegantcollection.entity.Post;
import com.elegantcollection.entity.PostReply;
import com.elegantcollection.service.BlockService;
import com.elegantcollection.service.CustomerService;
import com.elegantcollection.service.MessageService;
import com.elegantcollection.service.PostService;
import com.elegantcollection.util.Date2String;
import com.elegantcollection.util.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class Information {
    private final MessageService messageService;
    private final PostService postService;
    private final BlockService blockService;
    private final CustomerService customerService;

    @Autowired
    public Information(MessageService messageService, PostService postService, BlockService blockService, CustomerService customerService) {
        this.messageService = messageService;
        this.postService = postService;
        this.blockService = blockService;
        this.customerService = customerService;
    }


    /**
     * 查询所有未查看的消息的数量
     * @param request 请求信息
     * @return 客服没查看的消息数量,书评区未查看的消息的数量,以及 两者 消息的和
     */
    @GetMapping("/notifications")
    public Map<String, Integer> notifications(HttpServletRequest request){
        //从session中得到用户信息
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        Integer custId = customer.getCustId();

        //查看用户未阅读的 客服消息
        Integer messageNum = messageService.quaryNumByRecipientsId(custId).intValue();

        //查看用户未阅读的 书评区消息
        Integer postReplyNum = postService.quaryPstoNumByRecipientsId(custId).intValue();


        //创建 map 并将数据封装到map中并 返回页面
        Map<String,Integer> map = new HashMap<>();

        map.put("messageNum",messageNum);
        map.put("postReplyNum",postReplyNum);
        return  map;
    }

    /**
     * 分页查寻用户的所有未回复消息(客服)
     * @param request 用户的请求信息
     * @param currentPageCode 要查询的页数(第几页)
     * @return 该页的信息
     */
    @GetMapping("/messageView")
    public PageModel<Message> TheMessageView(HttpServletRequest request,String currentPageCode){
        PageModel<Message> pageModel = new PageModel<>();
        //客户要查询的购物车页数
        if (currentPageCode == null){
            pageModel.setCurrentPageCode(1);
        }else {
            pageModel.setCurrentPageCode(Integer.valueOf(currentPageCode));
        }

        //从session中得到用户信息
        Customer customer = (Customer)request.getSession().getAttribute("customer");
        //得到用户id
        Integer custId = customer.getCustId();
        //查询出所有未回复的消息 数量
        List<Message> messageList = messageService.quaryByRecipientsId(custId);

        //用户购物车商品种类数量
        pageModel.setTotalRecord(messageList.size());

        //总页数
        if (messageList.size()%pageModel.getPageSize() !=0 ){
            pageModel.setTotalPages(messageList.size() / pageModel.getPageSize() + 1);
        }else{
            pageModel.setTotalPages(messageList.size() / pageModel.getPageSize());
        }

        //从第几条记录开始
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize() );

        //分页查询,得到数据
        List<Message> list = messageService.quaryMessageByPage(custId,14,pageModel.getStartRecord());

        pageModel.setModelList(list);


        return pageModel;
    }


    /**
     * 分页查寻用户的所有未回复消息(书评区) 并将分页查询出来的数据改为已读状态
     * @param request 用户的请求信息
     * @param currentPageCode  请求页数
     * @return 该页的信息
     */
    @GetMapping("/postReplyView")
    public PageModel<Map<String,Object>> ThePostReplyView(HttpServletRequest request, String currentPageCode){
        PageModel<Map<String,Object>> pageModel = new PageModel<>();
        //客户要查询的回复消息页数
        if (currentPageCode == null){
            pageModel.setCurrentPageCode(1);
        }else {
            pageModel.setCurrentPageCode(Integer.valueOf(currentPageCode));
        }

        //从session中得到用户信息
        Customer customer = (Customer)request.getSession().getAttribute("customer");
        //得到用户id
        Integer custId = customer.getCustId();
        //查询出所有未回复的消息 数量
        List<PostReply> postReplyList = postService.quaryPostReplyByRecipientsId(custId);
        if (postReplyList == null){
            return null;
        }

        //用户购物车商品种类数量
        pageModel.setTotalRecord(postReplyList.size());

        //总页数
        if (postReplyList.size()%pageModel.getPageSize() !=0 ){
            pageModel.setTotalPages(postReplyList.size() / pageModel.getPageSize() + 1);
        }else{
            pageModel.setTotalPages(postReplyList.size() / pageModel.getPageSize());
        }

        //从第几条记录开始
        pageModel.setStartRecord((pageModel.getCurrentPageCode() - 1) * pageModel.getPageSize() );

        //分页查询,得到数据
        List<PostReply> list = postService.quaryPostReplyByPage(custId,14,pageModel.getStartRecord());

        List<Map<String,Object>> returnList = new ArrayList<>();

        for (PostReply postReply:list){
            //创建map 用于封装要返回的消息
            Map<String,Object> map = new HashMap<>();

            //将 返回的消息 改为 已读状态
            postService.alterPostReplyIdBy(postReply);
            //判断 该消息是回复帖子,还是 回复 评论
            if (postReply.getByReplyId() != null) {
                //查找 该消息回复 的评论的详情
                PostReply postReply1 = postService.queryPostReplyByReplyId(postReply.getByReplyId().toString());
                //封装 被回复人的id 被回复的消息内容
                map.put("byPostReply",postReply1.getCustId());
                map.put("byPostReplyText",postReply1.getReplyText());
            }else{
                //查找该消息回复的帖子的详情
                Post post = postService.queryPostByPostId(postReply.getPostId());
                //封装回复人的id 被回复消息的类容 (标题)
                String byPostReplyText  =  "<<" + post.getPostTitle() + ">>";

                map.put("byPostReply",post.getCustId());
                map.put("byPostReplyText",byPostReplyText);

            }
            //封装回复人的id 该消息 id  消息内容
            map.put("postReply",postReply.getCustId());
            map.put("postReplyId",postReply.getReplyId());
            map.put("postReplyText",postReply.getReplyText());
            returnList.add(map);


        }
        pageModel.setModelList(returnList);

        return pageModel;

    }


    /**
     * 回复用户消息(回复帖子的评论,并非回复帖子),并刷新页面数据
     * @param replyId 要回复消息的id
     * @param text 回复内容
     * @param request 用户的请求信息
     * @return 分页方式的用户未查看的消息
     */
    @PostMapping("writeBack")
    public PageModel<Map<String,Object>> writeBack(@Param("replyId") String replyId,@Param("text") String text, HttpServletRequest request){
        if (persistentReplyMessages(replyId,text,request) == null){
            return null;
        }else {
            //查找未回复的消息 并以分页方式 返回
            return ThePostReplyView(request,"1");
        }
    }


    /**
     * 删除回复消息(更改该消息状态为 1)
     * @param replyId 要删除的消息的id
     * @param request 用户的请求信息
     * @return 如果该用户为 该帖子的发帖人 则更改该消息的状态,并返回新的未读消息界面,否则返回null
     */
    @DeleteMapping("deleteReply")
    public  PageModel<Map<String,Object>> deleteReply(String replyId,HttpServletRequest request){
        //得到用户的信息
        Customer customer = (Customer)request.getSession().getAttribute("customer");
        //查看该用户 是否为帖子的 发帖人
        Boolean b = postService.queryNoneThePoster(customer.getCustId(),replyId);
        if (b){
            //用户是帖子的发帖人: 更改消息状态
            postService.removeByReplyId(replyId);
            //返回新的 未读消息列表
            return ThePostReplyView(request,"1");
        }else {
            //用户不是帖子的发帖人: 返回null
            return null;
        }
    }


    /**
     * 回复一级 或二级消息 并返回 该层的所有子回复
     * @param replyId 要回复消息的id
     * @param text 回复内容
     * @param request 用户的请求信息
     * @return 用户所回复的楼层的子回复(分页显示/第一页)
     */
    @PostMapping("/ReplyLevelMessage")
    public PageModel<Map<String,Object>> ReplyLevel1or2Message(@Param("replyId") String replyId,@Param("text") String text, HttpServletRequest request){
        System.out.println("replyId============>"+ replyId);
        System.out.println("text==============>" + text);
        //将消息持久化到数据库中
        Map<String,Integer> map = persistentReplyMessages(replyId,text,request);

        //判断持久化操作是否成功
        if (map == null){
            return null;
        }
        Integer postId = map.get("postId");
        Integer floor = map.get("floor");

        //得到层主的详细信息
        Customer customer = postService.queryLayerMain(postId,floor.toString());

        System.out.println(customer);

        //得到该层的前8条 子回复 按时间排序
        List<PostReply> postReplies = blockService.quarySubreplies(postId,floor.toString(),0);

        PageModel<Map<String,Object>> pageModel = new PageModel<>();

        //得到所有的子回复的数量
        int postReplyNum = blockService.quaryAllSubreplies(postId,floor.toString()).intValue();


        //将子回复的数量 存入map中
        map.put("childBackNum", postReplyNum);


        List<Map<String, Object>> list = new ArrayList<>();
        //子回复当前页码
        pageModel.setCurrentPageCode(1);
        //子回复每页显示数量
        pageModel.setPageSize(8);
        //子回复的总记录数
        pageModel.setTotalRecord(postReplyNum);
        //子回复的总页数
        pageModel.setTotalPages(postReplyNum % 10 == 0 ? postReplyNum / 10 : (postReplyNum / 10) + 1);
        //子回复的从第几条记录开始显示
        pageModel.setStartRecord(0);
        //子回复到第几条记录结束
        pageModel.setEndRecord(7);

        for (PostReply postReply:postReplies){
            Map<String, Object> map1 = new HashMap<>();
            Customer customer1 = customerService.quaryCustomerById(postReply.getCustId());
            //得到用户的头像,并封装到map1中
            map1.put("custProfile", customer1.getCustProfile());
            //得到用户的昵称,并封装到map1中
            map1.put("custName", customer1.getCustName());
            //得到该消息的回复时间
            map1.put("childDate", Date2String.date2StringYMDHms(postReply.getReplyTime()));
            //得到子回复的 id
            map1.put("replyId",postReply.getReplyId().toString());


            //查看被回复人id 如果不是该层 层主id 则将被回复人id加入map1中
            if (!Integer.valueOf(postReply.getByRead()).equals(customer.getCustId())) {
                Customer customer2 = customerService.quaryCustomerById(Integer.valueOf(postReply.getByRead()));
                map1.put("byReplyId", customer2.getCustName());
            }

            //将该条回复内容放入map中
            map1.put("replytext", postReply.getReplyText());
            list.add(map1);
        }
        pageModel.setModelList(list);


        return pageModel;
    }

    /**
     * 将回复消息 持久到数据库中
     * @param replyId 要回复消息的id
     * @param text 回复内容
     * @param request 用户的请求信息
     * @return 数据库受影响条数
     */
    private  Map<String,Integer> persistentReplyMessages(String replyId,String text, HttpServletRequest request){
        Customer customer = (Customer)request.getSession().getAttribute("customer");
        if (customer == null){
            return null;
        }
        //得到要回复的消息的详情
        PostReply oldPostReply = postService.queryPostReplyByReplyId(replyId);

        //将用户回复内容 封装成对象
        PostReply postReply = new PostReply();
        //发帖id
        postReply.setPostId(oldPostReply.getPostId());
        //被回复的评论id
        postReply.setByReplyId(Integer.valueOf(replyId));
        //回复人id
        postReply.setCustId(customer.getCustId());
        //被回复人id
        postReply.setByRead(oldPostReply.getCustId().toString());

        //回复的消息所在帖子的id
        postReply.setPostId(oldPostReply.getPostId());
        //reply_text 回复内容
        postReply.setReplyText(text);
        //reply_time 回复时间
        postReply.setReplyTime(new Date());
        //is_reply_id 是否已读(0 未读 1 已读)
        postReply.setIsReplyId(0);
        //reply_status 回复状态(0 可显示 1 不可显示(删除))
        postReply.setReplyStatus(0);
        //所在的楼层
        postReply.setRedundancyField1(oldPostReply.getRedundancyField1());

        Map<String,Integer> map = new HashMap<>();
        map.put("postId",oldPostReply.getPostId());
        map.put("floor",Integer.valueOf(oldPostReply.getRedundancyField1()));
        // 将回复内容持久化
        if (postService.addPostReply(postReply) == 1){
            return map;
        }else {
            return null;
        }
    }


    /**
     * 将用户回复帖子的消息持久化到数据库中
     * @param postId 要回复的帖子id
     * @param text 回复的内容
     * @return 消息集合
     */
    public Map<String,String> replyTheOriginalPoster(Integer postId,String text){


        return null;
    }






}
