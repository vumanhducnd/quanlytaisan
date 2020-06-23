package com.website.qlts.repository;

import com.website.qlts.models.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AccountRepository extends JpaRepository<Accounts,Long> {
    Accounts findByUserName(String userName);
}
