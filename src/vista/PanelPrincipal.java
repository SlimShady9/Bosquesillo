package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PanelPrincipal extends JFrame {
	
	private PanelPantallaJuego pJ;
	
	PanelPrincipal(){
		super("Juego");
		setLayout(new BorderLayout());
		pJ = new PanelPantallaJuego();
		add(pJ, BorderLayout.CENTER);
		add(new JButton("Hola"), BorderLayout.SOUTH);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		PanelPrincipal v = new PanelPrincipal();
	}

}