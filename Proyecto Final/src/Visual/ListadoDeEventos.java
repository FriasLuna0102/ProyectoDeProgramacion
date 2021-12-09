package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

import Logico.Eventos;
import Logico.PUCMM;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class ListadoDeEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JTable table;
	private Eventos selected = null;
	private static Object[] rows;
	private static DefaultTableModel model;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JComboBox cbxTipodeEventos;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListadoDeEventos dialog = new ListadoDeEventos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoDeEventos() {
		setTitle("Listado de Eventos");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 1136, 612);
		dim = getToolkit().getScreenSize();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);

		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			panel = new JPanel();
			panel.setBackground(new Color(0, 51, 255));
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(0, 0, 1350, 655);
			contentPanel.add(panel);
			panel.setLayout(null);


			lblNewLabel = new JLabel("Filtro:");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
			lblNewLabel.setBounds(624, 24, 101, 16);
			panel.add(lblNewLabel);


			cbxTipodeEventos = new JComboBox();
			cbxTipodeEventos.setBackground(new Color(255, 255, 255));
			cbxTipodeEventos.setForeground(new Color(0, 0, 0));
			cbxTipodeEventos.setFont(new Font("Times New Roman", Font.BOLD, 12));
			cbxTipodeEventos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selection = cbxTipodeEventos.getSelectedIndex();
					loadwines(selection);
				}
			});
			cbxTipodeEventos.setModel(new DefaultComboBoxModel(new String[] {"<<Todos>>", "\t\t\t\t\t\tCientifico", "\t\t\t\t\t\tMesa Redonda", "\t\t\t\t\t\tConferencia", "\t\t\t\t\t\tDeportivo", "\t\t\t\t\t\tDiscurso Motivacional", "\t\t\t\t\t\tVideoJuegos", "\t\t\t\t\t\tOtro..."}));
			cbxTipodeEventos.setBounds(461, 53, 428, 22);
			panel.add(cbxTipodeEventos);



			panel_1 = new JPanel();
			panel_1.setBounds(12, 117, 1328, 527);
			panel.add(panel_1);
			panel_1.setLayout(null);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 1328, 527);
			panel_1.add(scrollPane);


			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					int aux = table.getSelectedRow();
					if(aux != -1) {
						
						String eventos = (String) table.getValueAt(aux, 0);
						selected = PUCMM.getInstance().buscarEvento(eventos);
						
					}					
				}});
			
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			String[] headers = {"Titulo del Evento","Codigo del Evento","Limite de Participantes","Lugar del Evento","Correo del Evento","Tipo de Evento","Fecha de Inicio"};			
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);	
			table.setModel(model);
			scrollPane.setViewportView(table);



		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 51, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCerrar = new JButton("Cerrar");
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
			loadwines(0);
		}
	}
	
	public static void loadwines(int select) {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		switch (select) {
		case 0:
			for (int i = 0; i < PUCMM.getInstance().getMisEventos().size(); i++) {
				rows[0] = PUCMM.getInstance().getMisEventos().get(i).getTituloDeEvento();
				rows[1] = PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento();
				rows[2] = PUCMM.getInstance().getMisEventos().get(i).getLimiteDeParticipantes();
				rows[3] = PUCMM.getInstance().getMisEventos().get(i).getLugarDeEvento();
				rows[4] = PUCMM.getInstance().getMisEventos().get(i).getCorreoDeEvento();
				rows[5] = PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento();
				rows[6] = PUCMM.getInstance().getMisEventos().get(i).getFechaDeInicio();
				



				model.addRow(rows);		
			}
			break;
		case 1:
			for (int i = 0; i < PUCMM.getInstance().getMisEventos().size(); i++) {
				if(PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento().equalsIgnoreCase("Cientifico")) {
					rows[0] = PUCMM.getInstance().getMisEventos().get(i).getTituloDeEvento();
					rows[1] = PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento();
					rows[2] = PUCMM.getInstance().getMisEventos().get(i).getLimiteDeParticipantes();
					rows[3] = PUCMM.getInstance().getMisEventos().get(i).getLugarDeEvento();
					rows[4] = PUCMM.getInstance().getMisEventos().get(i).getCorreoDeEvento();
					rows[5] = PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento();
					rows[6] = PUCMM.getInstance().getMisEventos().get(i).getFechaDeInicio();
					
					model.addRow(rows);	

				}

			}
			break;
		case 2:
			for (int i = 0; i < PUCMM.getInstance().getMisEventos().size(); i++) {
				if(PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento().equalsIgnoreCase("Mesa Redonda")) {
					rows[0] = PUCMM.getInstance().getMisEventos().get(i).getTituloDeEvento();
					rows[1] = PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento();
					rows[2] = PUCMM.getInstance().getMisEventos().get(i).getLimiteDeParticipantes();
					rows[3] = PUCMM.getInstance().getMisEventos().get(i).getLugarDeEvento();
					rows[4] = PUCMM.getInstance().getMisEventos().get(i).getCorreoDeEvento();
					rows[5] = PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento();
					rows[6] = PUCMM.getInstance().getMisEventos().get(i).getFechaDeInicio();
					
					model.addRow(rows);	

				}

			}
			break;
		case 3:
			for (int i = 0; i < PUCMM.getInstance().getMisEventos().size(); i++) {
				if(PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento().equalsIgnoreCase("Conferencia")) {
					rows[0] = PUCMM.getInstance().getMisEventos().get(i).getTituloDeEvento();
					rows[1] = PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento();
					rows[2] = PUCMM.getInstance().getMisEventos().get(i).getLimiteDeParticipantes();
					rows[3] = PUCMM.getInstance().getMisEventos().get(i).getLugarDeEvento();
					rows[4] = PUCMM.getInstance().getMisEventos().get(i).getCorreoDeEvento();
					rows[5] = PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento();
					rows[6] = PUCMM.getInstance().getMisEventos().get(i).getFechaDeInicio();
					model.addRow(rows);	

				}
			}
			break;
		case 4:
			for (int i = 0; i < PUCMM.getInstance().getMisEventos().size(); i++) {
				if(PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento().equalsIgnoreCase("Deportivo")) {
					rows[0] = PUCMM.getInstance().getMisEventos().get(i).getTituloDeEvento();
					rows[1] = PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento();
					rows[2] = PUCMM.getInstance().getMisEventos().get(i).getLimiteDeParticipantes();
					rows[3] = PUCMM.getInstance().getMisEventos().get(i).getLugarDeEvento();
					rows[4] = PUCMM.getInstance().getMisEventos().get(i).getCorreoDeEvento();
					rows[5] = PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento();
					rows[6] = PUCMM.getInstance().getMisEventos().get(i).getFechaDeInicio();
					
					model.addRow(rows);	
				}
			}
			break;
		case 5:
			for (int i = 0; i < PUCMM.getInstance().getMisEventos().size(); i++) {
				if(PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento().equalsIgnoreCase("Discurso Motivacional")) {
					rows[0] = PUCMM.getInstance().getMisEventos().get(i).getTituloDeEvento();
					rows[1] = PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento();
					rows[2] = PUCMM.getInstance().getMisEventos().get(i).getLimiteDeParticipantes();
					rows[3] = PUCMM.getInstance().getMisEventos().get(i).getLugarDeEvento();
					rows[4] = PUCMM.getInstance().getMisEventos().get(i).getCorreoDeEvento();
					rows[5] = PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento();
					rows[6] = PUCMM.getInstance().getMisEventos().get(i).getFechaDeInicio();
					
					model.addRow(rows);	
				}
			}
			break;
		case 6:
			for (int i = 0; i < PUCMM.getInstance().getMisEventos().size(); i++) {
				if(PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento().equalsIgnoreCase("VideoJuegos")) {
					rows[0] = PUCMM.getInstance().getMisEventos().get(i).getTituloDeEvento();
					rows[1] = PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento();
					rows[2] = PUCMM.getInstance().getMisEventos().get(i).getLimiteDeParticipantes();
					rows[3] = PUCMM.getInstance().getMisEventos().get(i).getLugarDeEvento();
					rows[4] = PUCMM.getInstance().getMisEventos().get(i).getCorreoDeEvento();
					rows[5] = PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento();
					rows[6] = PUCMM.getInstance().getMisEventos().get(i).getFechaDeInicio();
					
					model.addRow(rows);	}
			}
			break;
		case 7:
			for (int i = 0; i < PUCMM.getInstance().getMisEventos().size(); i++) {
				if(PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento().equalsIgnoreCase("Otro...")) {
					rows[0] = PUCMM.getInstance().getMisEventos().get(i).getTituloDeEvento();
					rows[1] = PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento();
					rows[2] = PUCMM.getInstance().getMisEventos().get(i).getLimiteDeParticipantes();
					rows[3] = PUCMM.getInstance().getMisEventos().get(i).getLugarDeEvento();
					rows[4] = PUCMM.getInstance().getMisEventos().get(i).getCorreoDeEvento();
					rows[5] = PUCMM.getInstance().getMisEventos().get(i).getTipoDeEvento();
					rows[6] = PUCMM.getInstance().getMisEventos().get(i).getFechaDeInicio();
				
					model.addRow(rows);
				}
			}
			break;
		}

	}


}

