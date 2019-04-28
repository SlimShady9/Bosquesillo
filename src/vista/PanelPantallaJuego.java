package vista;
import java.awt.GridLayout;
import java.util.Random;
import modelo.Bosquesillo;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPantallaJuego extends JPanel{
	private int dimension_x;
	private int dimension_y;
	private JButton[][] matiz_botones;
	private Bosquesillo b;
	private Random rd;
	
	public PanelPantallaJuego() {
		rd = new Random();
		dimension_x = rd.nextInt(9);
		dimension_y = rd.nextInt(9);
		b = new Bosquesillo(dimension_x , dimension_y);
		setLayout(new GridLayout(dimension_x , dimension_y ));
		matiz_botones = new JButton[dimension_x][dimension_y];
		inicilizarBotones();
		cargarGrid();
		}
		
	
	public void inicilizarBotones() {
		for (int i = 0 ; i < dimension_x; i++) {
			for (int j = 0 ; j < dimension_y ; j++) {
				if (b.getPosX() == i && b.getPosY() == j){
					matiz_botones[i][j] = new JButton(b.cargarImagenes());
				}
				else{
					matiz_botones[i][j] = new JButton("  ");
				}
				
			}
		}
	}
	public void cargarGrid() {
		for (int i = 0 ; i < dimension_x ; i++) {
			for (int j = 0 ; j < dimension_y ; j++) {
				add(matiz_botones[i][j]);
			}
		}
		validate();
	}

	public int getDimension_x() {
		return dimension_x;
	}
	public int getDimension_y() {
		return dimension_y;
	}

}