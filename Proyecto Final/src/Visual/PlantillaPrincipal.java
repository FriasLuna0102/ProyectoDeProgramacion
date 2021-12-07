package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.TitledBorder;

import Logico.PUCMM;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PlantillaPrincipal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlantillaPrincipal frame = new PlantillaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}  
			
		});
	}
/*
	/**
	 * Create the frame.
	 */
	public PlantillaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream pucmm2;
				ObjectOutputStream pucmmWrite;
				try {
					pucmm2 = new FileOutputStream("pucmm.dat");
					pucmmWrite = new ObjectOutputStream(pucmm2);
					pucmmWrite.writeObject(PUCMM.getInstance());
				}catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Starl\\Downloads\\WhatsApp Image 2021-11-25 at 3.50.46 PM.jpeg"));
		setBackground(new Color(169, 169, 169));
		dim = getToolkit().getScreenSize();
		setResizable(false);
		setTitle("Eventos Cientificos:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 719);
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBackground(new Color(0, 51, 153));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_3 = new JMenu("Inscripciones");
		if(PUCMM.getLoginUser().getTipo().equalsIgnoreCase("Participante")) {
			mnNewMenu_3.setEnabled(true);
		}
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		
		
		menuBar.add(mnNewMenu_3);
		
		//Se añadio el if...
		JMenuItem mntmNewMenuItem = new JMenuItem("Inscripci\u00F3n para Participantes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
					InscripcionParticipantes inscripcion = new  InscripcionParticipantes();
					inscripcion.setModal(true);
					inscripcion.setVisible(true);

			}
		});
		mnNewMenu_3.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Registrar Jurados");
		if(PUCMM.getLoginUser().getTipo().equalsIgnoreCase("Participante")) {
			mntmNewMenuItem_5.setEnabled(false);
		}
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IncripcionJurados jurado = new IncripcionJurados();
				jurado.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Inscripci\u00F3n para Jurados");//hacer plantilla jurados, copiar la misma que participantes y arreglar
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegDeJurados jurados = new RegDeJurados();
				jurados.setModal(true);
				jurados.setVisible(true);
				
			}
		});
		
		
		
		
		JMenu mnNewMenu_1 = new JMenu("Jurados");
		if(PUCMM.getLoginUser().getTipo().equalsIgnoreCase("Participante")) {
			mnNewMenu_1.setEnabled(false);
		}
		mnNewMenu_1.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listado de Jurados");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeJurados jurados = new ListadoDeJurados();
				jurados.setModal(true);
				jurados.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("");
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu = new JMenu("Participantes");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		
		
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de Participantes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoDeParticipantes participantes = new ListadoDeParticipantes();
				participantes.setModal(true);
				participantes.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_4 = new JMenu("Eventos");
		if(PUCMM.getLoginUser().getTipo().equalsIgnoreCase("Participante")) {
			mnNewMenu_4.setEnabled(false);
		}
		mnNewMenu_4.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado de Eventos");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoDeEventos list = new ListadoDeEventos();
				list.setVisible(true);
				list.setModal(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Registrar Eventos");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearEvento conect = new CrearEvento(null);
				conect.setVisible(true);
				conect.setModal(true);	
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registrar Usuario");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegUsuarios usuario = new RegUsuarios();
				usuario.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_5 = new JMenu("Comisiones");
		if(PUCMM.getLoginUser().getTipo().equalsIgnoreCase("Participante")) {
			mnNewMenu_5.setEnabled(false);
		}
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Crear Comision");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearComision comision = new CrearComision();
				comision.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_8);
		menuBar.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 153));	
		panel.setForeground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 153));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 600, 1319, 30);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00A9Todos los derechos reservados");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 10));
		lblNewLabel.setBounds(594, 11, 162, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EVENTO CIENTIFICO PUCMM");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bodoni MT Condensed", Font.PLAIN, 67));
		lblNewLabel_1.setBounds(464, 37, 553, 69); 
		panel.add(lblNewLabel_1);  
		
		JLabel lblNewLabel_2 = new JLabel("Campus Santiago");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(804, 134, 149, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DE LA ESCULA DE CIENCIAS DE INGENIERIA");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 37));
		lblNewLabel_3.setBounds(576, 98, 413, 41);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Se apr\u00F3xima el Evento Cient\u00EDfico PUCMM en el cual estudiantes y exteriores pueden presentar sus proyectos cientificos");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(263, 279, 851, 30);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Desde el jueves 2 de diciembre  hasta el s\u00E1bado 4 de diciembre del 2021");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(451, 345, 510, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("9:00 a.m - 3:00 p.m");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(599, 370, 149, 14);
		panel.add(lblNewLabel_6); 
		
		JLabel lblNewLabel_7 = new JLabel("Para favor informaci\u00F3n contactarse al (809) 580-1962, Ext. 4265");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_7.setBounds(471, 551, 490, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Costo: $250 c/u");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_8.setBounds(614, 404, 139, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Para calificar en la Segunda ronda deber\u00E1n de mandar sus proyectos al siguiente correo: eventopucmm@ce.pucmm.edu.do");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(252, 440, 862, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Est\u00E1 es tu oportunidad de demostrar el poder del conocimiento y la creatividad.");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_10.setBounds(434, 320, 583, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Starl\\Downloads\\WhatsApp Image 2021-11-25 at 3.50.46 PM (1).jpeg"));
		lblNewLabel_11.setBounds(78, 26, 320, 216);
		panel.add(lblNewLabel_11);
	} 
}
