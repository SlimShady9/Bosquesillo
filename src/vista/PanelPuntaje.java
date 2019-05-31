package vista;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelPuntaje extends JFrame{

	private JLabel puntaje, nPasos;
	private JLabel pasos , score;
	private JFrameP fr;
	private Controlador c;

	public PanelPuntaje(JFrameP fr) {
		this.fr  = fr;
		c = fr.getControl();
		setLayout(new GridLayout(2, 2));
		setSize(250, 200);
		setResizable(false);
		iniciarComponentes();
		getContentPane().setBackground(Color.red);
	}

	public void iniciarComponentes() {
		String sPasos = Integer.toString(c.getPasos());
		String sScore = Integer.toString(c.getScore());
		nPasos = new JLabel("  Pasos restantes: ");
		puntaje = new JLabel ("   Su puntaje es:  ");	
		pasos = new JLabel(sPasos);
		score = new JLabel(sScore);
		add(nPasos);
		add(pasos);
		add(puntaje);
		add(score);
		pasos.setBorder(BorderFactory.createLineBorder(Color.black));
		puntaje.setBorder(BorderFactory.createLineBorder(Color.black));
		nPasos.setBorder(BorderFactory.createLineBorder(Color.black));
		score.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	public JLabel getPasos() {
		return pasos;
	}
	public JLabel getScore() {
		return score;
	}

	public void setPasos(JLabel pasos) {
		this.pasos = pasos;
	}

	public void actiulizar() {
		String sPasos = Integer.toString(c.getPasos());
		String sScore = Integer.toString(c.getScore());
		pasos.setText(sPasos);
		score.setText(sScore);
	}


}