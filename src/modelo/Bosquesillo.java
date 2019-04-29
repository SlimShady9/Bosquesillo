package modelo;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;

public class Bosquesillo {

	private boolean[][] posicion;
	private int posX;
	private int posY;
	private int maxX;
	private int maxY;
	private ImageIcon imagen;
	private boolean moverArriba;
	private boolean moverAbajo;
	private boolean moverIzquierda;
	private boolean moverDerecha;
	
	public Bosquesillo(int x, int y){
		moverArriba = false;
		moverAbajo = false; 
		moverIzquierda = false;
		moverDerecha = false;
		maxX = x;
		maxY= y;
		posicion = new boolean[maxX][maxY];
		posInicial();
	}
	public void posInicial(){
		posX = ThreadLocalRandom.current().nextInt(0, maxX );
 		posY = ThreadLocalRandom.current().nextInt(0, maxY );
 		for (int i = 0; i < posX ; i++) {
 			for (int j = 0 ; j < posY; j++) {
 				
 			}
 		}

	}

	public ImageIcon cargarImagenes(){
		imagen = new ImageIcon("Data/Bosquesillo.jpeg");
		return imagen;
	}

	public void actualizar(){
		if (moverArriba) {
			posY -= 1;
			
		}
		if (moverAbajo) {
			posY += 1;
		}
		if (moverIzquierda) {
			posX -= 1;
		}
		if (moverDerecha) {
			posX += 1;
		}

	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	public void setMoverArriba(boolean moverArriba) {
		this.moverArriba = moverArriba;
	}
	public void setMoverAbajo(boolean moverAbajo) {
		this.moverAbajo = moverAbajo;
	}
	public void setMoverIzquierda(boolean moverIzquierda) {
		this.moverIzquierda = moverIzquierda;
	}
	public void setMoverDerecha(boolean moverDerecha) {
		this.moverDerecha = moverDerecha;
	}
	
}
