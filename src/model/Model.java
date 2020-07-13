package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Model {
	
	private Connection hid;
	
	public Model() {
		try {
			hid = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "teodor", "teodor");
			System.out.println("Database connected!");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured connecting to database!");
		}
	}
	
	
	public List<Town> listTowns(){
		
		ArrayList<Town> townList = new ArrayList<>();
		ResultSet sofor;
		
		
		try {
			Statement teherauto = hid.createStatement();
			sofor = teherauto.executeQuery("SELECT * FROM towns");//a teherautoval elviszi a kerelmet az adatbazisnak
			while(sofor.next()) {
				Town t = new Town(sofor.getString("Name"), sofor.getInt("Funded"));
				townList.add(t);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR!");
		}
		return townList;
		
	}

}
