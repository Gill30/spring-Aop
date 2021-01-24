package com.example.aop.business;

import com.example.aop.Aspect.TimeTrack;
import com.example.aop.DAO.Data1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

    @Autowired
    private Data1 data1;

    @TimeTrack
    public String calculateSomething(){

        //Some business logic
        return data1.retrieveSomething();
    }
}
