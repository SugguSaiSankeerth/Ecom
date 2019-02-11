package dao;
import java.sql.*;

import dbcon.DatabaseConnection;

public class DAO_Item {
	String query = null;
	ResultSet rs;
	public boolean Add_Item(String description , float price, float discount, String name, String pic_location,
			String category, String sub_category, String barcode, String dummy_1, String dummy_2, String dummy_3, String dummy_4) {
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			query = "insert into item_table(descriptor,price,discount,name,pic_location,category,sub_category,barcode)"+" VALUES "+
			"(?,?,?,?,?,?,?,?)";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, description);
			preparedStatement.setFloat(2, price);
			preparedStatement.setFloat(3, discount);
			preparedStatement.setString(4, name);
			preparedStatement.setString(5, pic_location);
			preparedStatement.setString(6, category);
			preparedStatement.setString(7, sub_category);
			preparedStatement.setString(8, barcode);
			
			int rs = preparedStatement.executeUpdate();
			if(rs==0) {
				return false;
			}
			else {
				return true;
			}

		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public int Check_Item(String BarCode) {
		Connection conn = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			query = "SELECT item_id FROM item_table where barcode=?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, BarCode);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				return rs.getInt("item_id");
			}
			else {
				return -1;
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
