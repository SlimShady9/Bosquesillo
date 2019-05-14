package controlador;
import java.awt.Point;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.*;
import vista.*;

public class Controlador{
	private Bosquesillo b;
	private JFrameP p;
	private Tablero t;
	private MonstruoLetal[] mL;
	private Tormentoso[] thor;
	private MuroDeTrump[] trump;
	private int dimX, dimY;
	
	
	public Controlador() {
		dimX = ThreadLocalRandom.current().nextInt(300, 500);
		dimY = ThreadLocalRandom.current().nextInt(300, 530);
		while (dimX % 30 != 0) {
		}
		while (dimY % 30 != 0) {
			dimY++;
		}
		iniciarBosquesillo();
		iniciarMostruoL();
		iniciarTormentoso();
		iniciarTablero();
		iniciarMuroDeTrump();
		p = new JFrameP(this, dimX, dimY);
	}
	
	private void iniciarMuroDeTrump() {
		trump = new MuroDeTrump[5];
	}

	public void iniciarBosquesillo () {
		b = new Bosquesillo(dimX, dimY);
	}
	public void iniciarTormentoso(){
		thor = new Tormentoso[5];
	}
	public void iniciarMostruoL(){
		mL = new MonstruoLetal[5];
	}
	public void iniciarTablero() {
		t = new Tablero();
	}
	public JButton asignarBosquesillo () {
		ImageIcon imagenB = b.cargarImagenes();
		JButton r = new JButton(imagenB);
		r.setBounds((int) b.getUbicacion().getX(), (int) b.getUbicacion().getY(), 30, 30);
		return r;
	}
	public JLabel[] asignarThor(){
		ImageIcon imagenThor;
		int posX, posY;
		JLabel[] r = new JLabel[5];
		for (int i = 0 ; i < r.length ; i++) {
			thor[i] = new Tormentoso(dimX,dimY);
			imagenThor = thor[i].cargarImagen();
			r[i] = new JLabel(imagenThor);
			posX = (int) thor[i].getUbicacion().getX();
			posY = (int) thor[i].getUbicacion().getY();
			r[i].setBounds(posX, posY, 30, 30);
		}
		return r;
		}
	public JLabel[] asignarMonstuoL(){
		ImageIcon imagenML;
		int posX, posY;
		JLabel[] r = new JLabel[5];
		for (int i = 0 ; i < r.length ; i++) {
			mL[i] = new MonstruoLetal(dimX,dimY);
			imagenML = mL[i].cargarImagen();
			r[i] = new JLabel(imagenML);
			posX = (int) mL[i].getUbicacion().getX();
			posY = (int) mL[i].getUbicacion().getY();
			r[i].setBounds(posX, posY, 30, 30);
		}
		return r;
	}
	public JLabel[] asignarTrumps(){
		ImageIcon imagenTrump;
		int posX ;
		int posY ;
		JLabel[] r = new JLabel[5];
		for (int i = 0 ; i < r.length ; i++) {
			trump[i] = new MuroDeTrump(dimX,dimY);
			imagenTrump = trump[i].cargarImagen();
			r[i] = new JLabel(imagenTrump);
			posX = (int)trump[i].getUbicacion().getX();
			posY = (int)trump[i].getUbicacion().getY();
			r[i].setBounds(posX, posY, 30, 30);
		}
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
	
	public Point getBosque() {
		return b.getUbicacion();
	}

	public Point getMLetal(int indice){
		return mL[indice].getUbicacion();
	}

	public Point getThor(int indice){
		return thor[indice].getUbicacion();
	}

	public int getDimX() {
		return dimX;
	}

	public int getDimY() {
		return dimY;
	}
	
	public void moverThors() {
		for (int i = 0 ; i < thor.length ; i++) {
			thor[i].setMoverse(true);
			thor[i].moverse();
			thor[i].setMoverse(false);
			thor[i].verificarMuros();
		}
	}
	public void moverLetales() {
		for (int i = 0 ; i < mL.length ; i++) {
			mL[i].setMoverse(true);
			mL[i].moverse();
			mL[i].setMoverse(false);
			mL[i].verificarMuros();
		}
	}

	public void moverArriba() {
		moverThors();
		moverLetales();
		b.setMoverArriba(true);
		b.actualizar();
		b.verificarMuros();
	}
	public void moverAbajo() {
		moverThors();
		moverLetales();
		b.setMoverAbajo(true);
		b.actualizar();
		b.verificarMuros();
	}
	public void moverIzquierda() {
		moverThors();
		moverLetales();
		b.setMoverIzquierda(true);
		b.actualizar();
		b.verificarMuros();
	}
	public void moverDerecha() {
		moverThors();
		moverLetales();
		b.setMoverDerecha(true);
		b.actualizar();
		b.verificarMuros();
	}
}
