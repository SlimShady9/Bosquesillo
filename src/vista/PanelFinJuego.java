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

import controlador.Controlador;

public class PanelFinJuego extends JPanel  implements ActionListener {

	private JLabel Titulo, sc, nCasillasY, score ;
	private JFrameP f;
	private JButton volver, aceptar, salir;
	private int valorx, valory;
	private Controlador c;

	public PanelFinJuego(JFrameP f){
		this.f = f;
		c = f.getControl();
		valorx = 15;
		valory = 15;
		setLayout(null);
		setSize(400, 400);
		setBackground(Color.getHSBColor(255, 175, 40));
		cargarComponentes();

	}

	public void cargarComponentes() {

		cargarLabels();
		cargarBotones();

	}
	public void cargarLabels(){
		Font fuente1 = new Font("Comic Sans MS", Font.ITALIC, 20);
		Font fuentet = new Font("Comic Sans MS", Font.CENTER_BASELINE, 26);
		String sScore = Integer.toString(c.getScore());
		
		Titulo = new JLabel("LA PODEROSA URSS HA CAIDO :'(");
		Titulo.setFont(fuentet);
		Titulo.setBounds(60, 60, 250, 50);
		add(Titulo);

		sc = new JLabel("SCORE:");
		sc.setFont(fuente1);
		sc.setBounds(190, 140, 250, 50);
		add(sc);
		
		score = new JLabel (sScore);
		score.setFont(fuente1);
		score.setBounds(390, 140, 250, 50);
		add(sc);
		

		nCasillasY = new JLabel("HIGH SCORE:");
		nCasillasY.setFont(fuente1);
		nCasillasY.setBounds(125, 230, 500, 50);
		add(nCasillasY);

	}
	
	public void cargarBotones(){
		volver = new JButton ("Volver como China");
		volver.addActionListener(this);
		volver.setBackground(Color.RED);
		volver.setFont(new Font("Book Antiqua", Font.ITALIC, 18));
		volver.setBounds(30, 500, 200, 50);
		add(volver);

		aceptar = new JButton("Ir a menu principal");
		aceptar.addActionListener(this);
		aceptar.setBackground(Color.RED);
		aceptar.setFont(new Font("Book Antiqua", Font.ITALIC, 18));
		aceptar.setBounds(235, 500 , 210, 50);
		add(aceptar);
	
		salir = new JButton("Salir");
		salir.addActionListener(this);
		salir.setBackground(Color.RED);
		salir.setFont(new Font("Book Antiqua", Font.ITALIC, 18));
		salir.setBounds(450, 500 , 105, 50);
		add(salir);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String accion = arg0.getActionCommand();

		if (accion == aceptar.getActionCommand()){
			setVisible(false);
			f.getpM().setVisible(true);
		}
		if (accion == salir.getActionCommand()) {
			System.exit(0);
		}
	}
}