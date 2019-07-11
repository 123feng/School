package com.iflytek.tms.mapper;

import com.iflytek.tms.pojo.User;

import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/4/26 - 14:33
 */
public interface UserDao {
    public User  getUserByNameAndPass(User user);
    public User getUserById(Integer id);
    public  void  updateUser(User user);
    public void updatePassword(User user);
}
