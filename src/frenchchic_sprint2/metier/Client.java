/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frenchchic_sprint2.metier;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author MAROUANE
 */
public class Client {

    private String nom;
    private String prenom;
    private String pseudo;
    private String motDePasse;
    private Panier panier;

    public String getPseudo() {
        return pseudo;
    }

    public Client(String nom, String prenom, String pseudo, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.panier = new Panier();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public static Client rechrcheClientParPseudo(String pseudo) {
        return new Client("Dupon", "Marie", pseudo, "123456");
    }

    public Panier getPanier() {
        return panier;
    }

}
