package vista;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Configraciones extends JPanel{
	
	private JLabel dificultad, nCasillas ;
	 private JLabel facil;
	private JLabel intermedio, dificil;
	private JScrollBar rangoX, rangoY;
	private JFrameP f;
	private JButton volver;
	

	
	public Configraciones(JFrameP f){
		this.f = f;
		cargarComponentes();		
	}
	
	public void cargarComponentes() {
		volver = new JButton ("volver0");
		add(volver);
		dificultad = new JLabel("Numero de casillas");
		add(dificultad);
		facil = new JLabel("Facil");
		add(facil);
		SpinnerModel fa = new SpinnerNumberModel(5,5,8,1);
		JSpinner faspinner = new JSpinner(fa);
		add(faspinner);
		intermedio = new JLabel("Intermedio");
		add(intermedio);
		SpinnerModel in = new SpinnerNumberModel(8,8,15,1);
		JSpinner inspinner = new JSpinner(in);
		add(inspinner);
		dificil = new JLabel ("Dificil");
		add(dificil);
		SpinnerModel di = new SpinnerNumberModel(15,15,20,1);
		JSpinner dispinner = new JSpinner(di);
		add(dispinner);		
	
	}
	private void volver() {
		volver.addKeyListener();
		f.setVisible(false);
}
}