package com.example.vente.model;

import jakarta.persistence.*;

@Entity
@Table(name ="Produit")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    public User() {}

    public Long getId() { return id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}