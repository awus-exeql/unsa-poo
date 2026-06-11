package gui_intro;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Botonera extends JFrame {
    private JPanel panelBotones;
    private JButton[] botones;

    public Botonera(){
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelBotones = new JPanel();
        botones = new JButton[5];
        armarBotonera();
        getContentPane().add(panelBotones);
    }
    private void armarBotonera(){
        Oyente oyente = new Oyente();
        for(int i = 0; i<5; i++){
            botones[i] = new JButton();
            botones[i].setText(""+i);
            botones[i].setBackground(Color.WHITE);
            botones[i].addActionListener(oyente);
            panelBotones.add(botones[i]);
        }
    }
    private class Oyente implements ActionListener{
        public void actionPerformed(ActionEvent evento){
            JButton b = (JButton) evento.getSource();
            if(b.getText().equals("OK")){
                b.setBackground(Color.WHITE);
                int i = 0;
                while(!b.equals(botones[i]))
                    i++;
                b.setText(""+i);
            }else{
                b.setBackground(Color.RED);
                b.setText("OK");
            }
        }
    }
}
