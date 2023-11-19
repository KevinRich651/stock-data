package com.kevin.data.service

import com.kevin.data.dal.dao.CounterDAO
import com.kevin.data.dal.entity.Counter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CounterService {
    private val id = 1

    @Autowired
    private lateinit var counterDAO: CounterDAO

    fun getCount():Int{
        val cnt = counterDAO.findById(id).orElse(Counter(id=1,count=0))
        counterDAO.save(cnt!!)
        return cnt.count
    }
    fun upsertCount(): Int {
        val cnt = counterDAO.findById(id).orElse(Counter(id=1,count=0))!!
        cnt.count = cnt.count+1
        counterDAO.save(cnt)
        return cnt.count
    }

    fun clearCount(): Int {
        val cnt = counterDAO.findById(id).orElse(Counter(id=1,count=0))!!
        cnt.count = 0
        counterDAO.save(cnt)
        return cnt.count
    }
}

