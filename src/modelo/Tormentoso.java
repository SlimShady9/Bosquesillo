package modelo;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

public class Tormentoso {

	private Point ubicacion;
	private int maxX, maxY;
	private ImageIcon imagen;
	private boolean moverse;

	public Tormentoso(int x, int y){
		moverse = false;
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
		imagen = new ImageIcon("Data/Tormentoso.png");
		return imagen;
	}

	public void moverse(Point obj){
		int x = 30;
		int y = 30;
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
			ubicacion.setLocation(ubicacion.getX()+x, ubicacion.getY());
			if (ubicacion.getX() + 30 == obj.getX() && ubicacion.getY() == obj.getY()) {
				moverse(obj);

			}
			if (direccion == 3){
				x = (int) (ubicacion.getX() - x);
				ubicacion.setLocation(x, ubicacion.getY());
				moverse = false;
			}
		}
	}

	public void verificarObjs(Point obj) {

		if (ubicacion.getX() + 30 == obj.getX() && ubicacion.getY() == obj.getY()) {
			moverse = false;
		}
		if (ubicacion.getX() - 30 == obj.getX() && ubicacion.getY() == obj.getY()) {
			moverse = false;
		}
		if (ubicacion.getY() + 30 == obj.getY() && ubicacion.getX() == obj.getX()) {
			moverse = false;
		}
		if (ubicacion.getY() - 30 == obj.getY() && ubicacion.getX() == obj.getX()) {
			moverse = false;
		}
	}

	public void verificarMuros() {
		if (ubicacion.getX() + 30 ==  maxX ) {
			moverse = false;
		}
		if (ubicacion.getX() == 0) {
			moverse = false;
		}
		if (ubicacion.getY() + 60 == maxY ) {
			moverse = false;
		}
		if (ubicacion.getY() == 0) {
			moverse = false;
		}
	}


	public Point getUbicacion() {
		return ubicacion;
	}

	public boolean isMoverse() {
		return moverse;
	}

	public void setMoverse(boolean moverse) {
		this.moverse = moverse;
	}
}
