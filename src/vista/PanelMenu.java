package vista;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements ActionListener {

	private JButton inicio, configuraciones, creditos;
	private JFrameP p;
	
	public PanelMenu(JFrameP p) {
		this.p = p;
		setLayout(new GridLayout(3, 1));
		iniciarBotones();
	}

	public void iniciarBotones(){
		ImageIcon comu = new ImageIcon("Data/jug.png");
		ImageIcon co = new ImageIcon("Data/configuraciones.png");
		ImageIcon co2 = new ImageIcon("Data/salir.png");
		inicio = new JButton("Jugar");
		configuraciones = new JButton("Configuraciones");
		creditos = new JButton("Salir");
		add(inicio);
		inicio.addActionListener(this);
		inicio.setIcon(comu);
		add(configuraciones);
		configuraciones.addActionListener(this);
		configuraciones.setIcon(co);
		add(creditos);
		creditos.addActionListener(this);
		creditos.setIcon(co2);

		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();

		if (accion == inicio.getActionCommand()){
			setVisible(false);
			p.iniciarPanelPJuego();
			p.iniciarPuntaje();
			p.getpJ().setVisible(true);
						

		}
		if (accion == configuraciones.getActionCommand()){
			setVisible(false);
			p.getCof().setVisible(true);
		}
		
		if ( accion == creditos.getActionCommand()) {
			System.exit(0);
		}

	}

}
