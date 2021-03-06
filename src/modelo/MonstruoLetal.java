package modelo;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;

public class MonstruoLetal {

	private ImageIcon imagen;
	private Point ubicacion;
	private int maxX, maxY;
	private boolean moverDerecha, moverIzquierda, moverAbajo, moverArriba ;

	public MonstruoLetal(int x, int y){
		moverArriba = false;
		moverAbajo = false; 
		moverIzquierda = false;
		moverDerecha = false;
		maxX = x;
		maxY = y;
		iniciarPosicion();
	}

	public void iniciarPosicion(){
		int posX = ThreadLocalRandom.current().nextInt(0 , maxX);
		int posY = ThreadLocalRandom.current().nextInt(0 , maxY);
		while (posX % 30 != 0){
			posX--;
		}
		while (posY % 30 != 0){
			posY--;
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
		int direccion = ThreadLocalRandom.current().nextInt(0, 4);
		
		if (direccion == 0 && moverArriba == true){
			y = (int) (ubicacion.getY() - y); 
			ubicacion.setLocation(ubicacion.getX(), y);
			setMoverse(false);
		}
		else if (direccion == 1 && moverAbajo == true){
			y = (int) (ubicacion.getY() + y);
			ubicacion.setLocation(ubicacion.getX(), y);
			setMoverse(false);
		}
		else if (direccion == 2 && moverDerecha == true){
			x = (int) (ubicacion.getX() + x);
			ubicacion.setLocation(x, ubicacion.getY());
			setMoverse(false);
		}
		else if (direccion == 3 && moverIzquierda == true){
			x = (int) (ubicacion.getX() - x);
			ubicacion.setLocation(x, ubicacion.getY());
			setMoverse(false);
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

	public void setMoverse(boolean mov) {
		moverDerecha = mov;
		moverIzquierda = mov;
		moverAbajo = mov;
		moverArriba = mov;
	}

}
