package view;
import javax.swing.*;
import controller.Controller;
import model.Town;

public class View extends JFrame {
	
	
	private static final long serialVersionUID = -1991379657007171367L;
	private Controller controller;

	public View(Controller controller) {
		this.controller = controller;
	}

	public Controller getController(){
		return this.controller;
	}
	
	public void startGui() {
		SwingUtilities.invokeLater(()->{
			createAndShowGui();
		});
			
		
	}

	private void createAndShowGui() {//creating the window!
		setTitle("TownCatalog");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		setJMenuBar(createMenubar());
		setVisible(true);
	}

	private JMenuBar createMenubar() {//creating the the menubar
		JMenuBar menubar = new JMenuBar();
		menubar.add(createTownsMenu());
		return menubar;
	}
	
	private JMenu createTownsMenu() {//creating the first menu option
		JMenu townsMenu = new JMenu("Towns");
		JMenuItem listTowns = new JMenuItem("List towns");
		JMenuItem addTown = new JMenuItem("Add a town");
		townsMenu.add(listTowns);
		townsMenu.add(addTown);
		
		listTowns.addActionListener(e->{
			new ListTownTable(this,this.getController().mergeToArray(controller.listTowns()));
		});
		
		addTown.addActionListener(e->{
			new AddTownDialog(this);
		});
		return townsMenu;
	}
	
	
	
	
	
	

}
