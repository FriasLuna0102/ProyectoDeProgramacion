package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Eventos;
import Logico.PUCMM;
import Logico.Participantes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoDeParticipantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JPanel panel_1;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private static Object[] rows;
	private static DefaultTableModel model;
	private Participantes selected = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoDeParticipantes dialog = new ListadoDeParticipantes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoDeParticipantes() {
		setResizable(false);
		setBounds(100, 100, 511, 399);
		dim = getToolkit().getScreenSize();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Listado De Participantes:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(0, 0, 1350, 685);
			contentPanel.add(panel);
			panel.setLayout(null);

			panel_1 = new JPanel();
			panel_1.setBounds(0, 56, 1350, 597);
			panel.add(panel_1);
			panel_1.setLayout(null);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 11, 1350, 565);
			panel_1.add(scrollPane);

			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					int aux = table.getSelectedRow();
					if(aux != -1) {
						String participantes = (String) table.getValueAt(aux, 0);
						selected = PUCMM.getInstance().buscarParticipantes(participantes, participantes);
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			String[] headers = {"Nombre","Apellido","Matricula","Edad","Cédula","Teléfono","Lugar Proveniente","Dirrecion","Correo Electronico","Codigo del evento",
					"Genero","Nombre de Trabajos"};			
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);	
			table.setModel(model);
			scrollPane.setViewportView(table);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar\r\n");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			for (int i = 0; i<PUCMM.getInstance().getMisEventos().size(); i++) {
				loadParticipantes(0,  PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento());
			} 
		}

	}
	
	public static void loadParticipantes(int select, String codigoEvento) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		Eventos evento = PUCMM.getInstance().buscarEvento(codigoEvento);
		if(evento != null) {
			for (int i = 0; i < evento.getMisParticipantes().size(); i++) {
				rows[0] = evento.getMisParticipantes().get(i).getNombre();
				rows[1] = evento.getMisParticipantes().get(i).getApellido();
				rows[2] = evento.getMisParticipantes().get(i).getMatricula();
				rows[3] = evento.getMisParticipantes().get(i).getEdadParticipante();
				rows[4] = evento.getMisParticipantes().get(i).getCedula();
				rows[5] = evento.getMisParticipantes().get(i).getDireccion();
				rows[6] = evento.getMisParticipantes().get(i).getInstitucionProveniente();
				rows[7] = evento.getMisParticipantes().get(i).getTelefono();
				rows[8] = evento.getMisParticipantes().get(i).getCorreo();
				rows[9] = evento.getMisParticipantes().get(i).getCodigoDeEvento();
				rows[10] = evento.getMisParticipantes().get(i).getSexo();
				for(int j = 0; j<evento.getMisParticipantes().size(); j++) {
					rows[11] = evento.getMisParticipantes().get(j).getMisTrabajos().get(i).getNombre();
				}				
				model.addRow(rows);		     

			}
			
		}

	}


}


