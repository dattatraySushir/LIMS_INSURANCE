package practicePrograms.nominee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.mysql.jdbc.Driver;

public class InserDataIntoDB {
	public static void main(String[] args) throws Throwable {
		Connection conn = null;
	
		try {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement state=conn.createStatement();
		String Query="insert into project values('TY_PROJ_1995','kamoado','29/06/2023','TYSS','Completed','5')";
		int result=state.executeUpdate(Query);
		if(result==1) {
			System.out.println("Data is created");
		}
		else {
			System.out.println("Data is not created");
		}
		}
		finally {
			conn.close();
		}
		
	}

}
