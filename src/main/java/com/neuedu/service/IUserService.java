package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;

import java.util.List;

public interface IUserService {

    public UserInfo login(UserInfo userInfo) throws MyException;

    List<UserInfo> getAllUser();

     int insert(UserInfo userInfo);
     int updateById(UserInfo userInfo);
     UserInfo selectById(int id);
     int deleteById(int id);

}
