package com.koulgar.service;

import com.koulgar.entitiy.User;
import com.koulgar.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);
    void save(CrmUser crmUser);
}
