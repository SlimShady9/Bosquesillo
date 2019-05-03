package controlador;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.*;
import vista.*;

public class Controlador{
	private Bosquesillo b;
	private PanelPrincipal p;
	private Tablero t;
	private int dimX, dimY;
	public Controlador() {
		
		iniciarBosquesillo();
		iniciarTablero();
		p = new PanelPrincipal(this, dimX, dimY);
	}
	
	public void iniciarBosquesillo () {
		dimX = ThreadLocalRandom.current().nextInt(150, 500);
		dimY = ThreadLocalRandom.current().nextInt(150, 530);
		while (dimX % 30 != 0) {
			dimX++;
		}
		while (dimY % 30 != 0) {
			dimY++;
		}
		b = new Bosquesillo(dimX, dimY);
	}
	public void iniciarTablero() {
		t = new Tablero();
	}
	public JButton asignarBosquesillo () {
		ImageIcon imagenB = b.cargarImagenes();
		int posX = b.getPosX();
		int posY = b.getPosY();
		JButton r = new JButton(imagenB);
		r.setBounds(posX, posY, 30, 30);
		return r;
	}
	public JLabel[][] asignarTablero() {
		ImageIcon imagenA = t.cargarImagenA();
		ImageIcon imagenB = t.cargarImagenB();
		int x = dimX / 30;
		int y = dimY / 30;
		JLabel casillas[][] = new JLabel[x][y];
		for (int i = 0; i < x ; i++) {
			for (int j = 0 ; j < y ; j++) {
				if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
					casillas[i][j] = new JLabel(imagenA);
					casillas[i][j].setBounds((i* 30), (j * 30), 30, 30);
				}
				else {
					casillas[i][j] = new JLabel(imagenB);
					casillas[i][j].setBounds((i* 30), (j * 30), 30, 30);
				}
			}
		}
		return casillas;
	}
	
	public int getPosX() {
		return b.getPosX();
	}
	public int getPosY() {
		return b.getPosY();
	}
	

	public int getDimX() {
		return dimX;
	}

	public int getDimY() {
		return dimY;
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
