package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;
import modelo.Ajustes;

public class JFrameP extends JFrame{
	
	
	private PanelPantallaJuego pJ;
	private PanelFinal pF;
	private PanelMenu pM;
	private Controlador c;
	private Configraciones cof;
	
	public JFrameP(Controlador co){
		super("Juego");
		c = co;
		setBackground(Color.BLACK);
		setLayout(null);
		setSize(600, 600);
		setResizable(true);
		setVisible(true);
		iniciarPaneles();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void iniciarPaneles(){
		pM = new PanelMenu(this);
		pM.setVisible(true);
		pM.setBounds(0 ,0 , 600, 600);
		add(pM);
		cof = new Configraciones(this);
		cof.setVisible(false);
		cof.setBounds(0, 0, 600, 600);
		add(cof);
	}
	
	public void iniciarPanelPJuego() {
		int posX = (570 -((cof.getValorx() * 30) ))/2;
		int posY = (570 -((cof.getValory() * 30) ))/2;
		pJ = new PanelPantallaJuego(this);
		pJ.setVisible(false);
		pJ.setBounds(posX, posY, cof.getValorx() * 30, cof.getValory() * 30);
		add(pJ);
		
	}

	public PanelPantallaJuego getpJ() {
		return pJ;
	}

	public PanelFinal getpF() {
		return pF;
	}

	public PanelMenu getpM() {
		return pM;
	}

	public Configraciones getCof() {
		return cof;
	}
	public Controlador getControl() {
		return c;
	}
	
	
}