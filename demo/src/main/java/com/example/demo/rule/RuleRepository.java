package com.example.demo.rule;

import org.springframework.data.jpa.repository.JpaRepository;

//@NoRepositoryBean
public interface RuleRepository extends JpaRepository<Rule, Long> {

}
