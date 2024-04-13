/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * Nombre: David Emmanuel Kantún Marín
 * Matrícula: 22032378
 * Módulo: Tópicos Avanzados de Programación v2
 * Asesor: Andrés Espinal Jiménez
 * Fecha: 12 de abril de 2024
 */
public class ListenersBotones implements ActionListener {

    private final JButton botones[];
    String textoBotones[];
    // Cuales son los botones que tienen numeros
    private final int numerosBotones[];
    // Aqui se acumula el resultado en total
    private double acumuladorGlobal;
    // Aqui se manda el resultado en pantalla a un acumulador temporal
    private double acumuladorPantalla;
    private boolean nuevoNumero;
    private String signo;
    private String resultado;
    private JTextField campo;

    public ListenersBotones() {
        this.resultado = "";
        this.signo = "";
        this.nuevoNumero = true;
        this.acumuladorPantalla = 0;
        this.acumuladorGlobal = 0;
        this.numerosBotones = new int[]{13, 8, 9, 10, 4, 5, 6, 0, 1, 2}; // Las posiciones que contienen numeros
        this.textoBotones = new String[]{"7", "8", "9", "÷", "4", "5", "6", "×", "1", "2", "3", "-", "C", "0", "=", "+"};
        this.botones = new JButton[16];
    }

    public void recibeBoton(JButton botones[]) {
        System.arraycopy(botones, 0, this.botones, 0, 16);
    }

    public void recibeCampo(JTextField campo) {
        this.campo = campo;
    }

    private void borrar() {
        signo = "";
        resultado = "";
        acumuladorGlobal = 0;
        acumuladorPantalla = 0;
    }

    private boolean esNumero(String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void realizarOperacion() {
        // Este if se aplica si por accidente, el usuario oprime un signo
        // equivocado y luego oprime el signo correcto, así, se almacena
        // solo el último signo digitado.
        if (esNumero(this.campo.getText())) {
            acumuladorPantalla = Double.parseDouble(this.campo.getText());
            acumuladorGlobal = switch (signo) {
                case "+" ->
                    acumuladorGlobal + acumuladorPantalla;
                case "-" ->
                    acumuladorGlobal - acumuladorPantalla;
                case "×" ->
                    acumuladorGlobal * acumuladorPantalla;
                case "÷" ->
                    acumuladorGlobal / acumuladorPantalla;
                default ->
                    acumuladorPantalla; // No hay signo, es decir, apenas va a mover el acumuladorPantalla al acumuladorGlobal
            };
        }
        resultado = Double.toString(acumuladorGlobal);
        this.campo.setText(resultado);
        nuevoNumero = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Primero, la funcion numerica
        for (int i = 0; i < 10; i++) {
            int numBoton = numerosBotones[i];
            if (e.getSource() == botones[numBoton]) {
                if (nuevoNumero) {
                    if (!textoBotones[numBoton].equals("0")) {
                        this.campo.setText(textoBotones[numBoton]);
                        nuevoNumero = false;
                    } // Para poder agregar 0 como argumento
                    else if (!this.campo.getText().equals("0")) {
                        if (textoBotones[numBoton].equals("0")) {
                            this.campo.setText(textoBotones[numBoton]);
                        }
                    }
                } else {
                    this.campo.setText(this.campo.getText() + textoBotones[numBoton]);
                }
            }
        }

        // Boton de borrado
        if (e.getSource() == botones[12]) {
            borrar();
            nuevoNumero = true;
            this.campo.setText("0");
        }

        // Suma
        if (e.getSource() == botones[15]) {
            realizarOperacion();
            signo = textoBotones[15];
            this.campo.setText(signo);
        }

        // Resta
        if (e.getSource() == botones[11]) {
            realizarOperacion();
            signo = textoBotones[11];
            this.campo.setText(signo);
        }

        // Multiplicacion
        if (e.getSource() == botones[7]) {
            realizarOperacion();
            signo = textoBotones[7];
            this.campo.setText(signo);
        }

        // Division
        if (e.getSource() == botones[3]) {
            realizarOperacion();
            signo = textoBotones[3];
            this.campo.setText(signo);
        }

        // Igual
        if (e.getSource() == botones[14]) {
            realizarOperacion();
            borrar();
        }
    }

}
