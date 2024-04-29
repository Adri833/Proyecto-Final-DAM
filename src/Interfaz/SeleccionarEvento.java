package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.sql.*;
import BBDD.ConexionMySQL;

public class SeleccionarEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> comboBoxEventos;

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionarEvento frame = new SeleccionarEvento();
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
	
	public SeleccionarEvento() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(0, 0, 1280, 720);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		
			JButton botonGuardar = new JButton("Guardar");
			botonGuardar.setForeground(Color.ORANGE);
			botonGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
					try {
						conexion.conectar();
						System.out.println("on"); // Comprobaciones que la base de datos funciona
							
						// Declaracion SQL
							
						// Obtener el ID del participante recién insertado
						String obtenerIdParticipante = "SELECT LAST_INSERT_ID()"; 
						ResultSet rs = conexion.ejecutarSelect(obtenerIdParticipante);
						int idParticipante = 0;
						if (rs.next()) {
							idParticipante = rs.getInt(1);
						}
							
						// Insertar el participante en la tabla Participantes_Eventos asociado al evento seleccionado
					    String insertarParticipanteEvento = "INSERT INTO Participantes_Eventos (id_Evento, id_Participante) VALUES (?, ?)";
					    PreparedStatement ps = conexion.prepareStatement(insertarParticipanteEvento);
					    ps.setInt(1, idEventoSeleccionado); // Aquí deberías tener el ID del evento seleccionado
					    ps.setInt(2, idParticipante);
						   ps.executeUpdate();

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
				  }	
			});
			botonGuardar.setBackground(new Color(0, 0, 0));
			botonGuardar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
			botonGuardar.setBounds(168, 518, 297, 100);
			contentPane.add(botonGuardar);


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
