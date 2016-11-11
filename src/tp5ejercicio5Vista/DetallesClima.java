package tp5ejercicio5Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import tp1ejercicio6.Clima;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class DetallesClima extends JFrame {
	//Atributos
	JLabel lblCiudadPaisProvincia = new JLabel("Ciudad de x, provicia de x, pais.");
	JLabel lblValor = new JLabel("Valor"); //Tempactual
	JLabel lblValor_1 = new JLabel("Valor"); //Temp minima
	JLabel lblValor_2 = new JLabel("Valor"); //Temp maxi
	JLabel lblValor_3 = new JLabel("Valor"); //escala	
	JLabel lblValor_4 = new JLabel("Valor"); //Humedad
	JLabel lblValor_5 = new JLabel("Valor"); //Presion
	JLabel lblValor_6 = new JLabel("Valor"); //Dir del viento
	JLabel lblValor_7 = new JLabel("Valor"); //Vel del viento
	JLabel lblValor_8 = new JLabel("Valor"); //Visibilidad
	JLabel lblFoto = new JLabel("");

	JLabel lblUltimaActualizacion = new JLabel("Ultima Actualizacion");		
	JLabel lblCondicion = new JLabel("Condicion");


	//Metods
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public void actualizar(Clima clima){
		lblCiudadPaisProvincia.setText("Ciudad de "+clima.getCiudad()+","+clima.getProvincia()+","+clima.getPais());
		lblUltimaActualizacion.setText(dameUnString(clima.getUltimaActualizacion()));
		lblValor.setText(((Float)clima.getTemperaturaActual()).toString());
		lblValor_1.setText(((Float)clima.getTemperaturaMinima()).toString());
		lblValor_2.setText(((Float)clima.getTemperaturaMaxima()).toString());
		lblValor_3.setText(clima.getEscala().toString());
		lblValor_4.setText(((Float)clima.getHumedad()).toString());
		lblValor_5.setText(((Float)clima.getPresion()).toString());
		//dir viento, vel viento, visibilidad
		lblValor_6.setText(clima.getDireccionDelViento().toString());
		lblValor_7.setText(((Float)clima.getViento()).toString());
		lblValor_8.setText(((Float)clima.getVisibilidad()).toString());
		lblCondicion.setText(clima.getCondicion());
		switch (clima.getCondicion()) {
		case "clear":
			if (Calendar.HOUR_OF_DAY>20){
				lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("/Iconos/noche.png")));
			}else{
				lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("/Iconos/soleado.png")));
			}
			break;
		case "Partly Cloudy":
			lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("/Iconos/nublado48.png")));
			break;
		case "cloudy":
			lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("/Iconos/nublado.png")));
			break;
		case "showers":
			lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("Iconos/lluvioso.png")));

		default:
			break;
		}
		lblFoto.setIcon(new ImageIcon(DetallesClima.class.getResource("/Iconos/noche.png")));

	}
	public String dameUnString(Date date){
		SimpleDateFormat formateador = new SimpleDateFormat("'Actualizado a las' HH:mm' del' dd 'de' MMMMM',' yyyy");
		return formateador.format(date);
	}
	public DetallesClima() {
		setResizable(false);
		setTitle("Detalles del tiempo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 446, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		
		JPanel cabecera = new JPanel();
		contentPane.add(cabecera, BorderLayout.NORTH);
		
		cabecera.add(lblCiudadPaisProvincia);
		lblCiudadPaisProvincia.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel actualizacion = new JPanel();
		contentPane.add(actualizacion, BorderLayout.SOUTH);
		
		actualizacion.add(lblUltimaActualizacion);
		
		JPanel imagen1 = new JPanel();
		
		////////////////////////////
		Image imagen = new ImageIcon("/Iconos/lluvioso.png").getImage();
		
		
		////////////////////////////
		contentPane.add(imagen1, BorderLayout.EAST);
		
		imagen1.setLayout(new MigLayout("", "[117px]", "[151px][15px]"));
		
		imagen1.add(lblFoto, "cell 0 0,grow");
		
		imagen1.add(lblCondicion, "cell 0 1,alignx center,aligny top");
		
		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		GridBagLayout gbl_center = new GridBagLayout();
		gbl_center.columnWidths = new int[]{154, 37, 0};
		gbl_center.rowHeights = new int[]{15, 15, 15, 15, 15, 15, 15, 15, 15, 0};
		gbl_center.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		center.setLayout(gbl_center);
		
		JLabel lblTemperaturaActual = new JLabel("Temperatura Actual:");
		GridBagConstraints gbc_lblTemperaturaActual = new GridBagConstraints();
		gbc_lblTemperaturaActual.anchor = GridBagConstraints.NORTH;
		gbc_lblTemperaturaActual.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTemperaturaActual.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemperaturaActual.gridx = 0;
		gbc_lblTemperaturaActual.gridy = 0;
		center.add(lblTemperaturaActual, gbc_lblTemperaturaActual);
		
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor.gridx = 1;
		gbc_lblValor.gridy = 0;
		center.add(lblValor, gbc_lblValor);
		
		JLabel lblTemperaturaMinima = new JLabel("Temperatura Minima:");
		GridBagConstraints gbc_lblTemperaturaMinima = new GridBagConstraints();
		gbc_lblTemperaturaMinima.anchor = GridBagConstraints.NORTH;
		gbc_lblTemperaturaMinima.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTemperaturaMinima.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemperaturaMinima.gridx = 0;
		gbc_lblTemperaturaMinima.gridy = 1;
		center.add(lblTemperaturaMinima, gbc_lblTemperaturaMinima);
		
		GridBagConstraints gbc_lblValor_1 = new GridBagConstraints();
		gbc_lblValor_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor_1.gridx = 1;
		gbc_lblValor_1.gridy = 1;
		center.add(lblValor_1, gbc_lblValor_1);
		
		JLabel lblTemperaturaMaxima = new JLabel("Temperatura Maxima:");
		GridBagConstraints gbc_lblTemperaturaMaxima = new GridBagConstraints();
		gbc_lblTemperaturaMaxima.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTemperaturaMaxima.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemperaturaMaxima.gridx = 0;
		gbc_lblTemperaturaMaxima.gridy = 2;
		center.add(lblTemperaturaMaxima, gbc_lblTemperaturaMaxima);
		
		GridBagConstraints gbc_lblValor_2 = new GridBagConstraints();
		gbc_lblValor_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor_2.gridx = 1;
		gbc_lblValor_2.gridy = 2;
		center.add(lblValor_2, gbc_lblValor_2);
		
		JLabel lblEscala = new JLabel("Escala:");
		GridBagConstraints gbc_lblEscala = new GridBagConstraints();
		gbc_lblEscala.anchor = GridBagConstraints.NORTH;
		gbc_lblEscala.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEscala.insets = new Insets(0, 0, 5, 5);
		gbc_lblEscala.gridx = 0;
		gbc_lblEscala.gridy = 3;
		center.add(lblEscala, gbc_lblEscala);
		
		GridBagConstraints gbc_lblValor_3 = new GridBagConstraints();
		gbc_lblValor_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor_3.gridx = 1;
		gbc_lblValor_3.gridy = 3;
		center.add(lblValor_3, gbc_lblValor_3);
		
		JLabel lblHumedad = new JLabel("Humedad:");
		GridBagConstraints gbc_lblHumedad = new GridBagConstraints();
		gbc_lblHumedad.anchor = GridBagConstraints.NORTH;
		gbc_lblHumedad.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblHumedad.insets = new Insets(0, 0, 5, 5);
		gbc_lblHumedad.gridx = 0;
		gbc_lblHumedad.gridy = 4;
		center.add(lblHumedad, gbc_lblHumedad);
		
		GridBagConstraints gbc_lblValor_4 = new GridBagConstraints();
		gbc_lblValor_4.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor_4.gridx = 1;
		gbc_lblValor_4.gridy = 4;
		center.add(lblValor_4, gbc_lblValor_4);
		
		JLabel lblPresion = new JLabel("Presion:");
		GridBagConstraints gbc_lblPresion = new GridBagConstraints();
		gbc_lblPresion.anchor = GridBagConstraints.NORTH;
		gbc_lblPresion.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPresion.insets = new Insets(0, 0, 5, 5);
		gbc_lblPresion.gridx = 0;
		gbc_lblPresion.gridy = 5;
		center.add(lblPresion, gbc_lblPresion);
		
		GridBagConstraints gbc_lblValor_5 = new GridBagConstraints();
		gbc_lblValor_5.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor_5.gridx = 1;
		gbc_lblValor_5.gridy = 5;
		center.add(lblValor_5, gbc_lblValor_5);
		
		JLabel lblDireccionDelViento = new JLabel("Direccion del Viento:");
		GridBagConstraints gbc_lblDireccionDelViento = new GridBagConstraints();
		gbc_lblDireccionDelViento.anchor = GridBagConstraints.NORTH;
		gbc_lblDireccionDelViento.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDireccionDelViento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccionDelViento.gridx = 0;
		gbc_lblDireccionDelViento.gridy = 6;
		center.add(lblDireccionDelViento, gbc_lblDireccionDelViento);
		
		GridBagConstraints gbc_lblValor_6 = new GridBagConstraints();
		gbc_lblValor_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor_6.gridx = 1;
		gbc_lblValor_6.gridy = 6;
		center.add(lblValor_6, gbc_lblValor_6);
		
		JLabel lblVelocidadDelViento = new JLabel("Velocidad del viento:");
		GridBagConstraints gbc_lblVelocidadDelViento = new GridBagConstraints();
		gbc_lblVelocidadDelViento.anchor = GridBagConstraints.NORTH;
		gbc_lblVelocidadDelViento.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVelocidadDelViento.insets = new Insets(0, 0, 5, 5);
		gbc_lblVelocidadDelViento.gridx = 0;
		gbc_lblVelocidadDelViento.gridy = 7;
		center.add(lblVelocidadDelViento, gbc_lblVelocidadDelViento);
		
		GridBagConstraints gbc_lblValor_7 = new GridBagConstraints();
		gbc_lblValor_7.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor_7.gridx = 1;
		gbc_lblValor_7.gridy = 7;
		center.add(lblValor_7, gbc_lblValor_7);
		
		JLabel lblVisibilidad = new JLabel("Visibilidad:");
		GridBagConstraints gbc_lblVisibilidad = new GridBagConstraints();
		gbc_lblVisibilidad.anchor = GridBagConstraints.NORTH;
		gbc_lblVisibilidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVisibilidad.insets = new Insets(0, 0, 0, 5);
		gbc_lblVisibilidad.gridx = 0;
		gbc_lblVisibilidad.gridy = 8;
		center.add(lblVisibilidad, gbc_lblVisibilidad);
		
		GridBagConstraints gbc_lblValor_8 = new GridBagConstraints();
		gbc_lblValor_8.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblValor_8.gridx = 1;
		gbc_lblValor_8.gridy = 8;
		center.add(lblValor_8, gbc_lblValor_8);
	}
}
