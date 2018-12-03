package com.example.demo.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleController {

    @Autowired
    private RuleRepository ruleRepository;

    @RequestMapping("/rule/{id}")
    public Rule getRule(@PathVariable(value = "id") Long ruleId){
        return ruleRepository.getOne(ruleId);
    }
}
