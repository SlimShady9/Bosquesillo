package modelo;

import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;


public class Meta {

	private ImageIcon imagen;
	private Point ubicacion;
	private int maxX, maxY;

	public Meta (int x, int y){

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
	public ImageIcon cargarImagen(){
		imagen = new ImageIcon("Data/Meta.jpeg");
		return imagen;
	}

	public Point getUbicacion () {
		return ubicacion;
	}



}
