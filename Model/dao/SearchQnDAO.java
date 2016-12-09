package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbc.DatabaseConnection;
import vo.ExDbquestion;
import vo.ExDbquestionnaire;

public class SearchQnDAO {
	private DatabaseConnection dbconn = null;
	private Connection conn = null;
	
	static public final int SUCCESS = 1;
	static public final int EXCEPTION = -1;

	public SearchQnDAO() {
		try {
			dbconn = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = dbconn.getConnection();
	}
	
	private int getExQnsByQnTitle(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, String orderBy) {
		int message = EXCEPTION;
		String sql = "select * from "
				+ "(select * from db_16.questionnaire where qn_title like ?) questionnaire "
				+ "join (select u_id s_id, u_name s_name from db_16.user) user using(s_id) "
				+ orderBy;
		exQuestionnaireList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + qn_title + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ExDbquestionnaire exQuestionnaire = new ExDbquestionnaire();
				exQuestionnaire.setAll(rs);
				exQuestionnaireList.add(exQuestionnaire);
				message = SUCCESS;
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
	public int getExQnsByQnTitle(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList) {
		return this.getExQnsByQnTitle(qn_title, exQuestionnaireList, "");
	}
	
	private int getExQnsByQnTitleByQnTypeOrTag(String qn_typeOrTag, ArrayList<ExDbquestionnaire> exQuestionnaireList, String orderBy) {
		int message = EXCEPTION;
		String sql = "select * from "
				+ "(select * from db_16.questionnaire where qn_type = ? or qn_tag = ?) questionnaire "
				+ "join (select u_id s_id, u_name s_name from db_16.user) user using(s_id) "
				+ orderBy;
		exQuestionnaireList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qn_typeOrTag);
			pstmt.setString(2, qn_typeOrTag);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ExDbquestionnaire exQuestionnaire = new ExDbquestionnaire();
				exQuestionnaire.setAll(rs);
				exQuestionnaireList.add(exQuestionnaire);
				message = SUCCESS;
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
	public int getExQnsByQnTitleByQnTypeOrTag(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList) {
		return this.getExQnsByQnTitleByQnTypeOrTag(qn_title, exQuestionnaireList, "");
	}
	
	private int getExQByAStem(String q_stem, ArrayList<ExDbquestion> exQuestionList, String orderBy) {
		int message = EXCEPTION;
		String sql = "select * from "
				+ "(select * from db_16.question where q_stem like ?) question "
				+ "join (select qn_id, qn_title from db_16.questionnaire) questionnaire using(qn_id) "
				+ orderBy;
		exQuestionList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + q_stem + "%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ExDbquestion exQuestion = new ExDbquestion();
				exQuestion.setAll(rs);
				exQuestionList.add(exQuestion);
				message = SUCCESS;
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
	public int getExQByAStem(String qn_title, ArrayList<ExDbquestion> exQuestionList) {
		return this.getExQByAStem(qn_title, exQuestionList, "");
	}
}
