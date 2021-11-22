package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Participantes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InscripcionParticipantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JRadioButton rdbtnEstudiante;
	private JRadioButton rdbtnVisitante;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnOtro;
	private JPanel PanelParticipantes;
	private JPanel PanelGenero;

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
		panel.setBorder(new TitledBorder(null, "Inscripci�n para Evento Cient�fico PUCMM:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 620, 605);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombres:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			lblNewLabel.setBounds(163, 64, 95, 14);
			panel.add(lblNewLabel);
		}
		
		txtNombre = new JTextField();
		txtNombre.setBounds(163, 89, 226, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(163, 132, 73, 14);
		panel.add(lblNewLabel_1);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(163, 159, 226, 20);
		panel.add(txtApellido);
		
		JLabel lblNewLabel_2 = new JLabel("Ced\u00FAla:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(161, 201, 73, 14);
		panel.add(lblNewLabel_2);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(163, 226, 226, 20);
		panel.add(txtCedula);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDireccin.setBounds(161, 259, 73, 14);
		panel.add(lblDireccin);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTelfono.setBounds(161, 322, 73, 14);
		panel.add(lblTelfono);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(163, 284, 226, 20);
		panel.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(163, 345, 226, 20);
		panel.add(txtTelefono);
		
		PanelParticipantes = new JPanel();
		PanelParticipantes.setBounds(10, 374, 600, 83);
		panel.add(PanelParticipantes);
		PanelParticipantes.setLayout(null);
		PanelParticipantes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel label = new JLabel("Es estudiante de la Universidad o Visitante?");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label.setBounds(153, 11, 210, 14);
		PanelParticipantes.add(label);
		
		rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelParticipantes.setVisible(true);
				rdbtnVisitante.setSelected(false);
				
			}
		});
		rdbtnEstudiante.setSelected(true);
		rdbtnEstudiante.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnEstudiante.setBounds(163, 42, 77, 23);
		PanelParticipantes.add(rdbtnEstudiante);
		
		rdbtnVisitante = new JRadioButton("Visitante");
		rdbtnVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelParticipantes.setVisible(true);
				rdbtnEstudiante.setSelected(false);
			}
		});
		rdbtnVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnVisitante.setBounds(294, 42, 69, 23);
		PanelParticipantes.add(rdbtnVisitante);
		
		PanelGenero = new JPanel();
		PanelGenero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PanelGenero.setBounds(10, 462, 600, 114);
		panel.add(PanelGenero);
		PanelGenero.setLayout(null);
		
		JLabel label_1 = new JLabel("G\u00E9nero:");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		label_1.setBounds(157, 0, 256, 14);
		PanelGenero.add(label_1);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelGenero.setVisible(true);
				rdbtnMujer.setSelected(true);
				rdbtnHombre.setSelected(false);
				rdbtnOtro.setSelected(false);
				
			}
		});
		rdbtnMujer.setSelected(true);
		rdbtnMujer.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnMujer.setBounds(161, 32, 66, 23);
		PanelGenero.add(rdbtnMujer);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelGenero.setVisible(true);
				rdbtnMujer.setSelected(false);
				rdbtnHombre.setSelected(true);
				rdbtnOtro.setSelected(false);
				
			}
		});
		rdbtnHombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnHombre.setBounds(249, 34, 94, 23);
		PanelGenero.add(rdbtnHombre);
		
		rdbtnOtro = new JRadioButton("Otro");
		rdbtnOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelGenero.setVisible(true);
				rdbtnMujer.setSelected(false);
				rdbtnHombre.setSelected(false);
				rdbtnOtro.setSelected(true);
			}
		});
		rdbtnOtro.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnOtro.setBounds(347, 32, 66, 23);
		PanelGenero.add(rdbtnOtro);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
}
