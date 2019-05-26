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
	private Point[] disponibilidad;
	private int posicion;
	private Ajustes ajustes;
	private Carreta c;
	private Meta mE;
	private Checkpoint[] cH;


	public Controlador() {

		ajustes = new Ajustes();
		p = new JFrameP(this);

	}

	public void iniciarCompoJuego() {
		dimX = ajustes.getDimX() * 30;
		dimY = ajustes.getDimY() * 30;
		iniciarComponentes();
	}
	
	public void iniciarComponentes() {
		disponibilidad = new Point[ajustes.getDimX() * ajustes.getDimY()];
		posicion = 0;
		iniciarTablero();
		iniciarBosquesillo();
		iniciarMostruoL();
		iniciarTormentoso();
		iniciarMuroDeTrump();
		iniciarCheckpoint();
		iniciarCarreta();
		iniciarMeta();
	}

	public void iniciarMeta() {
		mE = new Meta(dimX, dimY);

	}
	public void iniciarCarreta() {
		c = new Carreta(dimX, dimY);

	}
	public void iniciarCheckpoint() {
		cH = new Checkpoint [ajustes.getcObjetos()];
		for (int i = 0 ; i < cH.length ; i++) {
			cH[i] = new Checkpoint(dimX, dimY);
			cH[i].iniciarPosicion(disponibilidad);
			disponibilidad[posicion]  = cH[i].getUbicacion();
			posicion++;
		}

	}
	public void iniciarMuroDeTrump() {
		trump = new MuroDeTrump[ajustes.getcObjetos()];
		for (int i = 0 ; i < trump.length ; i++) {
			trump[i] = new MuroDeTrump(dimX, dimY);
			trump[i].iniciarPosicion(disponibilidad);
			disponibilidad[posicion] = trump[i].getUbicacion();
			posicion++;
		}
	}
	public void iniciarBosquesillo () {
		b = new Bosquesillo(dimX, dimY);
		disponibilidad[posicion] = b.getUbicacion();
		posicion++;
	}
	public void iniciarTormentoso(){
		thor = new Tormentoso[ajustes.getcObjetos()];
		for (int i = 0 ; i < thor.length ; i++) {
			thor[i] = new Tormentoso(dimX, dimY);
			thor[i].iniciarPosicion(disponibilidad);
			disponibilidad[posicion]  = thor[i].getUbicacion();
			posicion++;
		}
	}
	public void iniciarMostruoL(){
		mL = new MonstruoLetal[ajustes.getcObjetos()];
		for (int i = 0 ; i < mL.length ; i++) {
			mL[i] = new MonstruoLetal(dimX, dimY);
			mL[i].iniciarPosicion(disponibilidad);
			disponibilidad[posicion] = mL[i].getUbicacion();
			posicion++;
		}
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
		JLabel[] r = new JLabel[ajustes.getcObjetos()];
		for (int i = 0 ; i < r.length ; i++) {
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
		JLabel[] r = new JLabel[ajustes.getcObjetos()];
		for (int i = 0 ; i < r.length ; i++) {
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
		int posX, posY ;
		JLabel[] r = new JLabel[ajustes.getcObjetos()];
		for (int i = 0 ; i < r.length ; i++) {
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
		int x = ajustes.getDimX();
		int y = ajustes.getDimY();
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


	public Ajustes getAjustes() {
		return ajustes;
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
			thor[i].verificarMuros();
			for (int j = 0 ; j < trump.length ; j++ ) {
				thor[i].verificarObjs(trump[j].getUbicacion());
			}
			for (int k = 0 ; k < mL.length ; k++ ) {
				thor[i].verificarObjs(mL[k].getUbicacion());
			}
			for (int l = 0 ; l < thor.length ; l++) {
				if (i != l) {
					thor[i].verificarObjs(thor[l].getUbicacion());
				}
			}
			thor[i].moverse();

		}
	}
	public void moverLetales() {
		for (int i = 0 ; i < mL.length ; i++) {
			mL[i].setMoverse(true);
			mL[i].verificarMuros();
			for (int j = 0 ; j < trump.length ; j++) {
				mL[i].verificarObjs(trump[j].getUbicacion());
			}
			for (int k = 0 ; k < thor.length ; k++) {
				mL[i].verificarObjs(thor[k].getUbicacion());
			}
			for (int l = 0 ; l < mL.length ; l++) {
				if (i != l) {
					mL[i].verificarObjs(mL[l].getUbicacion());
				}
			}
			mL[i].moverse();

		}
	}

	public void moverArriba() {
		moverThors();
		moverLetales();
		b.setMoverArriba(true);
		b.verificarMuros();
		for (int i = 0 ; i < trump.length ; i++) {
			b.verificarObjs(trump[i].getUbicacion());
		}
		b.actualizar();
	}
	public void moverAbajo() {
		moverThors();
		moverLetales();
		b.setMoverAbajo(true);
		b.verificarMuros();
		for (int i = 0 ; i < trump.length ; i++) {
			b.verificarObjs(trump[i].getUbicacion());
		}
		b.actualizar();

	}
	public void moverIzquierda() {
		moverThors();
		moverLetales();
		b.setMoverIzquierda(true);
		b.verificarMuros();
		for (int i = 0 ; i < trump.length ; i++) {
			b.verificarObjs(trump[i].getUbicacion());
		}
		b.actualizar();

	}
	public void moverDerecha() {
		moverThors();
		moverLetales();
		b.setMoverDerecha(true);
		b.verificarMuros();
		for (int i = 0 ; i < trump.length ; i++) {
			b.verificarObjs(trump[i].getUbicacion());
		}
		b.actualizar();
	}
}
