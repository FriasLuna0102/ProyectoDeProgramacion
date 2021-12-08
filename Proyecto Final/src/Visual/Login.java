package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.PUCMM;
import Logico.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	private JTextField txtUsuarioe;
	private JButton btnLogin;
	private JPasswordField passwordField;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream pucmm; 
				FileOutputStream pucmm2;
				ObjectInputStream pucmmRead;
				ObjectOutputStream pucmmWrite;
				try {
					pucmm = new FileInputStream("pucmm.dat");
					pucmmRead = new ObjectInputStream(pucmm);
					PUCMM temp = (PUCMM)pucmmRead.readObject();
					PUCMM.setAlma(temp); 
					pucmm.close();
					pucmmRead.close();
										
					
				} catch (FileNotFoundException e) {
					try {
						pucmm2 = new  FileOutputStream("pucmm.dat");
						pucmmWrite = new ObjectOutputStream(pucmm2);
						User aux = new User("Administrador", "Admin", "Admin");
						PUCMM.getInstance().regUser(aux);
						pucmmWrite.writeObject(PUCMM.getInstance());
						pucmm2.close();
						pucmmWrite.close();
					} catch(FileNotFoundException e1) {
					}catch(IOException e1) {
							
						}}catch(IOException e) {
					
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
					
					try {
						Login frame = new Login();
						frame.setVisible(true);
					}catch(Exception e) {
						e.printStackTrace();
					}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 350);
		dim = getToolkit().getScreenSize();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 255));
		panel.setBounds(12, 25, 1338, 663);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(648, 226, 118, 16);
		panel.add(lblNewLabel);
		
		txtUsuarioe = new JTextField();
		txtUsuarioe.setFont(new Font("Times New Roman", Font.BOLD, 11));
		txtUsuarioe.setBounds(595, 253, 181, 22);
		panel.add(txtUsuarioe);
		txtUsuarioe.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(632, 304, 118, 16);
		panel.add(lblNewLabel_1);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(PUCMM.getInstance().confirmarLogin(txtUsuarioe.getText(), passwordField.getText())) {
					PlantillaPrincipal frame = new PlantillaPrincipal();
					dispose();
					frame.setVisible(true);
					
				}	
			} 
		});
		btnLogin.setBounds(632, 383, 97, 25);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(595, 335, 181, 22);
		panel.add(passwordField);
	}
} 
