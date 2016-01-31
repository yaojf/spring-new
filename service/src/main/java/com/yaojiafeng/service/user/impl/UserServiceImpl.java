package com.yaojiafeng.service.user.impl;

import com.yaojiafeng.dao.bean.User;
import com.yaojiafeng.service.user.UserService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by yaojiafeng on 16/1/31.
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    @Async
    public User getUser(int userID) {
        return new User();
    }
}
