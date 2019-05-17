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

public class JFrameP extends JFrame{
	
	
	private PanelPantallaJuego pJ;
	private PanelFinal pF;
	private PanelMenu pM;
	private Configraciones cof;
	private Controlador c;
	private int dimX, dimY;
	
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
		pJ = new PanelPantallaJuego(c, cof);
		pJ.setVisible(false);
		pJ.setBounds(0, 0, cof.getValorx()* 30, cof.getValory());
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
	
	
}