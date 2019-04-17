package com.koulgar.config.com.koulgar.dao;

import com.koulgar.config.com.koulgar.entitiy.User;


public interface UserDao {
    User findByUserName(String userName);
    void save(User user);
}
