/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Nombre: David Emmanuel Kantún Marín
 * Matrícula: 22032378
 * Módulo: Tópicos Avanzados de Programación v2
 * Asesor: Andrés Espinal Jiménez
 * Fecha: 12 de abril de 2024
 */
class GUIBotones extends JFrame {

    JButton botones[];
    String textoBotones[];
    private final JTextField campo;
    private final ListenersBotones listenersBotones;

    public GUIBotones() {
        this.textoBotones = new String[]{"7", "8", "9", "÷", "4", "5", "6", "×", "1", "2", "3", "-", "C", "0", "=", "+"};
        this.botones = new JButton[16];

        // Se declara el campo
        campo = new JTextField();
        campo.setText("0");
        campo.setPreferredSize(new Dimension(320, 50));
        campo.setFont(new Font("Sans Serif", Font.PLAIN, 45));
        campo.setEditable(false);
        campo.setHorizontalAlignment(JTextField.RIGHT);

        // Se declara el layout
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 6, 6));

        //Se declaran los botones
        for (int i = 0; i < 16; i++) {
            botones[i] = new JButton(textoBotones[i]);
            botones[i].setPreferredSize(new Dimension(80, 80));
            botones[i].setFont(new Font("Sans Serif", Font.PLAIN, 30));
            panelBotones.add(botones[i]);
        }

        // Panel principal, añadir JTextField y Botones
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(20, 20));
        panelPrincipal.add(campo, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);

        // Configuracion de ventana
        this.setContentPane(panelPrincipal);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Clase oyente
        listenersBotones = new ListenersBotones();
        listenersBotones.recibeBoton(botones);
        for (int i = 0; i < 16; i++) {
            botones[i].addActionListener(listenersBotones);
        }
        listenersBotones.recibeCampo(campo);
    }
}
