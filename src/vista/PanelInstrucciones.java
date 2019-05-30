package vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

	private JLabel logoBienVergas, imbos, insb, insb1, iml, insl, insl1, imt, inst, inst1, immu, insmu, imc, insc, insc1, imm, insm, insm1, fondoi ;
	private JFrameP f;
	private JButton aceptar,siguiente;
	
	public PanelInstrucciones(JFrameP f){
		this.f = f;
		setLayout(null);
		TitledBorder border = new TitledBorder("INSTRUCCIONES");
		setBorder(border);
		setSize(600, 600);
		setBackground(Color.WHITE);
		cargarComponentes();

	}
{
		// TODO Auto-generated method stub
		
	}

	public void cargarComponentes() {

		cargarLabels();
		cargarBotones();

	}
	

	public void cargarBotones(){
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(this);
		ImageIcon co = new ImageIcon("Data/aceptar.png");
		aceptar.setBounds(200, 500 , 200, 50);
		add(aceptar);
		aceptar.setIcon(co);
	
	}

	public void actionPerformed(ActionEvent arg0) {
		String accion = arg0.getActionCommand();

		if (accion == aceptar.getActionCommand()){
			setVisible(false);
			f.getpM().setVisible(true);

		}
	}
	public void cargarLabels(){
		Font fuente = new Font("Comic Sans MS", Font.BOLD, 14);
		
		
		
		ImageIcon log = new ImageIcon("Data/logo.png");
		logoBienVergas = new JLabel(log);
		logoBienVergas.setBounds(0, 15, 610, 100);
		add(logoBienVergas);

		ImageIcon ibos = new ImageIcon("Data/Bosquesillo.jpeg");
		imbos = new JLabel (ibos);
		imbos.setBounds(70, 175, 50, 50);
		add(imbos);
		
		insb = new JLabel("Al iniciar la partida se debe seleccionar Bosquecillo para ");
		insb.setFont(fuente);
		insb.setBounds(120, 170, 460, 50);
		add(insb);
		insb1 = new JLabel("poder dirigirlo con las flechas vergas del pc.");
		insb1.setFont(fuente);
		insb1.setBounds(120, 185, 460, 50);
		add(insb1);
		
		ImageIcon il = new ImageIcon("Data/MonstruoLetal.png");
		iml = new JLabel (il);
		iml.setBounds(70, 220, 50, 50);
		add(iml);
		
		insl = new JLabel("Los Americanos eliminan a Bosquecillo cuando colindan ");
		insl.setFont(fuente);
		insl.setBounds(120, 225, 460, 30);
		add(insl);
		insl1 = new JLabel("con el");
		insl1.setFont(fuente);
		insl1.setBounds(120, 240, 460, 30);
		add(insl1);
		
		ImageIcon it = new ImageIcon("Data/Tormentoso.png");
		imt = new JLabel (it);
		imt.setBounds(70, 265, 50, 50);
		add(imt);
		
		inst = new JLabel("Los Revolucionarios h�ngaros quitan un porcentaje de los ");
		inst.setFont(fuente);
		inst.setBounds(120, 270, 460, 30);
		add(inst);
		inst1 = new JLabel("movimientos restantes");
		inst1.setFont(fuente);
		inst1.setBounds(120, 285, 460, 30);
		add(inst1);
		
		ImageIcon imu = new ImageIcon("Data/Muro.png");
		immu = new JLabel (imu);
		immu.setBounds(70, 305, 50, 50);
		add(immu);
		
		insmu = new JLabel("No puedes atravezar los muros de Berlin");
		insmu.setFont(fuente);
		insmu.setBounds(120, 305, 460, 50);
		add(insmu);
		
		ImageIcon ic = new ImageIcon("Data/Check.png");
		imc = new JLabel (ic);
		imc.setBounds(70, 342, 50, 50);
		add(imc);
		
		insc = new JLabel("Tienes que llevar la ideologia comunista a todos los puntos");
		insc.setFont(fuente);
		insc.setBounds(120, 335, 460, 50);
		add(insc);
		insc1 = new JLabel("capitalistas");
		insc1.setFont(fuente);
		insc1.setBounds(120, 350, 460, 50);
		add(insc1);
		
		ImageIcon im = new ImageIcon("Data/Meta.png");
		imm = new JLabel (im);
		imm.setBounds(70, 385, 50, 50);
		add(imm);
		
		insm = new JLabel("Luego de llevar el comunismo a todo el mundo debes ir a ");
		insm.setFont(fuente);
		insm.setBounds(120, 380, 460, 50);
		add(insm);
		insm1 = new JLabel("descansar en Rusia");
		insm1.setFont(fuente);
		insm1.setBounds(120, 395, 460, 50);
		add(insm1);
		
		ImageIcon fon = new ImageIcon("Data/fondoi.png");
		fondoi = new JLabel(fon);
		fondoi.setBounds(0, 0, 610, 610);
		add(fondoi);

	}
}