package servletSample.jp.co.aforce.t.yo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import servletSample.jp.co.aforce.t.yo.dto.UsersDto;
import servletSample.jp.co.aforce.t.yo.util.DBUtil;

public class RegisterDao {
	
	
		public boolean existsById(String id) {
		    boolean exists = false;
		    String sql = "SELECT COUNT(*) FROM users WHERE user_id = ?";
		
		    try (Connection conn = DBUtil.openConnection();
		        PreparedStatement pstmt = conn.prepareStatement(sql)) {
		        pstmt.setString(1, id);
		        try (ResultSet rs = pstmt.executeQuery()) {
		            if (rs.next()) {
		                exists = rs.getInt(1) > 0;
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return exists;
		}

	
	
	    public boolean insertUser(UsersDto user) {
	        String sql = "INSERT INTO users (user_id, password, user_name, age, created_user, updated_user) VALUES (?, ?, ?, ?, ?, ?)";
	        
	        try (Connection conn = DBUtil.openConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, user.getUserID());
	            pstmt.setString(2, user.getPassword());
	            pstmt.setString(3, user.getUserName());
	            pstmt.setInt(4, user.getAge());
	            pstmt.setString(5, user.getUserID());
	            pstmt.setString(6, user.getUserID());

	            int rowsAffected = pstmt.executeUpdate();
	            return rowsAffected > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}
