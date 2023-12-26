package com.skm.recipeapp.domain;

import jakarta.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

}
