package practicePrograms.nominee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class VerifyAndCheckData {
	public static void main(String[] args) throws Throwable {
		Connection conn = null;
		String Projectname = "TYSS";
		try {

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = conn.createStatement();
			String Query = "select * from project";
			ResultSet result = state.executeQuery(Query);
			boolean flag = false;
			while (result.next()) {
				String value = result.getString(4);
				if (value.equalsIgnoreCase(Projectname)) {
					System.out.println("Project is created");
					flag = true;
					break;
				}
			}
			if (flag=false) {
				System.out.println("Project is not created");
			}
		}

		finally {
			conn.close();

		}
	}
}
