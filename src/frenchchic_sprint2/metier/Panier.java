package frenchchic_sprint2.metier;

import frenchchic_sprint2.metier.Produit;
import java.util.HashMap;
import java.util.Map;

public class Panier {

    private Map<Produit, Integer> mapProduit;

    public Panier() {
        this.mapProduit = new HashMap<>();
    }

    public Map<Produit, Integer> getListProduit() {
        return mapProduit;
    }

}
