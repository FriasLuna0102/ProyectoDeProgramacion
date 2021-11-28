package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Comisiones;
import Logico.Eventos;
import Logico.PUCMM;
import Logico.Recursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;

public class CrearEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private Dimension dim;
	private JTextField txtTituloDelEvento;
	private JTextField txtCodigoDelEvento;
	private JTextField txtCorreoDelEvento;
	private JComboBox cbxTipoDeEventos;
	private JSpinner spnLimiteDeParticipantes;
	private JSpinner spnFechaDeInscripcion;
	private JSpinner spnFechaDeFin;
	private static Eventos updated = null;
	private JTextField txtNombreComision;
	private JTextField txtPucmm;
	private JSpinner spnFechaDeInicio;
	private JRadioButton rdbtnMicrofonos;
	private JRadioButton rdbtnLuces;
	private JRadioButton rdbtnSalones;

	/**   
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearEvento dialog = new CrearEvento(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearEvento(Eventos evento) {
		getContentPane().setBackground(new Color(0, 153, 204));
		updated = evento;
		setModal(true);
		setResizable(false);
		if(updated == null) {
			setTitle("Crear Evento:");
		}else {
			setTitle("Cancelar Evento");
		}

		setResizable(false);
		setBounds(100, 100, 776, 656);
		dim = getToolkit().getScreenSize();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 153, 204));
		contentPanel.setBorder(new TitledBorder(null, "Datos para crear Evento.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 43, 1360, 607);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("T\u00EDtulo de Evento:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(391, 108, 109, 16);
		panel.add(lblNewLabel_4);

		txtTituloDelEvento = new JTextField();
		txtTituloDelEvento.setForeground(new Color(0, 0, 0));
		txtTituloDelEvento.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtTituloDelEvento.setBounds(533, 106, 347, 22);
		panel.add(txtTituloDelEvento);
		txtTituloDelEvento.setColumns(10);

		JLabel lblNewLabel = new JLabel("C\u00F3digo del Evento:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(391, 144, 116, 16);
		panel.add(lblNewLabel);

		txtCodigoDelEvento = new JTextField();
		txtCodigoDelEvento.setForeground(new Color(0, 0, 0));
		txtCodigoDelEvento.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtCodigoDelEvento.setBounds(533, 142, 347, 22);
		panel.add(txtCodigoDelEvento);
		txtCodigoDelEvento.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Fecha de Inicio:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(391, 225, 100, 16);
		panel.add(lblNewLabel_1);

		spnFechaDeFin = new JSpinner();
		Date datee = new Date();
		spnFechaDeFin.setForeground(new Color(0, 0, 0));
		spnFechaDeFin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spnFechaDeFin.setModel(new SpinnerDateModel(new Date(1638021128669L), null, null, Calendar.YEAR));
		JSpinner.DateEditor de= new JSpinner.DateEditor(spnFechaDeFin, "yyyy");
		spnFechaDeFin.setEditor(de);
		spnFechaDeFin.setBounds(771, 223, 109, 22);
		panel.add(spnFechaDeFin);

		
		

		JLabel lblNewLabel_2 = new JLabel("L\u00EDmite de participantes:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(677, 187, 161, 16);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Correo del Evento:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(391, 273, 124, 16);
		panel.add(lblNewLabel_3);

		spnLimiteDeParticipantes = new JSpinner();
		spnLimiteDeParticipantes.setForeground(new Color(0, 0, 0));
		spnLimiteDeParticipantes.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spnLimiteDeParticipantes.setBounds(848, 185, 32, 22);
		panel.add(spnLimiteDeParticipantes);

		txtCorreoDelEvento = new JTextField();
		txtCorreoDelEvento.setForeground(new Color(0, 0, 0));
		txtCorreoDelEvento.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtCorreoDelEvento.setEditable(false);
		txtCorreoDelEvento.setBounds(533, 271, 347, 22);
		panel.add(txtCorreoDelEvento);
		txtCorreoDelEvento.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Tipo de Eventos:");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(391, 319, 109, 16);
		panel.add(lblNewLabel_6);

		cbxTipoDeEventos = new JComboBox();
		cbxTipoDeEventos.setForeground(new Color(0, 0, 0));
		cbxTipoDeEventos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		cbxTipoDeEventos.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Cientifico", "Mesa Redonda", "Conferencia", "Deportivo", "Discurso Motivacional", "VideoJuegos", "Otro..."}));
		cbxTipoDeEventos.setBounds(533, 317, 347, 22);
		panel.add(cbxTipoDeEventos);

		spnFechaDeInicio = new JSpinner();
		Date date = new Date();
		spnFechaDeInicio.setForeground(new Color(0, 0, 0));
		spnFechaDeInicio.setFont(new Font("Times New Roman", Font.BOLD, 14));
		spnFechaDeInicio.setModel(new SpinnerDateModel(new Date(1638021128669L), null, null, Calendar.YEAR));
		JSpinner.DateEditor di = new JSpinner.DateEditor(spnFechaDeInicio, "yyyy");
		spnFechaDeInicio.setEditor(di);
		spnFechaDeInicio.setBounds(533, 223, 109, 22);
		panel.add(spnFechaDeInicio);

		JLabel lblFechaDeFin = new JLabel("Fecha de Fin:");
		lblFechaDeFin.setForeground(new Color(255, 255, 255));
		lblFechaDeFin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFechaDeFin.setBounds(677, 225, 100, 16);
		panel.add(lblFechaDeFin);



		JLabel lblNewLabel_7 = new JLabel("Para crear un evento le invitamos a llenar el siguiente formulario, al terminar s\u00F3lo presione el bot\u00F3n registrar.");
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(301, 34, 785, 14);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Nombre de Comisi\u00F3n:");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_8.setBounds(391, 354, 141, 16);
		panel.add(lblNewLabel_8);

		txtNombreComision = new JTextField();
		txtNombreComision.setForeground(new Color(0, 0, 0));
		txtNombreComision.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtNombreComision.setBounds(533, 351, 347, 22);
		panel.add(txtNombreComision);
		txtNombreComision.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Lugar Del Evento:");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_9.setBounds(391, 383, 116, 16);
		panel.add(lblNewLabel_9);

		txtPucmm = new JTextField();
		txtPucmm.setForeground(new Color(0, 0, 0));
		txtPucmm.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtPucmm.setEditable(false);
		txtPucmm.setText("PUCMM");
		txtPucmm.setBounds(533, 380, 172, 22);
		panel.add(txtPucmm);
		txtPucmm.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Tipo de Recursos a Utilizar:");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_10.setBounds(391, 434, 172, 16);
		panel.add(lblNewLabel_10);

		rdbtnSalones = new JRadioButton("Salones");
		rdbtnSalones.setBackground(new Color(0, 153, 204));
		rdbtnSalones.setForeground(new Color(255, 255, 255));
		rdbtnSalones.setFont(new Font("Times New Roman", Font.BOLD, 14));
		/*rdbtnSalones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSalones.setSelected(true);
				rdbtnLuces.setSelected(false);
				rdbtnMicrofonos.setSelected(false);
			}
		});*/
		rdbtnSalones.setSelected(true);
		rdbtnSalones.setBounds(388, 460, 88, 25);
		panel.add(rdbtnSalones);

		rdbtnLuces = new JRadioButton("Luces");
		rdbtnLuces.setBackground(new Color(0, 153, 204));
		rdbtnLuces.setForeground(new Color(255, 255, 255));
		rdbtnLuces.setFont(new Font("Times New Roman", Font.BOLD, 14));
		/*rdbtnLuces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLuces.setSelected(true);
				rdbtnMicrofonos.setSelected(false);
				rdbtnSalones.setSelected(false);
			}
		});*/
		rdbtnLuces.setBounds(531, 457, 75, 25);
		panel.add(rdbtnLuces);

		rdbtnMicrofonos = new JRadioButton("Micr\u00F3fonos");
		rdbtnMicrofonos.setBackground(new Color(0, 153, 204));
		rdbtnMicrofonos.setForeground(new Color(255, 255, 255));
		rdbtnMicrofonos.setFont(new Font("Times New Roman", Font.BOLD, 14));
		/*rdbtnMicrofonos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMicrofonos.setSelected(true);
				rdbtnLuces.setSelected(false);
				rdbtnSalones.setSelected(false);
			}
		});*/
		rdbtnMicrofonos.setBounds(650, 460, 127, 25);
		panel.add(rdbtnMicrofonos);
		{	if(updated == null) {
			txtCorreoDelEvento.setText("eventopucmm@ce.pucmm.edu.do ");
		}
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(0, 153, 204));
		buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					Date dateAuxx = (Date) spnFechaDeFin.getValue();
					SimpleDateFormat dee = new SimpleDateFormat("yyyy");
					String yearr = dee.format(dateAuxx);
					
					Date dateAuxxx = (Date) spnFechaDeInicio.getValue();
					SimpleDateFormat deee = new SimpleDateFormat("yyyy");
					String yearrr = deee.format(dateAuxxx);
					
					Comisiones comision = PUCMM.getInstance().buscarComisiones(txtNombreComision.getText());
					Recursos recurso = PUCMM.getInstance().buscarRecursos(rdbtnSalones.getText().toString());
					//	String salones = rdbtnSalones.getText().toString();
					Eventos evento = new Eventos(txtTituloDelEvento.getText(), comision,recurso , txtCodigoDelEvento.getText(),txtPucmm.getText() ,Integer.valueOf(yearrr) , txtCorreoDelEvento.getText(),Integer.valueOf(spnLimiteDeParticipantes.getValue().toString()),
							cbxTipoDeEventos.getSelectedItem().toString(),txtNombreComision.getText(),Integer.valueOf(yearr));
					if(evento.getCodigoDeEvento().length() != 0 && evento.getTituloDeEvento().length() != 0 )
					{
						PUCMM.getInstance().insertarEvento(evento);
						JOptionPane.showMessageDialog(null, "El Evento se ha creado sastifactoriamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}else {
						JOptionPane.showMessageDialog(null, "El Evento carece de informacion. Complete todos los campos.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

					}//hacer que si esta registrado correctamente que le de un usuario y una contrase;a la cual se va ir incrementando de uno a uno cuando se vayan registrando ese usuario y contrase;a deben de estar conectados a la pantalla de usuario de los don individuos

				}
			});
			btnRegistrar.setActionCommand("OK");
			buttonPane.add(btnRegistrar);
			getRootPane().setDefaultButton(btnRegistrar);
		}
		{
			JButton btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCerrar.setActionCommand("Cancel");
			buttonPane.add(btnCerrar);
		}
	}
	/*
	private void loadWine (Eventos evento) {
		if(evento != null) {
			txtCodigoDelEvento.setText(evento.getCodigoDeEvento());
			txtTituloDelEvento.setText(evento.getTituloDeEvento());
			Calendar auxDate = Calendar.getInstance();
			auxDate.set(evento.getFechaDeInicio(), 1,1);
			
		}
	}*/
	
	private void clean() {
		txtTituloDelEvento.setText("");
		txtNombreComision.setText("");
		txtCodigoDelEvento.setText("");
		cbxTipoDeEventos.setSelectedItem(0);
		spnFechaDeInicio.setValue(new Date());
		spnFechaDeFin.setValue(new Date());
		spnLimiteDeParticipantes.setValue(Integer.valueOf(0));
	
	}
}

