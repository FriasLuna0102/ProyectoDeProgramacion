package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class ClaseElegir extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ClaseElegir dialog = new ClaseElegir();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ClaseElegir() {
		setBounds(100, 100, 450, 300);
		dim = getToolkit().getScreenSize();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(dim.width, dim.height-40);
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 1330, 634);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Participantes.");
				rdbtnNewRadioButton.setBounds(293, 285, 109, 23);
				panel.add(rdbtnNewRadioButton);
			}
			
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Jurados");
			rdbtnNewRadioButton_1.setBounds(494, 285, 109, 23);
			panel.add(rdbtnNewRadioButton_1);
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
