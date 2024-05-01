/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AthleticRaceInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Listeners implements ActionListener {

    private JButton botonRegistrarCorredor;
    private JTextField registrarCorredor;
    private JTextArea corredoresRegistrados;
    private JButton botonIniciar;
    private JButton botonReiniciar;
    private JButton botonTerminar;
    private int numCorredores;
    String corredores = "";

    public void recibeRegistrarCorredor(JTextField registrarCorredor) {
        this.registrarCorredor = registrarCorredor;
    }

    public void recibeBotonRegistrarCorredor(JButton botonRegistrarCorredor) {
        this.botonRegistrarCorredor = botonRegistrarCorredor;
    }

    public void recibeCorredoresRegistrados(JTextArea corredoresRegistrados) {
        this.corredoresRegistrados = corredoresRegistrados;
    }

    public void recibeBotonIniciar(JButton botonIniciar) {
        this.botonIniciar = botonIniciar;
    }

    public void recibeBotonReiniciar(JButton botonReiniciar) {
        this.botonReiniciar = botonReiniciar;
    }

    public void recibeBotonTerminar(JButton botonTerminar) {
        this.botonTerminar = botonTerminar;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == botonRegistrarCorredor) {
            // Para no añadir campos vacíos
            if (this.registrarCorredor.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Introduzca el nombre del corredor.", "Error", JOptionPane.ERROR_MESSAGE);
            // Si ya se introdujeron 5 corredores, no se aceptarán más
            } else if (this.corredoresRegistrados.getLineCount() >= 6) {
                JOptionPane.showMessageDialog(null, "Solo se puede introducir un máximo de 5 corredores.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                corredores = corredores + registrarCorredor.getText() + System.lineSeparator();
            }
            // El botón para Iniciar solo se activará si hay 2 o más corredores
            if (this.corredoresRegistrados.getLineCount() >= 2) {
                this.botonIniciar.setEnabled(true);
            }
            this.corredoresRegistrados.setText(corredores);
        }

        if (ae.getSource() == botonIniciar) {
            numCorredores = this.corredoresRegistrados.getLineCount() - 1;
            String[] arrayCorredores = corredoresRegistrados.getText().split(System.lineSeparator());
            for (int i = 0; i < numCorredores; i++) {
                ThreadRunner threadRunner = new ThreadRunner(arrayCorredores[i]);
                Thread thread = new Thread(threadRunner);
                thread.start();
            }
            // Terminó el ciclo, ahora podemos activar o desactivar botones
            this.botonIniciar.setEnabled(false);
            this.botonReiniciar.setEnabled(true);
            Interfaz.resultado = "";
        }

        if (ae.getSource() == botonReiniciar) {
            // Reiniciamos variables
            Interfaz.resultado = "";
            corredores = "";
            this.registrarCorredor.setText("");
            this.corredoresRegistrados.setText("");
            Interfaz.resultados.setText("");
            this.botonReiniciar.setEnabled(false);
        }

        if (ae.getSource() == botonTerminar) {
            System.exit(0); // Bye
        }
    }

}
