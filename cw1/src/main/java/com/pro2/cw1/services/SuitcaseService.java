package com.pro2.cw1.services;

import com.pro2.cw1.models.Suitcase;
import com.pro2.cw1.repositories.SuitcaseRepository;
import org.springframework.stereotype.Service;

@Service
public class SuitcaseService {

    private SuitcaseRepository suitcaseRepository;

    public SuitcaseService(SuitcaseRepository suitcaseRepository){
        this.suitcaseRepository = suitcaseRepository;
    }

    public Suitcase getSuitcaseById(Integer id){
        //returns suitcase with given id
        return null;
    }

    public Suitcase getSuitcaseByName(String name){
        //returns suitcase with given name
        return null;
    }

    public void deleteSuitcase(Integer id){
        //deleting suitcase
    }
}
