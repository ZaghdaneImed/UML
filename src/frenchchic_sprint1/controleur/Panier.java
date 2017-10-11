package frenchchic_sprint1.controleur;
import frenchchic_sprint1.metier.Produit;
import java.util.ArrayList;

public class Panier {
    private ArrayList<Produit> listProduit;

    public Panier() {
        this.listProduit = new ArrayList<>();
    }

    public ArrayList<Produit> getListProduit() {
        return listProduit;
    }
    
}
