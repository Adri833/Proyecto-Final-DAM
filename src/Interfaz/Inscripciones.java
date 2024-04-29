package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BBDD.ConexionMySQL;

public class Inscripciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cuadroNombre;
	private JTextField cuadroDni;
	private JLabel labelEdad;
	private JTextField cuadroPokemon;
	private JTextField cuadroEdad;
	private JLabel labelPokemon;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscripciones frame = new Inscripciones();
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
	public Inscripciones() {
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
		labelNombre.setBounds(56, 110, 136, 43);
		contentPane.add(labelNombre);
		
		cuadroNombre = new JTextField();
		cuadroNombre.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 25));
		cuadroNombre.setBackground(Color.GRAY);
		cuadroNombre.setForeground(Color.WHITE);
		cuadroNombre.setBounds(191, 110, 340, 43);
		contentPane.add(cuadroNombre);
		cuadroNombre.setColumns(10);
		
		JLabel labelDni = new JLabel("DNI:");
		labelDni.setForeground(Color.BLACK);
		labelDni.setFont(new Font("Dialog", Font.BOLD, 30));
		labelDni.setBackground(Color.BLACK);
		labelDni.setBounds(56, 210, 76, 43);
		contentPane.add(labelDni);
		
		cuadroDni = new JTextField();
		cuadroDni.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 25));
		cuadroDni.setForeground(Color.WHITE);
		cuadroDni.setColumns(10);
		cuadroDni.setBackground(Color.GRAY);
		cuadroDni.setBounds(138, 210, 340, 43);
		contentPane.add(cuadroDni);
		
		labelEdad = new JLabel("Edad:");
		labelEdad.setForeground(Color.BLACK);
		labelEdad.setFont(new Font("Dialog", Font.BOLD, 30));
		labelEdad.setBackground(Color.BLACK);
		labelEdad.setBounds(56, 310, 102, 43);
		contentPane.add(labelEdad);
		
		cuadroEdad = new JTextField();
		cuadroEdad.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 25));
		cuadroEdad.setForeground(Color.WHITE);
		cuadroEdad.setColumns(10);
		cuadroEdad.setBackground(Color.GRAY);
		cuadroEdad.setBounds(158, 310, 340, 43);
		contentPane.add(cuadroEdad);
		
		labelPokemon = new JLabel("Pokemon:");
		labelPokemon.setForeground(Color.BLACK);
		labelPokemon.setFont(new Font("Dialog", Font.BOLD, 30));
		labelPokemon.setBackground(Color.BLACK);
		labelPokemon.setBounds(56, 410, 156, 43);
		contentPane.add(labelPokemon);
		
		cuadroPokemon = new JTextField();
		cuadroPokemon.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 25));
		cuadroPokemon.setForeground(Color.WHITE);
		cuadroPokemon.setColumns(10);
		cuadroPokemon.setBackground(Color.GRAY);
		cuadroPokemon.setBounds(209, 410, 340, 43);
		contentPane.add(cuadroPokemon);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setForeground(Color.ORANGE);
		botonGuardar.setBackground(new Color(0, 0, 0));
		botonGuardar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		botonGuardar.setBounds(168, 518, 297, 100);
		contentPane.add(botonGuardar);

		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Se inicializan los datos recogidos en el textfield
				String nombre = cuadroNombre.getText();
				String dni= cuadroDni.getText();
				String edadString = cuadroEdad.getText();
				String pokemon = cuadroPokemon.getText();

				// Convertir edad de String a Int
				int edad = Integer.parseInt(edadString);
				
				// Comprobar que el participante sea mayor de edad y el dni sea correcto
				if (edad < 18) {
					String mensaje18 = "El participante debe ser mayor de edad";
					JOptionPane.showMessageDialog(null, mensaje18, "" ,JOptionPane.WARNING_MESSAGE);
				} else {
					ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
					try {
						conexion.conectar();
						System.out.println("on"); // Comprobaciones que la base de datos funciona
						
						// Declaracion SQL
						String insertar = "INSERT INTO Participantes (nombre, dni, edad, pokemon) "
								+ "VALUES ('" + nombre + "', '" + dni + "', '" + edad + "', '" + pokemon + "');";
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
					String mensajeEvento = "Participante agregado";
					JOptionPane.showMessageDialog(null, mensajeEvento);
					
					SeleccionarEvento ventanaSeleccionarEvento = new SeleccionarEvento();
					ventanaSeleccionarEvento.setVisible(true);
			    }
			}
		});

        // Establecer el marco como visible
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		// Fondo de pantalla
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AñadirEvento.class.getResource("/Imagenes/Wallpaper6.jpg")));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel);
    }
	}
