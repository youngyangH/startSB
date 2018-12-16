package com.example.demo.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RuleController {

    @Autowired
    private RuleRepository ruleRepository;

    @RequestMapping("/rule/{id}")
    public Rule getRule(@PathVariable(value = "id") Long ruleId){
        return ruleRepository.getOne(ruleId);
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("forward:/index.html");
    }
}
