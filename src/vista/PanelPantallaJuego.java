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
	private JLabel[] mLetal;
	private JLabel thor[];
	private JLabel trump[];
	private JLabel tablero[][];
	private Controlador c;
	private JFrameP fr;
	private JPanel esc;
	public PanelPantallaJuego(JFrameP fr) {

		this.fr = fr;
		setLayout(null);
		c = fr.getControl();
		c.iniciarCompoJuego();
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

	public void cagarMonstruo(){
		mLetal = new JLabel[c.getAjustes().getcObjetos()];
		System.out.println(mLetal.length);
		JLabel[] eo = c.asignarMonstuoL();
		System.out.println(eo.length);
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
		if( key ==  KeyEvent.VK_ESCAPE) {
			
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