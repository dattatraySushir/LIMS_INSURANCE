package practicePrograms.nominee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class FetchTheDataFromDB {
public static void main(String[] args) throws Throwable {
	Connection conn = null;
	try {
	Driver driver= new Driver();
	DriverManager.registerDriver(driver);
	conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	Statement state=conn.createStatement();
	String Query="select * from project";
	 ResultSet result=state.executeQuery(Query);
	 while(result.next()) {
		 String value=result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6);
				System.out.println(value); 
	 }
	}
	finally {
		conn.close();
	}
	
		
	
}
}
