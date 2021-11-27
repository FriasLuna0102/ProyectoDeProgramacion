package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.border.TitledBorder;

public class ElegirComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ElegirComision dialog = new ElegirComision();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.  
	 */
	public ElegirComision() {
		setTitle("Comisiones");
		setBounds(100, 100, 450, 464);
		dim = getToolkit().getScreenSize();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(0, 0, 1350, 656);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Lista de Jurados:");
				lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblNewLabel.setBounds(503, 61, 128, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Jurados seleccionados:");
				lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				lblNewLabel_1.setBounds(865, 61, 163, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(380, 97, 296, 474);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 463, 276, -456);
				panel_1.add(scrollPane);
				
				JList list = new JList();
				list.setBounds(10, 18, 276, 445);
				panel_1.add(list);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(790, 97, 296, 474);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 674, 276, -666);
				panel_1.add(scrollPane);
				
				JList list = new JList();
				list.setBounds(10, 19, 276, 445);
				panel_1.add(list);
			}
			
			JButton btnNewButton = new JButton("<<");
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			btnNewButton.setBounds(686, 237, 94, 23);
			panel.add(btnNewButton);
			
			JButton button = new JButton(">>");
			button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			button.setBounds(686, 429, 94, 23);
			panel.add(button);
			
			JLabel lblNewLabel_2 = new JLabel("Acontinuaci\u00F3n se pasar\u00E1 a elegir cada jurado para cada comisi\u00F3n.");
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(36, 34, 380, 14);
			panel.add(lblNewLabel_2);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>"}));
			comboBox.setBounds(36, 121, 305, 20);
			panel.add(comboBox);
		}
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
}
