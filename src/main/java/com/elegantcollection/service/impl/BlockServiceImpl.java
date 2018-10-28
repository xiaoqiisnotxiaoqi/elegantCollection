package com.elegantcollection.service.impl;

import com.elegantcollection.dao.BlockDao;
import com.elegantcollection.dao.PostDao;
import com.elegantcollection.dao.PostReplyDao;
import com.elegantcollection.entity.*;
import com.elegantcollection.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    private final BlockDao blockDao;
    private final PostDao postDao;
    private final PostReplyDao postReplyDao;

    @Autowired
    public BlockServiceImpl(BlockDao blockDao, PostDao postDao, PostReplyDao postReplyDao) {
        this.blockDao = blockDao;
        this.postDao = postDao;
        this.postReplyDao = postReplyDao;
    }


    @Override
    public Block quaryBlockByBlockId(Integer blockId) {
        return blockDao.selectByPrimaryKey(blockId);
    }

    @Override
    public Long quaryAllPostByBlockId(Integer blockId) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andPostPetnameEqualTo(blockId.toString()).andPostStatusNotEqualTo(2);
        return postDao.countByExample(postExample);
    }

    @Override
    public Long quaryAllPostReplyNum(Integer postId) {
        // 查询出直接回复帖子的 所有评论(按楼层的顺序排列)

        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andPostIdEqualTo(postId).andByReplyIdIsNull().andReplyStatusEqualTo(0);
        postReplyExample.setOrderByClause("redundancy_field1 ASC");
        return postReplyDao.countByExample(postReplyExample);
    }

    @Override
    public List<PostReply> quaryPostReplyByPostId(Integer postId,Integer startRecord) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andPostIdEqualTo(postId).andByReplyIdIsNull().andReplyStatusEqualTo(0);
        postReplyExample.setOrderByClause("redundancy_field1 ASC");
        postReplyExample.setLimit(10);
        postReplyExample.setOffset(startRecord.longValue());
        return postReplyDao.selectByExample(postReplyExample);
    }

    @Override
    public Long quaryAllSubreplies(Integer postId, String floor) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andPostIdEqualTo(postId).andRedundancyField1EqualTo(floor).andByReplyIdIsNotNull().andReplyStatusEqualTo(0);
        return postReplyDao.countByExample(postReplyExample);
    }

    @Override
    public List<PostReply> quarySubreplies(Integer postId, String floor,Integer startRecord) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andPostIdEqualTo(postId).andRedundancyField1EqualTo(floor).andByReplyIdIsNotNull().andReplyStatusEqualTo(0);
        postReplyExample.setOrderByClause("reply_time ASC");
        postReplyExample.setLimit(8);
        postReplyExample.setOffset(startRecord.longValue());
        return postReplyDao.selectByExample(postReplyExample);
    }

    @Override
    public Long quaryAllReview(Integer postId) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andPostIdEqualTo(postId).andReplyStatusEqualTo(0);
        return postReplyDao.countByExample(postReplyExample);
    }

    @Override
    public List<Post> quaryPostByTime(Date date) {
        PostExample postExample = new PostExample();
        postExample.createCriteria().andPostTimeGreaterThan(date).andPostStatusNotEqualTo(2);
        return postDao.selectByExample(postExample);
    }

    @Override
    public Long quaryAllLandlordPostReplyNum(Integer postId, Integer custId) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andPostIdEqualTo(postId).andByReplyIdIsNull().andCustIdEqualTo(custId).andReplyStatusEqualTo(0);
        return postReplyDao.countByExample(postReplyExample);
    }

    @Override
    public List<PostReply> quaryLandlordPostReplyByPostId(Integer postId, Integer custId, Integer startRecord) {
        PostReplyExample postReplyExample = new PostReplyExample();
        postReplyExample.createCriteria().andPostIdEqualTo(postId).andByReplyIdIsNull().andCustIdEqualTo(custId).andReplyStatusEqualTo(0);
        postReplyExample.setLimit(8);
        postReplyExample.setOffset(startRecord.longValue());
        return postReplyDao.selectByExample(postReplyExample);
    }
}
