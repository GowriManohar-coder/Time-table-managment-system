package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		System.out.println("----Time Table Managment System-----");
		TimeTable tt = new TimeTable();
		Retrieve rr = new Retrieve();
		//tt.dataentry();
		System.out.println("Enter which Time Table you Requried in 'cse_firstyear' format");
		String n = Scan.nextLine();
		rr.retrieve(n);
		

	}

}
