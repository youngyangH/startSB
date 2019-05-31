package com.example.demo.RuleScenario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleScenarioController {

    @Autowired
    private RuleScenarioRepository ruleScenarioRepository;

    @RequestMapping("/rc/{id}")
    public RuleScenario getRule(@PathVariable(value = "id") Long rcId){
        return ruleScenarioRepository.getOne(rcId);
    }

}
