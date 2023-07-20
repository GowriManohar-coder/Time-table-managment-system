package TimeTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TimeTable {
	String day, name, p1, p2, p3, p4, p5, p6, p7;
	String[] department = { "CSE", "MECH", "ECE", "EEE", "Civil" };
	String[] year = {"first", "second", "third","fourth"};
	Scanner Scan = new Scanner(System.in);

	public void dataentry() {
		System.out.println("Enter no of departments ");
		int dept = Scan.nextInt();
		for (int i = 0; i < dept; i++) {
			Scan.nextLine();
			System.out.println("Department " + (i + 1) + " Name in CSE, MECH, ECE, EEE, Civil Format");
			String n = Scan.nextLine();
			name = n.toLowerCase();
			for (int k = 0; k < 4; k++) {
				System.out.println(name + " Department "+year[k]+" year Data Entry");
				System.out.println("Enter no of days");
				int days = Scan.nextInt();
				for (int j = 1; j <= days; j++) {
					Scan.nextLine();
					System.out.println("Enter the day name for time slots (e.g., Monday, Tuesday, etc.):");
					day = Scan.nextLine();
					System.out.println("Enter  " + day + " subjects for time slots");
					System.out.println("Subject for 9:00 am to 10:00 am");
					p1 = Scan.next();
					System.out.println("Subject for 10:00 am to 11:00 am");
					p2 = Scan.next();
					System.out.println("Subject for 11:00 am to 12:00 pm");
					p3 = Scan.next();
					System.out.println("Subject for 12:00 pm to 1:00 pm");
					p4 = Scan.next();
					System.out.println("Subject for 1:00 pm to 2:00 pm");
					p5 = Scan.next();
					System.out.println("Subject for 2:00 pm to 3:00 pm");
					p6 = Scan.next();
					System.out.println("Subject for 3:00 pm to 4:00 pm");
					p7 = Scan.next();
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						System.out.println("driver found successful");
						String url = "jdbc:mysql://localhost:3306/timetable";
						String username = "root";
						String password = "root";
						Connection con;
						con = DriverManager.getConnection(url, username, password);
						System.out.println("connected with database successfully");
							String query = "insert into " +department[i]+"_"+year[i]+"year values(?,?,?,?,?,?,?,?)";
							PreparedStatement st = con.prepareStatement(query);
							st.setString(1, day);
							st.setString(2, p1);
							st.setString(3, p2);
							st.setString(4, p3);
							st.setString(5, p4);
							st.setString(6, p5);
							st.setString(7, p6);
							st.setString(8, p7);
							st.execute();
						System.out.println("data inserted successfully...");
						con.close();

					} catch (ClassNotFoundException e) {
						System.out.println("unable to find the driver");
					} catch (SQLException e) {
						System.out.println("unable to connect with database");
					}
				}
			}
		}

	}

}
