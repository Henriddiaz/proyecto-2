package damas.interfaz;

// ESTE FUNCIONA 
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AcercaDe extends JFrame {

	private Principal principal;
	
	private JLabel label1,label2,label3;
	
	private JTextArea area;
	
	private JScrollPane panel;
	
	private Hipervinculo label4,label5;
	
	public AcercaDe(Principal Pprincipal) {
		principal = Pprincipal;
		iniciar();
		alinear();
		setSize(500,350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(principal);
	}
	
	public void alinear() {
		setLayout(null);
		label1.setBounds(90,0,500,50);
		getContentPane().add(label1);
		label2.setBounds(0,250,500,50);
		getContentPane().add(label2);
		label3.setBounds(5,250,500,50);
		getContentPane().add(label3);
		label4.setBounds(220,265,500,20);
		getContentPane().add(label4);
		label5.setBounds(220,285,500,20);
		getContentPane().add(label5);
		panel.setBounds(0,50,485,200);
		getContentPane().add(panel);
	}
	//controla lo que se ve en las REGLAS DE LOS JUEGOS
	public void iniciar() {
		label1 = new JLabel("Juego De Damas Y Torre De Hanoi");
		label1.setFont(new Font("report", Font.CENTER_BASELINE, 18));
		label2 = new JLabel("");
		label2.setFont(new Font("report", Font.CENTER_BASELINE, 13));
		label3 = new JLabel("vinculos para \n"
                        + "las reglas de los juegos ");
		label2.setFont(new Font(" report", Font.CENTER_BASELINE, 13));
		label4 = new Hipervinculo("REGLAS DEL DAMAS", "https://www.mundijuegos.com/multijugador/damas/reglas/");
		label5 = new Hipervinculo("REGLAS DE HANOI", "https://es.khanacademy.org/computing/computer-science/algorithms/towers-of-hanoi/a/towers-of-hanoi");
		area = new JTextArea();
		area.setEditable(false);
		area.setText("El menu principal de ''opciones'' es el que controla \n"
                        + "principalmente para jugar el modo de Damas principalmente y \n "
                        + "tambien nos direcciona para el modo de Torre De Hanoi");
		panel = new JScrollPane(area);
	}
	
}
