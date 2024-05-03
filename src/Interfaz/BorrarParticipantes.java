package Interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.ConexionMySQL;

public class BorrarParticipantes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrarParticipantes frame = new BorrarParticipantes();
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
	public BorrarParticipantes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("¿Qué participante quieres borrar?");
		lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 35));
		lblNewLabel_1.setBounds(40, 60, 734, 80);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> eventosComboBox = new JComboBox<>();
		eventosComboBox.setForeground(new Color(225, 217, 142));
		eventosComboBox.setBackground(new Color(125, 132, 149));
		eventosComboBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 27));
		eventosComboBox.setBounds(98, 311, 428 ,56);
		contentPane.add(eventosComboBox);
		
		// Carga el contenido de la base de datos
		ParticipantesBBDD(eventosComboBox);
		
		// Boton
		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.setForeground(new Color(225, 217, 142));
		botonBorrar.setBackground(new Color(75, 79, 86));
		botonBorrar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		botonBorrar.setBounds(167, 500, 297, 100);
		contentPane.add(botonBorrar);
				
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				// Verificar si el JComboBox tiene elementos
		        if (eventosComboBox.getItemCount() == 0) {
		            JOptionPane.showMessageDialog(null, "No hay participantes disponibles para borrar", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				
			 // Obtener el participante seleccionado del comboBox
				String participanteSeleccionado = (String) eventosComboBox.getSelectedItem();
				        
			// Obtener el ID del participante seleccionado
			   int idParticipante = obtenerIdParticipante(participanteSeleccionado);

			   BorrarParticipante(idParticipante);
				 dispose();
			 }
		});
		
		// Fondo de pantalla
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AñadirEvento.class.getResource("/Imagenes/Wallpaper9.jpg")));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel);
	}

	// Metodo para obtener el nombre de los participantes
	private void ParticipantesBBDD(JComboBox<String> eventosComboBox) {
		ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
		
		try {
			conexion.conectar();
			
			// Sentencia SQL para obtener los eventos y ejecutarlos
			String consulta = "SELECT Nombre FROM Participantes";
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
	
	// Metodo para borrar el Participante seleccionado
	private void BorrarParticipante(int idParticipantes) {
			  ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
			  try {
			      conexion.conectar();
			      
			   // Eliminar los registros asociados al evento en la tabla Participantes_Eventos
			      String consultaEliminarParticipantes = "DELETE FROM Participantes_Eventos WHERE id_participantes = ?";
			      PreparedStatement statementEliminarParticipantes = conexion.prepareStatement(consultaEliminarParticipantes);
			      statementEliminarParticipantes.setInt(1, idParticipantes);
			      statementEliminarParticipantes.executeUpdate();
			        
			      String consultaEliminarEvento = "DELETE FROM Participantes WHERE idParticipantes = ?";
			      PreparedStatement statementEliminarEvento = conexion.prepareStatement(consultaEliminarEvento);
			      statementEliminarEvento.setInt(1, idParticipantes);
			      statementEliminarEvento.executeUpdate();
			        
			      JOptionPane.showMessageDialog(null, "Participante borrado");
			  } catch (SQLException e) {
			      e.printStackTrace();
			      JOptionPane.showMessageDialog(null, "Error al borrar el participante");
			  } finally {
			      try {
			          conexion.desconectar();
			      } catch (SQLException e) {
			          e.printStackTrace();
			      }
			  }
	}
}
