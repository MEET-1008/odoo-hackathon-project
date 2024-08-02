package com.codewithbrinda.scm.scm0_2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String price;
    private String productImage;
    private String description;
    private Boolean favorite=false;




    @ManyToOne
    private User user;




}
