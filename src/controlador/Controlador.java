package controlador;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.*;
import vista.*;

public class Controlador{
	private Bosquesillo b;
	private PanelPrincipal p;
	private Tablero t;
	private MonstruoLetal mL;
	private Tormentoso thor;
	private int dimX, dimY;
	public Controlador() {
		dimX = ThreadLocalRandom.current().nextInt(300, 500);
		dimY = ThreadLocalRandom.current().nextInt(300, 530);
		while (dimX % 30 != 0) {
			dimX++;
		}
		while (dimY % 30 != 0) {
			dimY++;
		}
		iniciarBosquesillo();
		iniciarMostruoL();
		iniciarTormentoso();
		iniciarTablero();
		p = new PanelPrincipal(this, dimX, dimY);
	}
	
	public void iniciarBosquesillo () {
		b = new Bosquesillo(dimX, dimY);
	}
	public void iniciarTormentoso(){
		thor = new Tormentoso(dimX, dimY);
	}
	public void iniciarMostruoL(){
		mL = new MonstruoLetal(dimX, dimY);
	}
	public void iniciarTablero() {
		t = new Tablero();
	}
	public JButton asignarBosquesillo () {
		ImageIcon imagenB = b.cargarImagenes();
		int posX = b.getPosX();
		int posY = b.getPosY();
		JButton r = new JButton(imagenB);
		r.setBounds(posX, posY, 30, 30);
		return r;
	}
	public JLabel asignarThor(){
		ImageIcon imagenThor = thor.cargarImagen();
		int posX = thor.getPosX();
		int posY = thor.getPosY();
		JLabel r = new JLabel(imagenThor);
		r.setBounds(posX, posY, 30, 30);
		return r;
	}
	public JLabel asignarMonstruo(){
		ImageIcon imagenML = mL.cargarImagen();
		int posX = mL.getPosX();
		int posY = mL.getPosY();
		JLabel r = new JLabel(imagenML);
		r.setBounds(posX, posY, 30, 30);
		return r;
	}
	public JLabel[][] asignarTablero() {
		ImageIcon imagenA = t.cargarImagenA();
		ImageIcon imagenB = t.cargarImagenB();
		int x = dimX / 30;
		int y = dimY / 30;
		JLabel casillas[][] = new JLabel[x][y];
		for (int i = 0; i < x ; i++) {
			for (int j = 0 ; j < y ; j++) {
				if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
					casillas[i][j] = new JLabel(imagenA);
					casillas[i][j].setBounds((i* 30), (j * 30), 30, 30);
				}
				else {
					casillas[i][j] = new JLabel(imagenB);
					casillas[i][j].setBounds((i* 30), (j * 30), 30, 30);
				}
			}
		}
		return casillas;
	}
	
	public int getPosXBos() {
		return b.getPosX();
	}
	public int getPosYBos() {
		return b.getPosY();
	}
	public int getPosXML(){
		return mL.getPosX();
	}
	public int getPosYML(){
		return mL.getPosY();
	}
	public int getPosXThor(){
		return thor.getPosX();
	}

	public int getPosYThor(){
		return thor.getPosY();
	}
	public int getDimX() {
		return dimX;
	}

	public int getDimY() {
		return dimY;
	}

	public void moverArriba() {
		thor.setMoverse(true);
		thor.moverse();
		thor.setMoverse(false);
		thor.verificarMuros();
		mL.setMoverse(true);
		mL.moverse();
		mL.setMoverse(false);
		mL.verificarMuros();
		b.setMoverArriba(true);
		b.actualizar();
		b.setMoverArriba(false);
		b.verificarMuros();
	}
	public void moverAbajo() {
		thor.setMoverse(true);
		thor.moverse();
		thor.setMoverse(false);
		thor.verificarMuros();
		mL.setMoverse(true);
		mL.moverse();
		mL.setMoverse(false);
		mL.verificarMuros();
		b.setMoverAbajo(true);
		b.actualizar();
		b.setMoverAbajo(false);
		b.verificarMuros();
	}
	public void moverIzquierda() {
		thor.setMoverse(true);
		thor.moverse();
		thor.setMoverse(false);
		thor.verificarMuros();
		mL.setMoverse(true);
		mL.moverse();
		mL.setMoverse(false);
		mL.verificarMuros();
		b.setMoverIzquierda(true);
		b.actualizar();
		b.setMoverIzquierda(false);
		b.verificarMuros();
	}
	public void moverDerecha() {
		thor.setMoverse(true);
		thor.moverse();
		thor.setMoverse(false);
		thor.verificarMuros();
		mL.setMoverse(true);
		mL.moverse();
		mL.setMoverse(false);
		mL.verificarMuros();
		b.setMoverDerecha(true);
		b.actualizar();
		b.setMoverDerecha(false);
		b.verificarMuros();
	}
}
