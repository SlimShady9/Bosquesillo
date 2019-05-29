package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelInstrucciones extends JPanel  implements ActionListener {

	private JLabel logoBienVergas, ins ;
	private JFrameP f;
	private JButton aceptar,siguiente;
	
	public PanelInstrucciones(JFrameP f){
		this.f = f;
		setLayout(null);
		TitledBorder border = new TitledBorder("INSTRUCCIONES");
		setBorder(border);
		setSize(600, 600);
		setBackground(Color.getHSBColor(100, 100, 100));
		cargarComponentes();

	}
{
		// TODO Auto-generated method stub
		
	}

	public void cargarComponentes() {

		cargarLabels();
		cargarBotones();

	}
	public void cargarLabels(){
		Font fuente = new Font("Comic Sans MS", Font.ITALIC, 36);

		logoBienVergas = new JLabel("---------------------TE AMAMOS BOSQUESILLO----------");
		logoBienVergas.setFont(fuente);
		logoBienVergas.setBounds(60, 10, 500, 50);
		add(logoBienVergas);

		ins = new JLabel("Aqui van todas las madres de esta madre de pinchi proyecto y tienen");
		ins.setFont(fuente);
		ins.setBounds(20, 160, 500, 50);
		add(ins);

	}

	public void cargarBotones(){
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		aceptar.setBackground(Color.DARK_GRAY);
		aceptar.setFont(new Font("Book Antiqua", Font.ITALIC, 28));
		aceptar.setBounds(120, 500 , 170, 50);
		add(aceptar);
	
		siguiente = new JButton("Siguiente");
		siguiente.addActionListener(this);
		siguiente.setBackground(Color.DARK_GRAY);
		siguiente.setFont(new Font("Book Antiqua", Font.ITALIC, 28));
		siguiente.setBounds(295, 500 , 185, 50);
		add(siguiente);
	}

	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();

		if (accion == aceptar.getActionCommand()){
			setVisible(false);
			f.getpM().setVisible(true);

		}
	}
}