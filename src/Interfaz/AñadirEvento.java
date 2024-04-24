package Interfaz;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AñadirEvento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;

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
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(56, 112, 136, 43);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(Color.GRAY);
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setBounds(191, 112, 340, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Localización:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(56, 213, 195, 43);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(257, 213, 340, 43);
		contentPane.add(textField_1);
		
		lblNewLabel = new JLabel("Fecha:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(56, 307, 102, 43);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(168, 307, 340, 43);
		contentPane.add(textField_2);
		
		lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(56, 409, 102, 43);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(168, 518, 297, 100);
		contentPane.add(btnNewButton);
		
		//Menú desplegable
		
		String[] opciones = {"VGC", "Cartas"}; //Crear las opciones del menú
		
		//Crear un JComboBox con las opciones
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		comboBox.setFont(new Font("High Tower Text", Font.PLAIN, 27));
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.GRAY);
		comboBox.setBounds(150, 409, 340, 43);
		
		// Agregar un ActionListener para manejar los eventos de selección
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el elemento seleccionado del JComboBox
                String seleccion = (String) comboBox.getSelectedItem();
                /* Imprimir el elemento seleccionado
                System.out.println("Opción seleccionada: " + seleccion);*/
            }
        });

        // Agregar el JComboBox al marco
		contentPane.add(comboBox);

        // Establecer el marco como visible
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AñadirEvento.class.getResource("/Imagenes/Wallpaper3.jpg")));
		lblNewLabel.setBounds(0, 0, 1280, 720);
		contentPane.add(lblNewLabel);
    }
		

	}
