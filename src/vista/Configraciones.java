package vista;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controlador.Controlador;

public class Configraciones implements KeyListener {
	private static int dimension_X;
	private Controlador c;
	
	public Configraciones() {
		c = new Controlador();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			c.moverArriba();
			
			pJ.getBotonB().setLocation(pJ.getB().getPosX(), pJ.getB().getPosY());
		}
		if (key == KeyEvent.VK_DOWN) {
			pJ.getB().setMoverAbajo(true);
			pJ.getB().actualizar();
			pJ.getB().setMoverAbajo(false);
			
			pJ.getBotonB().setLocation(pJ.getB().getPosX(), pJ.getB().getPosY());
		}
		if (key == KeyEvent.VK_LEFT) {
			pJ.getB().setMoverIzquierda(true);
			pJ.getB().actualizar();
			pJ.getB().setMoverIzquierda(false);
			
			pJ.getBotonB().setLocation(pJ.getB().getPosX(), pJ.getB().getPosY());
		}
		if (key == KeyEvent.VK_RIGHT) {
			pJ.getB().setMoverDerecha(true);
			pJ.getB().actualizar();
			pJ.getB().setMoverDerecha(false);
			
			pJ.getBotonB().setLocation(pJ.getB().getPosX(), pJ.getB().getPosY());
		}
		
	}
	}
