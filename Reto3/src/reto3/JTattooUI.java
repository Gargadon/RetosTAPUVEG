/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto3;

import com.jtattoo.plaf.noire.NoireLookAndFeel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JTattooUI extends JFrame {

    public JTattooUI() {
        try {
            UIManager.setLookAndFeel(new NoireLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Failed to initialize JTattoo");
        }

        setTitle("Ejemplo de interfaz con librería JTattoo");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("JLabel:");
        JTextField textField = new JTextField();
        JButton button = new JButton("JButton");

        JCheckBox checkBox = new JCheckBox("JCheckBox");
        JRadioButton radioButton = new JRadioButton("JRadioButton");
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Option 1");
        comboBox.addItem("Option 2");
        comboBox.addItem("Option 3");
        comboBox.addItem("Option 4");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(label);
        panel.add(textField);
        panel.add(checkBox);
        panel.add(radioButton);
        panel.add(comboBox);
        panel.add(button);

        setContentPane(panel);
        setVisible(true);
        setResizable(false);

        button.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Message Dialog");
        });
    }
}
