package dao;
import model.Seller;
import java.sql.*;
import dbcon.DatabaseConnection;

public class DAO_Seller {
	public static boolean add_Seller(String name,String mobile,String email,String address_1,String address_2)
	{
		Connection conn=DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = null;
		String query=null;
		query = "insert into seller_table(name,mobile,email,address_1,address_2) VALUES " +
				 "(?,?,?,?,?);";
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, mobile);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, address_1);
			preparedStatement.setString(5, address_2);
			int rs = preparedStatement.executeUpdate();
			if(rs==0) {
				return false;
			}
			else {
				return true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	

}
