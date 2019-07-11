package com.iflytek.tms.service.impl;

import com.iflytek.tms.mapper.UserDao;
import com.iflytek.tms.pojo.User;
import com.iflytek.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiaoFeng
 * @date 2019/4/26 - 13:37
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
      private UserDao userDao;

    @Override
    public User getUserByNameAndPass(User user) {
        return userDao.getUserByNameAndPass(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void updatePassword(User user) {
        userDao.updatePassword(user);
    }


}
