package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import com.sun.javafx.event.EventQueue;

import java.awt.Color;

public class UsuarioParticipantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JTextField txtUsuario;
	private JPasswordField psContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UsuarioParticipantes dialog = new UsuarioParticipantes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 
	 * Create the dialog.
	 */
	public UsuarioParticipantes() {
		setResizable(false);
		setTitle("Bienvenidos Participantes");
		setBounds(100, 100, 450, 424);
		dim = getToolkit().getScreenSize();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 153, 153));
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 0, 1350, 656);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Usuario:");
				lblNewLabel.setForeground(new Color(255, 255, 255));
				lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
				lblNewLabel.setBounds(637, 223, 76, 14);
				panel.add(lblNewLabel);
			}
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(541, 246, 297, 39);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			psContrasena = new JPasswordField();
			psContrasena.setBounds(541, 350, 297, 39);
			panel.add(psContrasena);
			
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			lblNewLabel_1.setBounds(625, 325, 100, 14);
			panel.add(lblNewLabel_1);
			{
				JButton okButton = new JButton("Conectar");
				okButton.setBounds(594, 438, 161, 23);
				panel.add(okButton);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Evento Cient\u00EDfico PUCMM");
				lblNewLabel_2.setForeground(new Color(255, 255, 255));
				lblNewLabel_2.setFont(new Font("Lucida Bright", Font.PLAIN, 43));
				lblNewLabel_2.setBounds(426, 76, 570, 76);
				panel.add(lblNewLabel_2);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBackground(new Color(0, 153, 153));
				panel_1.setBounds(10, 598, 1319, 30);
				panel.add(panel_1);
				{
					JLabel label = new JLabel("\u00A9Todos los derechos reservados");
					label.setForeground(new Color(255, 255, 255));
					label.setFont(new Font("Sylfaen", Font.PLAIN, 10));
					label.setBackground(Color.LIGHT_GRAY);
					label.setBounds(593, 11, 162, 14);
					panel_1.add(label);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
