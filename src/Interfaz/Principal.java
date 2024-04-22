package Interfaz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel labelFondo = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Boton verde
		JButton addEventButton = new JButton("Añadir Evento");
		
		//Cambio de Frame
		addEventButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AñadirEvento ventanaAñadir = new AñadirEvento();
				ventanaAñadir.setVisible(true);
			}
		});
		
        addEventButton.setFont(new Font("Rockwell Condensed", Font.BOLD, 40));
        addEventButton.setBorderPainted(false);;
        addEventButton.setContentAreaFilled(false);
        addEventButton.setBounds(73, 95, 471, 144);

        // Establecer texto en el centro del botón
        addEventButton.setHorizontalTextPosition(JButton.CENTER);
        addEventButton.setVerticalTextPosition(JButton.CENTER);

        // Cargar la imagen normal
        ImageIcon botonNormal = new ImageIcon(Principal.class.getResource("/Imagenes/Boton verde.png"));
        Image imagenNormal = botonNormal.getImage().getScaledInstance(addEventButton.getWidth(), addEventButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoNormal = new ImageIcon(imagenNormal);

        // Cargar la imagen para cuando el ratón pasa sobre el botón
        ImageIcon botonHover = new ImageIcon(Principal.class.getResource("/Imagenes/Boton verde seleccionado.png"));
        Image imagenHover = botonHover.getImage().getScaledInstance(addEventButton.getWidth(), addEventButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconoHover = new ImageIcon(imagenHover);

        // Establecer la imagen normal como icono inicial
        addEventButton.setIcon(iconoNormal);

        // Agregar el botón al panel de contenido
        contentPane.add(addEventButton);

        // Listener de ratón para cambiar la imagen cuando el ratón entra en el botón
        addEventButton.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addEventButton.setIcon(iconoHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addEventButton.setIcon(iconoNormal);
            }
        });
        
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/Wallpaper2.jpg")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel);
	
		
	}
}
