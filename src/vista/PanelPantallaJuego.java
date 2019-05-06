package vista;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelPantallaJuego extends JPanel implements KeyListener{

	private JButton botonB;
	private JLabel botonML;
	private JLabel botonThor;
	private JLabel Trump[];
	private JLabel tablero[][];
	private Controlador c;
	public PanelPantallaJuego(Controlador co) {
		
		setLayout(null);
		c = co;
		iniciarObjetos();
		
	}


	public void iniciarObjetos() {
		cargarBosquesillo();
		cagarMonstruo();
		cargarThor();
		cargarTrump();
		cargarTabla();
	}
	
	private void cargarTrump() {
		Trump = new JLabel[5];
		JLabel[] eo = c.asignarTrumps();
		for (int i = 0 ; i < Trump.length ; i++) {
			Trump[i] = eo[i];
			add(Trump[i]);
		}
	}
	public void cargarThor (){
		botonThor = c.asignarThor();
		add(botonThor);
	}
	public void cargarBosquesillo() {
		botonB = c.asignarBosquesillo();
		botonB.addKeyListener(this);
		add(botonB);
	}
	
	public void cagarMonstruo(){
		botonML = c.asignarMonstruo();
		add(botonML);
	}
	public void cargarTabla() {
		tablero = c.asignarTablero();
		int x = c.getDimX() / 30;
		int y = c.getDimY() / 30;
		for (int i = 0; i < x ; i++) {
			for (int j = 0 ; j < y; j++) {
				add(tablero[i][j]);
			}
		}
		validate();
	}
	
	public void actualizarPosicionB() {
		int x = c.getPosXBos();
		int y = c.getPosYBos();
		botonB.setLocation(x, y);
	}
	
	public void actualizarPosicionML(){
		int x = c.getPosXML();
		int y = c.getPosYML();
		botonML.setLocation(x, y);
	}
	public void actualizarThor(){
		int x = c.getPosXThor();
		int y = c.getPosYThor();
		botonThor.setLocation(x, y);
	}


	public JButton getBotonB() {
		return botonB;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			c.moverArriba();
			actualizarPosicionB();
			actualizarPosicionML();
			actualizarThor();
			
		}
		if (key == KeyEvent.VK_DOWN) {
			c.moverAbajo();
			actualizarPosicionB();
			actualizarPosicionML();
			actualizarThor();
		}
		if (key == KeyEvent.VK_LEFT) {
			c.moverIzquierda();
			actualizarPosicionB();
			actualizarPosicionML();
			actualizarThor();
		}
		if (key == KeyEvent.VK_RIGHT) {
			c.moverDerecha();
			actualizarPosicionB();
			actualizarPosicionML();
			actualizarThor();

		}
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	

}