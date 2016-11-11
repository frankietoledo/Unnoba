package tp5ejercicio5Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import tp1ejercicio6.Clima;
import tp3ejercicio6.EstacionMeteorologica;

import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaClima extends JFrame implements Observer {

	private JPanel contentPane;
	private JLabel lbltemperaturaActual = new JLabel("Cargando Temperatura actual...");
	private EstacionMeteorologica estacion = new EstacionMeteorologica();
	private JList list = new JList();
	private DefaultListModel modeloLista = new DefaultListModel();
	//private DefaultListModel modeloLista = new DefaultListModel();
	private List<Clima> historial = new ArrayList<Clima>();
	JLabel lblFoto = new JLabel("");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					VentanaClima frame = new VentanaClima();
					frame.setVisible(true);
					frame.agregarObservador(frame);
					frame.iniciarServicio();
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//Metodo que actualiza el orden de la lista de la estacion y luego copia el historial de la estacion al historial de la ventana
	//Despues de eso recorre el historial nuevo, lo va agregando a un nuevo modelo de la lista y al final la setea
	public void ordenarPorTemperatura(){
		lbltemperaturaActual.setText("Actualizando Climas...");
		this.estacion.ordenaPorTemperatura();
		this.historial.clear();
		this.historial=this.estacion.getClimas();
		for (Clima c : this.historial){
			actualizarHistorial(c);
		}
	}
	public void ordenarporfecha(){
		lbltemperaturaActual.setText("Actualizando Climas...");
		this.estacion.ordenarPorHora();
		this.historial.clear();
		this.historial=this.estacion.getClimas();
		for (Clima c: this.historial){
			actualizarHistorial(c);
		}
	}
	public void limpiarLista(){
		modeloLista.clear();
		this.historial.clear();
		lbltemperaturaActual.setText("Actualizando Climas...");
	}	
	public void iniciarServicio(){
		this.estacion.iniciarServicio();
	}
	public void agregarObservador(Observer obs){
		this.estacion.addObserver(obs);
	}
	public void actualizarLabel(Clima clima){
		lbltemperaturaActual.setText("La temperatura actual en "+clima.getCiudad()+" es "+clima.getTemperaturaActual()+"º");
		//actualizarFoto(clima);
		
	}
	public void actualizarHistorial(Clima unclima){
		historial.add(0,unclima);
		modeloLista.add(0,dameUnString(unclima.getUltimaActualizacion())+" - "+unclima.getCiudad()+" "+(int)unclima.getTemperaturaActual()+"º - "+unclima.getCondicion());
	}
	public void actualizarFoto(Clima clima){
		Calendar justoAhora = Calendar.getInstance();
		switch (clima.getCondicion()) {
		case "Clear":
			if (justoAhora.HOUR_OF_DAY>1){
				lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("/Iconos/noche48.png")));
			}else{
				lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("/Iconos/soleado48.png")));
			}
			lblFoto.repaint();
			break;
		case "Cloudy":
			lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("/Iconos/nublado48.png")));
			lblFoto.repaint();
			break;
		case "Partly Cloudy":
			lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("/Iconos/nublado48.png")));
			lblFoto.repaint();
			break;
		case "Showers":
			lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("Iconos/lluvioso48.png")));
			lblFoto.repaint();
			break;
		default:
			lblFoto.repaint();
			break;
		}
	}
	public String dameUnString(Date date){
		SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMMM',' yyyy");
		return formateador.format(date);
	}
	public VentanaClima() {
		setResizable(false);
		setTitle("Ejercicio 5 Practico 5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		
		JPanel izquierdo = new JPanel();
		contentPane.add(izquierdo, BorderLayout.WEST);
		GridBagLayout gbl_izquierdo = new GridBagLayout();
		gbl_izquierdo.columnWidths = new int[]{0, 0};
		gbl_izquierdo.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_izquierdo.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_izquierdo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		izquierdo.setLayout(gbl_izquierdo);
		
		JButton btnTemperatura = new JButton("Temperatura");
		btnTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenarPorTemperatura();
			}
		});
		GridBagConstraints gbc_btnTemperatura = new GridBagConstraints();
		gbc_btnTemperatura.fill = GridBagConstraints.BOTH;
		gbc_btnTemperatura.insets = new Insets(0, 0, 5, 0);
		gbc_btnTemperatura.gridx = 0;
		gbc_btnTemperatura.gridy = 1;
		izquierdo.add(btnTemperatura, gbc_btnTemperatura);
		
		JButton btnFecha = new JButton("Fecha");
		btnFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ordenarporfecha();
			}
		});
		GridBagConstraints gbc_btnFecha = new GridBagConstraints();
		gbc_btnFecha.fill = GridBagConstraints.BOTH;
		gbc_btnFecha.insets = new Insets(0, 0, 5, 0);
		gbc_btnFecha.gridx = 0;
		gbc_btnFecha.gridy = 2;
		izquierdo.add(btnFecha, gbc_btnFecha);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarLista();
			}
		});
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 0);
		gbc_btnLimpiar.fill = GridBagConstraints.BOTH;
		gbc_btnLimpiar.gridx = 0;
		gbc_btnLimpiar.gridy = 4;
		izquierdo.add(btnLimpiar, gbc_btnLimpiar);
		
		JPanel derecho = new JPanel();
		list.setVisibleRowCount(1000);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2){
					DetallesClima ventanita = new DetallesClima();
					ventanita.setVisible(true);
					ventanita.actualizar(historial.get(list.getSelectedIndex()));
				}
			}
		});
		
		list.setToolTipText("");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.setModel(modeloLista);
		contentPane.add(derecho, BorderLayout.CENTER);
		derecho.setLayout(new BorderLayout(0, 0));
		
		derecho.add(list, BorderLayout.CENTER);
		
		JPanel cabecera = new JPanel();
		contentPane.add(cabecera, BorderLayout.NORTH);
				
		lbltemperaturaActual.setLabelFor(cabecera);
		lbltemperaturaActual.setHorizontalAlignment(SwingConstants.CENTER);
		cabecera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblFoto.setIcon(new ImageIcon(VentanaClima.class.getResource("/Iconos/termostato48.png")));
		cabecera.add(lblFoto);
		cabecera.add(lbltemperaturaActual);
		
		// ################## ACA EMPIEZA MI CODIGO ##############################
		
	}

	@Override
	public void update(Observable estacion, Object unClima) {
		Clima clima = (Clima) unClima;
		actualizarHistorial(clima);
		actualizarLabel(clima);
	}
}
