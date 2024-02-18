package dao;

import java.sql.*;
import Config.SQLInfo;

public class Dao {

	public boolean insertData(String fileName, String remark, byte[] imgData) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(SQLInfo.URL, SQLInfo.USERNAME, SQLInfo.PASSWORD);
			PreparedStatement st = conn.prepareStatement(SQLInfo.INSERTQ);
			st.setString(1, fileName);
			st.setString(2, remark);
			st.setBytes(3, imgData);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean updateData1(String fileName, String remark, byte[] imgData, int id) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(SQLInfo.URL, SQLInfo.USERNAME, SQLInfo.PASSWORD);
	        PreparedStatement st = conn.prepareStatement(SQLInfo.UPDATEQ1);

	      
	            st.setString(1, fileName);
	            st.setString(2, remark);
	            st.setBytes(3, imgData);
	            st.setInt(4, id);

	        int rowsAffected = st.executeUpdate();

	        if (rowsAffected == 1) {
	            return true;
	        } else {
	            return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	public boolean updateData2(String remark, int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(SQLInfo.URL, SQLInfo.USERNAME, SQLInfo.PASSWORD);
			PreparedStatement st = conn.prepareStatement(SQLInfo.UPDATEQ2);
			
			
			st.setString(1, remark);
			st.setInt(2, id);

			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}


	public ResultSet selectData() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(SQLInfo.URL, SQLInfo.USERNAME, SQLInfo.PASSWORD);
			PreparedStatement st = conn.prepareStatement(SQLInfo.SELECTQ);
			if (st.execute()) {
				return st.executeQuery();
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public ResultSet selectIdData(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(SQLInfo.URL, SQLInfo.USERNAME, SQLInfo.PASSWORD);
			PreparedStatement st = conn.prepareStatement(SQLInfo.SELECTIDQ);
			st.setInt(1 ,id );
			if (st.execute()) {
				return st.executeQuery();
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean deleteData(int id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(SQLInfo.URL, SQLInfo.USERNAME, SQLInfo.PASSWORD);
			PreparedStatement st = conn.prepareStatement(SQLInfo.DELETEQ);
			st.setInt(1, id);
			if (st.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

}
