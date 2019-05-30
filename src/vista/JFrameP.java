package vista;

import java.awt.Color;
import javax.swing.JFrame;
import controlador.Controlador;

public class JFrameP extends JFrame{
	
	
	private PanelPantallaJuego pJ;
	private PanelFinJuego pF;
	private PanelMenu pM;
	private Controlador c;
	private Configuraciones cof;
	private PanelInstrucciones pI;
	private Esc esc;
	private PanelPuntaje puntaje;

	
	public JFrameP(Controlador co){
		super("Bosquecillo");
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
		cof = new Configuraciones(this);
		cof.setVisible(false);
		cof.setBounds(0, 0, 610, 630);
		add(cof);
		pI = new PanelInstrucciones(this);
		pI.setVisible(false);
		pI.setBounds(0, 0, 610, 630);
		add(pI);
		esc = new Esc(this);
		esc.setVisible(false);
		esc.setBounds(100, 100, 400, 300);
		add(esc);
		pF = new PanelFinJuego(this);
		pF.setBounds(0, 0, 610, 630);
		pF.setVisible(false);
		add(pF);
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

	public PanelFinJuego getpF() {
		return pF;
	}

	public PanelMenu getpM() {
		return pM;
	}
	public Esc getEsc() {
		return esc;
	}

	public Configuraciones getCof() {
		return cof;
	}
	
	public PanelInstrucciones getpI() {
		return pI;
	}

	public Controlador getControl() {
		return c;
	}
	
	
}