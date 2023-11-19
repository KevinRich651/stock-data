package com.kevin.data.dal.dao

import com.kevin.data.dal.entity.Counter
import org.springframework.data.jpa.repository.JpaRepository
import javax.transaction.Transactional

@Transactional
interface CounterDAO : JpaRepository<Counter?, Int?>
