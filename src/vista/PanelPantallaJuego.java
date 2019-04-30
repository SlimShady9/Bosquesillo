package vista;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.concurrent.ThreadLocalRandom;
import modelo.Bosquesillo;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPantallaJuego extends JPanel{
	private int dimX;
	private int dimY;
	private Bosquesillo b;
	private JButton botonB;
	private JButton[][] matriz;
	private PanelPrincipal pPrincipal;

	public PanelPantallaJuego(PanelPrincipal p) {
		
		pPrincipal = p;
		dimX = ThreadLocalRandom.current().nextInt(5, 20);
		dimY = ThreadLocalRandom.current().nextInt(5, 20);
		b = new Bosquesillo(dimX , dimY);
		matriz = new JButton[dimX][dimY];
		inicializarTabla();
		cargarGrid();
	}


	public void inicializarTabla() {
		
		for (int i = 0 ; i < dimX; i++) {
			for (int j = 0 ; j < dimY ; j++) {
				if (b.getPosX() == i && b.getPosY() == j){
					botonB = new JButton(b.cargarImagenes());
					botonB.addKeyListener(pPrincipal);
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


	public Bosquesillo getB() {
		return b;
	}


	public JButton getBotonB() {
		return botonB;
	}


	

}