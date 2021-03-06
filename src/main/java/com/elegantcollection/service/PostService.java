package com.elegantcollection.service;

import com.elegantcollection.entity.Customer;
import com.elegantcollection.entity.Post;
import com.elegantcollection.entity.PostReply;
import com.elegantcollection.util.PageModel;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PostService {
    /**
     * 根据收信人得id查找该用户未阅读的书评区回复
     * @param recipientsId 收信人id
     * @return 该收信人未阅读的书评区回复数量
     */
    Long quaryPstoNumByRecipientsId(Integer recipientsId);


    /**
     * 根据收信人得id查找该用户未阅读的书评回复
     * @param recipientsId 收信人id
     * @return 收信人未阅读的书评内容集合
     */
    List<PostReply> quaryPostReplyByRecipientsId(Integer recipientsId);


    /**
     * 根据收信人得id 分页查找该用户未阅读的书评回复
     * @param byRead 被回复人id
     * @param pageSize 一页显示多少数据
     * @param startRecord 从第几条数据开始显示
     * @return 当前页 要显示的 消息集合
     */
    List<PostReply> quaryPostReplyByPage(Integer byRead, Integer pageSize, Integer startRecord);

    /**
     * 根据消息id查找该消息详情
     * @param replyId 消息id
     * @return 该消息对象
     */
     PostReply queryPostReplyByReplyId(String replyId);

    /**
     * 将回复内容持久化到数据库中
     * @param postReply 回复的消息对象
     * @return 数据库受影响行数
     */
    Integer addPostReply(PostReply postReply);


    /**
     * 删除回复内容(修改 该消息的状态为1)
     * @param replyId 要删除的回复id
     * @return 数据库受影响行数
     */
    Integer removeByReplyId(String replyId);

    /**
     * 查看用户是否为该书评贴发帖人
     * @param custId 用户id
     * @param replyId 消息id
     * @return 如果是发帖人返回 true 否则返回false
     */
    Boolean queryNoneThePoster(Integer custId, String replyId);

    /**
     * 修改消息状态为已读
     * @param postReply  要修改的消息对象
     */
    void alterPostReplyIdBy(PostReply postReply);

    /**
     * 根据帖子id查询帖子详情
     * @param postId 帖子id
     * @return 帖子对象
     */
    Post queryPostByPostId(Integer postId);

    /**
     * 根据帖子id 以及 楼层数 查找出 该层 层主的详细信息
     * @param postId 书评帖id
     * @param floor 层主id
     * @return 层主的详细信息
     */
    Customer queryLayerMain(Integer postId, String floor);


    /**
     * 将用户回复内容持久化到数据库中
     * @param postId 书评帖id
     * @param text 回复的内容
     * @param request 用户的请求信息
     * @return 持久化操作是否成功
     */
    Map<String,String> replyOriginalPoster(Integer postId, String text, HttpServletRequest request);

    /**
     * 添加帖子
     * @param post 帖子
     * @return 添加结果
     */
    HashMap<String,String> add(Post post, HttpServletRequest request);
    /**
     * 置顶帖查询（前五条）
     *
     * @param blockId 板块id
     * @return 置顶帖(五条)
     */
    List<Post> queryStickPost(Integer blockId);

    /**
     * 本版块帖子数量查询—去除置顶帖
     *
     * @param blockId 板块id
     * @return 帖子数量
     */
    Integer queryPost4Size(Integer blockId);

    /**
     * 本版块帖子查询—去除置顶帖
     *
     * @param blockId   板块id
     * @param pageModel 分页
     * @return 帖子集合
     */
    PageModel<Post> queryPost(Integer blockId, PageModel<Post> pageModel);

    /**
     * 精品贴数量（分页）
     *
     * @param blockId 板块id
     * @return 帖子数量
     */
    Integer queryBestPost4Size(Integer blockId);

    /**
     * 本版块精品帖查询
     *
     * @param blockId   板块id
     * @param pageModel 分页
     * @return 帖子集合
     */
    PageModel<Post> queryBestPost(Integer blockId, PageModel<Post> pageModel);

    /**
     * 全板块回复数最多帖子十条
     *
     * @return 帖子集合
     */
    List<Post> queryBestPopularPost();

    /**
     * 帖子回复数+1
     *
     * @param postId 帖子Id
     * @return
     */
    Integer addReplyCount(Integer postId);

    /**
     * 本版块帖子数量查询
     *
     * @param blockId 板块id
     * @return 帖子数量
     */
    Integer queryPostNumber(Integer blockId);

    /*-----------------------------------数据接口---------------------------------*/


}
