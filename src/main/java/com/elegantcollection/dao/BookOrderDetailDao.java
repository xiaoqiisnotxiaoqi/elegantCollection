package com.elegantcollection.dao;

import com.elegantcollection.entity.BookOrderDetail;
import com.elegantcollection.entity.BookOrderDetailExample;
import com.elegantcollection.entity.BookOrderDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface BookOrderDetailDao {
    long countByExample(BookOrderDetailExample example);

    int deleteByExample(BookOrderDetailExample example);

    int deleteByPrimaryKey(BookOrderDetailKey key);

    int insert(BookOrderDetail record);

    int insertSelective(BookOrderDetail record);

    List<BookOrderDetail> selectByExample(BookOrderDetailExample example);

    BookOrderDetail selectByPrimaryKey(BookOrderDetailKey key);

    int updateByExampleSelective(@Param("record") BookOrderDetail record, @Param("example") BookOrderDetailExample example);

    int updateByExample(@Param("record") BookOrderDetail record, @Param("example") BookOrderDetailExample example);

    int updateByPrimaryKeySelective(BookOrderDetail record);

    int updateByPrimaryKey(BookOrderDetail record);
}