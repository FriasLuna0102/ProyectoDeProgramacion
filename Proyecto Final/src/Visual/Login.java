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

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuarioe;
	private JTextField txtContrasenaa;
	private JButton btnLogin;
 
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 25, 507, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario:\r\n");
		lblNewLabel.setBounds(12, 45, 56, 16);
		panel.add(lblNewLabel);
		
		txtUsuarioe = new JTextField();
		txtUsuarioe.setBounds(0, 74, 116, 22);
		panel.add(txtUsuarioe);
		txtUsuarioe.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(12, 130, 56, 16);
		panel.add(lblNewLabel_1);
		
		txtContrasenaa = new JTextField();
		txtContrasenaa.setBounds(12, 166, 116, 22);
		panel.add(txtContrasenaa);
		txtContrasenaa.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PUCMM.getInstance().confirmarLogin(txtUsuarioe.getText(), txtContrasenaa.getText())) {
					PlantillaPrincipal frame = new PlantillaPrincipal();
					dispose();
					frame.setVisible(true);
				}	
			}
		});
		btnLogin.setBounds(181, 192, 97, 25);
		panel.add(btnLogin);
	}
}
