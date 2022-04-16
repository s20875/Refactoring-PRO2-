package com.pro2.cw1.services;

import com.pro2.cw1.repositories.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public void addItemToSuitcase(Integer suitcaseId, Integer itemId){
        //adding item to suitcase
    }

    public void setPacked(Integer itemId){
        //setting item as packed
    }
}
