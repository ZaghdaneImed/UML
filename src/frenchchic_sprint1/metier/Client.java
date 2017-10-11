/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frenchchic_sprint1.metier;

/**
 *
 * @author MAROUANE
 */
public class Client {
    private String nom;
    private String prenom;
    private String pseudo;
    private String motDePasse;

    public Client(String nom, String prenom, String pseudo, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    public static Client rechrcheClientParPseudo(String pseudo){
        return new Client("Dupon", "Marie", pseudo, "123456");
    }
    
}
