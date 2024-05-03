package Interfaz;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.*;
import BBDD.ConexionMySQL;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionarEvento2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionarEvento2 frame = new SeleccionarEvento2();
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
	
	public SeleccionarEvento2() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(0, 0, 1280, 720);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			
			JLabel lblNewLabel_1 = new JLabel("¿A qué evento quieres agregarlo?");
			lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 35));
			lblNewLabel_1.setBounds(40, 60, 691, 80);
			contentPane.add(lblNewLabel_1);
			
			JComboBox<String> participantesComboBox = new JComboBox<>();
			participantesComboBox.setBackground(new Color(177, 146, 164));
			participantesComboBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 27));
			participantesComboBox.setBounds(160, 250, 390 ,56);
			contentPane.add(participantesComboBox);
			
			JComboBox<String> eventosComboBox = new JComboBox<>();
			eventosComboBox.setBackground(new Color(177, 146, 164));
			eventosComboBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 27));
			eventosComboBox.setBounds(160, 350, 390 ,56);
			contentPane.add(eventosComboBox);
			 
			// Carga los eventos de la base de datos
			EventosBBDD(eventosComboBox);
			ParticipantesBBDD(participantesComboBox);
	
			// Establecer el marco como visible
				contentPane.setLayout(null);
				contentPane.setVisible(true);
	
			JButton botonInscribir = new JButton("Inscribir");
			botonInscribir.setForeground(new Color(225, 215, 221));
			botonInscribir.setBackground(new Color(177, 146, 164));
			botonInscribir.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
			botonInscribir.setBounds(209, 500, 297, 100);
			contentPane.add(botonInscribir);
			
			botonInscribir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				    // Obtener el evento seleccionado del comboBox
			        String eventoSeleccionado = (String) eventosComboBox.getSelectedItem();
			        
			        // Obtener el participante seleccionado del comboBox
			        String participanteSeleccionado = (String) participantesComboBox.getSelectedItem();
			        
			        // Obtener el ID del evento seleccionado
			        int idEvento = obtenerIdEvento(eventoSeleccionado);
			        
			        // Obtener el ID del participante seleccionado
			        int idParticipante = obtenerIdParticipante(participanteSeleccionado);
			        
			        // Insertar la nueva fila en la tabla Participante_Eventos
			        insertarParticipanteEvento(idEvento, idParticipante);
			        
			        dispose();
			    }
			});
			
			// Fondo de pantalla
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(AñadirEvento.class.getResource("/Imagenes/Wallpaper7.jpg")));
			lblNewLabel.setBounds(0, 0, 1280, 720);
			contentPane.add(lblNewLabel);

	}
	
	private void EventosBBDD(JComboBox<String> eventosComboBox) {
		ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
		
		try {
			conexion.conectar();
			
			// Sentencia SQL para obtener los eventos y ejecutarlos
			String consulta = "SELECT Nombre FROM Eventos";
			ResultSet resultSet = conexion.ejecutarSelect(consulta);
			
			// Recorre el resultado y lo va agregando al ComboBox
			while (resultSet.next()) {
				String nombreEvento = resultSet.getString("Nombre");
				eventosComboBox.addItem(nombreEvento);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void ParticipantesBBDD(JComboBox<String> participantesComboBox) {
		ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
		
		try {
			conexion.conectar();
			
			// Sentencia SQL para obtener los eventos y ejecutarlos
			String consulta = "SELECT Nombre FROM Participantes";
			ResultSet resultSet = conexion.ejecutarSelect(consulta);
			
			// Recorre el resultado y lo va agregando al ComboBox
			while (resultSet.next()) {
				String nombreParticipante = resultSet.getString("Nombre");
				participantesComboBox.addItem(nombreParticipante);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				conexion.desconectar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Método para obtener el ID del evento seleccionado
	private int obtenerIdEvento(String nombreEvento) {
	    int idEvento = -1;
	    ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
	    try {
	        conexion.conectar();
	        String consulta = "SELECT idEventos FROM Eventos WHERE Nombre = ?";
	        PreparedStatement statement = conexion.prepareStatement(consulta);
	        statement.setString(1, nombreEvento);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            idEvento = resultSet.getInt("idEventos");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conexion.desconectar();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return idEvento;
	}
	
	// Método para obtener el ID del participante seleccionado
	private int obtenerIdParticipante(String nombreParticipante) {
	    int idParticipante = -1;
	    ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
	    try {
	        conexion.conectar();
	        String consulta = "SELECT idParticipantes FROM Participantes WHERE Nombre = ?";
	        PreparedStatement statement = conexion.prepareStatement(consulta);
	        statement.setString(1, nombreParticipante);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            idParticipante = resultSet.getInt("idParticipantes");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            conexion.desconectar();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return idParticipante;
	}
	
	// Método para insertar una nueva fila en la tabla Participante_Eventos
	private void insertarParticipanteEvento(int idEvento, int idParticipantes) {
	    ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
	    try {
	        conexion.conectar();
	        
	        // Verificar si el participante ya está inscrito en el evento
	        String verificacion = "SELECT COUNT(*) FROM Participantes_Eventos WHERE id_eventos = ? AND id_participantes = ?";
	        PreparedStatement Verificacion = conexion.prepareStatement(verificacion);
	        Verificacion.setInt(1, idEvento);
	        Verificacion.setInt(2, idParticipantes);
	        ResultSet rsVerificacion = Verificacion.executeQuery();
	        rsVerificacion.next();
	        int cantidad = rsVerificacion.getInt(1);
	        
	        // Si la cantidad es mayor que 0, significa que el participante ya está inscrito
	        if (cantidad > 0) {
				JOptionPane.showMessageDialog(null, "El participante ya está inscrito en este evento", "Error", JOptionPane.ERROR_MESSAGE);
	        } else {
	            // Si no, inserta el nuevo registro en la tabla Participantes_Eventos
	            String consulta = "INSERT INTO Participantes_Eventos (id_eventos, id_participantes) VALUES (?, ?)";
	            PreparedStatement statement = conexion.prepareStatement(consulta);
	            statement.setInt(1, idEvento);
	            statement.setInt(2, idParticipantes);
	            statement.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Participante inscrito correctamente al evento.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al inscribir al participante", "Error", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
	            conexion.desconectar();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
}
