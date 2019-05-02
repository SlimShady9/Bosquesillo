package vista;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;

public class PanelPrincipal extends JFrame {
	
	
	private PanelPantallaJuego pJ;
	private Controlador c;
	
	public PanelPrincipal(Controlador co, int dimX, int dimY){
		super("Juego");
		setLayout(new BorderLayout());
		c = co;
		pJ = new PanelPantallaJuego(c);
		add(pJ, BorderLayout.CENTER);
		add(new JButton("Hola"), BorderLayout.SOUTH);
		setSize(dimX, dimY);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}