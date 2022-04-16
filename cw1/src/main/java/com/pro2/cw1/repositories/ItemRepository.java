package com.pro2.cw1.repositories;

import com.pro2.cw1.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Integer> {

}
