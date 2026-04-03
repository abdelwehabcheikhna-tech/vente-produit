package com.example.vente.service;

import com.example.vente.model.Produit;
import com.example.vente.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProduitService {
    Produit creerProduit(Produit produit);
    List<Produit> lire();
    String supprimerProduit(Long id);

    Produit modifierProduit(Long id, Produit produit);
}

@Service
class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit creerProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public String supprimerProduit(Long id) {
        produitRepository.deleteById(id);
        return "produit supprimer";
    }

    @Override
    public Produit modifierProduit(Long id, Produit produit) {
        return produitRepository.findById(id)
                .map(p -> {
                    p.setNom(produit.getNom());
                    p.setPrix(produit.getPrix());
                    p.setDescription(produit.getDescription());
                    return produitRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }
}
