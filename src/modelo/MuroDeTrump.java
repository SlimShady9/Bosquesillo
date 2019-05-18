package modelo;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;


public class MuroDeTrump {

	private ImageIcon imagen;
	private Point ubicacion;
	private int maxX, maxY;

	public MuroDeTrump (int x, int y){

		maxX = x;
		maxY = y;
		iniciarPosicion();
	}

	public void iniciarPosicion(){
		int posX = ThreadLocalRandom.current().nextInt(0 , maxX );
		int posY = ThreadLocalRandom.current().nextInt(0 , maxY );
		while (posX % 30 != 0){
			posX --;
		}
		while (posY % 30 != 0){
			posY --;
		}
		ubicacion = new Point(posX, posY);
	}
	public ImageIcon cargarImagen(){
		imagen = new ImageIcon("Data/Muro.png");
		return imagen;
	}

	public Point getUbicacion () {
		return ubicacion;
	}



}
