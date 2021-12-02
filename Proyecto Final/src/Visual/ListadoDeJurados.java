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
import Logico.Jurado;
import Logico.PUCMM;
import Logico.Participantes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ListadoDeJurados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JPanel panel_1;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private static Object[] rows;
	private static DefaultTableModel model;
	private Jurado selected = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {  
			ListadoDeJurados dialog = new ListadoDeJurados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoDeJurados() {
		setResizable(false);
		setBounds(100, 100, 511, 399);
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
			panel.setBorder(new TitledBorder(null, "Listado De Jurados:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(0, 0, 1350, 685);
			contentPanel.add(panel);
			panel.setLayout(null);

			panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 51, 255));
			panel_1.setBounds(10, 79, 1330, 567);
			panel.add(panel_1);
			panel_1.setLayout(null);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 11, 1350, 565);
			panel_1.add(scrollPane);

			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int aux =-1;
					 aux = table.getSelectedRow();
					if(aux != -1) {
						String jurados = (String) table.getValueAt(aux, 0);
						selected = PUCMM.getInstance().buscarJurado(jurados);
						System.out.println(selected.getNombre()+""+selected.getAreaDeConocimiento());
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			String[] headers = {"Nombre","Apellido","Labor","Área de Conocimiento","Año de Experiencia","Lugar de Recomendación","Cédula","Teléfono"};			
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);	
			table.setModel(model);
			scrollPane.setViewportView(table);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 51, 255));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			loadJurados(0,  "");
		}

	}
	public static void loadJurados(int select, String codigoEvento) {
		
		//if(evento != null) {
			//model.setRowCount(0);
			//rows = new Object[model.getColumnCount()];
			//switch (select) {
			//case 0:
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		Eventos evento = PUCMM.getInstance().buscarEvento(codigoEvento);
		if(evento != null) {
				for (int i = 0; i < evento.getMisJurados().size(); i++) {
					rows[0] = evento.getMisJurados().get(i).getApellido();
					rows[1] = evento.getMisJurados().get(i).getCedula();
					rows[2] = evento.getMisJurados().get(i).getNombre();
					rows[3] = evento.getMisJurados().get(i).getAreaDeConocimiento();
					rows[4] = evento.getMisJurados().get(i).getAñoDeExperiencia();
					rows[5] = evento.getMisJurados().get(i).getLugarDeRecomendacion();
					rows[6] = evento.getMisJurados().get(i).getTelefono();
					model.addRow(rows);		     

				}
				
		}

			}

		
	}
	

