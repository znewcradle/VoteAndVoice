package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbc.DatabaseConnection;
import vo.Dbquestionnairetype;

public class CreateQnDAO {
	private DatabaseConnection dbconn = null;
	private Connection conn = null;

	static public final int EXCEPTION = -1;
	static public final int SUCCESS = 1;
	static public final int FAILED = -2;
	
	public CreateQnDAO() {
		try {
			dbconn = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = dbconn.getConnection();
	}
	
	public int getQnTypes(String u_id, ArrayList<Dbquestionnairetype> qnTypeList) {
		int message = EXCEPTION;
		String sql = "select * from db_16.questionnairetype ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Dbquestionnairetype questionnairetype = new Dbquestionnairetype();
				questionnairetype.setAll(rs);
				qnTypeList.add(questionnairetype);
			}
			message = SUCCESS;
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
	
/*	public int createQn(Questionnaire) {
		int message = EXCEPTION;
		int checkMessage = new RegisterDAO().checkIdAvailable(u_id);
		if(checkMessage < 0) {
			message = checkMessage;
			return message;
		}
		String sql = "insert into db_16.user(u_id, u_pwd, u_name, u_gender, u_phone, u_ad_country, u_ad_province, u_ad_city, u_ad_street) "
				+ "values(?,?,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			String[] paraList = {u_id, u_pwd, u_name, u_gender, u_phone, u_ad_country, u_ad_province, u_ad_city, u_ad_street};
			for(int i = 0; i != paraList.length; i++) {
				if(paraList[i] == null) {
					paraList[i] = "";
				}
				pstmt.setString(i + 1, paraList[i]);
			}
			int i = pstmt.executeUpdate();
			if(i > 0) {
				message = SUCCESS;
			}
			else {
				message = EXIST;
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
	}*/
}
