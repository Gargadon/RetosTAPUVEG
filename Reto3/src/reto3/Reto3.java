/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Reto3 extends JFrame {

    public static void main(String[] args) {

        JButton botonJtattoo = new JButton("Interfaz con librería JTattoo");
        JButton botonFlatlaf = new JButton("Interfaz con librería FlatLaf");
        JButton botonMaterial = new JButton("Interfaz con librería Material-UI-Swing");
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Reto3 reto3 = new Reto3();
        
        panelPrincipal.setLayout(new GridLayout(3, 1, 10, 10));
        panelPrincipal.add(botonJtattoo);
        panelPrincipal.add(botonFlatlaf);
        panelPrincipal.add(botonMaterial);
        
        reto3.setContentPane(panelPrincipal);

        reto3.pack();
        reto3.setLocationRelativeTo(null);
        reto3.setVisible(true);
        reto3.setTitle("Menú principal");
        reto3.setResizable(false);
        reto3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botonJtattoo.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new JTattooUI());
        });
        
        botonFlatlaf.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new FlatLafUI());
        });
        
        botonMaterial.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new MaterialUI());
        });
    }

}
