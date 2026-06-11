package massobregui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.filechooser.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu extends JFrame {
	private static final int FrameW=350;
	private static final int FrameH=350;
	private static final int FrameX=100, FrameY=100;
	private static final long serialVersionUID = 1L;
	
	private JLabel lblStatus;
	private JMenu mnuFile, mnuAbout;
	private JMenuItem mnuItem;
	private JMenuBar mnuBar;
	private JFileChooser chooser;
	private String fileName="";
	
	
	public Menu(){
		Container panel = getContentPane();
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FrameW, FrameH);
		setResizable(false);
		setLocation(FrameX, FrameY);
		
		panel.setLayout(new FlowLayout());
		mnuFile = new JMenu("Archivo");
		mnuItem= new JMenuItem("Abrir");
		mnuItem.addActionListener(new OyenteMenuAbrir());
		mnuFile.add(mnuItem);

		mnuItem= new JMenuItem("Informacion");
		//mnuItem.addActionListener(this);
		mnuFile.add(mnuItem);
		mnuFile.addSeparator();
		mnuItem=new JMenuItem("Salir");
		mnuItem.addActionListener(new OyenteMenuSalir());
		mnuFile.add(mnuItem);
		
		mnuAbout=new JMenu("Opciones");
		mnuItem= new JMenuItem("Ventana");
		mnuItem.addActionListener(new OyenteMenuVentana());
		mnuAbout.add(mnuItem);
		
		mnuBar=new JMenuBar();
		setJMenuBar(mnuBar); // poniendo la barra al formulario
		mnuBar.add(mnuFile);
		mnuBar.add(mnuAbout);
		
		lblStatus=new JLabel("Ingresando...");
		lblStatus.setSize(100,50);
		panel.add(lblStatus);
		
		
	}
	
	private class OyenteMenuSalir implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
	private class OyenteMenuVentana implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Ventana ventana=new Ventana(fileName);
			ventana.setEstado("Abierto desde el Menu Ppal");			
			ventana.setVisible(true);
		}
	}
	
	private class OyenteMenuAbrir implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int status;
			chooser =new JFileChooser();
			chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
			chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", "txt", "text"));
			status = chooser.showOpenDialog(null);
			if (status==chooser.APPROVE_OPTION){
				fileName=chooser.getSelectedFile().getPath();
				System.out.println(fileName);
				String extension = fileName.substring(fileName.lastIndexOf("."),fileName.length());
				System.out.println(extension);
				if(extension.equals(".txt")){
					File f = new File(fileName);
					Scanner s;
					try {
						JFrame nuevaVentana=new JFrame("Info de txt");
						JTextArea texto=new JTextArea();
						JScrollPane panelScroll = new JScrollPane(texto);
						nuevaVentana.getContentPane().add(panelScroll);
						s = new Scanner(f);
						while (s.hasNextLine()) {
							String linea = s.nextLine();
							System.out.println(linea);
							texto.append(linea+"\n");
						}
						s.close();
						nuevaVentana.setSize(400, 400);
						nuevaVentana.setVisible(true);
					} catch (FileNotFoundException e) {
						e.printStackTrace();}
				}			

			}

		}
	}
	
}
