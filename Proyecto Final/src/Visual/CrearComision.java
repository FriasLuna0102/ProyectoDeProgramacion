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
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
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
		setResizable(false);
		setBounds(100, 100, 657, 598);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Crear Comision:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 639, 510);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de Comision:");
		lblNewLabel.setBounds(12, 56, 142, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 85, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jurados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 159, 615, 349);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 25, 202, 283);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 202, 283);
		panel_2.add(scrollPane);
		
		listJuradosDispo = new JList();
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

		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(364, 25, 202, 283);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 202, 283);
		panel_3.add(scrollPane_1);
		
		listJuradosOcupados = new JList();
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
		btnDerecha.setBounds(226, 56, 97, 25);
		panel_1.add(btnDerecha);
		
		btnIzquierda = new JButton("<<");
		btnIzquierda.setEnabled(false);
		btnIzquierda.setBounds(226, 115, 97, 25);
		panel_1.add(btnIzquierda);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo de Evento:");
		lblNewLabel_1.setBounds(258, 56, 131, 16);
		panel.add(lblNewLabel_1);
		
		txtCodigoDelEvento = new JTextField();
		txtCodigoDelEvento.setBounds(250, 85, 116, 22);
		panel.add(txtCodigoDelEvento);
		txtCodigoDelEvento.setColumns(10);


		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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

