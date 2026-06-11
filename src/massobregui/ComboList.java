package massobregui;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class ComboList extends JFrame {
	private static final long serialVersionUID = 1L;
	private String[] edades = {"<18","18 a 30", "31 a 50",">50"};
	private JComboBox cboEdades;
	
	private String[] idiomas = {"Ingles", "Portugues", "Frances", "Italiano", "Castellano"};	
	private JList lstIdioma;
	
	private static final int FrameW = 400;
	private static final int FrameH = 200;

	private JPanel panelCombo, panelList, panelButton, panelLabel;
	private JLabel lblEstado;
	
	private JButton btnRestart, btnExit;
	
	public ComboList(){
		Container panel = getContentPane();
		setTitle("Combo y Listbox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FrameW, FrameH);

		panel.setLayout(new BorderLayout());
		panelCombo = new JPanel(new FlowLayout());
		panelCombo.setBorder(BorderFactory.createTitledBorder("tu edad"));
		
		cboEdades=new JComboBox(edades);
		OyenteItem oi = new OyenteItem();
		cboEdades.addItemListener(oi);
		panelCombo.add(cboEdades);
		
		lstIdioma = new JList(idiomas);
		lstIdioma.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		lstIdioma.addListSelectionListener(new OyenteListaSeleccion());
		
		panelList=new JPanel(new GridLayout(0,1));
		panelList.setBorder(BorderFactory.createTitledBorder("Elige idiomas"));
		panelList.add(new JScrollPane(lstIdioma));
		
		
		panelButton=new JPanel(new FlowLayout());
		btnRestart = new JButton("Restart");
		
		//***otra forma de crear un oyente interno!! O____O
		ActionListener oyenteRestart = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				restablecer();
				lblEstado.setText("Esperando tus opciones...");
			}
			
		};
		//***debe declararse antes de agregarlo al boton.
		
		btnRestart.addActionListener(oyenteRestart);
		btnExit = new JButton("Exit");
		
		//***otra forma de crear un oyente interno!! O____O
				ActionListener oyenteExit = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null, "saliendo...");
						System.exit(0);
					}
					
				};
		//***debe declararse antes de agregarlo
		
		btnExit.addActionListener(oyenteExit);
		
		panelButton.add(btnRestart,BorderLayout.WEST);
		panelButton.add(btnExit,BorderLayout.EAST);
		
		lblEstado = new JLabel("Resultados de tus opciones");
		panelLabel = new JPanel(new BorderLayout());
		panelLabel.add(lblEstado);
		panel.add(panelLabel, BorderLayout.NORTH);
		panel.add(panelCombo, BorderLayout.WEST);
		panel.add(panelList, BorderLayout.EAST);
		panel.add(panelButton, BorderLayout.SOUTH);
	}
	
	private void restablecer(){
		cboEdades.setSelectedIndex(0);
		lstIdioma.clearSelection();
		
	}	

	private class OyenteItem implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			String mensaje = "Tus opciones: ";
			String mensaje1 = "";
			String mensaje2 = "";
			int[] posiciones;
			mensaje1 = event.getItem().toString();
			
			posiciones = lstIdioma.getSelectedIndices();
			for (int i = 0; i < posiciones.length; i++) {
				mensaje2 = mensaje2 + " " + idiomas[posiciones[i]];
			}						
				
			lblEstado.setText(mensaje + " tu edad es " + mensaje1 + " y hablas " + mensaje2);
		}	
	}
	
	private class OyenteListaSeleccion implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			String mensaje = "Tus opciones: ";
			String mensaje1 = cboEdades.getSelectedItem().toString();
			String mensaje2 = "";
			int[] posiciones;
	    
			posiciones = lstIdioma.getSelectedIndices();
			
	  		for (int i = 0; i < posiciones.length; i++) {
	  			mensaje2 = mensaje2 + " " + idiomas[posiciones[i]];
	  		}						
	  		lblEstado.setText(mensaje + " tu edad es " + mensaje1 + " y hablas " + mensaje2);
			
		}		
	}
	
}
