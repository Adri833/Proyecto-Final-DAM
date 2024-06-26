package Interfaz;

import java.awt.EventQueue;

import com.toedter.calendar.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.ConexionMySQL;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class AñadirEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cuadroNombre;
	private JTextField cuadroLocalizacion;
	private JLabel labelFecha;
	private JLabel labelTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirEvento frame = new AñadirEvento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AñadirEvento() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBackground(Color.BLACK);
		labelNombre.setFont(new Font("Dialog", Font.BOLD, 30));
		labelNombre.setForeground(Color.BLACK);
		labelNombre.setBounds(56, 112, 136, 43);
		contentPane.add(labelNombre);
		
		cuadroNombre = new JTextField();
		cuadroNombre.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 25));
		cuadroNombre.setBackground(Color.GRAY);
		cuadroNombre.setForeground(Color.WHITE);
		cuadroNombre.setBounds(191, 112, 340, 43);
		contentPane.add(cuadroNombre);
		cuadroNombre.setColumns(10);
		
		JLabel labelLocalizacion = new JLabel("Localización:");
		labelLocalizacion.setForeground(Color.BLACK);
		labelLocalizacion.setFont(new Font("Dialog", Font.BOLD, 30));
		labelLocalizacion.setBackground(Color.BLACK);
		labelLocalizacion.setBounds(56, 213, 195, 43);
		contentPane.add(labelLocalizacion);
		
		cuadroLocalizacion = new JTextField();
		cuadroLocalizacion.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 25));
		cuadroLocalizacion.setForeground(Color.WHITE);
		cuadroLocalizacion.setColumns(10);
		cuadroLocalizacion.setBackground(Color.GRAY);
		cuadroLocalizacion.setBounds(257, 213, 307, 43);
		contentPane.add(cuadroLocalizacion);
		
		labelFecha = new JLabel("Fecha:");
		labelFecha.setForeground(Color.BLACK);
		labelFecha.setFont(new Font("Dialog", Font.BOLD, 30));
		labelFecha.setBackground(Color.BLACK);
		labelFecha.setBounds(56, 307, 102, 43);
		contentPane.add(labelFecha);
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setForeground(Color.GRAY);
		dateChooser.setBackground(Color.GRAY);
		dateChooser.setBounds(172, 307, 385, 43);
		contentPane.add(dateChooser);
		
		labelTipo = new JLabel("Tipo:");
		labelTipo.setForeground(Color.BLACK);
		labelTipo.setFont(new Font("Dialog", Font.BOLD, 30));
		labelTipo.setBackground(Color.BLACK);
		labelTipo.setBounds(56, 409, 102, 43);
		contentPane.add(labelTipo);

		//Menú desplegable
		
				String[] opciones = {"VGC", "Cartas"}; //Crear las opciones del menú
				
				//Crear un JComboBox con las opciones
				JComboBox<String> comboBox = new JComboBox<>(opciones);
				comboBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 27));
				comboBox.setForeground(Color.WHITE);
				comboBox.setBackground(Color.GRAY);
				comboBox.setBounds(150, 409, 340, 43);
				
		        // Agregar el JComboBox al marco
				contentPane.add(comboBox);

		        // Establecer el marco como visible
				contentPane.setLayout(null);
				contentPane.setVisible(true);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Se inicializan los datos recogidos en el textfield
				String nombre = cuadroNombre.getText();
				String localizacion = cuadroLocalizacion.getText();
				Date fecha = dateChooser.getDate();
				String tipo = (String) comboBox.getSelectedItem();
				
				// Comprobar que todos los campos estan llenos
				if (nombre.isEmpty() || localizacion.isEmpty()|| fecha == null) {
					JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Convertir fecha a String
				SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
				String fechaString = formatDate.format(fecha);

					ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
					try {
						conexion.conectar();
						System.out.println("on"); // Comprobaciones que la base de datos funciona
	
						// Declaracion SQL
						String insertar = "INSERT INTO Eventos (nombre, localizacion, fecha, tipo) "
								+ "VALUES ('" + nombre + "', '" + localizacion + "', '" + fechaString + "', '" + tipo + "');";
						conexion.ejecutarInsertDeleteUpdate(insertar);
					} catch (SQLException e1) {
						e1.printStackTrace();					
					}
					// Cerramos la conexion
					finally {
						try {
							conexion.desconectar();
							System.out.println("off");
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					
					dispose(); // Cerrar la ventana al pulsar el botón
					
					// Mostrar un mensaje 
					JOptionPane.showMessageDialog(null, "Evento creado");
			    }
		});
		botonGuardar.setBackground(new Color(255, 255, 81));
		botonGuardar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		botonGuardar.setBounds(168, 518, 297, 100);
		contentPane.add(botonGuardar);
		
		// Fondo de pantalla
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AñadirEvento.class.getResource("/Imagenes/Wallpaper3.jpg")));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel);


    }
	}
