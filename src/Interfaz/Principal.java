package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

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
        addEventButton.setBounds(50, 95, 471, 144);

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
        
     // Boton marrón
        JButton brownButton = new JButton("Inscripciones");

        // Cambio de Frame
        brownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Inscripciones ventanaInscripciones = new Inscripciones();
            	ventanaInscripciones.setVisible(true);            }
        });

        brownButton.setFont(new Font("Rockwell Condensed", Font.BOLD, 40));
        brownButton.setBorderPainted(false);
        brownButton.setContentAreaFilled(false);
        brownButton.setBounds(50, 265, 471, 144);

        // Establecer texto en el centro del botón
        brownButton.setHorizontalTextPosition(JButton.CENTER);
        brownButton.setVerticalTextPosition(JButton.CENTER);

        // Cargar la imagen normal
        ImageIcon brownNormalIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton marron.png"));
        Image brownNormalImage = brownNormalIcon.getImage().getScaledInstance(brownButton.getWidth(), brownButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon brownNormal = new ImageIcon(brownNormalImage);

        // Cargar la imagen para cuando el ratón pasa sobre el botón
        ImageIcon brownHoverIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton marron seleccionado.png"));
        Image brownHoverImage = brownHoverIcon.getImage().getScaledInstance(brownButton.getWidth(), brownButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon brownHover = new ImageIcon(brownHoverImage);

        // Establecer la imagen normal como icono inicial
        brownButton.setIcon(brownNormal);

        // Agregar el botón al panel de contenido
        contentPane.add(brownButton);

        // Listener de ratón para cambiar la imagen cuando el ratón entra en el botón
        brownButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                brownButton.setIcon(brownHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                brownButton.setIcon(brownNormal);
            }
        });
        
     // Boton rojo
        JButton redButton = new JButton("Borrar Evento");

        // Cambio de Frame
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               BorrarEvento ventanaBorrar = new BorrarEvento();
                ventanaBorrar.setVisible(true);
            }
        });

        redButton.setFont(new Font("Rockwell Condensed", Font.BOLD, 40));
        redButton.setBorderPainted(false);
        redButton.setContentAreaFilled(false);
        redButton.setBounds(1397, 95, 471, 144);

        // Establecer texto en el centro del botón
        redButton.setHorizontalTextPosition(JButton.CENTER);
        redButton.setVerticalTextPosition(JButton.CENTER);

        // Cargar la imagen normal
        ImageIcon redNormalIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton rojo.png"));
        Image redNormalImage = redNormalIcon.getImage().getScaledInstance(redButton.getWidth(), redButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon redNormal = new ImageIcon(redNormalImage);

        // Cargar la imagen para cuando el ratón pasa sobre el botón
        ImageIcon redHoverIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton rojo seleccionado.png"));
        Image redHoverImage = redHoverIcon.getImage().getScaledInstance(redButton.getWidth(), redButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon redHover = new ImageIcon(redHoverImage);

        // Establecer la imagen normal como icono inicial
        redButton.setIcon(redNormal);

        // Agregar el botón al panel de contenido
        contentPane.add(redButton);

        // Listener de ratón para cambiar la imagen cuando el ratón entra en el botón
        redButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                redButton.setIcon(redHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                redButton.setIcon(redNormal);
            }
        });
        
     // Boton azul
        JButton blueButton = new JButton("Consultar Eventos");

        // Cambio de Frame
        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Consultorio ventanaconsultorio = new Consultorio();
            	ventanaconsultorio.setVisible(true);
            }
        });

        blueButton.setFont(new Font("Rockwell Condensed", Font.BOLD, 40));
        blueButton.setBorderPainted(false);
        blueButton.setContentAreaFilled(false);
        blueButton.setBounds(1397, 265, 471, 144);

        // Establecer texto en el centro del botón
        blueButton.setHorizontalTextPosition(JButton.CENTER);
        blueButton.setVerticalTextPosition(JButton.CENTER);

        // Cargar la imagen normal
        ImageIcon blueNormalIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton azul.png"));
        Image blueNormalImage = blueNormalIcon.getImage().getScaledInstance(blueButton.getWidth(), blueButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon blueNormal = new ImageIcon(blueNormalImage);

        // Cargar la imagen para cuando el ratón pasa sobre el botón
        ImageIcon blueHoverIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton azul seleccionado.png"));
        Image blueHoverImage = blueHoverIcon.getImage().getScaledInstance(blueButton.getWidth(), blueButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon blueHover = new ImageIcon(blueHoverImage);

        // Establecer la imagen normal como icono inicial
        blueButton.setIcon(blueNormal);

        // Agregar el botón al panel de contenido
        contentPane.add(blueButton);

        // Listener de ratón para cambiar la imagen cuando el ratón entra en el botón
        blueButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                blueButton.setIcon(blueHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                blueButton.setIcon(blueNormal);
            }
        });

     // Boton rosa
        JButton pinkButton = new JButton("Agregar a Evento");

        // Cambio de Frame
        pinkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SeleccionarEvento2 ventanaSeleccionarEvento2 = new SeleccionarEvento2();
                ventanaSeleccionarEvento2.setVisible(true);
            }
        });

        pinkButton.setFont(new Font("Rockwell Condensed", Font.BOLD, 40));
        pinkButton.setBorderPainted(false);
        pinkButton.setContentAreaFilled(false);
        pinkButton.setBounds(1397, 435 , 471, 144);

        // Establecer texto en el centro del botón
        pinkButton.setHorizontalTextPosition(JButton.CENTER);
        pinkButton.setVerticalTextPosition(JButton.CENTER);

        // Cargar la imagen normal
        ImageIcon pinkNormalIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton rosa.png"));
        Image pinkNormalImage = pinkNormalIcon.getImage().getScaledInstance(pinkButton.getWidth(), pinkButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pinkNormal = new ImageIcon(pinkNormalImage);

        // Cargar la imagen para cuando el ratón pasa sobre el botón
        ImageIcon pinkHoverIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton rosa seleccionado.png"));
        Image pinkHoverImage = pinkHoverIcon.getImage().getScaledInstance(pinkButton.getWidth(), pinkButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pinkHover = new ImageIcon(pinkHoverImage);

        // Establecer la imagen normal como icono inicial
        pinkButton.setIcon(pinkNormal);

        // Agregar el botón al panel de contenido
        contentPane.add(pinkButton);

        // Listener de ratón para cambiar la imagen cuando el ratón entra en el botón
        pinkButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pinkButton.setIcon(pinkHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pinkButton.setIcon(pinkNormal);
            }
        });
        
     // Boton gris
        JButton botonGris = new JButton("Borrar Participante");

        // Cambio de Frame
        botonGris.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BorrarParticipantes ventanaBorrarParticipantes = new BorrarParticipantes();
                ventanaBorrarParticipantes.setVisible(true);
            }
        });

        botonGris.setFont(new Font("Rockwell Condensed", Font.BOLD, 40));
        botonGris.setBorderPainted(false);
        botonGris.setContentAreaFilled(false);
        botonGris.setBounds(50, 435, 471, 144);

        // Establecer texto en el centro del botón
        botonGris.setHorizontalTextPosition(JButton.CENTER);
        botonGris.setVerticalTextPosition(JButton.CENTER);

        // Cargar la imagen normal
        ImageIcon grayNormalIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton gris.png"));
        Image grayNormalImage = grayNormalIcon.getImage().getScaledInstance(botonGris.getWidth(), botonGris.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon grayNormal = new ImageIcon(grayNormalImage);

        // Cargar la imagen para cuando el ratón pasa sobre el botón
        ImageIcon grayHoverIcon = new ImageIcon(Principal.class.getResource("/Imagenes/Boton gris seleccionado.png"));
        Image grayHoverImage = grayHoverIcon.getImage().getScaledInstance(botonGris.getWidth(), botonGris.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon grayHover = new ImageIcon(grayHoverImage);

        // Establecer la imagen normal como icono inicial
        botonGris.setIcon(grayNormal);

        // Agregar el botón al panel de contenido
        contentPane.add(botonGris);

        // Listener de ratón para cambiar la imagen cuando el ratón entra en el botón
        botonGris.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonGris.setIcon(grayHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonGris.setIcon(grayNormal);
            }
        });


        
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Imagenes/Wallpaper2.jpg")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		contentPane.add(lblNewLabel);
		
		
	
		
	}
}
