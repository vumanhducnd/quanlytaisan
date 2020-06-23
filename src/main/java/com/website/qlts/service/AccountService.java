package com.website.qlts.service;

import com.website.qlts.models.Accounts;

public interface AccountService {
    void save(Accounts user);

    Accounts findByUsername(String username);
}
