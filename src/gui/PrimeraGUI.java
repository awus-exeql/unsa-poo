package gui;

import javax.swing.*;

public class PrimeraGUI {
    public static void main(){
        JFrame frame = new JFrame();
        JButton boton = new JButton("Aceptar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(boton);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
