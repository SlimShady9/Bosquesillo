package modelo;
import javax.swing.ImageIcon;
public class Tablero {

	private ImageIcon imagenA;
	private ImageIcon imagenB;
	
	public Tablero () {
		
	}
	

	public ImageIcon cargarImagenA() {
		imagenA = new ImageIcon("Data/TableroA.jpeg");
		return imagenA;
	}

	public ImageIcon cargarImagenB() {
		imagenB = new ImageIcon("Data/TableroB.jpeg");
		return imagenB;
	}
	
}
