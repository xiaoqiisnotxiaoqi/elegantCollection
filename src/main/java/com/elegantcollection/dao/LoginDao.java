package com.elegantcollection.dao;

import com.elegantcollection.entity.Login;
import com.elegantcollection.entity.LoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface LoginDao {
    long countByExample(LoginExample example);

    int deleteByExample(LoginExample example);

    int deleteByPrimaryKey(Integer loginId);

    int insert(Login record);

    int insertSelective(Login record);

    List<Login> selectByExample(LoginExample example);

    Login selectByPrimaryKey(Integer loginId);

    int updateByExampleSelective(@Param("record") Login record, @Param("example") LoginExample example);

    int updateByExample(@Param("record") Login record, @Param("example") LoginExample example);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
}