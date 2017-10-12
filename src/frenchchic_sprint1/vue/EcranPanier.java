/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frenchchic_sprint1.vue;

import frenchchic_sprint1.controleur.Panier;
import frenchchic_sprint1.controleur.Session;
import frenchchic_sprint1.metier.Produit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAROUANE
 */
public class EcranPanier extends JFrame {

    private JTable panierTable;
    private Panier panier;

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
        JScrollPane scrollPane = new JScrollPane();
        panierTable = new JTable(buildTableModel(panier.getListProduit()));
        scrollPane.setViewportView(panierTable);
        
        scrollPane.setBounds(0, 0, 550, 400);
        this.add(scrollPane);
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
