/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AthleticRaceInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Nombre: David Emmanuel Kantún Marín
 * Matrícula: 22032378
 * Módulo: Tópicos Avanzados de Programación v2
 * Asesor: Andrés Espinal Jiménez
 * Fecha: 25 de abril de 2024
 */
public class Interfaz extends JFrame {
    static String resultado = "";
    static JTextArea resultados;
    JLabel labelRegistrarCorredor;
    JTextField registrarCorredor;
    JButton botonRegistrarCorredor;
    JLabel labelCorredoresRegistrados;
    JTextArea corredoresRegistrados;
    JLabel labelResultados;
    JButton botonIniciar;
    JButton botonReiniciar;
    JButton botonTerminar;
    JPanel panelPrincipal;
    JPanel panelCorredor;
    JPanel arriba;
    JPanel centro;
    JPanel abajo;
    JPanel panelResultados;
    JPanel botones;

    public Interfaz() {

        setTitle("Athletic Race Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        // Genero los elementos graficos
        labelRegistrarCorredor = new JLabel("Registrar corredor");
        registrarCorredor = new JTextField();
        botonRegistrarCorredor = new JButton("Registrar");
        labelCorredoresRegistrados = new JLabel("Corredores registrados");
        corredoresRegistrados = new JTextArea();
        corredoresRegistrados.setEditable(false);
        labelResultados = new JLabel("Resultados");
        resultados = new JTextArea();
        resultados.setEditable(false);
        
        botonIniciar = new JButton("Iniciar");
        botonReiniciar = new JButton("Reiniciar");
        botonTerminar = new JButton("Terminar");

        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1, 10, 5));

        panelCorredor = new JPanel();
        panelCorredor.setLayout(new GridLayout(1, 2, 10, 5));
        panelCorredor.add(registrarCorredor);
        panelCorredor.add(botonRegistrarCorredor);
        
        arriba = new JPanel();
        arriba.setLayout(new BorderLayout());
        arriba.add(labelRegistrarCorredor, BorderLayout.CENTER);
        arriba.add(panelCorredor, BorderLayout.SOUTH);
        
        centro = new JPanel();
        centro.setLayout(new BorderLayout());
        centro.add(labelCorredoresRegistrados, BorderLayout.NORTH);
        centro.add(corredoresRegistrados, BorderLayout.CENTER);

        panelResultados = new JPanel();
        panelResultados.setLayout(new GridLayout(1, 2, 10, 5));
        panelResultados.add(resultados);

        botones = new JPanel();
        botones.setLayout(new GridLayout(3, 1, 10, 5));
        botones.add(botonIniciar);
        botones.add(botonReiniciar);
        botones.add(botonTerminar);
        botonIniciar.setEnabled(false);
        botonReiniciar.setEnabled(false);

        panelResultados.add(botones);
        
        abajo = new JPanel();
        abajo.setLayout(new BorderLayout());
        abajo.add(labelResultados, BorderLayout.NORTH);
        abajo.add(panelResultados, BorderLayout.CENTER);

        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(arriba);
        panelPrincipal.add(centro);
        panelPrincipal.add(abajo);

        setContentPane(panelPrincipal);
                
        Listeners listeners = new Listeners();
        listeners.recibeRegistrarCorredor(registrarCorredor);
        listeners.recibeCorredoresRegistrados(corredoresRegistrados);
        botonRegistrarCorredor.addActionListener(listeners);
        listeners.recibeBotonRegistrarCorredor(botonRegistrarCorredor);
        botonIniciar.addActionListener(listeners);
        listeners.recibeBotonIniciar(botonIniciar);
        botonReiniciar.addActionListener(listeners);
        listeners.recibeBotonReiniciar(botonReiniciar);
        botonTerminar.addActionListener(listeners);
        listeners.recibeBotonTerminar(botonTerminar);
        
    }
}