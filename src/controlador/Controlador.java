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
	private Carreta carro;
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
		carro = new Carreta(dimX, dimY);
		carro.iniciarPosicion(disponibilidad);
		disponibilidad[posicion] = carro.getUbicacion();
		posicion++;
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
		if (b.getUbicacion().getX() + 30 <= dimX) {
			Point savePoint = new Point((int)b.getUbicacion().getX() + 30 , (int)b.getUbicacion().getY());
			disponibilidad[posicion] = savePoint;
			posicion++;
			savePoint = null;
		}
		if (b.getUbicacion().getX() - 30 >= 0)  {
			Point savePoint = new Point((int)b.getUbicacion().getX() - 30 , (int)b.getUbicacion().getY());
			disponibilidad[posicion] = savePoint;
			posicion++;
			savePoint = null;
		}
		if (b.getUbicacion().getY() + 30 <= dimY) {
			Point savePoint = new Point((int)b.getUbicacion().getX() , (int)b.getUbicacion().getY() + 30);
			disponibilidad[posicion] = savePoint;
			posicion++;
			savePoint = null;
		}
		if (b.getUbicacion().getY() - 30 >= 0) {
			Point savePoint = new Point((int)b.getUbicacion().getX() , (int)b.getUbicacion().getY() - 30);
			disponibilidad[posicion] = savePoint;
			posicion++;
			savePoint = null;
		}

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
	public JLabel asignarCarrito() {
		ImageIcon imagenCarro = carro.cargarImagen();
		JLabel r = new JLabel(imagenCarro);
		r.setBounds((int) carro.getUbicacion().getX(), (int) carro.getUbicacion().getY(), 30, 30);
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
	public Point getCarro() {
		return carro.getUbicacion();
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
			thor[i].verificarObjs(b.getUbicacion());
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
	public void moverCarro() {
		carro.verificarBosque(b.getUbicacion());
		carro.verificarMuros();
		for (int j = 0 ; j < trump.length ; j++) {
			carro.verificarObjs(trump[j].getUbicacion());
		}
		for (int k = 0 ; k < thor.length ; k++) {
			carro.verificarObjs(thor[k].getUbicacion());
		}
		for (int l = 0 ; l < mL.length ; l++) {
			carro.verificarObjs(mL[l].getUbicacion());

		}
		carro.actualizar();
	}
	public void moverLetales() {
		for (int i = 0 ; i < mL.length ; i++) {
			mL[i].setMoverse(true);
			mL[i].verificarMuros();
			mL[i].verificarObjs(b.getUbicacion());
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

		b.setMoverArriba(true);
		b.verificarMuros();
		b.setContador(b.getContador() - 1);
		for (int i = 0 ; i < trump.length ; i++) {
			b.verificarObjs(trump[i].getUbicacion());
		}
		for (int i = 0 ; i < thor.length ; i++) {
			if (b.colision(thor[i].getUbicacion())) {
				int reduccion = (int)((ajustes.getDimX() * ajustes.getDimY())/ 100);
				b.setContador(b.getContador() - reduccion);
			}
		}
		for (int i = 0 ; i < mL.length ; i++) {
			if (b.colision(mL[i].getUbicacion())){
				b.setContador(0);
			}
		}
		moverCarro();
		b.actualizar();
		moverThors();
		moverLetales();
	}
	public void moverAbajo() {

		b.setMoverAbajo(true);
		b.verificarMuros();
		b.setContador(b.getContador() - 1);
		for (int i = 0 ; i < trump.length ; i++) {
			b.verificarObjs(trump[i].getUbicacion());
		}
		for (int i = 0 ; i < thor.length ; i++) {
			if (b.colision(thor[i].getUbicacion())) {
				int reduccion = (int)((ajustes.getDimX() * ajustes.getDimY())/ 100);
				b.setContador(b.getContador() - reduccion);
			}
		}
		for (int i = 0 ; i < mL.length ; i++) {
			if (b.colision(mL[i].getUbicacion())){
				b.setContador(0);
			}
		}
		moverCarro();
		b.actualizar();
		moverThors();
		moverLetales();
	}
	public void moverIzquierda() {

		b.setMoverIzquierda(true);
		b.verificarMuros();
		b.setContador(b.getContador() - 1);
		for (int i = 0 ; i < trump.length ; i++) {
			b.verificarObjs(trump[i].getUbicacion());
		}
		for (int i = 0 ; i < thor.length ; i++) {
			if (b.colision(thor[i].getUbicacion())) {
				int reduccion = (int)((ajustes.getDimX() * ajustes.getDimY())/ 100);
				b.setContador(b.getContador() - reduccion);
			}
		}
		for (int i = 0 ; i < mL.length ; i++) {
			if (b.colision(mL[i].getUbicacion())){
				b.setContador(0);
			}
		}
		moverCarro();
		b.actualizar();
		moverThors();
		moverLetales();
	}
	public void moverDerecha() {

		b.setMoverDerecha(true);
		b.verificarMuros();
		b.setContador(b.getContador() - 1);
		for (int i = 0 ; i < trump.length ; i++) {
			b.verificarObjs(trump[i].getUbicacion());
		}
		for (int i = 0 ; i < thor.length ; i++) {
			if (b.colision(thor[i].getUbicacion())) {
				int reduccion = (int)((ajustes.getDimX() * ajustes.getDimY())/ 100);
				b.setContador(b.getContador() - reduccion);
			}
		}
		for (int i = 0 ; i < mL.length ; i++) {
			if (b.colision(mL[i].getUbicacion())){
				b.setContador(0);
			}
		}
		moverCarro();
		b.actualizar();
		moverThors();
		moverLetales();
	}
	public boolean verificarMuerte() {
		boolean estaMuerto ;
		if (b.getContador() <= 0) {
			estaMuerto = true;
		}
		else {
			estaMuerto = false;
		}
		return estaMuerto;
	}
	public int getPuntaje() {
		return b.getContador();
	}
}
