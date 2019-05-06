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
		imagen = new ImageIcon("Data/MonstruoLetal.png");
		return imagen;
	}
	
	public void moverse(){
		int x = 30;
		int y = 30;
		if (moverse){
			int direccion = ThreadLocalRandom.current().nextInt(0, 4);
			if (direccion == 0){
				y = (int) (ubicacion.getY() - y); 
				ubicacion.setLocation(ubicacion.getX(), y);
			}
			if (direccion == 1){
				y = (int) (ubicacion.getY() + y);
				ubicacion.setLocation(ubicacion.getX(), y);
			}
			if (direccion == 2){
				x = (int) (ubicacion.getX() + x);
				ubicacion.setLocation(x, ubicacion.getY());
			}
			if (direccion == 3){
				x = (int) (ubicacion.getX() - x);
				ubicacion.setLocation(x, ubicacion.getY());
			}
		}
	}
	public void verificarMuros() {
		int x = 30;
		int y = 30;
		if (ubicacion.getX() + 30  > maxX ) {
			x = (int) (ubicacion.getX() - x);
			ubicacion.setLocation(x, ubicacion.getY());
		}
		if (ubicacion.getX() < 0) {
			x = (int) (ubicacion.getX() + x);
			ubicacion.setLocation(x, ubicacion.getY());
		}
		if (ubicacion.getY() + 70> maxY) {
			y = (int) (ubicacion.getY() - y); 
			ubicacion.setLocation(ubicacion.getX(), y);
		}
		if (ubicacion.getY() < 0) {
			y = (int) (ubicacion.getY() + y);
			ubicacion.setLocation(ubicacion.getX(), y);
		}
	}

	public boolean isMoverse() {
		return moverse;
	}
	
	public Point getUbicacion() {
		return ubicacion;
	}

	public void setMoverse(boolean moverse) {
		this.moverse = moverse;
	}
	
}
