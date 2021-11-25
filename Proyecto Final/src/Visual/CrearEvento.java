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
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;

public class CrearEvento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JTextField txtTituloDelEvento;
	private JTextField txtCodigoDelEvento;
	private JTextField txtCorreoDelEvento;
	private JComboBox cbxTipoDeEventos;
	private JSpinner spnLimiteDeParticipantes;
	private JSpinner spnFechaDeInscripcion;
	private JSpinner spnFechaDeInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearEvento dialog = new CrearEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearEvento() {
		setTitle("Crear Evento:");
		setResizable(false);
		setBounds(100, 100, 776, 656);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Datos para crear Evento.", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 46, 617, 306);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Titulo de Evento:");
		lblNewLabel_4.setBounds(12, 13, 109, 16);
		panel.add(lblNewLabel_4);
		
		txtTituloDelEvento = new JTextField();
		txtTituloDelEvento.setBounds(5, 35, 116, 22);
		panel.add(txtTituloDelEvento);
		txtTituloDelEvento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo del Evento:");
		lblNewLabel.setBounds(169, 13, 116, 16);
		panel.add(lblNewLabel);
		
		txtCodigoDelEvento = new JTextField();
		txtCodigoDelEvento.setBounds(169, 35, 116, 22);
		panel.add(txtCodigoDelEvento);
		txtCodigoDelEvento.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Inicio:");
		lblNewLabel_1.setBounds(5, 88, 100, 16);
		panel.add(lblNewLabel_1);
		
		spnFechaDeInicio = new JSpinner();
		spnFechaDeInicio.setBounds(5, 127, 100, 22);
		panel.add(spnFechaDeInicio);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de Inscripcion:");
		lblNewLabel_5.setBounds(169, 88, 116, 16);
		panel.add(lblNewLabel_5);
		
		spnFechaDeInscripcion = new JSpinner();
		spnFechaDeInscripcion.setBounds(169, 127, 109, 22);
		panel.add(spnFechaDeInscripcion);
		
		JLabel lblNewLabel_2 = new JLabel("Limite de participantes:");
		lblNewLabel_2.setBounds(5, 177, 158, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo del Evento:");
		lblNewLabel_3.setBounds(229, 177, 124, 16);
		panel.add(lblNewLabel_3);
		
		spnLimiteDeParticipantes = new JSpinner();
		spnLimiteDeParticipantes.setBounds(5, 208, 30, 22);
		panel.add(spnLimiteDeParticipantes);
		
		txtCorreoDelEvento = new JTextField();
		txtCorreoDelEvento.setBounds(229, 206, 116, 22);
		panel.add(txtCorreoDelEvento);
		txtCorreoDelEvento.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo de Eventos:");
		lblNewLabel_6.setBounds(156, 242, 109, 16);
		panel.add(lblNewLabel_6);
		
		cbxTipoDeEventos = new JComboBox();
		cbxTipoDeEventos.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Cientifico", "Mesa Redonda", "Conferencia", "Deportivo", "Discurso Motivacional", "VideoJuegos", "Otro..."}));
		cbxTipoDeEventos.setBounds(156, 271, 129, 22);
		panel.add(cbxTipoDeEventos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
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
}
