package view;

import javax.swing.*;

import model.Town;

public class ListTownTable extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3206442616896719068L;
	private View view;
	private String data[][];
	
	public ListTownTable(View view, String data[][]) {
		this.view = view;
		this.data = data;
		String[] columns = new String[] {
				 "Name", "Funded"
		};
		JTable table = new JTable(data, columns);
		add(table);
		setTitle("Towns!");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	

}
