package Interfaz;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BBDD.ConexionMySQL;

import javax.swing.JTable;

public class Consultorio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultorio frame = new Consultorio();
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
	public Consultorio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Nombre_ParticipantesBBDD();
		
		// Fondo de pantalla
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AñadirEvento.class.getResource("/Imagenes/Wallpaper5.jpg")));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel);
		
		

	}

	private void Nombre_ParticipantesBBDD() {
	    ConexionMySQL conexion = new ConexionMySQL("root", "test", "dbname");
	    try {
	        conexion.conectar();
	        String consulta = "SELECT Eventos.Nombre AS Evento, Eventos.fecha AS Fecha, COUNT(Participantes_Eventos.id_participantes) AS numParticipantes " +
                    "FROM Eventos LEFT JOIN Participantes_Eventos " +
                    "ON Eventos.idEventos = Participantes_Eventos.id_eventos " +
                    "GROUP BY Eventos.Nombre, Eventos.fecha";
	        ResultSet rs = conexion.ejecutarSelect(consulta);

	        	DefaultTableModel model = new DefaultTableModel();
	    		model.addColumn("Evento");
	    		model.addColumn("Fecha");
	    		model.addColumn("nº Participantes");
	    		
	    	try {
	    		while (rs.next()) {
	    			String evento = rs.getString("Evento");
	    			String fecha = rs.getString("Fecha");
	    			int numParticipantes = rs.getInt("numParticipantes");
	    			model.addRow(new Object[]{evento, fecha, numParticipantes});
	    		}
	    		
	    		
	    		// Crea la tabla y la configura
	    		table = new JTable(model);
	    		JScrollPane scrollPane = new JScrollPane(table);
	    		scrollPane.setBounds(59, 61, 558, 577);
	    		contentPane.add(scrollPane);
	
	    		
	    	} catch (SQLException e) {
	    		
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
	}
}
