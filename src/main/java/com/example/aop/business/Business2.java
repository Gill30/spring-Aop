package com.example.aop.business;

import com.example.aop.DAO.Data2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {

    @Autowired
    private Data2 data2;

    public String calculateSomething(){

        //Some business logic
        return data2.retrieveSomething();
    }
}
