package modelo;
import java.awt.Image;
import java.awt.font.NumericShaper.Range;
import java.util.Random;
import javax.swing.ImageIcon;
import vista.PanelPantallaJuego;

public class Bosquesillo {

	private int[][] posicion;
	private int posX;
	private int posY;
	private String imBosquesillo;
	private int maxX;
	private int maxY;
	private Random rd;
	
	public Bosquesillo(int x, int y){
		rd = new Random();
		maxX = x;
		maxY= y;
		posInicial();
	}
	public void posInicial(){
		posX = rd.nextInt(maxX);
 		posY = rd.nextInt(maxY);

		posicion = new int[posX][posY];

	}

	public String cargarImagenes(){
		return imBosquesillo = "(^･ｪ･^)";
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
