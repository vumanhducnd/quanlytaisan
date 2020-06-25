package com.website.qlts.config;

import com.website.qlts.models.User;
import com.website.qlts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.getByUserName(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Not found" + username));
        return optionalUser.map(MyUserDetails::new).get();
    }
}
