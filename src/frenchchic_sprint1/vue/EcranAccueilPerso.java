package frenchchic_sprint1.vue;

import frenchchic_sprint1.controleur.Session;
import frenchchic_sprint1.metier.Produit;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EcranAccueilPerso extends JFrame implements ActionListener{
    
    private Produit dayProduct;
    private JLabel lbTitle;
    private JLabel lbWelcome;
    private JLabel lbProduct;
    private JTextField tfQt;
    
    private JButton btnAddProduct;

    public EcranAccueilPerso() throws HeadlessException {
        
        dayProduct = new Produit("pantalon zouk", 100);
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
        
        lbProduct = new JLabel("Le produit du jour est le " + dayProduct.getNomProduit() + " au prix HT de " + dayProduct.getPrixHT() + "€");
        lbProduct.setBounds(110, 190, 350, 30);
        this.add(lbProduct);
        
        lbProduct = new JLabel("Quantité");
        lbProduct.setBounds(220, 260, 60, 30);
        this.add(lbProduct);
        
        tfQt = new JTextField(20);
        tfQt.setBounds(290, 260, 40, 30);
        this.add(tfQt);
        
        btnAddProduct = new JButton("Ajouter le produit du jour au panier");
        btnAddProduct.setBackground(Color.lightGray);
        btnAddProduct.setBorder(null);
        btnAddProduct.addActionListener(this);
        btnAddProduct.setBounds(190, 350, 230, 30);
        this.add(btnAddProduct);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddProduct) {
            System.out.println("add to panier");
        }
    }
}
