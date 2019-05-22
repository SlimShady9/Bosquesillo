package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Esc extends JPanel  implements ActionListener{
	private JPanel esc;
	private JButton resume , exit;
	public JFrameP p;
	public PanelPantallaJuego pa;

	public Esc(JFrameP p) {
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
			pa.setEnabled(true);
		}
		if(accion == exit.getActionCommand()) {
			setVisible(false);
			pa.setVisible(false);
			p.getpM().setVisible(true);
		}


	}

}