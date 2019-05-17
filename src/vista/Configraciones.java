package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class Configraciones extends JPanel  implements ActionListener {

	private JLabel dificultad, nCasillasX, nCasillasY ;
	private JButton facil, intermedio, dificil;;
	private JFrameP f;
	private JButton volver, aceptar;
	private JSpinner faspinnerx, faspinnery;
	private int valorx, valory;
	
	public Configraciones(JFrameP f){
		this.f = f;
		setLayout(null);
		setSize(600, 600);
		setBackground(Color.getHSBColor(100, 100, 100));
		cargarComponentes();

	}

	public void cargarComponentes() {

		cargarLabels();
		cargarBotonesDificultad();
		cargarSpinners();
		cargarBotones();

	}
	public void cargarLabels(){
		Font fuente = new Font("Comic Sans MS", Font.ITALIC, 36);

		dificultad = new JLabel("Creacion de la matriz");
		dificultad.setFont(fuente);
		dificultad.setBounds(20, 20, 150, 50);
		add(dificultad);

		nCasillasX = new JLabel("Numero de casillas en X");
		nCasillasX.setFont(fuente);
		nCasillasX.setBounds(20, 160, 150, 50);
		add(nCasillasX);

		nCasillasY = new JLabel("Numero de casillas en Y");
		nCasillasY.setFont(fuente);
		nCasillasY.setBounds(20, 230, 150, 50);
		add(nCasillasY);


	}


	public void cargarBotonesDificultad(){
		facil = new JButton(" Nivel Facil ");
		facil.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		facil.setForeground(Color.BLACK);
		add(facil);
		facil.setBounds(40, 90, 150, 50);

		intermedio = new JButton(" Nivel Intermedio  ");
		intermedio.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		facil.setForeground(Color.BLACK);
		add(intermedio);
		intermedio.setBounds(200, 90, 150, 50);

		dificil = new JButton (" Nivel Dificil  ");
		add(dificil);
		dificil.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		facil.setForeground(Color.BLACK);
		dificil.setBounds(400, 90, 150, 50);

	}
	public void cargarSpinners(){
		SpinnerModel fa = new SpinnerNumberModel(5,5,20,1);
		SpinnerModel fay = new SpinnerNumberModel(5,5,20,1);
		faspinnerx = new JSpinner(fa);
		faspinnery = new JSpinner(fay);
		add(faspinnery);
		add(faspinnerx);
		faspinnerx.setBounds(200, 160, 50, 50);
		faspinnery.setBounds(200, 230, 50, 50);

	}
	public void cargarBotones(){
		volver = new JButton ("volver");
		volver.addActionListener(this);
		volver.setBackground(Color.DARK_GRAY);
		volver.setFont(new Font("Book Antiqua", Font.ITALIC, 38));
		volver.setBounds(20, 530, 150, 50);
		add(volver);

		aceptar = new JButton("aceptar");
		aceptar.addActionListener(this);
		aceptar.setBackground(Color.DARK_GRAY);
		aceptar.setFont(new Font("Book Antiqua", Font.ITALIC, 38));
		aceptar.setBounds(450, 530 , 150, 50);
		add(aceptar);
	}
	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();

		if (accion == volver.getActionCommand()){
			setVisible(false);
			f.getpM().setVisible(true);

		}
		if( accion==aceptar.getActionCommand()){
			valorx = (int)faspinnerx.getValue();
			valory = (int)faspinnery.getValue();
			setVisible(false);
			f.getpM().setVisible(true);
		}
	}

	public int getValorx() {
		return valorx;
	}

	public int getValory() {
		return valory;
	}
	
}
