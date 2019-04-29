package vista;
import java.awt.GridLayout;
import java.util.concurrent.ThreadLocalRandom;
import modelo.Bosquesillo;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPantallaJuego extends JPanel{
	private int dimX;
	private int dimY;
	private Bosquesillo b;
	private JButton botonB;
	private JButton[][] matriz;

	public PanelPantallaJuego() {
		dimX = ThreadLocalRandom.current().nextInt(1, 10);
		dimY = ThreadLocalRandom.current().nextInt(1, 10);
		b = new Bosquesillo(dimX , dimY);
		setLayout(new GridLayout(dimX , dimY ));
		matriz = new JButton[dimX][dimY];
		inicializarTabla();
		cargarGrid();
	}


	public void inicializarTabla() {
		for (int i = 0 ; i < dimX; i++) {
			for (int j = 0 ; j < dimY ; j++) {
				if (b.getPosX() == i && b.getPosY() == j){
					botonB = new JButton(b.cargarImagenes());
				}else {
					matriz[i][j] = new JButton(" ");
				}
			}
		}
	}
	public void cargarGrid() {
		for (int i = 0 ; i < dimX ; i++) {
			for (int j = 0 ; j < dimY ; j++) {
				if (b.getPosX() == i && b.getPosY() == j){
					add(botonB);
				}
				else {
					add(matriz[i][j]);
				}
			}
		}
		validate();
	}

	public int getDimX() {
		return dimX;
	}
	public int getDimY() {
		return dimY;
	}

}