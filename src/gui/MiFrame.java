package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiFrame extends JFrame implements ActionListener {
    private JButton boton;

    public MiFrame(){
        this.boton = new JButton("Aceptar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(boton);
        setSize(300,300);
        boton.addActionListener(this);
    }

    private void cambiarText(){
        this.boton.setText("HOLA ISA..");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cambiarText();
    }
}
