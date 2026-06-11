package massobregui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class RadioButtonyCheckBox extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton botonRestart, botonExit;
	private JLabel etiquetaEstado;
	private static final int FrameW=400;
	private static final int FrameH=150;
	private int cantIdiomas;
	private String[] edades ={"<18","18 a 30", "31 a 50",">50"};
	private String[] idioma ={"Ingles","Portugues","Frances","Italiano","Castellano"};	
	
	private JCheckBox[] checkIdiomas;
	private JRadioButton[] rbtnEdades;
	
	private JPanel panelCheck, panelRadio, panelBotones, panelEtiqueta;
	private ButtonGroup radioGroup;
	
	public RadioButtonyCheckBox(){
		Container panel = getContentPane();
		setTitle("Frame Personalizado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FrameW, FrameH);
		setResizable(false);
		cantIdiomas = 0;
		panel.setLayout(new BorderLayout());
		panelRadio = new JPanel(new GridLayout(0,1));
		panelRadio.setBorder(BorderFactory.createTitledBorder("Tu Edad"));
		
		rbtnEdades = new JRadioButton[edades.length];
		radioGroup = new ButtonGroup();
		CheckboxGroup checkGroup=new CheckboxGroup();
		
		OyenteRadioButton orb = new OyenteRadioButton();
		for (int i=0;i<edades.length;i++){
			rbtnEdades[i]=new JRadioButton(edades[i]);
			rbtnEdades[i].setSelected(false);	
			rbtnEdades[i].addItemListener(orb);
			radioGroup.add(rbtnEdades[i]);
			panelRadio.add(rbtnEdades[i]);
		}
		
		panelCheck = new JPanel(new GridLayout(0,2));
		panelCheck.setBorder(BorderFactory.createTitledBorder("Idiomas que habla"));
		
		OyenteCheckBox ocb = new OyenteCheckBox();
		checkIdiomas = new JCheckBox[idioma.length];
		for (int i=0;i<idioma.length;i++){
			checkIdiomas[i]=new JCheckBox(idioma[i]);
			checkIdiomas[i].setSelected(false);
			checkIdiomas[i].addItemListener(ocb);

			panelCheck.add(checkIdiomas[i]);
		}
	
		
		botonRestart = new JButton("Restablecer");
		botonRestart.addActionListener(new OyenteRestart());
		botonExit = new JButton("Salir");
		botonExit.addActionListener(new OyenteExit());
		botonExit.requestFocusInWindow();
		
		panelBotones = new JPanel(new BorderLayout());
		panelBotones.add(botonRestart,BorderLayout.WEST);
		panelBotones.add(botonExit,BorderLayout.EAST);
		
		etiquetaEstado = new JLabel("Resultados de tus opciones");
		panelEtiqueta = new JPanel(new BorderLayout());
		panelEtiqueta.add(etiquetaEstado);
		panel.add(panelEtiqueta, BorderLayout.NORTH);
		panel.add(panelRadio, BorderLayout.WEST);
		panel.add(panelCheck, BorderLayout.EAST);
		panel.add(panelBotones, BorderLayout.SOUTH);
		
	}
	
	private void restablecer(){
		radioGroup.clearSelection();			
		for (int i=0;i<idioma.length;i++){
			checkIdiomas[i].setSelected(false);
		}
	}
	
	
		
	private class OyenteRestart implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			restablecer();
			etiquetaEstado.setText("Esperando tus opciones...");
		}
		
	}
	
	private class OyenteExit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "saliendo...");
			System.exit(0);
		}
		
	}
	
	private class OyenteRadioButton implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			String mensaje="Tus opciones: ";
			String mensaje1="";
			String mensaje2="";
			JRadioButton radio = (JRadioButton)event.getSource();
			mensaje1 = radio.getText();
			mensaje2 += cantIdiomas;
			etiquetaEstado.setText(mensaje + " tu edad es " + mensaje1 + " y hablas " + mensaje2+" idiomas");
			
		}
		
	}
	
	private class OyenteCheckBox implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			String mensaje="Tus opciones: ";
			String mensaje1="";
			String mensaje2="";
			
			JCheckBox check = (JCheckBox)event.getSource();
			boolean encontrado=false;
			int i=0;
			while(i<edades.length && !encontrado){
				if(rbtnEdades[i].isSelected()){
					encontrado=true;
					mensaje1=rbtnEdades[i].getText();
				}else{i++;}
			}
			if(encontrado){
				mensaje1=rbtnEdades[i].getText();
				}else{mensaje1="no ingresada";}
			
			if (check.isSelected()){
				cantIdiomas++;			
			}else{
				cantIdiomas--;
			}			
		
			mensaje2 += cantIdiomas;
			etiquetaEstado.setText(mensaje + " tu edad es " + mensaje1 + " y hablas " + mensaje2+" idiomas");
			
		}
		
	}



}
