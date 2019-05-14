package vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Configraciones extends JPanel{
	
	private JLabel dificultad, nCasillas ;
	private JButton facil, intermedio, dificil;
	private JScrollBar rangoX, rangoY;
	private JFrameP f;
	
	public Configraciones(JFrameP f){
		this.f = f;
		setLayout(new FlowLayout(20, 20, 50));
		cargarComponentes();
			
	}
	
	public void cargarComponentes(){
		dificultad = new JLabel("Dificultad");
		add(dificultad);
		facil = new JButton("Facil");
		add(facil);
		intermedio = new JButton("Intermedio");
		add(intermedio);
		dificil = new JButton("Dificil");
		add(dificil);
		nCasillas = new JLabel("Numero de casillas");
		add(nCasillas);
		rangoX = new JScrollBar();
		add(rangoX);
		rangoY = new JScrollBar();
		add(rangoY);
		
		
	}
}
