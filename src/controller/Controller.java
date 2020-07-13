package controller;

import java.time.LocalDate;
import java.util.List;

import model.*;
import view.View;

public class Controller {
	
	private Model model;
	private View view;
	

	public void startDesktop() {
		this.model = new Model();
		this.view = new View(this);
		view.startGui();;
	}
	
	public List<Town> listTowns(){
		return this.model.listTowns();
	}
	
	public boolean stringValidation(String string){
		if(string.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean integerValidation(int number) {
		LocalDate localDate = LocalDate.now();
		final int MIN = 0;
		final int MAX = localDate.getYear();
		if(number <= MIN || number >= MAX) {
			return false;
		}
		return true;		
	}
	
	public String [][] mergeToArray(List<Town> list) {// ezt esetleg szebben valami mas modon?
		String[][] data = new String [list.size()][2];
		for(int  i = 0; i < list.size();i++) {
			for(int j = 0; j < 2;) {
				data[i][j] = list.get(i).getName();
				data[i][j+1] = String.valueOf(list.get(i).getFunded());
				break;
			}
		}
		return data;
	}
	



}