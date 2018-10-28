package com.elegantcollection.dao;

import com.elegantcollection.entity.BookImg;
import com.elegantcollection.entity.BookImgExample;
import com.elegantcollection.entity.BookImgKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BookImgDao {
    long countByExample(BookImgExample example);

    int deleteByExample(BookImgExample example);

    int deleteByPrimaryKey(BookImgKey key);

    int insert(BookImg record);

    int insertSelective(BookImg record);

    List<BookImg> selectByExample(BookImgExample example);

    BookImg selectByPrimaryKey(BookImgKey key);

    int updateByExampleSelective(@Param("record") BookImg record, @Param("example") BookImgExample example);

    int updateByExample(@Param("record") BookImg record, @Param("example") BookImgExample example);

    int updateByPrimaryKeySelective(BookImg record);

    int updateByPrimaryKey(BookImg record);
}