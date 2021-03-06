package com.example.demo.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/rule")
//@Profile(value = "hana") //Enable with profile hana
public class RuleController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private RuleService ruleService;

    @RequestMapping("/{id}")
    public Rule getRule(@PathVariable(value = "id") Long ruleId){
        return ruleService.findById(ruleId);
    }

    @RequestMapping("/insert/{id}")
    public String insertRule(@PathVariable(value = "id") Long ruleId){
         jdbcTemplate.execute("insert into \"BIZX_BIZXTEST\".\"RULE\" values("+ ruleId + ",'Rule2');\n");
         return "Success saved";
    }

    @RequestMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("forward:/index.html");
    }
}
