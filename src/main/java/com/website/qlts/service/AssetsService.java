package com.website.qlts.service;

import com.website.qlts.repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetsService {
    @Autowired
    private AssetsRepository assetsRepository;

}
