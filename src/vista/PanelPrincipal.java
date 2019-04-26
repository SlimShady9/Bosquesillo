package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;;

public class PanelPrincipal extends JFrame {
	
	private PanelPantallaJuego pJ;
	
	PanelPrincipal(){
		super("Juego");
		setLayout(new BorderLayout());
		pJ = new PanelPantallaJuego();
		add(pJ, BorderLayout.CENTER);
		add(new JButton("Hola"), BorderLayout.SOUTH);
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		PanelPrincipal v = new PanelPrincipal();
	}

}
