package modelo;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;

public class Bosquesillo {

	private int[][] posicion;
	private int posX;
	private int posY;
	private int maxX;
	private int maxY;
	private ImageIcon imagen;
	
	public Bosquesillo(int x, int y){
		maxX = x;
		maxY= y;
		posInicial();
	}
	public void posInicial(){
		posX = ThreadLocalRandom.current().nextInt(0, maxX );
 		posY = ThreadLocalRandom.current().nextInt(0, maxY );

		posicion = new int[posX][posY];

	}

	public ImageIcon cargarImagenes(){
		imagen = new ImageIcon("Data/Bosquesillo.jpeg");
		return imagen;
	}

	public void actualizar(){

	}

	public int[][] getPosicion() {
		return posicion;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	



}
