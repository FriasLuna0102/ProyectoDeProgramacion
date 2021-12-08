package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;

import Logico.Eventos;
import Logico.PUCMM;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CrearComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JTextField textField;
	private JScrollPane scrollPane;
	private ArrayList <String> pasarADerecha;
	private ArrayList <String> pasarAIzquierda;
	private String selectedIzquierda = ""; 
	private String selectedDerecha = "";
	private DefaultListModel<String> listModelJuecesOcupados;
	private DefaultListModel<String> listModelJuecesDisponible;
	private JButton btnDerecha;
	private JScrollPane scrollPane_1;
	private JList listJuradosOcupados;
	private JButton btnIzquierda;
	private JList listJuradosDispo;
	private JTextField txtCodigoDelEvento;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearComision dialog = new CrearComision();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearComision() {
		setTitle("Creaci\u00F3n de Comisi\u00F3n");
		setResizable(false);
		setBounds(100, 100, 657, 598);
		dim = getToolkit().getScreenSize();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 153, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 1340, 644);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Comisi\u00F3n:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(556, 56, 142, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 11));
		textField.setBounds(556, 83, 185, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(0, 159, 1340, 423);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panelDisponibles = new JPanel();
		panelDisponibles.setBounds(430, 52, 202, 360);
		panel_1.add(panelDisponibles);
		panelDisponibles.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 202, 359);
		panelDisponibles.add(scrollPane);
		
		listJuradosDispo = new JList();
		listJuradosDispo.setFont(new Font("Times New Roman", Font.BOLD, 11));
		listJuradosDispo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = listJuradosDispo.getSelectedIndex();
				if(index != -1) {
					selectedIzquierda = (String) listJuradosDispo.getModel().getElementAt(index);
					btnDerecha.setEnabled(true);
				}
			}
		});		
		listModelJuecesDisponible = new DefaultListModel();
		pasarAIzquierda = loadJurados();
		listJuradosDispo.setModel(listModelJuecesDisponible);
		listJuradosDispo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listJuradosDispo.setBounds(12, 188, 151, -182);
		scrollPane.setViewportView(listJuradosDispo);

		
		
		
		JPanel panelSeleccionados = new JPanel();
		panelSeleccionados.setBounds(802, 52, 202, 360);
		panel_1.add(panelSeleccionados);
		panelSeleccionados.setLayout(null);
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 202, 359);
		panelSeleccionados.add(scrollPane_1);
		
		listJuradosOcupados = new JList();
		listJuradosOcupados.setFont(new Font("Times New Roman", Font.BOLD, 11));
		listJuradosOcupados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = listJuradosOcupados.getSelectedIndex();
				if(index != -1) {
					selectedDerecha = (String) listJuradosOcupados.getModel().getElementAt(index);
					btnIzquierda.setEnabled(true);
				}
			}
			
		});
		listModelJuecesOcupados = new DefaultListModel();
		listJuradosOcupados.setModel(listModelJuecesOcupados);
		listJuradosOcupados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(listJuradosOcupados);
		
		btnDerecha = new JButton(">>");
		btnDerecha.setEnabled(false);
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pasarADerecha.add(selectedIzquierda);
				insertarAlListJuradoOcupado(pasarADerecha);
				pasarAIzquierda.remove(selectedIzquierda);
				listModelJuecesDisponible.removeAllElements();
				for(int i = 0; i<pasarAIzquierda.size(); i++) {
					listModelJuecesDisponible.addElement(pasarAIzquierda.get(i));
				}
				btnDerecha.setEnabled(false);
				btnIzquierda.setEnabled(false);			
			}
			
		});
		btnDerecha.setBounds(667, 163, 97, 25);
		panel_1.add(btnDerecha);
		
		btnIzquierda = new JButton("<<");
		btnIzquierda.setEnabled(false);
		btnIzquierda.setBounds(667, 305, 97, 25);
		panel_1.add(btnIzquierda);
		
		JLabel lblNewLabel_2 = new JLabel("Jurados Disponibles:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(430, 27, 129, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblJuradosSeleccionados = new JLabel("Jurados Seleccionados:");
		lblJuradosSeleccionados.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblJuradosSeleccionados.setForeground(new Color(255, 255, 255));
		lblJuradosSeleccionados.setBounds(802, 27, 129, 14);
		panel_1.add(lblJuradosSeleccionados);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo de Evento:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(758, 56, 131, 16);
		panel.add(lblNewLabel_1);
		
		txtCodigoDelEvento = new JTextField();
		txtCodigoDelEvento.setFont(new Font("Times New Roman", Font.BOLD, 11));
		txtCodigoDelEvento.setBounds(758, 83, 185, 22);
		panel.add(txtCodigoDelEvento);
		txtCodigoDelEvento.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBackground(new Color(0, 153, 204));
		panel_2.setBounds(10, 603, 1320, 30);
		panel.add(panel_2);
		
		JLabel label = new JLabel("\u00A9Todos los derechos reservados");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sylfaen", Font.PLAIN, 10));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(655, 11, 162, 14);
		panel_2.add(label);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 153, 204));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}

	private Eventos buscar() {
		Eventos evento = null;
		for(int i = 0; i<PUCMM.getInstance().getMisEventos().size();i++) {
			
			if(PUCMM.getInstance().getMisEventos().get(i).getCodigoDeEvento() != null) {
			evento = PUCMM.getInstance().getMisEventos().get(i);
			}
		}
		return evento;
	}
	
	
	private ArrayList<String> loadJurados(){
		ArrayList<String> temp = new ArrayList();
		Eventos evento = buscar();
		if(evento!= null) {

			for(int i = 0; i<evento.getMisJurados().size(); i++) {
			String aux = new String(evento.getMisJurados().get(i).getNombre()+"   "+evento.getMisJurados().get(i).getAreaDeConocimiento());
			listModelJuecesDisponible.addElement(aux);
			temp.add(aux);

		}
		}
		
		return temp;
		
	}
	
	private void insertarAlListJuradoOcupado(ArrayList<String> pasarDerecha) {
		listModelJuecesOcupados.removeAllElements();
		for(int i = 0; i < pasarDerecha.size(); i++) {
			listModelJuecesOcupados.addElement(pasarDerecha.get(i));
		}
	}
	
	private void insertarAlListJuradoDisponible(ArrayList<String> pasarIzquierda) {
		listModelJuecesDisponible.removeAllElements();
		for(int i = 0; i<pasarIzquierda.size(); i++) {
			listModelJuecesDisponible.addElement(pasarIzquierda.get(i));
		}
	}
}

/*

}*/

