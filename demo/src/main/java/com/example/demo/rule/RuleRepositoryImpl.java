package com.example.demo.rule;

//@Repository("RuleRepository")
public class RuleRepositoryImpl {

    public Rule getOne(Long id) {
        return getRule();
    }

    private Rule getRule() {
        return new Rule("23");
    }
}
