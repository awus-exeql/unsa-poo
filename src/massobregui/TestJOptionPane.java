package massobregui;

import javax.swing.*;

public class TestJOptionPane {
	public static void main(String[] args) {
		JFrame miFrame;
		miFrame = new JFrame();
		miFrame.setSize(400,250);
		
		//para mostrar mensajes:
		//JOptionPane.showMessageDialog(miFrame, "Usando un frame");
		//JOptionPane.showMessageDialog(null, "Hola, no hay componente");
		
		//para ingresar datos
		String nombre = JOptionPane.showInputDialog("Ingrese nombre ");
		String edadenString = JOptionPane.showInputDialog(null, "Cual es tu edad?" );
		// JOptionPane solo soporta String. Hay que hacer conversion. (a diferencia de Scanner)
		int edad = Integer.parseInt(edadenString);
		if (edad<18)
			JOptionPane.showMessageDialog(null, nombre + " eres menor de edad");
		else
			JOptionPane.showMessageDialog(null, nombre + " eres mayor de edad");
				
	}

}
