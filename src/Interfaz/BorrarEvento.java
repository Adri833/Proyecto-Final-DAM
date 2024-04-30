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

public class BorrarEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrarEvento frame = new BorrarEvento();
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
	public BorrarEvento() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("¿Qué evento quieres borrar?");
		lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 35));
		lblNewLabel_1.setBounds(40, 60, 691, 80);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> eventosComboBox = new JComboBox<>();
		eventosComboBox.setBackground(new Color(38, 96, 101));
		eventosComboBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 27));
		eventosComboBox.setBounds(98, 311, 428 ,56);
		contentPane.add(eventosComboBox);
		 
		// Carga los eventos de la base de datos
		EventosBBDD(eventosComboBox);
		
		// Boton
		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.setForeground(new Color(255, 255, 255));
		botonBorrar.setBackground(new Color(38, 96, 101));
		botonBorrar.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
		botonBorrar.setBounds(167, 500, 297, 100);
		contentPane.add(botonBorrar);
		
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    // Obtener el evento seleccionado del comboBox
		        String eventoSeleccionado = (String) eventosComboBox.getSelectedItem();
		        
		        // Obtener el ID del evento seleccionado
		        int idEvento = obtenerIdEvento(eventoSeleccionado);

		        BorrarEventos(idEvento);
		        dispose();
		    }
		});
		
		
		// Fondo de pantalla
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AñadirEvento.class.getResource("/Imagenes/Wallpaper4.jpg")));
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
		
		// Metodo para borrar el evento seleccionado
		private void BorrarEventos(int idEventos) {
		    ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
		    try {
		        conexion.conectar();
		        
		        // Eliminar los registros asociados al evento en la tabla Participantes_Eventos
		        String consultaEliminarParticipantes = "DELETE FROM Participantes_Eventos WHERE id_eventos = ?";
		        PreparedStatement statementEliminarParticipantes = conexion.prepareStatement(consultaEliminarParticipantes);
		        statementEliminarParticipantes.setInt(1, idEventos);
		        statementEliminarParticipantes.executeUpdate();
		        
		        // Luego de eliminar los participantes asociados, eliminar el evento de la tabla Eventos
		        String consultaEliminarEvento = "DELETE FROM Eventos WHERE idEventos = ?";
		        PreparedStatement statementEliminarEvento = conexion.prepareStatement(consultaEliminarEvento);
		        statementEliminarEvento.setInt(1, idEventos);
		        statementEliminarEvento.executeUpdate();
		        
		        JOptionPane.showMessageDialog(null, "Evento borrado");
		    } catch (SQLException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al borrar el evento");
		    } finally {
		        try {
		            conexion.desconectar();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
}

	
