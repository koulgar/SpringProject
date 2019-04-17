package com.koulgar.dao;

import com.koulgar.entitiy.User;


public interface UserDao {
    User findByUserName(String userName);
    void save(User user);
}
