package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;

public class InscripcionParticipantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InscripcionParticipantes dialog = new InscripcionParticipantes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	/**
	 * Create the dialog.
	 */
	public InscripcionParticipantes() {
		getContentPane().setEnabled(false);
		setTitle("Inscripci\u00F3n de Participantes");
		setBounds(100, 100, 633, 687);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inscripción para Evento Científico PUCMM:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 620, 605);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombres:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel.setBounds(163, 64, 95, 14);
			panel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(163, 89, 226, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(163, 132, 73, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 159, 226, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ced\u00FAla:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(161, 201, 73, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 226, 226, 20);
		panel.add(textField_2);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDireccin.setBounds(161, 259, 73, 14);
		panel.add(lblDireccin);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTelfono.setBounds(161, 322, 73, 14);
		panel.add(lblTelfono);
		
		JLabel lblCedla = new JLabel("Es estudiante de la Universidad o Visitante?");
		lblCedla.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCedla.setBounds(163, 376, 256, 14);
		panel.add(lblCedla);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Estudiante");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnNewRadioButton.setBounds(173, 415, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Visitante");
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnNewRadioButton_1.setBounds(310, 415, 109, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(163, 284, 226, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(163, 345, 226, 20);
		panel.add(textField_4);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
