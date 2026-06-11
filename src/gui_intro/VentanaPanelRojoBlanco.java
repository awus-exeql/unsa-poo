package gui_intro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPanelRojoBlanco extends JFrame{
	//declaramos los botones y los paneles
	private JButton botonRojo, botonBlanco;
	private JPanel panelColor, panelBotones;
		
	public VentanaPanelRojoBlanco(){
		setLayout(new GridLayout(1,2));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,120);
		
		
		//creamos los botones y los paneles
		botonRojo=new JButton("Rojo");
		botonBlanco=new JButton("Blanco");
		panelColor=new JPanel();
		panelBotones=new JPanel();
		panelBotones.setLayout(new FlowLayout());
		panelColor.setLayout(new FlowLayout());
		
		//creamos oyentes y los registramos a los botones
		OyenteBotonR oyenteR = new OyenteBotonR();
		OyenteBotonB oyenteB = new OyenteBotonB();
		//Completar!!!!

		botonRojo.addActionListener(oyenteR);
		botonBlanco.addActionListener(oyenteB);
			
		//insertamos los botones en el panel de botones, y los paneles en el panel de contenido
		//el orden de estas instrucciones influye en la apariencia de la GUI
		panelBotones.add(botonRojo);
		panelBotones.add(botonBlanco);
		getContentPane().add(panelBotones);		
		getContentPane().add(panelColor);

	}
	//Definimos clases para establecer el comportamiento de los botones, estas clases son 
	//internas a la clase VentanaPanelRojoBlanco por eso tiene acceso sus atributos de instancia como panelColor
	private class OyenteBotonR implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evento) {
			panelColor.setBackground(Color.RED);
		}

	}

	private class OyenteBotonB implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent evento) {
			panelColor.setBackground(Color.WHITE);
		}

	}
}
