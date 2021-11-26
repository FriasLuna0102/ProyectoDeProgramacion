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
	private JSpinner spnFechaDeInicio;
	private static Eventos updated = null;
	private JTextField txtNombreComision;
	private JTextField txtPucmm;
	private JSpinner spnFechaFInal;
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
		contentPanel.setBorder(new TitledBorder(null, "Datos para crear Evento.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 64, 1360, 676);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Titulo de Evento:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(396, 196, 109, 16);
		panel.add(lblNewLabel_4);

		txtTituloDelEvento = new JTextField();
		txtTituloDelEvento.setBounds(538, 194, 347, 22);
		panel.add(txtTituloDelEvento);
		txtTituloDelEvento.setColumns(10);

		JLabel lblNewLabel = new JLabel("Codigo del Evento:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(396, 232, 116, 16);
		panel.add(lblNewLabel);

		txtCodigoDelEvento = new JTextField();
		txtCodigoDelEvento.setBounds(538, 230, 347, 22);
		panel.add(txtCodigoDelEvento);
		txtCodigoDelEvento.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Fecha de Inicio:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(396, 313, 100, 16);
		panel.add(lblNewLabel_1);

		spnFechaDeInicio = new JSpinner();
		spnFechaDeInicio.setBounds(776, 311, 109, 22);
		panel.add(spnFechaDeInicio);

		JLabel lblNewLabel_5 = new JLabel("Fecha de Inscripcion:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(396, 275, 141, 16);
		panel.add(lblNewLabel_5);

		spnFechaDeInscripcion = new JSpinner();
		spnFechaDeInscripcion.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(0)));
		spnFechaDeInscripcion.setBounds(538, 273, 109, 22);
		panel.add(spnFechaDeInscripcion);

		JLabel lblNewLabel_2 = new JLabel("Limite de participantes:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(682, 275, 161, 16);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Correo del Evento:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(396, 361, 124, 16);
		panel.add(lblNewLabel_3);

		spnLimiteDeParticipantes = new JSpinner();
		spnLimiteDeParticipantes.setBounds(855, 273, 30, 22);
		panel.add(spnLimiteDeParticipantes);

		txtCorreoDelEvento = new JTextField();
		txtCorreoDelEvento.setEditable(false);
		txtCorreoDelEvento.setBounds(538, 359, 347, 22);
		panel.add(txtCorreoDelEvento);
		txtCorreoDelEvento.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Tipo de Eventos:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(396, 407, 109, 16);
		panel.add(lblNewLabel_6);

		cbxTipoDeEventos = new JComboBox();
		cbxTipoDeEventos.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Cientifico", "Mesa Redonda", "Conferencia", "Deportivo", "Discurso Motivacional", "VideoJuegos", "Otro..."}));
		cbxTipoDeEventos.setBounds(538, 405, 253, 22);
		panel.add(cbxTipoDeEventos);

		spnFechaFInal = new JSpinner();

		spnFechaFInal.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(0)));
		spnFechaFInal.setBounds(538, 311, 109, 22);
		panel.add(spnFechaFInal);

		JLabel lblFechaDeFin = new JLabel("Fecha de Fin:");
		lblFechaDeFin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFechaDeFin.setBounds(682, 313, 100, 16);
		panel.add(lblFechaDeFin);



		JLabel lblNewLabel_7 = new JLabel("Para crear un evento le invitamos a llenar el siguiente formulario, al terminar s\u00F3lo presione el bot\u00F3n registrar.");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(312, 122, 689, 14);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Nombre de Comision:");
		lblNewLabel_8.setBounds(396, 442, 124, 16);
		panel.add(lblNewLabel_8);

		txtNombreComision = new JTextField();
		txtNombreComision.setBounds(538, 439, 347, 22);
		panel.add(txtNombreComision);
		txtNombreComision.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Lugar Del Evento:");
		lblNewLabel_9.setBounds(396, 471, 116, 16);
		panel.add(lblNewLabel_9);

		txtPucmm = new JTextField();
		txtPucmm.setEditable(false);
		txtPucmm.setText("PUCMM");
		txtPucmm.setBounds(538, 468, 172, 22);
		panel.add(txtPucmm);
		txtPucmm.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Tipo de Recursos a Utilizar:");
		lblNewLabel_10.setBounds(396, 522, 172, 16);
		panel.add(lblNewLabel_10);

		rdbtnSalones = new JRadioButton("Salones");
		rdbtnSalones.setBounds(393, 548, 127, 25);
		panel.add(rdbtnSalones);

		rdbtnLuces = new JRadioButton("Luces");
		rdbtnLuces.setBounds(396, 582, 127, 25);
		panel.add(rdbtnLuces);

		rdbtnMicrofonos = new JRadioButton("Microfonos");
		rdbtnMicrofonos.setBounds(396, 615, 127, 25);
		panel.add(rdbtnMicrofonos);
		{	if(updated == null) {
			txtCorreoDelEvento.setText("eventopucmm@ce.pucmm.edu.do ");
		}
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Comisiones comision = PUCMM.getInstance().buscarComisiones(txtNombreComision.getText());
					Recursos recurso = PUCMM.getInstance().buscarRecursos(rdbtnSalones.getText().toString());
					//	String salones = rdbtnSalones.getText().toString();
					Eventos evento = new Eventos(txtTituloDelEvento.getText(), comision,recurso , txtCodigoDelEvento.getText(),txtPucmm.getText() , Integer.valueOf(spnFechaDeInicio.getValue().toString()), txtCorreoDelEvento.getText(),Integer.valueOf(spnLimiteDeParticipantes.getValue().toString()),
							cbxTipoDeEventos.getSelectedItem().toString(),txtNombreComision.getText());
					if(evento.getCodigoDeEvento().length() != 0 && evento.getTituloDeEvento().length() != 0 )
					{
						PUCMM.getInstance().getMisEventos().add(evento);
						JOptionPane.showMessageDialog(null, "El Evento se ha creado sastifactoriamente.", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}else {
						JOptionPane.showMessageDialog(null, "El Evento carece de informacion. Complete todos los campos.", "Informacion", JOptionPane.INFORMATION_MESSAGE);

					}

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
		spnFechaDeInicio.setValue(Integer.valueOf(0));
		spnFechaDeInscripcion.setValue(Integer.valueOf(0));
		spnLimiteDeParticipantes.setValue(Integer.valueOf(0));

	}
}

