package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.PUCMM;
import Logico.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreUsuario;
	private JTextField txtContraseña;
	private JTextField textField_1;

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
		setResizable(false);
		setBounds(100, 100, 538, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Registro de Usuarios ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 67, 477, 243);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Usuario:");
		lblNewLabel.setBounds(12, 13, 131, 16);
		panel.add(lblNewLabel);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(12, 44, 116, 22);
		panel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(12, 79, 116, 16);
		panel.add(lblNewLabel_1);
		
		txtContraseña = new JTextField();
		txtContraseña.setBounds(12, 118, 116, 22);
		panel.add(txtContraseña);
		txtContraseña.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de Usuario:");
		lblNewLabel_2.setBounds(223, 13, 116, 16);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 189, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirmar Contrase\u00F1a:");
		lblNewLabel_3.setBounds(12, 156, 153, 16);
		panel.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "Administrador", "Participante"}));
		comboBox.setBounds(223, 44, 179, 22);
		panel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrarme");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						User user = new User(comboBox.getSelectedItem().toString(), txtNombreUsuario.getText(),txtContraseña.getText());
						PUCMM.getInstance().regUser(user);
					}
				}); 
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
