package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	private JTextField cuadroLocalizacion;
	private JLabel labelFecha;
	private JTextField cuadroFecha;
	private JLabel labelTipo;


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
		
		JLabel labelLocalizacion = new JLabel("DNI:");
		labelLocalizacion.setForeground(Color.BLACK);
		labelLocalizacion.setFont(new Font("Dialog", Font.BOLD, 30));
		labelLocalizacion.setBackground(Color.BLACK);
		labelLocalizacion.setBounds(56, 210, 76, 43);
		contentPane.add(labelLocalizacion);
		
		cuadroLocalizacion = new JTextField();
		cuadroLocalizacion.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 25));
		cuadroLocalizacion.setForeground(Color.WHITE);
		cuadroLocalizacion.setColumns(10);
		cuadroLocalizacion.setBackground(Color.GRAY);
		cuadroLocalizacion.setBounds(158, 210, 340, 43);
		contentPane.add(cuadroLocalizacion);
		
		labelFecha = new JLabel("Edad:");
		labelFecha.setForeground(Color.BLACK);
		labelFecha.setFont(new Font("Dialog", Font.BOLD, 30));
		labelFecha.setBackground(Color.BLACK);
		labelFecha.setBounds(56, 310, 102, 43);
		contentPane.add(labelFecha);
		
		cuadroFecha = new JTextField();
		cuadroFecha.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 25));
		cuadroFecha.setForeground(Color.WHITE);
		cuadroFecha.setColumns(10);
		cuadroFecha.setBackground(Color.GRAY);
		cuadroFecha.setBounds(158, 310, 340, 43);
		contentPane.add(cuadroFecha);
		
		labelTipo = new JLabel("Pokemon:");
		labelTipo.setForeground(Color.BLACK);
		labelTipo.setFont(new Font("Dialog", Font.BOLD, 30));
		labelTipo.setBackground(Color.BLACK);
		labelTipo.setBounds(56, 410, 156, 43);
		contentPane.add(labelTipo);
		
		cuadroFecha = new JTextField();
		cuadroFecha.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 25));
		cuadroFecha.setForeground(Color.WHITE);
		cuadroFecha.setColumns(10);
		cuadroFecha.setBackground(Color.GRAY);
		cuadroFecha.setBounds(209, 410, 340, 43);
		contentPane.add(cuadroFecha);
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setForeground(Color.ORANGE);
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "test", "");
				try {
					conexion.conectar();
					String insertar = "";
					conexion.ejecutarInsertDeleteUpdate(insertar);
				} catch (SQLException e1) {
					e1.printStackTrace();
					
				}
				finally {
					try {
						conexion.desconectar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				dispose(); // Cerrar la ventana al pulsar el botón
				
				// Mostrar un mensaje 
				String mensaje = "Usuario registrado";
				JOptionPane.showMessageDialog(null, mensaje);
			}
		});
		botonGuardar.setBackground(new Color(0, 0, 0));
		botonGuardar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		botonGuardar.setBounds(168, 518, 297, 100);
		contentPane.add(botonGuardar);


        // Establecer el marco como visible
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AñadirEvento.class.getResource("/Imagenes/Wallpaper6.jpg")));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel);
    }
	}
