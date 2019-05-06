package vista;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelPantallaJuego extends JPanel implements KeyListener{

	private JButton botonB;
	private JLabel[] mLetal;
	private JLabel thor[];
	private JLabel trump[];
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
		trump = new JLabel[5];
		JLabel[] eo = c.asignarTrumps();
		for (int i = 0 ; i < trump.length ; i++) {
			trump[i] = eo[i];
			add(trump[i]);
		}
	}
	public void cargarThor (){
		thor = new JLabel[5];
		JLabel[] eo = c.asignarThor();
		for (int i = 0 ; i < thor.length ; i++) {
			thor[i] = eo[i];
			add(thor[i]);
		}
	}
	public void cargarBosquesillo() {
		botonB = c.asignarBosquesillo();
		botonB.addKeyListener(this);
		add(botonB);
	}

	public void cagarMonstruo(){
		mLetal = new JLabel[5];
		JLabel[] eo = c.asignarMonstuoL();
		for (int i = 0; i < mLetal.length; i++) {
			mLetal[i] = eo[i];
			add(mLetal[i]);
		}
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

	public void actualizarPBosquesillo() {
		botonB.setLocation(c.getBosque());
	}

	public void actualizarPMLetales(){
		for (int i = 0 ; i < mLetal.length ; i++) {
			mLetal[i].setLocation(c.getMLetal(i));
		}
	}
	public void actualizarPThores(){
		for (int i = 0 ; i < thor.length ; i++) {
			thor[i].setLocation(c.getThor(i));
		}
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
			actualizarPBosquesillo();
			actualizarPMLetales();
			actualizarPThores();

		}
		if (key == KeyEvent.VK_DOWN) {
			c.moverAbajo();
			actualizarPBosquesillo();
			actualizarPMLetales();
			actualizarPThores();
		}
		if (key == KeyEvent.VK_LEFT) {
			c.moverIzquierda();
			actualizarPBosquesillo();
			actualizarPMLetales();
			actualizarPThores();
		}
		if (key == KeyEvent.VK_RIGHT) {
			c.moverDerecha();
			actualizarPBosquesillo();
			actualizarPMLetales();
			actualizarPThores();

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