package modelo;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;

public class Bosquesillo {

	private int maxX, maxY;
	private Point ubicacion;
	private ImageIcon imagen;
	private boolean moverArriba, moverAbajo, moverIzquierda, moverDerecha;

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
		int posX = ThreadLocalRandom.current().nextInt(0, maxX - 30 );
		int posY = ThreadLocalRandom.current().nextInt(0, maxY - 60 );
		while (posX % 30 != 0) {
			posX ++;
		}
		while (posY % 30 != 0) {
			posY++;
		}
		ubicacion = new Point(posX, posY);
	}

	public void verificarMuros() {
		if (ubicacion.getX() + 30 ==  maxX ) {
			moverDerecha = false;
		}
		if (ubicacion.getX() == 0) {
			moverIzquierda = false;
		}
		if (ubicacion.getY() + 60 == maxY ) {
			moverAbajo = false;
		}
		if (ubicacion.getY() == 0) {
			moverArriba = false;
		}
	}
	
	public void verificarObjs(Point obj) {

		if (ubicacion.getX() + 30 == obj.getX() && ubicacion.getY() == obj.getY()) {
			moverDerecha = false;
		}
		if (ubicacion.getX() - 30 == obj.getX() && ubicacion.getY() == obj.getY()) {
			moverIzquierda = false;
		}
		if (ubicacion.getY() + 30 == obj.getY() && ubicacion.getX() == obj.getX()) {
			moverAbajo = false;
		}
		if (ubicacion.getY() - 30 == obj.getY() && ubicacion.getX() == obj.getX()) {
			moverArriba = false;
		}
	}

	public ImageIcon cargarImagenes(){
		imagen = new ImageIcon("Data/Bosquesillo.jpeg");
		return imagen;
	}

	public void actualizar(){
		int x = 30;
		int y = 30;
		if (moverArriba) {
			y = (int) (ubicacion.getY() - y);
			ubicacion.setLocation(ubicacion.getX(), y);
			moverArriba = false;
		}
		if (moverAbajo) {
			y = (int) (ubicacion.getY() + y); 
			ubicacion.setLocation(ubicacion.getX(), y);
			moverAbajo = false;
		}
		if (moverIzquierda) {
			x = (int) (ubicacion.getX() - x);
			ubicacion.setLocation(x, ubicacion.getY());
			moverIzquierda = false;
		}
		if (moverDerecha) {
			x = (int) ubicacion.getX() + x;
			ubicacion.setLocation(x, ubicacion.getY());
			moverDerecha = false;
		}

	}

	public Point getUbicacion() {
		return ubicacion;
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
