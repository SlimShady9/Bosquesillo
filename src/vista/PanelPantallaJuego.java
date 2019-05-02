package vista;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;
import modelo.Bosquesillo;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelPantallaJuego extends JPanel implements KeyListener{
	private int dimX;
	private int dimY;
	private JButton botonB;
	private Controlador c;
	public PanelPantallaJuego(Controlador co) {
		
		setLayout(null);
		c = co;
		inicializarTabla();
		actualizarPosicion();
	}


	public void inicializarTabla() {
		
		botonB = c.asignarBosquesillo();
		botonB.addKeyListener(this);
		add(botonB);
	}
	
	public void actualizarPosicion() {
		int x = c.getPosX();
		int y = c.getPosY();
		botonB.setLocation(x, y);
	}

	public int getDimX() {
		return dimX;
	}
	public int getDimY() {
		return dimY;
	}



	public JButton getBotonB() {
		return botonB;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			c.moverArriba();
			actualizarPosicion();
			
		}
		if (key == KeyEvent.VK_DOWN) {
			c.moverAbajo();
			actualizarPosicion();
			
		}
		if (key == KeyEvent.VK_LEFT) {
			c.moverIzquierda();
			actualizarPosicion();
			
		}
		if (key == KeyEvent.VK_RIGHT) {
			c.moverDerecha();
			actualizarPosicion();
			

		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	

}