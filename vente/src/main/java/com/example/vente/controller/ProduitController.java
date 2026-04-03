package com.example.vente.controller;

import com.example.vente.model.Produit;
import com.example.vente.service.ProduitService;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    // ➡️ GET : récupérer tous les produits
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.lire();
    }

    // ➡️ POST : créer un nouveau produit
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.creerProduit(produit);
    }

    // ➡️ PUT : modifier un produit existant
    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.modifierProduit(id, produit);
    }

    // ➡️ DELETE : supprimer un produit
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
    }
}

