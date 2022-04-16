package com.pro2.cw1.controllers;

import com.pro2.cw1.models.Suitcase;
import com.pro2.cw1.services.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PutMapping("/addToSuitcase/{suitcaseId}/{itemId}")
    public String addSuitcaseToItem(@PathVariable Integer suitcaseId, @PathVariable Integer itemId){
        itemService.addItemToSuitcase(suitcaseId,itemId);
        return null;
    }

    @PutMapping("/setPacked/{itemId}")
    public String setAsPacked(@PathVariable Integer itemId){
        itemService.setPacked(itemId);
        return null;
    }


}
