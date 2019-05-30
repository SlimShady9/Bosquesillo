package vista;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelPuntaje extends JFrame{

	private JLabel lPuntaje, nPasos, mayorPuntaje;
	private JLabel puntaje ;
	private JFrameP fr;
	private Controlador c;

	public PanelPuntaje(JFrameP fr) {
		this.fr  = fr;
		c = fr.getControl();
		setLayout(new GridLayout(3,3));
		setSize(250, 200);
		setResizable(false);
		iniciarComponentes();
		getContentPane().setBackground(Color.red);
	}

	public void iniciarComponentes() {
		String score = Integer.toString(c.getPuntaje());
		lPuntaje = new JLabel("  Puntaje:");
		puntaje = new JLabel(score);
		nPasos = new JLabel("  Pasos restantes: ");
		mayorPuntaje = new JLabel ("   El mayor puntaje es:  ");	
		add(nPasos);
		add(puntaje);
		add(mayorPuntaje);
		puntaje.setBorder(BorderFactory.createLineBorder(Color.black));
		lPuntaje.setBorder(BorderFactory.createLineBorder(Color.black));
		nPasos.setBorder(BorderFactory.createLineBorder(Color.black));
		mayorPuntaje.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	public JLabel getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(JLabel puntaje) {
		this.puntaje = puntaje;
	}

	public void actiulizar() {
		String score = Integer.toString(c.getPuntaje());
		puntaje.setText(score);

	}


}