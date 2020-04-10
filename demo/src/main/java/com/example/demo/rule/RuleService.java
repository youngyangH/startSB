package com.example.demo.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    @Autowired
    private RuleRepositoryImpl ruleRepository;

    public Rule findById(Long id) {
        return ruleRepository.getOne(id);
    }
}
