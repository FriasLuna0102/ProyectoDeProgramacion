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
import Logico.Jurado;
import Logico.PUCMM;
import Logico.Participantes;
import Logico.Personas;
import Logico.Trabajos;

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
import javax.swing.DefaultComboBoxModel;

public class IncripcionJurados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JPanel PanelGenero;
	private JButton btnRegistar;
	private JTextField txtCorreo;
	private JLabel lblNewLabel_5;
	
	private JTextField txtAreadeConocimiento;
	private JLabel lblNewLabel_6;
	private JTextField txtCodigoDeJurados;
	private JLabel lblNewLabel_8;
	
	private JTextField txtSexo;
	
	private JSpinner spnEdadDeJurado;
	private JLabel lblNewLabel_9;
	private JTextField txtCodigoDelEvento;
	private int i = 1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel label_2;
	private static String codeTrabaj;
	private JComboBox cbxGenero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IncripcionJurados dialog = new IncripcionJurados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	/**
	 * Create the dialog.
	 */
	public IncripcionJurados() {
		getContentPane().setBackground(new Color(0, 51, 255));
		setResizable(false);
		getContentPane().setEnabled(false);
		dim = getToolkit().getScreenSize();
		setTitle("Inscripci\u00F3n de Jurados");
		setBounds(100, 100, 822, 777);
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 255));
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 255));
		panel.setBorder(new TitledBorder(null, "Inscripción de Jurados para Evento Científico PUCMM:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 1330, 370);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombres:");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
			lblNewLabel.setBounds(469, 48, 73, 14);
			panel.add(lblNewLabel);
		}

		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 0, 0));
		txtNombre.setFont(new Font("Dialog", Font.BOLD, 12));
		txtNombre.setBounds(469, 74, 226, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Apellidos:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(469, 96, 73, 14);
		panel.add(lblNewLabel_1);

		txtApellido = new JTextField();
		txtApellido.setForeground(new Color(0, 0, 0));
		txtApellido.setFont(new Font("Dialog", Font.BOLD, 12));
		txtApellido.setColumns(10);
		txtApellido.setBounds(469, 121, 226, 20);
		panel.add(txtApellido);

		JLabel lblNewLabel_2 = new JLabel("Ced\u00FAla:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(469, 144, 73, 14);
		panel.add(lblNewLabel_2);

		txtCedula = new JTextField();
		txtCedula.setForeground(new Color(0, 0, 0));
		txtCedula.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCedula.setColumns(10);
		txtCedula.setBounds(469, 169, 226, 20);
		panel.add(txtCedula);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setForeground(new Color(255, 255, 255));
		lblTelfono.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTelfono.setBounds(469, 200, 73, 14);
		panel.add(lblTelfono);

		txtTelefono = new JTextField();
		txtTelefono.setForeground(new Color(0, 0, 0));
		txtTelefono.setFont(new Font("Dialog", Font.BOLD, 12));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(469, 217, 226, 20);
		panel.add(txtTelefono);

		JLabel lblNewLabel_3 = new JLabel("Correo:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(469, 250, 73, 14);
		panel.add(lblNewLabel_3);

		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCorreo.setForeground(new Color(0, 0, 0));
		txtCorreo.setBounds(469, 269, 226, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);

		

		lblNewLabel_5 = new JLabel("Area de Conocimiento:");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(729, 47, 156, 16);
		panel.add(lblNewLabel_5);

		txtAreadeConocimiento = new JTextField();
		txtAreadeConocimiento.setForeground(new Color(0, 0, 0));
		txtAreadeConocimiento.setFont(new Font("Dialog", Font.BOLD, 12));
		txtAreadeConocimiento.setBounds(729, 74, 137, 20);
		panel.add(txtAreadeConocimiento);
		txtAreadeConocimiento.setColumns(10);

		lblNewLabel_6 = new JLabel("C\u00F3digo del Jurado:");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(184, 47, 137, 16);
		panel.add(lblNewLabel_6);

		txtCodigoDeJurados = new JTextField();
		txtCodigoDeJurados.setForeground(new Color(0, 0, 0));
		txtCodigoDeJurados.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCodigoDeJurados.setEditable(false);
		txtCodigoDeJurados.setBounds(184, 74, 137, 20);
		txtCodigoDeJurados.setText("J-"+PUCMM.getInstance().getGeneradoCodigoJurado());
		panel.add(txtCodigoDeJurados);
		txtCodigoDeJurados.setColumns(10);

		
		
		lblNewLabel_8 = new JLabel("Edad del Jurado:");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_8.setBounds(729, 95, 133, 16);
		panel.add(lblNewLabel_8);
		
		spnEdadDeJurado = new JSpinner();
		spnEdadDeJurado.setForeground(new Color(0, 0, 0));
		spnEdadDeJurado.setFont(new Font("Dialog", Font.BOLD, 12));
		spnEdadDeJurado.setBounds(729, 121, 137, 20);
		panel.add(spnEdadDeJurado);
		
		lblNewLabel_9 = new JLabel("C\u00F3digo del Evento:");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_9.setBounds(729, 143, 137, 16);
		panel.add(lblNewLabel_9);
		
		txtCodigoDelEvento = new JTextField();
		txtCodigoDelEvento.setForeground(new Color(0, 0, 0));
		txtCodigoDelEvento.setFont(new Font("Dialog", Font.BOLD, 12));
		txtCodigoDelEvento.setBounds(729, 169, 137, 20);
		panel.add(txtCodigoDelEvento);
		txtCodigoDelEvento.setColumns(10);
		
				
				panel_1 = new JPanel();
				panel_1.setBackground(new Color(0, 51, 255));
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 390, 1330, 250);
				contentPanel.add(panel_1);
				panel_1.setLayout(null);
				
						PanelGenero = new JPanel();
						PanelGenero.setBackground(new Color(0, 51, 255));
						PanelGenero.setBounds(20, 11, 1310, 193);
						panel_1.add(PanelGenero);
						PanelGenero.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						PanelGenero.setLayout(null);
						
								JLabel label_1 = new JLabel("G\u00E9nero:");
								label_1.setForeground(new Color(255, 255, 255));
								label_1.setFont(new Font("Dialog", Font.BOLD, 12));
								label_1.setBounds(639, 15, 257, 14);
								PanelGenero.add(label_1);
								
								cbxGenero = new JComboBox();
								cbxGenero.setModel(new DefaultComboBoxModel(new String[] {"<<Selecciones>>", "Hombre", "Mujer", "Otro"}));
								cbxGenero.setBounds(541, 40, 243, 22);
								PanelGenero.add(cbxGenero);
																								
																																		
																										
																															
																														
																														
																														
																														panel_2 = new JPanel();
																														panel_2.setLayout(null);
																														panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
																														panel_2.setBackground(new Color(0, 51, 255));
																														panel_2.setBounds(-51, 215, 1371, 30);
																														panel_1.add(panel_2);
																														
																														label_2 = new JLabel("\u00A9Todos los derechos reservados");
																														label_2.setBackground(Color.LIGHT_GRAY);
																														label_2.setForeground(new Color(255, 255, 255));
																														label_2.setFont(new Font("Dialog", Font.BOLD, 12));
																														label_2.setBounds(655, 11, 216, 14);
																														panel_2.add(label_2);
		{
			JPanel buttonPane = new JPanel(); 
			buttonPane.setBackground(new Color(0, 51, 255));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistar = new JButton("Registrar");
				btnRegistar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
								  
								Jurado jurado = new Jurado(txtNombre.getText(), txtAreadeConocimiento.getText(), txtCedula.getText(), txtApellido.getText(), txtTelefono.getText(), txtCorreo.getText(), null,Integer.valueOf(spnEdadDeJurado.getValue().toString()),txtCodigoDelEvento.getText(),cbxGenero.getSelectedItem().toString());
								Eventos evento = PUCMM.getInstance().buscarEvento(txtCodigoDelEvento.getText());
								
								if(evento != null && Integer.valueOf(spnEdadDeJurado.getValue().toString()) >= 25 && Integer.valueOf(spnEdadDeJurado.getValue().toString()) <= 60) {
									//evento.getMisJurados().add(jurado);
									PUCMM.getInstance().addJurado(txtCodigoDelEvento.getText(),jurado);
									
									
									JOptionPane.showMessageDialog(null, "Registro Satifactorio", "Informacion", JOptionPane.INFORMATION_MESSAGE);
									clean();
								}else if(Integer.valueOf(spnEdadDeJurado.getValue().toString()) < 25 || Integer.valueOf(spnEdadDeJurado.getValue().toString()) > 60 ) {	
									JOptionPane.showMessageDialog(null, "Su edad no cumple los requisitos. Debes ser mayor de 25 y menor de 60.");			
								}else {
									JOptionPane.showMessageDialog(null, "Es posible que este evento con codigo: "+ txtCodigoDelEvento.getText()+ " no exista, O intenta llenar todos los campos"
											+ " de manera correspondiente.");
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
		txtTelefono.setText("");
		
		txtCedula.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtAreadeConocimiento.setText("");
		txtCodigoDeJurados.setText("J-"+PUCMM.getInstance().getGeneradoCodigoJurado());
		spnEdadDeJurado.setValue(Integer.valueOf(0));
		txtCodigoDelEvento.setText("");
		cbxGenero.setSelectedIndex(0);
	}
	

}

