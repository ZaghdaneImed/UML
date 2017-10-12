package frenchchic_sprint2.metier;

public class Produit {

    private String nomProduit;
    private float prixHT;

    public Produit(String nomProduit, float prixHT) {
        this.nomProduit = nomProduit;
        this.prixHT = prixHT;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public float getPrixHT() {
        return prixHT;
    }

}
