package modelo;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;


public class Checkpoint {

	private ImageIcon imagen;
	private Point ubicacion;
	private int maxX, maxY;

	public Checkpoint (int x, int y){

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
	public boolean verificarObjs(Point obj) {

		boolean pego = false;
		if (ubicacion.getX() == obj.getX() && ubicacion.getY() == obj.getY()) {
			pego = true;
		}
		if (ubicacion.getX() == obj.getX() && ubicacion.getY() == obj.getY()) {
			pego = true;
		}
		if (ubicacion.getY() == obj.getY() && ubicacion.getX() == obj.getX()) {
			pego = true;
		}
		if (ubicacion.getY() == obj.getY() && ubicacion.getX() == obj.getX()) {
			pego = true;
		}
		return pego;
				
	}
	public ImageIcon cargarImagen(){
		imagen = new ImageIcon("Data/Check.jpeg");
		return imagen;
	}

	public Point getUbicacion () {
		return ubicacion;
	}

	public void setUbicacion(Point ubicacion) {
		this.ubicacion = ubicacion;
	}
	



}
