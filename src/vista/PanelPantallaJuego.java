package vista;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPantallaJuego extends JPanel{
	private int dimension_x;
	private int dimension_y;
	private JButton[][] matiz_botones;
	
	public PanelPantallaJuego() {
		dimension_x = 10;
		dimension_y = 10;
		setLayout(new GridLayout(dimension_x, dimension_y  ));
		matiz_botones = new JButton[dimension_x][dimension_y];
		inicilizarBotones();
		cargarGrid();
		
	}
	public void inicilizarBotones() {
		for (int i = 0 ; i < dimension_x; i++) {
			for (int j = 0 ; j < dimension_y ; j++) {
				matiz_botones[i][j] = new JButton("  ");
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
	 

}
