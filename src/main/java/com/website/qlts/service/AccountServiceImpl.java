package com.website.qlts.service;

import com.website.qlts.models.Accounts;
import com.website.qlts.repository.AccountRepository;
import com.website.qlts.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Accounts accounts) {
        accounts.setPassWord(bCryptPasswordEncoder.encode(accounts.getPassWord()));
        accounts.setRoles(new HashSet<>(roleRepository.findAll()));
        accountRepository.save(accounts);
    }

    @Override
    public Accounts findByUsername(String username) {
        return accountRepository.findByUserName(username);
    }
}
