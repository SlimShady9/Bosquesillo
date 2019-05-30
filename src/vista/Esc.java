package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Esc extends JPanel  implements ActionListener{
	
	private JButton resume , exit;
	private JFrameP fr;

	public Esc(JFrameP fr) {
		this.fr = fr;
		setLayout(new FlowLayout(20, 20, 50));
		setBackground(Color.getHSBColor(255, 175, 40));
		componentes();
		

		
	}
	public void componentes() {
		Font fuente = new Font("Comic Sans MS", Font.ITALIC, 36);
		
		resume = new JButton("Volver a la guerra");
		resume.setFont(fuente);
		resume.setBackground(Color.RED);
		add(resume);
		resume.addActionListener(this);
		
		exit = new JButton ("Rendirse");
		exit.setFont(fuente);
		exit.setBackground(Color.RED);
		add(exit);
		exit.addActionListener(this);
		

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