package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbcon.DatabaseConnection;

public class DAO_Item_Seller {
	public static boolean add_Item_Seller(int seller_id,int item_id,int quantity,int address)
	{
		Connection conn=DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = null;
		String query=null;
		query = "insert into item_seller(seller_id,item_id,quantity,address) VALUES " +
				 "(?,?,?,?);";
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, seller_id);
			preparedStatement.setInt(2, item_id);
			preparedStatement.setInt(3, quantity);
			preparedStatement.setInt(4, address);
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
		return false;
		
		
		
	}

}
