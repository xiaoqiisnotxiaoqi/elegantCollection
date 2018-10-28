package com.elegantcollection.dao;

import com.elegantcollection.entity.BookOrder;
import com.elegantcollection.entity.BookOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BookOrderDao {
    long countByExample(BookOrderExample example);

    int deleteByExample(BookOrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(BookOrder record);

    int insertSelective(BookOrder record);

    List<BookOrder> selectByExampleWithBLOBs(BookOrderExample example);

    List<BookOrder> selectByExample(BookOrderExample example);

    BookOrder selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") BookOrder record, @Param("example") BookOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") BookOrder record, @Param("example") BookOrderExample example);

    int updateByExample(@Param("record") BookOrder record, @Param("example") BookOrderExample example);

    int updateByPrimaryKeySelective(BookOrder record);

    int updateByPrimaryKeyWithBLOBs(BookOrder record);

    int updateByPrimaryKey(BookOrder record);
}