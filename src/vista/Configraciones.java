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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

public class Configraciones extends JPanel  implements ActionListener {

	private JLabel dificultad ;
	private JLabel facil;
	private JLabel intermedio, dificil;
	private JFrameP f;
	private JButton volver;
	public Configraciones(JFrameP f){
		this.f = f;
		cargarComponentes();
	}

	public void cargarComponentes() {
		f.getContentPane().setBackground(Color.BLACK);
		volver = new JButton ("volver");
		add(volver);
		volver.addActionListener(this);
		volver.setBackground(Color.DARK_GRAY);
		
		volver.setLayout(new FlowLayout());
		dificultad = new JLabel("Creacion de la matriz");
		add(dificultad);
		Font fuente0=new Font("Comic Sans MS", Font.ITALIC, 36);
		dificultad.setFont(fuente0);
		Font fuente=new Font("Book Antiqua", Font.ITALIC, 38);
		volver.setFont(fuente);		
		facil = new JLabel(" Nivel Facil  ");
		add(facil);
		Font fuente1=new Font("Comic Sans MS", Font.ITALIC, 20);
		facil.setFont(fuente1);
		facil.setForeground(Color.BLACK);
		Border borde1 = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
        facil.setBorder(borde1);
		SpinnerModel fa = new SpinnerNumberModel(5,5,8,1);
		JSpinner faspinnerx = new JSpinner(fa);
		add(faspinnerx);
		Integer valorx = (Integer)faspinnerx.getValue();
		SpinnerModel fay = new SpinnerNumberModel(5,5,8,1);
		JSpinner faspinnery = new JSpinner(fay);
		add(faspinnery);
		Integer valory = (Integer)faspinnery.getValue();
		faspinnerx.setBackground(Color.BLACK);
		faspinnerx.getEditor().getComponent(0).setBackground(Color.BLACK);
		faspinnery.setBackground(Color.BLACK);
		faspinnery.getEditor().getComponent(0).setBackground(Color.BLACK);
		faspinnerx.setLayout(new FlowLayout());
		faspinnery.setLayout(new FlowLayout());
		intermedio = new JLabel(" Nivel Intermedio  ");
		add(intermedio);
		Font fuente2=new Font("Comic Sans MS", Font.ITALIC, 20);
		intermedio.setFont(fuente2);
		SpinnerModel in = new SpinnerNumberModel(8,8,15,1);
		JSpinner inspinnerx = new JSpinner(in);
		add(inspinnerx);
		Integer valorix = (Integer)inspinnerx.getValue();
		SpinnerModel iny = new SpinnerNumberModel(8,8,15,1);
		JSpinner inspinnery = new JSpinner(iny);
		add(inspinnery);
		inspinnerx.setBackground(Color.BLACK);
		inspinnerx.getEditor().getComponent(0).setBackground(Color.BLACK);
		inspinnery.setBackground(Color.BLACK);
		inspinnery.getEditor().getComponent(0).setBackground(Color.BLACK);
		inspinnerx.setLayout(new FlowLayout());
		inspinnery.setLayout(new FlowLayout());
		intermedio.setForeground(Color.BLACK);
		Border borde2 = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
        intermedio.setBorder(borde2);
		dificil = new JLabel (" Nivel Dificil  ");
		add(dificil);
		Font fuente3=new Font("Comic Sans MS", Font.ITALIC, 20);
		dificil.setFont(fuente3);
		SpinnerModel di = new SpinnerNumberModel(15,15,20,1);
		JSpinner dispinnerx = new JSpinner(di);
		add(dispinnerx);
		Integer valordx = (Integer)dispinnerx.getValue();
		SpinnerModel diy = new SpinnerNumberModel(15,15,20,1);
		JSpinner dispinnery = new JSpinner(diy);
		add(dispinnery);
		Integer valordy = (Integer)dispinnery.getValue();
		dispinnerx.setBackground(Color.BLACK);
		dispinnerx.getEditor().getComponent(0).setBackground(Color.BLACK);
		dispinnery.setBackground(Color.BLACK);
		dispinnery.getEditor().getComponent(0).setBackground(Color.BLACK);
		dispinnerx.setLayout(new FlowLayout());
		dispinnery.setLayout(new FlowLayout());
		dificil.setForeground(Color.BLACK);
		Border borde3 = BorderFactory.createLineBorder(Color.DARK_GRAY, 2);
        dificil.setBorder(borde3);
        
	}
	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();

		if (accion == volver.getActionCommand()){
			setVisible(false);
			f.getpM().setVisible(true);

		}
	}
}
