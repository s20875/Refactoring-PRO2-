package com.pro2.cw1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String login;
    private String hashedPassword;
    private String email;
    private String refreshToken;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Suitcase> suitcases = new ArrayList<>();
}
