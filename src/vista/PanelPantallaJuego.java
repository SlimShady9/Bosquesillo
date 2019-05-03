package vista;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelPantallaJuego extends JPanel implements KeyListener{

	private JButton botonB;
	private JLabel tablero[][];
	private Controlador c;
	public PanelPantallaJuego(Controlador co) {
		
		setLayout(null);
		c = co;
		iniciarObjetos();
		actualizarPosicion();
	}


	public void iniciarObjetos() {
		cargarBosquesillo();
		cargarTabla();
	}
	public void cargarBosquesillo() {
		botonB = c.asignarBosquesillo();
		botonB.addKeyListener(this);
		add(botonB);
	}
	
	public void cargarTabla() {
		tablero = c.asignarTablero();
		int x = c.getDimX() / 30;
		int y = c.getDimY() / 30;
		for (int i = 0; i < x ; i++) {
			for (int j = 0 ; j < y; j++) {
				add(tablero[i][j]);
			}
		}
		validate();
	}
	
	public void actualizarPosicion() {
		int x = c.getPosX();
		int y = c.getPosY();
		botonB.setLocation(x, y);
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