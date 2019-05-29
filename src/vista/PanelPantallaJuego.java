package vista;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;
import modelo.Ajustes;

public class PanelPantallaJuego extends JPanel implements KeyListener{

	private JButton botonB;
	private JLabel carro;
	private JLabel[] mLetal;
	private JLabel thor[];
	private JLabel trump[];
	private JLabel tablero[][];
	private Controlador c;
	private JFrameP fr;

	public PanelPantallaJuego(JFrameP fr) {

		this.fr = fr;
		setLayout(null);
		c = fr.getControl();
		c.iniciarCompoJuego();
		iniciarObjetos();

	}


	public void iniciarObjetos() {
		cargarBosquesillo();
		cargarCarro();
		cagarMonstruo();
		cargarThor();
		cargarTrump();
		cargarTabla();
	}

	private void cargarTrump() {
		trump = new JLabel[c.getAjustes().getcObjetos()];
		JLabel[] eo = c.asignarTrumps();
		for (int i = 0 ; i < trump.length ; i++) {
			trump[i] = eo[i];
			add(trump[i]);
		}
	}
	public void cargarThor (){
		thor = new JLabel[c.getAjustes().getcObjetos()];
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
	public void cargarCarro() {
		carro = c.asignarCarrito();
		add(carro);
	}

	public void cagarMonstruo(){
		mLetal = new JLabel[c.getAjustes().getcObjetos()];
		JLabel[] eo = c.asignarMonstuoL();
		for (int i = 0; i < mLetal.length; i++) {
			mLetal[i] = eo[i];
			add(mLetal[i]);
		}
	}
	public void cargarTabla() {
		tablero = c.asignarTablero();
		int x = c.getAjustes().getDimX() ;
		int y = c.getAjustes().getDimY() ;
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
	public void actualizarCarro() {
		carro.setLocation(c.getCarro());
	}


	public JButton getBotonB() {
		return botonB;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		int key = arg0.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			if (c.verificarMuerte()) {

				setVisible(false);
				fr.getpF().setVisible(true);
			}
			else {
				c.moverArriba();
				fr.getPuntaje().actiulizar();
				actualizarPMLetales();
				actualizarPThores();
				actualizarCarro();
				actualizarPBosquesillo();
			}



		}
		if (key == KeyEvent.VK_DOWN) {
			if (c.verificarMuerte()) {
				setVisible(false);
				fr.getpF().setVisible(true);
				fr.getPuntaje().setVisible(false);
			}
			else {
				c.moverAbajo();
				fr.getPuntaje().actiulizar();
				actualizarPMLetales();
				actualizarPThores();
				actualizarCarro();
				actualizarPBosquesillo();
			}
			

		}
		if (key == KeyEvent.VK_LEFT) {
			if (c.verificarMuerte()) {
				setVisible(false);
				fr.getpF().setVisible(true);
				fr.getPuntaje().setVisible(false);
			}
			else {
				c.moverIzquierda();
				fr.getPuntaje().actiulizar();
				actualizarPMLetales();
				actualizarPThores();
				actualizarCarro();
				actualizarPBosquesillo();
			}
			

		}
		if (key == KeyEvent.VK_RIGHT) {
			if (c.verificarMuerte()) {
				fr.getPuntaje().setVisible(false);
				setVisible(false);
				fr.getpF().setVisible(true);
			}
			else {
				c.moverDerecha();
				fr.getPuntaje().actiulizar();
				actualizarPMLetales();
				actualizarPThores();
				actualizarCarro();
				actualizarPBosquesillo();	
			}
			


		}
		if( key ==  KeyEvent.VK_ESCAPE) {
			setEnabled(false);
			botonB.setEnabled(false);
			fr.getEsc().setVisible(true);
		}

	}

	public JButton getBosquesillo() {
		return botonB;
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