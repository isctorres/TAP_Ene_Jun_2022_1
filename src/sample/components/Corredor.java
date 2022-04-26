package sample.components;

import java.util.Random;

public class Corredor extends Thread{

    public Corredor(String nombre){
        super(nombre);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep((long)(Math.random()*2000));
                System.out.println("Corredor "+getName()+" (KM "+i+")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El corredor "+getName()+" llego a la meta");
    }
}
