package vista;

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
	
	public JFrameP(Controlador co, int dimX, int dimY){
		super("Juego");
		c = co;
		this.dimX = dimX;
		this.dimY = dimY;
		setLayout(null);
		setSize(dimX, dimY);
		setResizable(true);
		setVisible(true);
		iniciarPaneles();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void iniciarPaneles(){
		pM = new PanelMenu(this);
		pM.setVisible(true);
		add(pM);
		pM.setBounds(0, 0, dimX, dimY);
		pJ = new PanelPantallaJuego(c);
		pJ.setVisible(false);
		add(pJ);
		pJ.setBounds(0, 0 , dimX, dimY);
		cof = new Configraciones(this);
		cof.setVisible(false);
		add(cof);
		cof.setBounds(0, 0, dimX, dimY);
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