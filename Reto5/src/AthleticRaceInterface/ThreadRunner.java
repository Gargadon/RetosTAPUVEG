/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AthleticRaceInterface;

import static java.lang.Math.random;

public class ThreadRunner implements Runnable {

    private final String nombreCorredor;
    private int speed;
    private int min;
    private int max;
    private int range;

    public ThreadRunner(String nombreCorredor) {
        this.nombreCorredor = nombreCorredor;
    }
    
    @Override
    public void run() {
        min = 0;
        max = 30;
        range = max - min + 1;
        speed = (int)(random() * range) + min;
        try {
            System.out.println("Creando tarea " + nombreCorredor);
            Thread.sleep(speed * 1000);
            Interfaz.resultado = Interfaz.resultado + nombreCorredor + ": " + speed + " segundos" + System.lineSeparator();
            System.out.println(Interfaz.resultado);
            Interfaz.resultados.setText(Interfaz.resultado);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
