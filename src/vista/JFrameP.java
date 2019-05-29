package vista;

import java.awt.Color;
import javax.swing.JFrame;
import controlador.Controlador;

public class JFrameP extends JFrame{
	
	
	private PanelPantallaJuego pJ;
	private PanelFinal pF;
	private PanelMenu pM;
	private Controlador c;
	private Configraciones cof;
	private Esc esc;
	private PanelPuntaje puntaje;

	
	public JFrameP(Controlador co){
		super("Juego");
		c = co;
		setBackground(Color.BLACK);
		setLayout(null);
		setSize(610, 630);
		setLocation(0, 0);
		setResizable(false);
		setVisible(true);
		iniciarPaneles();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void iniciarPaneles(){
		pM = new PanelMenu(this);
		pM.setVisible(true);
		pM.setBounds(0 ,0 , 610, 630);
		add(pM);
		cof = new Configraciones(this);
		cof.setVisible(false);
		cof.setBounds(0, 0, 610, 630);
		add(cof);
		esc = new Esc(this);
		esc.setVisible(false);
		esc.setBounds(100, 100, 250, 300);
		add(esc);
		

		
	}
	public void iniciarPuntaje() {
		puntaje  = new PanelPuntaje(this);
		puntaje.setVisible(true);
		puntaje.setLocation(630, 310);
	}
	public void iniciarPanelPJuego() {
		int posX = (600 -((cof.getValorx() * 30) ))/2;
		int posY = (600 -((cof.getValory() * 30) ))/2;
		pJ = new PanelPantallaJuego(this);
		pJ.setVisible(false);
		pJ.setBounds(posX, posY, cof.getValorx() * 30, cof.getValory() * 30);
		add(pJ);
		
	}

	public PanelPantallaJuego getpJ() {
		return pJ;
	}

	public PanelPuntaje getPuntaje() {
		return puntaje;
	}

	public void setpJ(PanelPantallaJuego pJ) {
		this.pJ = pJ;
	}

	public PanelFinal getpF() {
		return pF;
	}

	public PanelMenu getpM() {
		return pM;
	}
	public Esc getEsc() {
		return esc;
	}

	public Configraciones getCof() {
		return cof;
	}
	public Controlador getControl() {
		return c;
	}
	
	
}