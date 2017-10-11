package frenchchic_sprint1.vue;

import frenchchic_sprint1.controleur.Session;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EcranAccueilPerso extends JFrame {

    private JLabel lbTitle;
    private JLabel lbWelcome;
    private JLabel lbProduct;

    public EcranAccueilPerso() throws HeadlessException {
        setWindow();
    }


    private void setWindow() {
        this.setTitle("French Chic | Accueil Perso");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(600, 500));
        this.placeComponents();
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    private void placeComponents() {
        this.setLayout(null);

        lbTitle = new JLabel("<html><span style='font-weight: lighter; font-family: \"MS Sans Serif\"; font-size: 40px; color: #CC00CC;'>French Chic</span></html>", (int) CENTER_ALIGNMENT);
        lbTitle.setBounds(0, 0, 500, 150);
        this.add(lbTitle);
        
        lbWelcome = new JLabel("<html><span style='font-weight: lighter; font-family: \"MS Sans Serif\"; font-size: 12px;'>Bonjour " + Session.clientSession.getPrenom() + " " + Session.clientSession.getNom() + "</span></html>");
        lbWelcome.setBounds(110, 150, 200, 30);
        this.add(lbWelcome);
        
        lbProduct = new JLabel("<html><span style='font-weight: lighter; font-family: \"MS Sans Serif\"; font-size: 12px;'>Bonjour " + Session.clientSession.getPrenom() + " " + Session.clientSession.getNom() + "</span></html>");
        lbProduct.setBounds(110, 150, 200, 30);
        this.add(lbProduct);

    }
}
