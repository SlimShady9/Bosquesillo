package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel implements ActionListener {

	public JButton inicio, configuraciones, creditos;
	public JFrameP p;

	public PanelMenu(JFrameP p) {
		this.p = p;
		setLayout(new GridLayout(3, 1));
		iniciarBotones();
		// TODO Auto-generated constructor stub
	}

	public void iniciarBotones(){
		inicio = new JButton("Jugar");
		add(inicio);
		inicio.setBackground(Color.BLACK);
		inicio.setForeground(Color.WHITE);
		Font fuente=new Font("Book Antiqua", Font.ITALIC, 36);
		inicio.setFont(fuente);
		inicio.addActionListener(this);
		configuraciones = new JButton("Configuraciones");
		add(configuraciones);
		configuraciones.setBackground(Color.BLACK);
		configuraciones.setForeground(Color.WHITE);
		Font fuente1=new Font("Book Antiqua", Font.ITALIC, 36);
		configuraciones.setFont(fuente1);
		configuraciones.addActionListener(this);
		creditos = new JButton("Salir");
		add(creditos);
		creditos.setBackground(Color.BLACK);
		creditos.setForeground(Color.WHITE);
		Font fuente2=new Font("Book Antiqua", Font.ITALIC, 36);
		creditos.setFont(fuente2);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();

		if (accion == inicio.getActionCommand()){
			setVisible(false);
			p.iniciarPanelPJuego();
			p.getpJ().setVisible(true);

		}
		if (accion == configuraciones.getActionCommand()){
			setVisible(false);
			p.getCof().setVisible(true);
		}

	}

}
