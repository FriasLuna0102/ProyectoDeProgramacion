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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class PlantillaPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Dimension dim;
	static Socket sfd = null;
	static DataInputStream EntradaSocket;
	static DataOutputStream SalidaSocket;
	BufferedInputStream bis;
	BufferedOutputStream bos;
	int in;
	byte[] byteArray;
	final String filename = "/pucmm.dat";


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
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inscripci\u00F3n para Participantes");
		if(PUCMM.getLoginUser().getTipo().equalsIgnoreCase("Jurado")) {
			mntmNewMenuItem.setEnabled(false);
			}
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
		if (PUCMM.getLoginUser().getTipo().equalsIgnoreCase("Jurado")) {
			mntmNewMenuItem_7.setEnabled(false);
		}
		mnNewMenu_3.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearEvento conect = new CrearEvento(null);
				conect.setVisible(true);
				conect.setModal(true);	
			}
		}); 
		mnNewMenu_4.add(mntmNewMenuItem_7);
		if(PUCMM.getLoginUser().getTipo().equalsIgnoreCase("Jurado")) {
			mnNewMenu_4.setEnabled(false);
		}
		
		JMenu mnNewMenu_5 = new JMenu("Comisiones");
		mnNewMenu_5.setForeground(new Color(255, 255, 255));
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
		
		JMenu mnNewMenu_6 = new JMenu("Respaldo");
		mnNewMenu_6.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Respaldar");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				byte[]b = new byte[20002];
				try {
					Socket sr = new Socket("127.0.0.1",7000);
					InputStream is = sr.getInputStream();
					FileOutputStream fr = new FileOutputStream("C:\\Users\\natas\\git\\ProyectoDeProgramacion\\Proyecto Final\\src\\Respaldo\\pucmm.dat");
					is.read(b,0,b.length);
					fr.write(b,0,b.length);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		}});
			
		mnNewMenu_6.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_7 = new JMenu(" Registros");
		mnNewMenu_7.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Registros de Usuarios");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegUsuarios usuarios= new RegUsuarios();
				usuarios.setModal(true);
				usuarios.setVisible(true);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_4);
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
		lblNewLabel_1.setBounds(671, 28, 553, 69); 
		panel.add(lblNewLabel_1);  
		
		JLabel lblNewLabel_2 = new JLabel("Campus Santiago");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(1034, 147, 149, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DE LA ESCULA DE CIENCIAS DE INGENIERIA");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Bodoni MT Poster Compressed", Font.PLAIN, 37));
		lblNewLabel_3.setBounds(805, 95, 413, 41);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Se apr\u00F3xima el Evento Cient\u00EDfico PUCMM en el cual estudiantes y exteriores pueden presentar sus proyectos cient\u00EDficos");
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
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\natas\\Desktop\\logo.png"));
		lblNewLabel_11.setBounds(10, 46, 651, 187);
		panel.add(lblNewLabel_11);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
}

/*try {
					sfd = new Socket("127.0.0.1",7000);
					EntradaSocket = new DataInputStream(new BufferedInputStream(sfd.getInputStream()));
					SalidaSocket = new DataOutputStream(new BufferedOutputStream(sfd.getOutputStream()));
					String fichero = new String ("Este es el fichero");
					try {
						SalidaSocket.writeUTF(fichero);
						SalidaSocket.flush();
						
					}catch(IOException ioe)	{
						System.out.println("Error"+ioe);
					}	
				}
				catch (UnknownHostException uhe)
				{
					System.out.println("No se puede acceder al servidor.");
					System.exit(1);
				}
				catch(IOException ioe) {
					System.out.println("Comunicacion rechazada.");
					System.exit(1);
				}
			}
		});
		
		*
		*
		*
		*try {
					final File localFile = new File("pucmm.dat");
					Socket client = new Socket("127.0.0.1",7000);
					bis = new BufferedInputStream(new FileInputStream(localFile));
					bos = new BufferedOutputStream(client.getOutputStream());
					
					DataOutputStream dos = new DataOutputStream(client.getOutputStream());
					dos.writeUTF(localFile.getName());
					
					byteArray = new byte[8192];
					while ((in = bis.read(byteArray))!= -1){
						bos.write(byteArray,0,in);
			
		}
					bis.close();
					bos.close();
					
				}catch(Exception e1) {
					System.err.println(e1);
				}
				
			}
		*
		*/
