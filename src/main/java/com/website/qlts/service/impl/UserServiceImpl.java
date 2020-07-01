package com.website.qlts.service.impl;

import com.website.qlts.entity.User;
import com.website.qlts.repository.UserRepository;
import com.website.qlts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        User tmp = userRepository.save(user);
        return tmp;
    }
}
