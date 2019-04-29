package vista;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PanelPrincipal extends JFrame implements KeyListener {
	
	
	private PanelPantallaJuego pJ;
	
	PanelPrincipal(){
		super("Juego");
		setLayout(new BorderLayout());
		pJ = new PanelPantallaJuego(this);
		add(pJ, BorderLayout.CENTER);
		add(new JButton("Hola"), BorderLayout.SOUTH);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		PanelPrincipal v = new PanelPrincipal();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		int key = arg0.getKeyCode();
		if (key == KeyEvent.VK_UP) {
			pJ.getB().setMoverArriba(true);
			pJ.getB().actualizar();
			pJ.getB().setMoverArriba(false);
			
			pJ.getBotonB().setLocation(pJ.getB().getPosX(), pJ.getB().getPosY());
		}
		if (key == KeyEvent.VK_DOWN) {
			pJ.getB().setMoverAbajo(true);
			pJ.getB().actualizar();
			pJ.getB().setMoverAbajo(false);
			
			pJ.getBotonB().setLocation(pJ.getB().getPosX(), pJ.getB().getPosY());
		}
		if (key == KeyEvent.VK_LEFT) {
			pJ.getB().setMoverIzquierda(true);
			pJ.getB().actualizar();
			pJ.getB().setMoverIzquierda(false);
			
			pJ.getBotonB().setLocation(pJ.getB().getPosX(), pJ.getB().getPosY());
		}
		if (key == KeyEvent.VK_RIGHT) {
			pJ.getB().setMoverDerecha(true);
			pJ.getB().actualizar();
			pJ.getB().setMoverDerecha(false);
			
			pJ.getBotonB().setLocation(pJ.getB().getPosX(), pJ.getB().getPosY());
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