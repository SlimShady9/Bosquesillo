package controlador;

import vista.Configraciones;;

public class Ajustes {
	
	private int dimX, dimY;
	private int cMonstruos;
	private Configraciones conf;
	
	public Ajustes(Configraciones pConf) {
		conf = pConf;
		dimX = conf.getValorx();
		dimY = conf.getValory();
		cMonstruos = 5;
	}
	
	public void cargarValores(int x, int y) {
		dimX = conf.getValorx();
		dimY = conf.getValory();
	}
	
	public void generarMonstruos(String pDificultad) {
		if (pDificultad.contentEquals("Facil")) {
			
		}
		if (pDificultad.contentEquals("Medio")) {
			
		}
		if (pDificultad.contentEquals("Dficil")) {
			
		}
	}

	public int getDimX() {
		return dimX;
	}

	public int getDimY() {
		return dimY;
	}

	public int getcMonstruos() {
		return cMonstruos;
	}
	

}
