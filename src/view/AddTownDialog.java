package view;

import javax.swing.*;
import java.awt.*;


public class AddTownDialog extends JDialog{
	
	
	private static final long serialVersionUID = 1053566451169911779L;
	private View view;
	private JTextField townNameField;
	private JSpinner townFundedSpinner;
	
	public AddTownDialog(View view) {
		this.view = view;
		createAndShowDialog();
	}

	private void createAndShowDialog() {
		setTitle("Add town");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		add(createInputPanel(),BorderLayout.LINE_START);
		add(createButtonPanel(),BorderLayout.LINE_END);
		pack();
		setVisible(true);
	}
	
	private JPanel createInputPanel() {
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		JLabel townName = new JLabel("Town name");
		townNameField = new JTextField();
		panel1.add(townName);
		panel1.add(townNameField);
		JLabel townFunded = new JLabel("Town funded");
		townFundedSpinner = new JSpinner();
		panel1.add(townFunded);
		panel1.add(townFundedSpinner);
		return panel1;
	}
	
	private JPanel createButtonPanel() {
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JButton okButton = new JButton("OK!");
		JButton cancelButton = new JButton("Canel");
		panel2.add(okButton);
		panel2.add(cancelButton);
		
		okButton.addActionListener(e->{
			if(!view.getController().stringValidation(townNameField.getText())){
				JOptionPane.showMessageDialog(this, "Town name field is empty!", "ERROR!", JOptionPane.ERROR_MESSAGE); 
			}
			else if(!view.getController().integerValidation((int)townFundedSpinner.getValue())){
				JOptionPane.showMessageDialog(this, "Enter a valid year!", "ERROR!", JOptionPane.ERROR_MESSAGE); 
			}
		});
		
		
		cancelButton.addActionListener(e->{
			this.dispose();
		});
		return panel2;
		
		
	}
	
	

}
