/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frenchchic_sprint2.vue;

import frenchchic_sprint2.metier.Panier;
import frenchchic_sprint2.controleur.Session;
import frenchchic_sprint2.metier.Produit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAROUANE
 */
public class EcranPanier extends JFrame {

    private JTable panierTable;
    private Panier panier;
    private JTextField tfMtPanier;
    private JLabel lbMtPanier;
    private JLabel lbTitle;

    public EcranPanier() throws HeadlessException {
        panier = Session.clientSession.getPanier();
        setWindow();
    }

    private void setWindow() {
        this.setTitle("French Chic | Panier");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(550, 400));
        this.placeComponents();
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void placeComponents() {
        this.setLayout(null);
        
        lbTitle = new JLabel("<html><span style='font-weight: lighter; font-family: \"MS Sans Serif\"; font-size: 40px; color: #CC00CC;'>Votre Panier</span></html>", (int) CENTER_ALIGNMENT);
        lbTitle.setBounds(0, 0, 500, 150);
        this.add(lbTitle);
        
        JScrollPane scrollPane = new JScrollPane();
        panierTable = new JTable(buildTableModel(panier.getListProduit()));
        scrollPane.setViewportView(panierTable);

        scrollPane.setBounds(0, 150, 550, 100);
        this.add(scrollPane);
        
        lbMtPanier = new JLabel("Montant panier");
        lbMtPanier.setBounds(20, 300, 100, 30);
        this.add(lbMtPanier);
        
        tfMtPanier = new JTextField(40);
        tfMtPanier.setBounds(130, 300, 40, 30);
        this.add(tfMtPanier);
    }

    public DefaultTableModel buildTableModel(Map<Produit, Integer> prods) {
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"Libellé",
            "Prix HT",
            "Quantité",
            "Montant"};

        Object rowData[][] = new Object[prods.size()][4];
        for (int i = 0; i < prods.size(); i++) {
            Produit prodi = (Produit) (prods.keySet().toArray())[i];
            rowData[i][0] = prodi.getNomProduit();
            rowData[i][1] = prodi.getPrixHT();
            rowData[i][2] = prods.get(prodi);
            rowData[i][3] = prods.get(prodi) * prodi.getPrixHT();
            model.addRow(rowData);
        }

        return new DefaultTableModel(rowData, columnNames);

    }
}
