package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Eventos;
import Logico.PUCMM;
import Logico.Participantes;
import Logico.Personas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Color;

public class InscripcionParticipantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
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
	private JButton btnRegistar;
	private JTextField txtCorreo;
	private JLabel lblNewLabel_4;
	private JTextField txtMatricula;
	private JLabel lblNewLabel_5;
	private JTextField txtLugarProveniente;
	private JLabel lblNewLabel_6;
	private JTextField txtCodigoDeParticipante;
	private JLabel lblNewLabel_7;
	private JTextField txtNombreDeTrabajo;
	private JLabel lblNewLabel_8;
	private JSpinner spnEdadDeParticipantes;
	private JLabel lblNewLabel_9;
	private JTextField txtCodigoDelEvento;
	private int i = 1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel label_2;

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
		dim = getToolkit().getScreenSize();
		setTitle("Inscripci\u00F3n de Participantes");
		setBounds(100, 100, 822, 777);
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Inscripción para Evento Científico PUCMM:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 1330, 370);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombres:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel.setBounds(469, 48, 73, 14);
			panel.add(lblNewLabel);
		}

		txtNombre = new JTextField();
		txtNombre.setBounds(469, 74, 226, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(469, 96, 73, 14);
		panel.add(lblNewLabel_1);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(469, 121, 226, 20);
		panel.add(txtApellido);

		JLabel lblNewLabel_2 = new JLabel("Ced\u00FAla:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(469, 144, 73, 14);
		panel.add(lblNewLabel_2);

		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(469, 169, 226, 20);
		panel.add(txtCedula);

		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDireccin.setBounds(469, 240, 73, 14);
		panel.add(lblDireccin);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTelfono.setBounds(469, 200, 73, 14);
		panel.add(lblTelfono);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(469, 217, 226, 20);
		panel.add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(469, 265, 226, 20);
		panel.add(txtTelefono);

		JLabel lblNewLabel_3 = new JLabel("Correo:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(469, 288, 73, 14);
		panel.add(lblNewLabel_3);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(469, 313, 226, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);

		lblNewLabel_4 = new JLabel("Matr\u00EDcula:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(734, 47, 73, 16);
		panel.add(lblNewLabel_4);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(734, 73, 137, 20);
		panel.add(txtMatricula);
		txtMatricula.setColumns(10);

		lblNewLabel_5 = new JLabel("Lugar Proveniente:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(734, 95, 116, 16);
		panel.add(lblNewLabel_5);

		txtLugarProveniente = new JTextField();
		txtLugarProveniente.setBounds(734, 120, 137, 20);
		panel.add(txtLugarProveniente);
		txtLugarProveniente.setColumns(10);

		lblNewLabel_6 = new JLabel("C\u00F3digo de Participante:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(734, 287, 144, 16);
		panel.add(lblNewLabel_6);

		txtCodigoDeParticipante = new JTextField();
		txtCodigoDeParticipante.setEditable(false);
		txtCodigoDeParticipante.setBounds(734, 313, 137, 20);
		txtCodigoDeParticipante.setText("P-"+PUCMM.getInstance().getGeneradorCodigoVino());//incrementar el codigo de participante
		panel.add(txtCodigoDeParticipante);
		txtCodigoDeParticipante.setColumns(10);

		txtNombreDeTrabajo = new JTextField();
		txtNombreDeTrabajo.setBounds(734, 217, 137, 20);
		panel.add(txtNombreDeTrabajo);
		txtNombreDeTrabajo.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Edad del Participante:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(734, 143, 133, 16);
		panel.add(lblNewLabel_8);
		
		spnEdadDeParticipantes = new JSpinner();
		spnEdadDeParticipantes.setBounds(734, 171, 137, 20);
		panel.add(spnEdadDeParticipantes);
		
		lblNewLabel_9 = new JLabel("C\u00F3digo del Evento:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(734, 239, 133, 16);
		panel.add(lblNewLabel_9);
		
		txtCodigoDelEvento = new JTextField();
		txtCodigoDelEvento.setBounds(734, 265, 137, 20);
		panel.add(txtCodigoDelEvento);
		txtCodigoDelEvento.setColumns(10);
		
				lblNewLabel_7 = new JLabel("Nombre de Trabajo:");
				lblNewLabel_7.setBounds(734, 199, 135, 16);
				panel.add(lblNewLabel_7);
				lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				
				panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 390, 1330, 250);
				contentPanel.add(panel_1);
				panel_1.setLayout(null);
				
						PanelGenero = new JPanel();
						PanelGenero.setBounds(20, 105, 1310, 99);
						panel_1.add(PanelGenero);
						PanelGenero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						PanelGenero.setLayout(null);
						
								JLabel label_1 = new JLabel("G\u00E9nero:");
								label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
								label_1.setBounds(517, 11, 256, 14);
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
										rdbtnMujer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
										rdbtnMujer.setBounds(517, 55, 66, 23);
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
												rdbtnHombre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
												rdbtnHombre.setBounds(623, 55, 94, 23);
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
														rdbtnOtro.setFont(new Font("Times New Roman", Font.PLAIN, 14));
														rdbtnOtro.setBounds(733, 55, 66, 23);
														PanelGenero.add(rdbtnOtro);
																						
																								PanelParticipantes = new JPanel();
																								PanelParticipantes.setBounds(10, 11, 1310, 83);
																								panel_1.add(PanelParticipantes);
																								PanelParticipantes.setLayout(null);
																								PanelParticipantes.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																								
																										JLabel label = new JLabel("Es estudiante de la Universidad o Visitante?");
																										label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
																										label.setBounds(512, 11, 282, 14);
																										PanelParticipantes.add(label);
																										
																												rdbtnEstudiante = new JRadioButton("Estudiante");
																												rdbtnEstudiante.addActionListener(new ActionListener() {
																													public void actionPerformed(ActionEvent e) {
																														PanelParticipantes.setVisible(true);
																														rdbtnVisitante.setSelected(false);
																														txtMatricula.setEnabled(true);

																													}
																												});
																												rdbtnEstudiante.setSelected(true);
																												rdbtnEstudiante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
																												rdbtnEstudiante.setBounds(512, 53, 101, 23);
																												PanelParticipantes.add(rdbtnEstudiante);
																												
																														rdbtnVisitante = new JRadioButton("Visitante");
																														rdbtnVisitante.addActionListener(new ActionListener() {
																															public void actionPerformed(ActionEvent e) {
																																PanelParticipantes.setVisible(true);
																																rdbtnEstudiante.setSelected(false);
																																txtMatricula.setEnabled(false);
																															}
																														});
																														rdbtnVisitante.setFont(new Font("Times New Roman", Font.PLAIN, 14));
																														rdbtnVisitante.setBounds(709, 53, 85, 23);
																														PanelParticipantes.add(rdbtnVisitante);
																														
																														panel_2 = new JPanel();
																														panel_2.setLayout(null);
																														panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																														panel_2.setBackground(Color.LIGHT_GRAY);
																														panel_2.setBounds(-51, 215, 1371, 30);
																														panel_1.add(panel_2);
																														
																														label_2 = new JLabel("\u00A9Todos los derechos reservados");
																														label_2.setBackground(Color.LIGHT_GRAY);
																														label_2.setForeground(Color.BLACK);
																														label_2.setFont(new Font("Sylfaen", Font.PLAIN, 10));
																														label_2.setBounds(655, 11, 162, 14);
																														panel_2.add(label_2);
		{
			JPanel buttonPane = new JPanel(); 
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistar = new JButton("Registrar");
				btnRegistar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							Participantes participantes = null;
							
								participantes = new Participantes(txtNombre.getText(), txtDireccion.getText(), txtCedula.getText(), txtApellido.getText(), txtTelefono.getText(), txtCorreo.getText(), txtMatricula.getText(),txtLugarProveniente.getText(),										
										txtCodigoDeParticipante.getText(),txtNombreDeTrabajo.getText(), null,Integer.valueOf(spnEdadDeParticipantes.getValue().toString()),txtCodigoDelEvento.getText());
								Eventos evento = PUCMM.getInstance().buscarEvento(txtCodigoDelEvento.getText());
								if(evento != null) {
									PUCMM.getInstance().addParticipante(txtCedula.getText(),participantes);
									JOptionPane.showMessageDialog(null, "Registro Satifactorio", "Informacion", JOptionPane.INFORMATION_MESSAGE);
									i++;
									clean();
								}else {									
									JOptionPane.showMessageDialog(null, "Este evento con codigo: "+ txtCodigoDelEvento.getText()+ " no existe. No puedes registrarte.");
									clean();

								}
																								
					}
				});
				btnRegistar.setActionCommand("OK");
				buttonPane.add(btnRegistar);
				getRootPane().setDefaultButton(btnRegistar);
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

	private void clean() {
		txtNombre.setText("");
		txtDireccion.setText("");
		txtMatricula.setText("");
		txtCedula.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtLugarProveniente.setText("");
		txtNombreDeTrabajo.setText("");
		spnEdadDeParticipantes.setValue(Integer.valueOf(0));
		txtCodigoDelEvento.setText("");
	}
}
