package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Esc extends JPanel  implements ActionListener{
	private JButton resume , exit;
	private JFrameP fr;
	private JLabel fondoe;

	public Esc(JFrameP fr) {
		this.fr = fr;
		setLayout(null);
		setBackground(Color.yellow);
		botones();
		fondo();
	}
	
	public void botones() {
		Font fuente = new Font("Comic Sans MS", Font.ITALIC, 28);
		
		resume = new JButton("resume");
		resume.setFont(fuente);
		resume.setBounds(30, 180 , 200, 40);
		add(resume);
		resume.addActionListener(this);
		exit = new JButton ("exit");
		exit.setFont(fuente);
		exit.setBounds(30, 235 , 200, 40);
		add(exit);
		exit.addActionListener(this);
		

	}
	private void fondo() {
		ImageIcon fon = new ImageIcon("Data/fondoe.png");
		fondoe = new JLabel(fon);
		fondoe.setBounds(0, 0, 370, 374);
		add(fondoe);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();

		if (accion == resume.getActionCommand()){
			setVisible(false);
			fr.getpJ().getBosquesillo().setEnabled(true);
		}
		if(accion == exit.getActionCommand()) {
			setVisible(false);
			fr.getpJ().setVisible(false);
			fr.setpJ(null);
			fr.getpM().setVisible(true);
			
		}
	}

}