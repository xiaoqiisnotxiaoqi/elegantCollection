package com.elegantcollection.service;

import com.elegantcollection.entity.Block;
import com.elegantcollection.entity.Post;
import com.elegantcollection.entity.PostReply;

import java.util.Date;
import java.util.List;

public interface BlockService {

    /**
     * 根据书评区板块id 查找该板块的详情
     * @param blockId 板块id
     * @return 该板块的详细信息(Block对象)
     */
    Block quaryBlockByBlockId(Integer blockId);

    /**
     * 根据模块的id 查询 所有的帖子的数量
     * @param blockId 模块id
     * @return 该模块所拥有的帖子
     */
    Long quaryAllPostByBlockId(Integer blockId);


    /**
     * 根据书评帖子的id 查询出直接回复帖子的 所有评论的数量
     * @param postId  书评帖子的id
     * @return 该书评贴的所有直接回复的数量
     */
    Long quaryAllPostReplyNum(Integer postId);


    /**
     * 根据书评帖子的id 分页查询出直接回复帖子的评论
     * @param postId  书评帖子的id
     * @param startRecord 当前页的起始条数
     * @return 该书评贴的所有直接回复的数量
     */
    List<PostReply> quaryPostReplyByPostId(Integer postId,Integer startRecord);


    /**
     * 根据帖子的id 回复的楼层 查询该回复的所有子回复的数量
     * @param postId 帖子id
     * @param floor 楼层
     * @return 该楼层的所有子回复的数量
     */
    Long quaryAllSubreplies(Integer postId,String floor);


    /**
     * 根据帖子的id , 回复的楼层 分页查询该回复的所有子回复
     * @param postId 帖子id
     * @param floor 楼层
     * @param startRecord 当前页的起始条数
     * @return 该楼层的所有子回复
     */
    List<PostReply> quarySubreplies(Integer postId,String floor,Integer startRecord);


    /**
     * 根据用户帖子的id 查询该帖子的回复总数量
     * @param postId 书评帖id
     * @return 该书评帖的 总回复数
     */
    Long quaryAllReview(Integer postId);


    /**
     * 返回三天内的帖子
     * @param date 三天前的日期
     * @return 三天内的所有帖子
     */
    List<Post> quaryPostByTime(Date date);


    /**
     * 得到楼主的 的 评论  (直接评论)
     * @param postId 帖子id
     * @param custId 用户id
     * @return 楼主直接 评论的数量
     */
    Long quaryAllLandlordPostReplyNum(Integer postId,Integer custId);


    /**
     * 分页得到楼主对自己的书评贴的直接回复 集合
     * @param postId 帖子id
     * @param custId 用户id
     * @param startRecord 开始记录的条数
     * @return 分页显示出楼主对自己的书评贴的直接回复
     */
    List<PostReply> quaryLandlordPostReplyByPostId(Integer postId,Integer custId,Integer startRecord);


}
