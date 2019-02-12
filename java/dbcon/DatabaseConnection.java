package dbcon;
import java.sql.*;

//import org.iiitb.OOAD.Settings;
//import org.json.JSONException;
//import org.json.JSONObject;

public class DatabaseConnection {
	public static Connection conn;

	public DatabaseConnection () 
	{
	}
	

	public static Connection getConnection() {
		try {
//			Statement stmt;
			
			Class.forName("com.mysql.jdbc.Driver");			
//			String user = "root";
//			String pass = "";
			String user = Settings.mysql_username;
			String password = Settings.mysql_password;
			System.out.println("Connecting to database...");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkartv2?autoReconnect=true&useSSL=false",
//					user, pass);
			 String URL="jdbc:mysql://localhost:"+Settings.mysql_port+"/flipkartv2";
			 conn = DriverManager.getConnection(URL,user,password);
			System.out.println("Successfully Connected to Database");
			 

	    }
		catch (Exception e) {
			System.out.println("in catch");
		//e.printStackTrace();
	}
		return conn;
	}

}
