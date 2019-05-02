package modelo;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;

public class Bosquesillo {

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
		posInicial();
	}
	public void posInicial(){
		posX = ThreadLocalRandom.current().nextInt(0, maxX );
 		posY = ThreadLocalRandom.current().nextInt(0, maxY );

	}
	
	public void verificarMuros() {
		if (posX  > maxX ) {
			System.out.println("x " + posX);
		}
		if (posX + 30 < 0) {
			System.out.println("x "+ posX);
		}
		if (posY > maxY) {
			System.out.println("y "+ posY);
		}
		if (posY - 30 < 0) {
			System.out.println("y "+posY);
		}
	}

	public ImageIcon cargarImagenes(){
		imagen = new ImageIcon("Data/Bosquesillo.jpeg");
		return imagen;
	}

	public void actualizar(){
		if (moverArriba) {
			posY -= 30;
			
		}
		if (moverAbajo) {
			posY += 30;
		}
		if (moverIzquierda) {
			posX -= 30;
		}
		if (moverDerecha) {
			posX += 30;
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
