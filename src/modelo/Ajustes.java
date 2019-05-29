package modelo;


public class Ajustes {
	
	private int dimX, dimY;
	private int cObjetos;
	
	public Ajustes() {
		dimX = 15;
		dimY = 15;
		cObjetos = 5;
	}
	
	public void setValores(int x, int y) {
		dimX = x;
		dimY = y;
	}
	
	public void setDificultad(String pDificultad) {
		if (pDificultad.contentEquals("Facil")) {
			cObjetos= (dimX*dimY)/((dimX+dimY)*3); 
		}
		if (pDificultad.contentEquals("Medio")) {
			cObjetos= (dimX*dimY)/((dimX+dimY)*2);
		}
		if (pDificultad.contentEquals("Dificil")) {
			cObjetos= (dimX*dimY)/((dimX+dimY));
		}
	}

	public int getDimX() {
		return dimX;
	}

	public int getDimY() {
		return dimY;
	}

	public int getcObjetos() {
		return cObjetos;
	}
	

}
