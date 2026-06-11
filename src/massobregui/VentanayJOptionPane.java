package massobregui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class VentanayJOptionPane extends JFrame {


	private JButton botonCancelar, botonOK;
	private JTextField textNombre, textEdad;
	private JLabel etiquetaNombre, etiquetaEdad;
	private static final int FrameW=400;
	private static final int FrameH=150;
	
		
	public VentanayJOptionPane(){
		Container panel = getContentPane();
		setTitle("Frame y JOptionPane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FrameW, FrameH);
		
		panel.setLayout(new FlowLayout());
		etiquetaNombre = new JLabel("Ingrese nombre:");
		etiquetaEdad = new JLabel("Ingrese edad:");
		
		botonOK = new JButton("Aceptar");
		botonOK.addActionListener(new OyenteAceptar());
		botonCancelar = new JButton("Salir");
		botonCancelar.addActionListener(new OyenteSalir());
		textNombre = new JTextField();
		textNombre.setColumns(20);
		textEdad = new JTextField();
		textEdad.setColumns(3);
		
		panel.add(etiquetaNombre);
		panel.add(textNombre);
		panel.add(etiquetaEdad);
		panel.add(textEdad);
		panel.add(botonOK);
		panel.add(botonCancelar);
	}
	
	private class OyenteAceptar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int edad = Integer.parseInt(textEdad.getText());
			String mensaje="";
			if (edad<18)
				mensaje=" sos menor de edad";
			else
				mensaje=" sos adulto!";
			JOptionPane.showMessageDialog(null, "te llamas " + textNombre.getText() + " y " + mensaje);
			
		}
		
	}
	
	private class OyenteSalir implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "saliendo...");
			System.exit(0);
		}
		
	}
	
}
