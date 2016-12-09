package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbc.DatabaseConnection;
import vo.Dbuser;

public class UserInfoDAO {
	private DatabaseConnection dbconn = null;
	private Connection conn = null;
	
	static public final int SUCCESS = 1;
	static public final int EXCEPTION = -1;
	static public final int WRONG_ID = -2;

	public UserInfoDAO() {
		try {
			dbconn = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = dbconn.getConnection();
	}
	
	public int getUserInfo(String u_id, ArrayList<Dbuser> userList) {
		int message = EXCEPTION;
		String sql = "select * "
				+ "from db_16.user "
				+ "where u_id=? ";
		userList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Dbuser user = new Dbuser();
				user.setU_id(rs.getString("u_id"));
				user.setU_pwd(rs.getString("u_pwd"));
				user.setV_exp(rs.getBigDecimal("v_exp"));
				user.setV_level(rs.getBigDecimal("v_level"));
				user.setV_coin(rs.getBigDecimal("v_coin"));
				user.setU_validity(rs.getString("u_validity"));
				user.setU_name(rs.getString("u_name"));
				user.setU_gender(rs.getString("u_gender"));
				user.setU_phone(rs.getString("u_phone"));
				user.setU_ad_country(rs.getString("u_ad_country"));
				user.setU_ad_province(rs.getString("u_ad_province"));
				user.setU_ad_city(rs.getString("u_ad_city"));
				user.setU_ad_street(rs.getString("u_ad_street"));
				userList.add(user);
				message = SUCCESS;
			}
			if(userList.size() == 0) {
				message = WRONG_ID;
			}
		} catch (SQLException e) {
			message = EXCEPTION;
			System.out.println("MySQL fault.");
			e.printStackTrace();
		} finally {
			try {
				dbconn.close();
			} catch (Exception e) {
				message = EXCEPTION;
				e.printStackTrace();
			}
		}
		return message;
	}
	
	public int changeUserInfo(Dbuser user) {
		int message = EXCEPTION;
		String sql = "update db_16.user "
				+ "set u_name = ?, u_gender = ?, u_phone = ?, u_ad_country = ?, u_ad_province = ?, u_ad_city = ?, u_ad_street = ? "
				+ "where u_id = ? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getU_name());
			pstmt.setString(2, user.getU_gender());
			pstmt.setString(3, user.getU_phone());
			pstmt.setString(4, user.getU_ad_country());
			pstmt.setString(5, user.getU_ad_province());
			pstmt.setString(6, user.getU_ad_city());
			pstmt.setString(7, user.getU_ad_street());
			pstmt.setString(8, user.getU_id());
			int i = pstmt.executeUpdate();
			if(i > 0) {
				message = SUCCESS;
			}
			else {
				message = WRONG_ID;
			}
		} catch (SQLException e) {
			message = EXCEPTION;
			e.printStackTrace();
		} finally {
			try {
				dbconn.close();
			} catch (Exception e) {
				message = EXCEPTION;
				e.printStackTrace();
			}
		}
		return message;
	}

}
