package damas.interfaz;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mycompany.damas.interfaz.mundo.Damas;

public class CAMBIO extends JFrame implements ActionListener{

	private Label rojas,negras,vs;
	
	private JButton boton1,boton2;
	
	private JComboBox<Object> ficha1,combo2;
	
	private Principal principal;
	
	private PanelDeJuego panelDeJuego;
	
	public void iniciar() {
		// MENU Y OPCIONES DE CAMBIAR MODO EN MEDIO DE LA PARTIDA
		boton1= new JButton("Cambiar Modo");
		boton1.setBounds(50,70,140,30);
		boton1.addActionListener(this);
		
		boton2= new JButton("Salir");
		boton2.setBounds(220,70,100,30);
		boton2.addActionListener(this);
		
		rojas = new Label("ROJAS");
		rojas.setBounds(100,10,100,20);
		negras = new Label("NEGRAS");
		negras.setBounds(235,10,100,20);
		vs = new Label("VS");
		vs.setBounds(185, 35, 30, 20);
		
		ficha1 = new JComboBox<>();
		ficha1.addItem("");
		ficha1.addItem("Modo Automatico");
		ficha1.addItem("Modo Manual");
		combo2 = new JComboBox<>();
		combo2.addItem("");
		combo2.addItem("Modo Automatico");
		combo2.addItem("Modo Manual");
		
		ficha1.setBounds(70,35,110,20);
		combo2.setBounds(210,35,110,20);
	}
	
	public CAMBIO(Principal Pprincipal,PanelDeJuego juego) {
		iniciar();
		principal = Pprincipal;
		panelDeJuego = juego;
		setLayout(null);
		getContentPane().add(rojas);
		getContentPane().add(negras);
		getContentPane().add(ficha1);
		getContentPane().add(combo2);
		getContentPane().add(vs);
		getContentPane().add(boton1);
		getContentPane().add(boton2);
		setResizable(false);
		setSize(400,200);
		setLocationRelativeTo(principal);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void abrir() {
		
	}
	
	@SuppressWarnings("null")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			if(ficha1.getSelectedIndex() == 0 || combo2.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(principal,"REVISAR LA ENTRADA");
			}else {
				panelDeJuego.cambiar(ficha1.getSelectedIndex(), combo2.getSelectedIndex());
				dispose();
			}
		}else {
			dispose();
		}
		
	}
}
