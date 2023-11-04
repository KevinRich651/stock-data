package com.kevin.data.service;

import com.kevin.data.dao.CounterDAO;
import com.kevin.data.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CounterService {
    private int id = 1;
    @Autowired
    private CounterDAO counterDAO;

    public int getCounter() {
        Counter c = counterDAO.findById(id).orElseGet(() -> {
            Counter nc = new Counter();
            nc.setCount(0);
            nc.setId(id);
            return nc;
        });
        return c.getCount();
    }

    public int upsertCount() {
        Counter c = counterDAO.findById(id).orElseGet(() -> {
            Counter nc = new Counter();
            nc.setCount(0);
            nc.setId(id);
            return nc;
        });
        c.setCount(c.getCount() + 1);
        counterDAO.save(c);
        return c.getCount();
    }

    public int clearCount() {
        Counter c = counterDAO.findById(id).orElseGet(() -> {
            Counter nc = new Counter();
            nc.setCount(0);
            nc.setId(id);
            return nc;
        });
        c.setCount(0);
        counterDAO.save(c);
        return c.getCount();
    }
}
