package massobregui;
import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.ImageIcon;




public class Ventana extends JFrame {
	private static final int FrameW=250;
	private static final int FrameH=250;
	private static final int FrameX=150, FrameY=150;
	private static final long serialVersionUID = 1L;

	private JLabel etiquetaEstado;
	private JButton botonOK;
	private JPanel panelEtiqueta, panelBoton, panelImagen;
	

	public Ventana(String fileName){
		Container panel = getContentPane();
		setTitle("Abriendo archivo");
		setSize(FrameW, FrameH);
		setResizable(false);
		setLocation(FrameX, FrameY);

		panel.setLayout(new BorderLayout());
		etiquetaEstado=new JLabel("Mostrando...");
		etiquetaEstado.setSize(100,50);
	
		panelEtiqueta = new JPanel(new BorderLayout());
		panelEtiqueta.add(etiquetaEstado);
		
		
		panel.add(panelEtiqueta,BorderLayout.NORTH);
		
		panelImagen=new JPanel(new BorderLayout());
		if (fileName!=""){
			panelImagen.add(new JLabel(new ImageIcon(fileName)));
		}
		panel.add(panelImagen,BorderLayout.CENTER);
		
		botonOK=new JButton("OK");
		botonOK.addActionListener(new OyenteBoton());
		panelBoton = new JPanel(new BorderLayout());
		panelBoton.add(botonOK);
		panel.add(panelBoton,BorderLayout.SOUTH);
	}
	
	public void setEstado(String message){
		etiquetaEstado.setText(message);
	}
	
	private class OyenteBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose(); // se destruye el objeto
			//setVisible(false); // solo se oculta.
			
		}
		
	}

	
	
}
