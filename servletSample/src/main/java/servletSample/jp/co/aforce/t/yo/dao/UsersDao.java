package servletSample.jp.co.aforce.t.yo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import servletSample.jp.co.aforce.t.yo.dto.UsersDto;
import servletSample.jp.co.aforce.t.yo.util.DBUtil;

public class UsersDao {
	public UsersDto selectByIdAndPassword(String id, String password) {
		UsersDto result = new UsersDto();
		String sql = "SELECT * FROM users WHERE user_id = ? AND password = ?";
		
		try(Connection con = DBUtil.openConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			try(ResultSet rs = pstmt.executeQuery();){
				while(rs.next()) {
					result.setUserID(rs.getString("user_id"));
					result.setUserName(rs.getString("user_name"));
					System.out.println(rs.getString("user_name"));
					result.setAge(Integer.valueOf(rs.getString("age")));
					System.out.println(rs.getString("age"));
				}
				System.out.println("SQLの実行に成功しました");
			} catch(SQLException e) {
				System.out.println("SQLの実行に失敗しました");
				e.printStackTrace();
			}
			
		} catch(Exception e) {
			System.out.println("DBとの接続に失敗しました。");
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
