package vista;

import java.awt.Color;
import java.awt.FlowLayout;
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
		setLayout(new FlowLayout());
		setBackground(Color.yellow);
		botones();
		

		
	}
	public void botones() {
		resume = new JButton("resume");
		add(resume);
		resume.addActionListener(this);
		exit = new JButton ("exit");
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