package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrieve {
	
	public void retrieve(String n) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver found successful");
			String url = "jdbc:mysql://localhost:3306/timetable";
			String username = "root";
			String password = "root";
			Connection con;
			con =DriverManager.getConnection(url,username,password);
			System.out.println("connected with database successfully");
			
			String query = "select * from " + n;
			PreparedStatement st = con.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			 System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s%n",
	                    "Day_name", "Period1", "Period2", "Period3", "Period4", "Period5", "Period6");
	            while (rs.next()) {
	                System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s%n",
	                        rs.getString("Day_name"),
	                        rs.getString("period1"),
	                        rs.getString("period2"),
	                        rs.getString("period3"),
	                        rs.getString("period4"),
	                        rs.getString("period5"),
	                        rs.getString("period6"));
	            }
			System.out.println("Table shown Successfully...");
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("unable to find the driver");
		}
		catch (SQLException e) {
			System.out.println("unable to connect with database");
		}
	}

}
