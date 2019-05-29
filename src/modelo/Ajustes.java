package modelo;


public class Ajustes {
	
	private int dimX, dimY;
	private int cObjetos, cCheckPoints;
	
	public Ajustes() {
		dimX = 15;
		dimY = 15;
		cObjetos = 5;
		cCheckPoints = 2;
	}
	
	public void setValores(int x, int y) {
		dimX = x;
		dimY = y;
	}
	
	public void setDificultad(String pDificultad) {
		if (pDificultad.contentEquals("Facil")) {
			cObjetos= (dimX*dimY)/((dimX+dimY)*3); 
			cCheckPoints = 1;
		}
		if (pDificultad.contentEquals("Medio")) {
			cObjetos= (dimX*dimY)/((dimX+dimY)*2);
			cCheckPoints = 2;
		}
		if (pDificultad.contentEquals("Dificil")) {
			cObjetos= (dimX*dimY)/((dimX+dimY));
			cCheckPoints = 3;
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
