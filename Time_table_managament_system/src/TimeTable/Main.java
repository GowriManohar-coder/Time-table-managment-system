package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		System.out.println("----Time Table Managment System-----");
		TimeTable tt = new TimeTable();
		tt.dataentry();

	}

}
