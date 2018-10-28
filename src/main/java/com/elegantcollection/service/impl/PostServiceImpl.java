package com.elegantcollection.service.impl;

import com.elegantcollection.dao.CustomerDao;
import com.elegantcollection.dao.PostDao;

import com.elegantcollection.dao.PostReplyDao;
import com.elegantcollection.entity.*;
import com.elegantcollection.service.PostService;
import com.elegantcollection.util.PageModel;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PostServiceImpl implements PostService{
    private final PostReplyDao postReplyDao;
    private final PostDao postDao;
    private final CustomerDao customerDao;

    @Autowired
    public PostServiceImpl(PostReplyDao postReplyDao, PostDao postDao, CustomerDao customerDao) {
        this.postReplyDao = postReplyDao;
        this.postDao = postDao;
        this.customerDao = customerDao;
    }


    @Override
    public Long quaryPstoNumByRecipientsId(Integer recipientsId) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andByReadEqualTo(recipientsId.toString()).andIsReplyIdEqualTo(0);
        return postReplyDao.countByExample(postReplyExample);

    }

    @Override
    public List<PostReply> quaryPostReplyByRecipientsId(Integer recipientsId) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andByReadEqualTo(recipientsId.toString()).andIsReplyIdEqualTo(0);
        return postReplyDao.selectByExample(postReplyExample);
    }

    @Override
    public List<PostReply> quaryPostReplyByPage(Integer byRead, Integer pageSize, Integer startRecord) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.setLimit(pageSize);
        postReplyExample.setOffset(startRecord.longValue());
        postReplyExample.createCriteria().andByReadEqualTo(byRead.toString()).andIsReplyIdEqualTo(0);
        return postReplyDao.selectByExample(postReplyExample);
    }

    @Override
    public PostReply queryPostReplyByReplyId(String replyId) {
        return postReplyDao.selectByPrimaryKey(Integer.valueOf(replyId));
    }

    @Override
    public Integer addPostReply(PostReply postReply) {
        return postReplyDao.insert(postReply);
    }

    @Override
    public Integer removeByReplyId(String replyId) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andByReadEqualTo(replyId);
        PostReply postReply = new PostReply();
        postReply.setReplyStatus(1);
        return postReplyDao.updateByExample(postReply,postReplyExample);
    }

    @Override
    public Boolean queryNoneThePoster(Integer custId, String replyId) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andReplyIdEqualTo(Integer.parseInt(replyId));
        List<PostReply> postReplies = postReplyDao.selectByExample(postReplyExample);
        PostReply postReply;
        //判断查询结果是否为空
        if (postReplies != null){
            postReply = postReplies.get(0);
        }else {
            return null;
        }

        PostExample postExample = new PostExample();
        postExample.createCriteria().andPostIdEqualTo(postReply.getPostId());
        List<Post> posts = postDao.selectByExample(postExample);
        //判断查询出来的结果是否为空
        if (posts.size() != 0) {
            Post post = posts.get(0);
            return post.getCustId().equals(custId);
        }else {
            return null;
        }
    }

    @Override
    public void alterPostReplyIdBy(PostReply postReply) {
        postReply.setIsReplyId(1);
        postReplyDao.updateByPrimaryKey(postReply);
    }

    @Override
    public Post queryPostByPostId(Integer postId) {
        return postDao.selectByPrimaryKey(postId);
    }

    @Override
    public Customer queryLayerMain(Integer postId, String floor) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andPostIdEqualTo(postId).andRedundancyField1EqualTo(floor).andByReplyIdIsNull();
        PostReply postReply = postReplyDao.selectByExample(postReplyExample).get(0);
        return customerDao.selectByPrimaryKey(postReply.getCustId());
    }


    /**
     * 将用户回复内容持久化到数据库中
     * @param postId 书评帖id
     * @param text 回复的内容
     * @param request 用户的请求信息
     * @return 持久化操作是否成功 ("err","用户未登陆") ("success","回复添加完成") ("err","回复添加失败")
     */
    @Override
    public Map<String,String> replyOriginalPoster(Integer postId, String text, HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        Customer customer = (Customer)request.getSession().getAttribute("customer");
        if (customer == null){
            map.put("err","用户未登陆");
            return map;
        }
        //查询 该书评帖 详情
        Post post = queryPostByPostId(postId);

        //根据帖子id 查询帖子的所有一级回复数量
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andPostIdEqualTo(postId).andByReplyIdIsNull();
        //得到所有的楼层
        Long num = postReplyDao.countByExample(postReplyExample);
        //创建postReply 详情
        PostReply postReply = new PostReply();
        //得到 书评帖id
        postReply.setPostId(postId);
        //得到 回复人id
        postReply.setCustId(customer.getCustId());
        //得到 被回复人id
        postReply.setByRead(post.getCustId().toString());
        //得到回复内容
        postReply.setReplyText(text);
        //得到回复时间
        postReply.setReplyTime(new Date());
        //读取状态
        postReply.setIsReplyId(0);
        //评论状态
        postReply.setReplyStatus(0);
        //楼层数
        int count = num.intValue() + 1;
        postReply.setRedundancyField1(Integer.toString(count));

        System.out.println(postReply);
        //将回复详情 持久化到数据库中
        int a = postReplyDao.insert(postReply);
        if (a == 1){
            map.put("success","回复添加完成");
            return map;
        }else {
            map.put("err","回复添加失败");
            return map;
        }
    }

    /*-----------------------------------------------------------------------------*/


    @Override
    public Integer add(Post post) {
        return postDao.insert(post);
    }

    @Override
    public List<Post> queryStickPost(Integer blockId) {
        PostExample postExample = new PostExample();
        postExample.setLimit(5);
        postExample.setOffset(0L);
        postExample.createCriteria().andIsStickEqualTo(1).andPostPetnameEqualTo(blockId.toString());
        return postDao.selectByExample(postExample);
    }

    @Override
    public Integer queryPost4Size(Integer blockId) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andIsStickEqualTo(0).andPostPetnameEqualTo(blockId.toString());
        return postDao.selectByExample(postExample).size();
    }

    @Override
    public PageModel<Post> queryPost(Integer blockId, PageModel<Post> pageModel) {
        PostExample postExample = new PostExample();
        postExample.setLimit(pageModel.getPageSize());
        postExample.setOffset(Long.valueOf(pageModel.getStartRecord()));
        postExample.createCriteria().andIsStickEqualTo(0).andPostPetnameEqualTo(blockId.toString());
        pageModel.setModelList(postDao.selectByExample(postExample));
        return pageModel;
    }

    @Override
    public Integer queryBestPost4Size(Integer blockId) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andPostStatusEqualTo(1).andPostPetnameEqualTo(blockId.toString());
        return postDao.selectByExample(postExample).size();
    }

    @Override
    public PageModel<Post> queryBestPost(Integer blockId, PageModel<Post> pageModel) {
        PostExample postExample = new PostExample();
        postExample.setLimit(pageModel.getPageSize());
        postExample.setOffset(Long.valueOf(pageModel.getStartRecord()));
        postExample.createCriteria().andPostStatusEqualTo(1).andPostPetnameEqualTo(blockId.toString());
        pageModel.setModelList(postDao.selectByExample(postExample));
        return pageModel;
    }

    @Override
    public List<Post> queryBestPopularPost() {
        PostExample postExample = new PostExample();
        postExample.setLimit(10);
        postExample.setOffset(0L);
        postExample.setOrderByClause("reply_count");
        postExample.createCriteria().andPostStatusBetween(0, 1);
        return postDao.selectByExample(postExample);
    }

    @Override
    public Integer addReplyCount(Integer postId) {
        Integer replyCount = postDao.selectByPrimaryKey(postId).getReplyCount() + 1;
        Post post = new Post();
        post.setPostId(postId);
        post.setReplyCount(replyCount);
        return postDao.updateByPrimaryKey(post);
    }

    @Override
    public Integer queryPostNumber(Integer blockId) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andPostStatusBetween(0, 1).andPostPetnameEqualTo(blockId.toString());
        return postDao.selectByExample(postExample).size();
    }


}

