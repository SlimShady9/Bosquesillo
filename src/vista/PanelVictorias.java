package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelVictorias extends JPanel  implements ActionListener{
	private JButton VolverAJugar , Salir;
	private JFrameP fr;
	private JLabel fondov;

	public PanelVictorias (JFrameP fr) {
		this.fr = fr;
		setLayout(null);
		setBackground(Color.yellow);
		botones();
		fondo();
		
	}
	
	public void botones() {
		VolverAJugar = new JButton("Volver a jugar");
		VolverAJugar.setBounds(30, 180 , 200, 40);
		add(VolverAJugar);
		VolverAJugar.addActionListener(this);
		
		Salir = new JButton ("Salir");
		Salir.setBounds(30, 235 , 200, 40);
		add(Salir);
		Salir.addActionListener(this);
		

	}
	private void fondo() {
		ImageIcon fon = new ImageIcon("Data/fondov.png");
		fondov = new JLabel(fon);
		fondov.setBounds(0, 0, 370, 374);
		add(fondov);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();

		if (accion == VolverAJugar.getActionCommand()){
			setVisible(false);
			
		}
		if(accion == Salir.getActionCommand()) {
			setVisible(false);
			fr.getpJ().setVisible(false);
			fr.setpJ(null);
			fr.getpM().setVisible(true);
			
		}
	}

}