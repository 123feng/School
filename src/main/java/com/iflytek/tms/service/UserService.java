package com.iflytek.tms.service;

import com.iflytek.tms.pojo.User;

/**
 * @author XiaoFeng
 * @date 2019/4/26 - 13:36
 */
public interface UserService {
    public User getUserByNameAndPass(User user);
    public  void  updateUser(User user);
    public User getUserById(Integer id);
    public void updatePassword(User user);
}
