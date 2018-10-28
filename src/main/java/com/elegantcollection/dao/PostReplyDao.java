package com.elegantcollection.dao;

import com.elegantcollection.entity.PostReply;
import com.elegantcollection.entity.PostReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PostReplyDao {
    long countByExample(PostReplyExample example);

    int deleteByExample(PostReplyExample example);

    int deleteByPrimaryKey(Integer replyId);

    int insert(PostReply record);

    int insertSelective(PostReply record);

    List<PostReply> selectByExample(PostReplyExample example);

    PostReply selectByPrimaryKey(Integer replyId);

    int updateByExampleSelective(@Param("record") PostReply record, @Param("example") PostReplyExample example);

    int updateByExample(@Param("record") PostReply record, @Param("example") PostReplyExample example);

    int updateByPrimaryKeySelective(PostReply record);

    int updateByPrimaryKey(PostReply record);
}
