package modelo;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;


public class Carreta {

	private ImageIcon imagen;
	private Point ubicacion;
	private int maxX, maxY;
	private boolean moverArriba, moverAbajo, moverIzquierda, moverDerecha;

	public Carreta  (int x, int y){

		maxX = x;
		maxY = y;
	}

	public void iniciarPosicion(Point[] posObj){
		int posX = ThreadLocalRandom.current().nextInt(0 , maxX );
		int posY = ThreadLocalRandom.current().nextInt(0 , maxY );
		while (posX % 30 != 0){
			posX --;
		}
		while (posY % 30 != 0){
			posY --;
		}
		ubicacion = new Point(posX, posY);
		for (int i = 0  ; i < posObj.length ; i++) {
			if(posObj[i] != null) {
				if (ubicacion.equals(posObj[i])) {
					ubicacion = null;
					iniciarPosicion(posObj);
				}
			}
		}
	}
	public void verificarBosque(Point obj) {

		if (ubicacion.getX() == obj.getX() + 30 && ubicacion.getY() == obj.getY()) {
			if (ubicacion.getX() + 30 == maxX) {
				ubicacion.setLocation(ubicacion.getX() - 30, ubicacion.getY());
			}
			else {
				moverDerecha = true;
			}
		}
		if (ubicacion.getX() + 30  == obj.getX() && ubicacion.getY() == obj.getY()) {
			if (ubicacion.getX() == 0) {
				ubicacion.setLocation(ubicacion.getX() + 30, ubicacion.getY());
			}
			else {
				moverIzquierda = true;
			}
		}
		if (ubicacion.getY() == obj.getY() + 30 && ubicacion.getX() == obj.getX()) {
			if (ubicacion.getY() + 30 == maxY) {
				ubicacion.setLocation(ubicacion.getX(), ubicacion.getY() - 30);
			}
			else {
				moverAbajo = true;
			}
		}
		if (ubicacion.getY() + 30  == obj.getY() && ubicacion.getX() == obj.getX()) {
			if (ubicacion.getY() == 0) {
				ubicacion.setLocation(ubicacion.getX(), ubicacion.getY() + 30);
			}
			else {
				moverArriba = true;
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
	public void verificarObjs(Point obj) {

		if (ubicacion.getX() + 30 == obj.getX() && ubicacion.getY() == obj.getY()) {
			if (ubicacion.getX() + 30 == 0) {
				moverDerecha = false;
			}
			
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
	public ImageIcon cargarImagen(){
		imagen = new ImageIcon("Data/Car.png");
		return imagen;
	}

	public Point getUbicacion () {
		return ubicacion;
	}



}
