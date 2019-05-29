package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
		setLayout(new FlowLayout(0,20,20));
		setSize(250, 200);
		setResizable(false);
		iniciarComponentes();
		
	}
	
	public void iniciarComponentes() {
		String score = Integer.toString(c.getPuntaje());
		lPuntaje = new JLabel("Puntaje:");
		puntaje = new JLabel(score);
		nPasos = new JLabel("Pasos restantes: ");
		mayorPuntaje = new JLabel ("el mayor puntaje es:  ");		
		
		add(nPasos);
		add(puntaje);
		add(mayorPuntaje);
		
	}
	public void actiulizar() {
		String score = Integer.toString(c.getPuntaje());
		puntaje.setText(score);
	}
	

}
