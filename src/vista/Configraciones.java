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
		valorx = 15;
		valory = 15;
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

		dificultad = new JLabel("Dificultad");
		dificultad.setFont(fuente);
		dificultad.setBounds(200, 20, 500, 50);
		add(dificultad);

		nCasillasX = new JLabel("Numero de casillas en X");
		nCasillasX.setFont(fuente);
		nCasillasX.setBounds(20, 160, 500, 50);
		add(nCasillasX);

		nCasillasY = new JLabel("Numero de casillas en Y");
		nCasillasY.setFont(fuente);
		nCasillasY.setBounds(20, 230, 500, 50);
		add(nCasillasY);


	}


	public void cargarBotonesDificultad(){
		facil = new JButton(" Facil ");
		facil.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		facil.setForeground(Color.BLACK);
		facil.addActionListener(this);
		add(facil);
		facil.setBounds(40, 90, 150, 50);

		intermedio = new JButton(" Medio  ");
		intermedio.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		intermedio.setForeground(Color.BLACK);
		intermedio.addActionListener(this);
		add(intermedio);

		intermedio.setBounds(220, 90, 150, 50);

		dificil = new JButton (" Dificil  ");
		add(dificil);
		dificil.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		dificil.setForeground(Color.BLACK);
		dificil.addActionListener(this);
		dificil.setBounds(400, 90, 150, 50);

	}
	public void cargarSpinners(){
		SpinnerModel fa = new SpinnerNumberModel(5,5,20,1);
		SpinnerModel fay = new SpinnerNumberModel(5,5,20,1);
		faspinnerx = new JSpinner(fa);
		faspinnery = new JSpinner(fay);
		add(faspinnery);
		add(faspinnerx);
		faspinnerx.setBounds(500, 160, 50, 50);
		faspinnery.setBounds(500, 230, 50, 50);

	}
	public void cargarBotones(){
		volver = new JButton ("Volver");
		volver.addActionListener(this);
		volver.setBackground(Color.DARK_GRAY);
		volver.setFont(new Font("Book Antiqua", Font.ITALIC, 38));
		volver.setBounds(20, 500, 190, 50);
		add(volver);

		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		aceptar.setBackground(Color.DARK_GRAY);
		aceptar.setFont(new Font("Book Antiqua", Font.ITALIC, 38));
		aceptar.setBounds(400, 500 , 190, 50);
		add(aceptar);
	}
	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();
		String arg1 = "Facil";

		if (accion == volver.getActionCommand()){
			setVisible(false);
			f.getpM().setVisible(true);

		}
		if( accion==aceptar.getActionCommand()){
			valorx = (int)faspinnerx.getValue();
			valory = (int)faspinnery.getValue();
			f.getControl().getAjustes().setDificultad(arg1);
			f.getControl().getAjustes().setValores(valorx, valory);
			setVisible(false);
			f.getpM().setVisible(true);
		}
		if (accion==facil.getActionCommand()) {
			arg1 = "Facil";
		}
		if (accion==intermedio.getActionCommand()) {
			arg1 = "Medio";
		}
		if (accion==dificil.getActionCommand()) {
			arg1 = "Dificil";
		}
	}

	public int getValorx() {
		return valorx;
	}

	public int getValory() {
		return valory;
	}

}
