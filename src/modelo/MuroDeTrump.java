package modelo;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;


public class MuroDeTrump {
		
		private ImageIcon imagen;
		private int posX;
		private int posY;
		private int maxX;
		private int maxY;
		private boolean moverse;
		
		public MuroDeTrump (int x, int y){
		
			maxX = x;
			maxY = y;
			iniciarPosicion();
		}
		
		public void iniciarPosicion(){
			posX = ThreadLocalRandom.current().nextInt(0 , maxX - 30);
			posY = ThreadLocalRandom.current().nextInt(0 , maxY - 60);
			while (posX % 30 != 0){
				posX++;
			}
			while (posY % 30 != 0){
				posY++;
			}
		}
		public ImageIcon cargarImagen(){
			imagen = new ImageIcon("Data/Muro.png");
			return imagen;
		}

		public int getPosX() {
			return posX;
		}

		public int getPosY() {
			return posY;
		}
		
		

}
