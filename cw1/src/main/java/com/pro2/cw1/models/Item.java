package com.pro2.cw1.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idItem;

    private String name;
    private int quantity;
    private boolean isPacked;

    @ManyToMany(mappedBy = "items")
    private List<Suitcase> suitcases = new ArrayList<>();
}
