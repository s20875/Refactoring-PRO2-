package com.pro2.cw1.controllers;

import com.pro2.cw1.models.Suitcase;
import com.pro2.cw1.repositories.SuitcaseRepository;
import com.pro2.cw1.services.SuitcaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/suitcase")
public class SuitcaseController {

    private SuitcaseService suitcaseService;

    public  SuitcaseController(SuitcaseService suitcaseService){
        this.suitcaseService = suitcaseService;
    }

    @GetMapping("/{id}")
    public Suitcase getSuitcase(@PathVariable Integer id){
        //returns suitcase with given id
        return suitcaseService.getSuitcaseById(id);
    }

    @GetMapping("/name/{name}")
    public Suitcase getSuitcaseWithName(@PathVariable String name){
        //returns suitcase with given name
        return suitcaseService.getSuitcaseByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void getSuitcaseWithName(@PathVariable Integer id){
        //delete suitcase
        suitcaseService.deleteSuitcase(id);
    }

}
