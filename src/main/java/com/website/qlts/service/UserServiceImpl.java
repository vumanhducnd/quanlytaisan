//package com.website.qlts.service;
//
//import com.website.qlts.models.User;
//import com.website.qlts.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//public class UserServiceImpl  implements UserService{
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Override
//    public void save(User user) {
//            user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
//            user.setRole(user.getRole());
//            userRepository.save(user);
//    }
//}
