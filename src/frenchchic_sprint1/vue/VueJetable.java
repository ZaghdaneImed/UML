/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frenchchic_sprint1.vue;

import frenchchic_sprint1.controleur.Session;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author ASUS
 */

// vue jetable
public class VueJetable extends JFrame {
    
    
    public VueJetable() {
        this.setTitle("French Chic");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 400));
        this.setLocation(200, 200);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //EcranAccueil ecranAccueil = 
        Session session = new Session();
        session.traiterConnexion();
    }
    
}
