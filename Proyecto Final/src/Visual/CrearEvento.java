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

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		panel.setBounds(10, 64, 1360, 643);
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
		
		JSpinner spnFechaFInal = new JSpinner();
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
						if(updated == null) {
							//Eventos aux = new Eventos(null,null,txtCodigoDelEvento.getText(),txtCorreoDelEvento.getText(),txtTituloDelEvento.getText(),Integer.valueOf(spnFechaFInal.getValue().toString()),Integer.valueOf(spnFechaDeInicio.getValue().toString()),Integer.valueOf(spnFechaDeInscripcion.getValue().toString()),Integer.valueOf(spnLimiteDeParticipantes.getValue().toString()) );
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCerrar = new JButton("Cerrar");
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}

