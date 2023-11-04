package com.kevin.data.dao;

import com.kevin.data.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CounterDAO extends JpaRepository<Counter, Integer> {
}
