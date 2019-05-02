package controlador;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import modelo.*;
import vista.*;

public class Controlador{
	private Bosquesillo b;
	private PanelPrincipal p;
	private int dimX, dimY;
	private PanelPantallaJuego ppJ;
	public Controlador() {
		
		iniciarBosquesillo();
		p = new PanelPrincipal(this, dimX, dimY);
	}
	
	public void iniciarBosquesillo () {
		dimX = ThreadLocalRandom.current().nextInt(0, 450);
		dimY = ThreadLocalRandom.current().nextInt(0, 500);
		b = new Bosquesillo(dimX, dimY);
	}
	public JButton asignarBosquesillo () {
		ImageIcon imagenB = b.cargarImagenes();
		int posX = b.getPosX();
		int posY = b.getPosY();
		JButton r = new JButton(imagenB);
		r.setBounds(posX, posY, 30, 30);
		return r;
	}
	
	public int getPosX() {
		return b.getPosX();
	}
	public int getPosY() {
		return b.getPosY();
	}

	public void moverArriba() {
		b.setMoverArriba(true);
		b.actualizar();
		b.setMoverArriba(false);
		b.verificarMuros();
	}
	public void moverAbajo() {
		b.setMoverAbajo(true);
		b.actualizar();
		b.setMoverAbajo(false);
		b.verificarMuros();
	}
	public void moverIzquierda() {
		b.setMoverIzquierda(true);
		b.actualizar();
		b.setMoverIzquierda(false);
		b.verificarMuros();
	}
	public void moverDerecha() {
		b.setMoverDerecha(true);
		b.actualizar();
		b.setMoverDerecha(false);
		b.verificarMuros();
	}


}
