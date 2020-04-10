package com.example.demo.RuleScenario;

import com.example.demo.rule.Rule;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleScenarioController {

    @Autowired
    private RuleScenarioRepository ruleScenarioRepository;

    @GetMapping("/rc/{id}")
    public RuleScenario getScenario(@PathVariable(value = "id") Long rcId){
        return ruleScenarioRepository.getOne(rcId);
    }

    @PostMapping("/rc/{id}")
    public Boolean createRuleScenario() {
        Rule rule1 = new Rule("test");
        Rule rule2 = new Rule("test2");
        RuleScenario ruleScenario = new RuleScenario();
        ruleScenario.setRuleList(List.of(rule1, rule2));

        Rule rule11 = new Rule("test11");
        Rule rule22 = new Rule("test22");
        RuleScenario ruleScenario2 = new RuleScenario();
        ruleScenario2.setRuleList(List.of(rule11, rule22));
        ruleScenarioRepository.saveAll(List.of(ruleScenario, ruleScenario2));
        return true;
    }

}
