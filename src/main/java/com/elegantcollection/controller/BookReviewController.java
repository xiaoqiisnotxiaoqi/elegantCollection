package com.elegantcollection.controller;

import com.elegantcollection.entity.Block;
import com.elegantcollection.entity.Customer;
import com.elegantcollection.entity.Post;
import com.elegantcollection.entity.PostReply;
import com.elegantcollection.service.BlockService;
import com.elegantcollection.service.CustomerService;
import com.elegantcollection.service.PostService;
import com.elegantcollection.util.Date2String;
import com.elegantcollection.util.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;


@RestController
public class BookReviewController {
    private final PostService postService;
    private final BlockService blockService;
    private final CustomerService customerService;

    @Autowired
    public BookReviewController(PostService postService, BlockService blockService, CustomerService customerService) {
        this.postService = postService;
        this.blockService = blockService;
        this.customerService = customerService;
    }


    /**
     * 根据帖子的id获得板块的信息
     *
     * @return 板块的相关信息
     */
    @GetMapping("/reviewHead")
    public Map<String, Object> getReviewHead(Integer postId, HttpServletRequest request) {
        if (postId == null) {
            request.getSession().setAttribute("postId", 10004);
            postId = (Integer) request.getSession().getAttribute("postId");
        }
        //根据书评id 查询出书评的详细信息
        Post post = postService.queryPostByPostId(postId);
        //根据书评模块的id 查询出 该模块的详细信息
        Block block = blockService.queryByBlockId(Integer.valueOf(post.getPostPetname()));
        Map<String, Object> map = new HashMap<>();
        //将 模块名存入map中
        map.put("blockName", block.getBlockName());
        //将 模块的图片地址存入map中
        map.put("blockImg", block.getBlockIma());
        //根据模块id 查询出该模块的书评的数量
        Long postNum = blockService.quaryAllPostByBlockId(Integer.valueOf(post.getPostPetname()));
        //将模块的 书评数量 封装到map中
        map.put("postNum", postNum);
        //将模块的 标题 封装到map中
        map.put("postName", post.getPostTitle());
        //根据 发帖人id 得到发帖人详情
        Customer customer = customerService.quaryCustomerById(post.getCustId());
        //将 该书评贴的id:postId  发帖人的id:custId 以及 发帖人的昵称:custName放入 map中
        map.put("postId", postId);
        map.put("custId", post.getCustId());
        map.put("custName", customer.getCustName());
        return map;
    }


    /**
     * 分页查询帖子的 回复信息
     *
     * @param postId      帖子的id
     * @param currentPage 要查询的页数
     * @return 回复信息的pageModel对象
     */
    @GetMapping("/reviewTheDetails")
    public PageModel<Map<String, Object>> reviewTheDetails(Integer postId, String currentPage, HttpServletRequest request) {
        if (postId == null) {
            postId = (Integer) request.getSession().getAttribute("postId");
        }
        //确定 用户请求的页数
        Integer currentPageCode;
        if (currentPage == null || Integer.valueOf(currentPage) < 1) {
            currentPageCode = 1;
        } else {
            currentPageCode = Integer.valueOf(currentPage);
        }

        //得到 该用户请求的帖子的所有直接回复并按楼层顺序排列
        int allPostReplieNum = blockService.quaryAllPostReplyNum(postId).intValue();

        //查询当前页 所要显示的回复消息
        List<PostReply> postReplies = blockService.quaryPostReplyByPostId(postId, (currentPageCode - 1) * 10);

        //得到该帖子的总回复数
        Integer all = blockService.quaryAllReview(postId).intValue();

        return findAllReplies(all, allPostReplieNum, currentPageCode, postReplies);
    }


    /**
     * 查询 热度最高的 10个书评帖
     *
     * @return 是个热门帖子
     */
    @GetMapping("/finTopReview")
    public List<Map<String, Object>> finTopReview() {

        Calendar c = Calendar.getInstance();

        //过去三天(测试 100天)
        c.setTime(new Date());
        c.add(Calendar.DATE, -90);
        //得到 三天前的 事件对象
        Date oldDate = c.getTime();
        //查询这三天内的所有的帖子
        List<Post> posts = blockService.quaryPostByTime(oldDate);
        Map<Post, Integer> map = new HashMap<>();


        //循环遍历所有帖子,放入map中
        for (Post post : posts) {
            int num = blockService.quaryAllReview(post.getPostId()).intValue();
            map.put(post, num);
        }
        System.out.println(map.size());
        //将map中的数据按 value(回复数量) 排序,并截取前面的前面的十个
        List<Post> mobileList = map.entrySet().stream()
                .sorted((Map.Entry<Post, Integer> o1, Map.Entry<Post, Integer> o2) -> o2.getValue() - o1.getValue())
                .map(Map.Entry::getKey).collect(Collectors.toList())
                .subList(0, 9);
        mobileList.retainAll(map.keySet());


        //创建list 用于 封装返回的数据
        List<Map<String, Object>> list = new ArrayList<>();
        for (Post post : mobileList) {
            //重新创建map
            Map<String, Object> map1 = new HashMap<>();
            //该书评贴的回复数量
            map1.put("num", map.get(post));
            //书评帖的标题
            map1.put("title", post.getPostTitle());
            //书评贴的id
            map1.put("postId", post.getPostId());
            //将map1 加入list集合中
            list.add(map1);
        }
        return list;
    }


    /**
     * 分页查询帖子的 回复信息(仅查看楼主的书评回复)
     *
     * @param postId      帖子id
     * @param currentPage 要查看的页数
     * @param custId      楼主id
     * @return 回复信息的pageModel对象
     */
    @GetMapping("/lookLandlord4Port")
    public PageModel<Map<String, Object>> lookLandlord(Integer postId, Integer currentPage, Integer custId) {
        //确定 用户请求的页数
        Integer currentPageCode;
        if (currentPage == null || currentPage < 1) {
            currentPageCode = 1;
        } else {
            currentPageCode = currentPage;
        }

        //得到 该用户请求的帖子的 楼主的 直接回复并按楼层顺序排列
        int allPostReplieNum = blockService.quaryAllLandlordPostReplyNum(postId, custId).intValue();


        //查询当前页 所要显示的回复消息
        List<PostReply> postReplies = blockService.quaryLandlordPostReplyByPostId(postId, custId, (currentPageCode - 1) * 10);

        //得到该帖子的总回复数
        Integer all = blockService.quaryAllReview(postId).intValue();

        return findAllReplies(all, allPostReplieNum, currentPageCode, postReplies);
    }


    /**
     * 返回用户请求页面 的书评区详情页面的 所有回复消息
     *
     * @param all              该帖子的总回复数
     * @param AllPostReplieNum 该用户请求的帖子的所有直接回复的消息数量(直接回复楼主的消息数量)
     * @param currentPageCode  用户请求的页数
     * @param postReplies      查询当前页 所要显示的 直接回复的消息(当前页所要显示的直接回复楼主的消息集合)
     * @return 直接回复楼主消息的 pageModel对象 和所有子回复的pageModel对象
     */
    private PageModel<Map<String, Object>> findAllReplies(Integer all, Integer AllPostReplieNum, Integer currentPageCode, List<PostReply> postReplies) {
        PageModel<Map<String, Object>> pageModel = new PageModel<>();
        //每页显示条数
        pageModel.setPageSize(10);

        //将用户请求页面存入pageModel 中 (当前页面)
        pageModel.setCurrentPageCode(currentPageCode);

        //将总的 回复数 存入 pageModal中
        pageModel.setTotalRecord(all);

        //得到 该回复的所有页数
        pageModel.setTotalPages(AllPostReplieNum % 10 == 0 ? (AllPostReplieNum / 10) : (AllPostReplieNum / 10) + 1);

        //当跳转的页面 不存在时  跳转至 尾页
        if (currentPageCode > pageModel.getTotalPages()) {
            currentPageCode = pageModel.getTotalPages();
        }

        //得到 当前页的回复从那一条开始
        pageModel.setStartRecord((currentPageCode - 1) * 10);

        //当前页数据到哪一条结束
        pageModel.setEndRecord(currentPageCode * 10 - 1);


        List<Map<String, Object>> list = new ArrayList<>();

        //遍历集合 查询出 所有 需要封装的信息
        for (PostReply postReply : postReplies) {
            Map<String, Object> map = new HashMap<>();

            //查询回复消息人的详细信息
            Customer customer = customerService.quaryCustomerById(postReply.getCustId());
            System.out.println(customer);


            //得到用户的头像,并封装到map中
            map.put("custProfile", customer.getCustProfile());
            //得到用户的昵称,并封装到map中
            map.put("custName", customer.getCustName());
            //得到用户的积分,并封装到map中
            map.put("custPoints", customer.getCustPoints());
            //将该条回复内容放入map中
            map.put("replytext", postReply.getReplyText());
            //得到该回复的楼层
            map.put("replyFloor", postReply.getRedundancyField1());
            //得到该回复的事件
            map.put("date", Date2String.date2StringYMDHms(postReply.getReplyTime()));
            //得到该回复的id
            map.put("postReplyId", postReply.getReplyId());


            Map<String, Object> childMap = getChildBack(customer, postReply.getPostId(), postReply.getRedundancyField1(), 1);
            //将子回复的数量 存入map中
            map.put("childBackNum", childMap.get("allNum"));
            //将该条回复的所有子回复加入map中
            map.put("childBack", childMap.get("postReplyPageModel"));
            list.add(map);
        }
        pageModel.setModelList(list);
        return pageModel;
    }


    /**
     * 分页查询出 某一层回复的所有子回复
     *
     * @param customer        层主详情 (对象)
     * @param postId          帖子id
     * @param floor           所在的楼层
     * @param currentPageCode 要跳转的页数
     * @return 子回复的pageModel对象
     */
    private Map<String, Object> getChildBack(Customer customer, Integer postId, String floor, Integer currentPageCode) {

        //当 要跳转的页数 为空 或者为为负数是 返回首页
        if (currentPageCode == null || currentPageCode < 1) {
            currentPageCode = 1;
        }

        PageModel<Map<String, Object>> postReplyPageModel = new PageModel<>();

        //根据帖子的id 回复的楼层 查询该回复的所有子回复
        int postReplyNum = blockService.quaryAllSubreplies(postId, floor).intValue();

        //当要跳转的页数 大于总页数时 ,则跳转到 尾页.
        if (currentPageCode > postReplyNum) {
            currentPageCode = postReplyNum;
        }


        if (postReplyNum != 0) {
            List<Map<String, Object>> list = new ArrayList<>();
            //子回复当前页码
            postReplyPageModel.setCurrentPageCode(currentPageCode);
            //子回复每页显示数量
            postReplyPageModel.setPageSize(8);
            //子回复的总记录数
            postReplyPageModel.setTotalRecord(postReplyNum);
            //子回复的总页数
            postReplyPageModel.setTotalPages(postReplyNum % 8 == 0 ? postReplyNum / 8 : (postReplyNum / 8) + 1);
            //子回复的从第几条记录开始显示
            postReplyPageModel.setStartRecord((currentPageCode - 1) * 8);
            //子回复到第几条记录结束
            postReplyPageModel.setEndRecord(currentPageCode * 8 - 1);
            //查询当页的所有的子消息
            List<PostReply> postReplyList = blockService.quarySubreplies(postId, floor, postReplyPageModel.getStartRecord());

            for (PostReply p : postReplyList) {
                System.out.println(p.getByRead());
                Map<String, Object> map1 = new HashMap<>();
                Customer customer1 = customerService.quaryCustomerById(p.getCustId());
                //得到用户的头像,并封装到map1中
                map1.put("custProfile", customer1.getCustProfile());
                //得到用户的昵称,并封装到map1中
                map1.put("custName", customer1.getCustName());
                //得到该消息的回复时间
                map1.put("childDate", Date2String.date2StringYMDHms(p.getReplyTime()));
                //得到子回复的 id
                map1.put("replyId", p.getReplyId().toString());


                //查看被回复人id 如果不是该层 层主id 则将被回复人id加入map1中
                if (!Integer.valueOf(p.getByRead()).equals(customer.getCustId())) {
                    Customer customer2 = customerService.quaryCustomerById(Integer.valueOf(p.getByRead()));
                    map1.put("byReplyId", customer2.getCustName());
                }

                //将该条回复内容放入map中
                map1.put("replytext", p.getReplyText());
                list.add(map1);
            }
            postReplyPageModel.setModelList(list);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("postReplyPageModel", postReplyPageModel);
        map.put("allNum", postReplyNum);


        return map;
    }


    /**
     * 子回复指定页面跳转
     *
     * @param postId          书评帖id
     * @param currentPageCode 要跳转的页面
     * @param floor           所在的楼层
     * @return 当前页面所有的子回复的pageModel对象
     */
    @GetMapping("/subreplyPageJump")
    public PageModel<Map<String, Object>> subreplyPageJump(Integer postId, String floor, Integer currentPageCode) {
        System.out.println("reply ============>" + postId);
        System.out.println("floor ============>" + floor);
        System.out.println("currentPageCode ============>" + currentPageCode);


        //查询出 层主的详细信息
        Customer customer = postService.queryLayerMain(postId, floor);

        Map<String, Object> map = getChildBack(customer, postId, floor, currentPageCode);
        return (PageModel<Map<String, Object>>) map.get("postReplyPageModel");
    }


    /**
     * 持久化对帖子的直接回复
     *
     * @param postId 书评帖id
     * @param text   评论内容
     * @return 持久化是否成功 ("err","用户未登陆") ("success","回复添加完成") ("err","回复添加失败")
     */
    @PutMapping("/replyOriginalPoster")
    public Map<String, String> replyOriginalPoster(@Param("postId") Integer postId, @Param("text") String text, HttpServletRequest request) {
        System.out.println("postId============>" + postId);
        System.out.println("text============>" + text);
        return postService.replyOriginalPoster(postId, text, request);
    }


    /**
     * 板块搜索 模糊查询
     *
     * @param queries 搜素的内容
     * @param request 用户请求信息
     * @return 成功(" success ") 失败/没有搜索到符合要求的板块 ("false")
     */
    @GetMapping("/queries")
    public String blockSearch(String queries, HttpServletRequest request) {
        //根据用户输入的内容 查询书评板块详情
        Block block = blockService.queryBlocksByQueries(queries);
        //判断用户搜索的内容是否存在,若存在 则继续 若不存在 则返回 false
        if (block == null) {
            return "false";
        }
        //将block的id存入 session中,以便页面跳转后 能够进入 当前的 block 板块中
        request.getSession().setAttribute("blockId", block.getBlockId());
        return "success";
    }


    /**
     * 帖子搜索  模糊查询
     *
     * @param queries 用户的搜素内容
     * @param request 用户的请求信息
     * @return 搜索结果
     */
    @GetMapping("/postSearch")
    public String postSearch(String queries, HttpServletRequest request) {
        //根据用户输入的内容 查询书评 详情 列表
        System.out.println(queries);
        List<Post> posts = blockService.queryPostsByQueries(queries);
        System.out.println(posts);
        //判断用户搜索的内容 是否存在 ,若 存在 则继续 若不存在 返回 false
        if (posts.size() == 0) {
            return "false";
        }
        //将查询到的 结过 存入 session中
        request.getSession().setAttribute("postSearch", posts);
        return "success";
    }

    /**
     * 帖子搜索,跳转后页面渲染
     *
     * @return 要搜索内容的 pageModel对象
     */
    @GetMapping("/postSearchPage")
    public PageModel<Map<String, Object>> postSearchPage(HttpServletRequest request, Integer pageNum) {
        List<Post> posts = (List<Post>) request.getSession().getAttribute("postSearch");

        if (posts.size() == 0) {
            return null;
        }

        List<Map<String, Object>> list = new ArrayList<>();

        PageModel<Map<String, Object>> pageModel = new PageModel<>();

        if (pageNum == null) {
            pageNum = 1;
        }
        //总记录数
        pageModel.setTotalRecord(posts.size());
        //总页数
        pageModel.setTotalPages(posts.size() % 10 == 0 ? posts.size() / 10 : (posts.size() / 10) + 1);
        //当前页码
        pageModel.setCurrentPageCode(pageNum);
        //每页显示记录数
        pageModel.setPageSize(10);
        //本页 从哪一个数据开始获取
        pageModel.setStartRecord((pageNum - 1) * 10);
        //查看当前页的数据量为多少
        if (posts.size() - pageModel.getStartRecord() >= 10) {
            //本页到那个数据结束
            pageModel.setEndRecord(pageNum * 10 - 1);
        } else {
            //本页到那个数据结束
            pageModel.setEndRecord(posts.size() - 1);
        }

        for (int i = pageModel.getStartRecord(); i <= pageModel.getEndRecord(); i++) {
            Post post = posts.get(i);
            Map<String, Object> map = new HashMap<>();
            //将postId放入 map中
            map.put("postId", post.getPostId());
            //将postTitle放入map中
            map.put("postTitle", post.getPostTitle());
            //得到发帖人的详情
            Customer customer = customerService.quaryCustomerById(post.getCustId());
            //将发帖人的id 存入 map中
            map.put("custName", customer.getCustName());
            //得到 帖子的内容
            String text = blockService.quaryTextByPostId(post.getPostId());
            //将帖子的内容放入map中
            map.put("text", text);
            //得到所有的评论数
            Integer num = blockService.quaryAllReplyNumByPostId(post.getPostId());
            //将所有的评论数 放入map中
            map.put("num", num);

            list.add(map);
        }
        pageModel.setModelList(list);
        return pageModel;
    }


}
