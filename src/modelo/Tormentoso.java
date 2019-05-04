package modelo;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

public class Tormentoso {
	
	private int posX, posY;
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
		posX = ThreadLocalRandom.current().nextInt(0 , maxX - 30);
		posY = ThreadLocalRandom.current().nextInt(0 , maxY - 60);
		while (posX % 30 != 0){
			posX++;
		}
		while (posY % 30 != 0){
			posY++;
		}
	}
	public ImageIcon cargarImagen(){
		imagen = new ImageIcon("Data/Tormentoso.png");
		return imagen;
	}
	
	public void moverse(){
		if (moverse){
			int direccion = ThreadLocalRandom.current().nextInt(0, 4);
			if (direccion == 0){
				posY -= 30;
			}
			if (direccion == 1){
				posY += 30;
			}
			if (direccion == 2){
				posX += 30;
			}
			if (direccion == 3){
				posX -= 30;
			}
		}
		
	}
	public void verificarMuros() {
		if (posX + 30  > maxX ) {
			posX -= 30;
		}
		if (posX  < 0) {
			posX +=30;
		}
		if (posY + 70> maxY) {
			posY -= 30;
		}
		if (posY < 0) {
			posY += 30;
		}
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public boolean isMoverse() {
		return moverse;
	}

	public void setMoverse(boolean moverse) {
		this.moverse = moverse;
	}
}
