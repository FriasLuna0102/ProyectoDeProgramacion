package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.PUCMM;
import Logico.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class RegUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JTextField txtNombreUsuario;
	private JTextField txtContraseña;
	private JTextField txtConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegUsuarios dialog = new RegUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  

	/**
	 * Create the dialog.
	 */
	public RegUsuarios() {
		getContentPane().setBackground(new Color(0, 153, 204));
		setTitle("Registro de Usuarios");
		setResizable(false);
		setBounds(100, 100, 538, 405);
		dim = getToolkit().getScreenSize();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 153, 204));
		contentPanel.setBorder(new TitledBorder(null, "Registro de Usuarios ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(10, 21, 1338, 634);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(603, 225, 131, 16);
		panel.add(lblNewLabel);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(541, 252, 256, 22);
		panel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(611, 299, 116, 16);
		panel.add(lblNewLabel_1);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(541, 326, 256, 22);
		panel.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de Usuario:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(618, 443, 116, 16);
		panel.add(lblNewLabel_2);
		
		txtConfirmar = new JTextField();
		txtConfirmar.setBounds(541, 397, 256, 22);
		panel.add(txtConfirmar);
		txtConfirmar.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirmar Contrase\u00F1a:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(592, 359, 153, 16);
		panel.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox(); 
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "Administrador", "Participante", "Jurado"}));
		comboBox.setBounds(541, 470, 256, 22);
		panel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setBackground(new Color(0, 153, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrarme");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user = new User(comboBox.getSelectedItem().toString(), txtNombreUsuario.getText(),txtContraseña.getText());
						PUCMM.getInstance().regUser(user);
						JOptionPane.showMessageDialog(null, "Usuario: "+txtNombreUsuario.getText()+" se ha registrado con exito.");
						clean();
					}
				}); 
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void clean() {
		txtNombreUsuario.setText("");
		txtContraseña.setText("");
		txtConfirmar.setText("");
		
	
	}
}
