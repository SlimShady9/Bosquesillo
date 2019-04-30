package controlador;

import java.util.concurrent.ThreadLocalRandom;

import modelo.*;
import vista.*;

public class Controlador {
	private Bosquesillo b;
	private int dimX, dimY;
	public Controlador() {
		
		dimX = ThreadLocalRandom.current().nextInt(5, 20);
		dimY = ThreadLocalRandom.current().nextInt(5, 20);
		b = new Bosquesillo(dimX, dimY);
	}

	public void moverArriba() {
		b.setMoverArriba(true);
		b.actualizar();
		b.setMoverArriba(false);
	}
	 

}
