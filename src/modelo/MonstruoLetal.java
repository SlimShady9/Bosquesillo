package modelo;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;

public class MonstruoLetal {
	
	private ImageIcon imagen;
	private Point ubicacion;
	private int maxX, maxY;
	private boolean moverse;
	
	public MonstruoLetal(int x, int y){
		moverse = true;
		maxX = x;
		maxY = y;
		iniciarPosicion();
	}
	
	public void iniciarPosicion(){
		int posX = ThreadLocalRandom.current().nextInt(0 , maxX - 30);
		int posY = ThreadLocalRandom.current().nextInt(0 , maxY - 60);
		while (posX % 30 != 0){
			posX++;
		}
		while (posY % 30 != 0){
			posY++;
		}
		ubicacion = new Point(posX, posY);
	}
	public ImageIcon cargarImagen(){
		imagen = new ImageIcon("Data/MonstruoLetal.png");
		return imagen;
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
	
	public void moverse(){
		int x = 30;
		int y = 30;
		if (moverse){
			int direccion = ThreadLocalRandom.current().nextInt(0, 4);
			if (direccion == 0){
				y = (int) (ubicacion.getY() - y); 
				ubicacion.setLocation(ubicacion.getX(), y);
				moverse = false;
			}
			if (direccion == 1){
				y = (int) (ubicacion.getY() + y);
				ubicacion.setLocation(ubicacion.getX(), y);
				moverse = false;
			}
			if (direccion == 2){
				x = (int) (ubicacion.getX() + x);
				ubicacion.setLocation(x, ubicacion.getY());
				moverse = false;
			}
			if (direccion == 3){
				x = (int) (ubicacion.getX() - x);
				ubicacion.setLocation(x, ubicacion.getY());
				moverse = false;
			}
		}
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
