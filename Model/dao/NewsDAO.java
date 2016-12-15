package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbc.DatabaseConnection;
import vo.Dbanswer;
import vo.Dbquestionnaire;
import vo.ExDbanswer;
import vo.ExDbquestionnaire;

public class NewsDAO {
	private DatabaseConnection dbconn = null;
	private Connection conn = null;
	
	static public final int SUCCESS = 1;
	static public final int EXCEPTION = -1;

	public NewsDAO() {
		try {
			dbconn = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = dbconn.getConnection();
	}
	
	public int getQuestionnairesByUId(String s_id, ArrayList<Dbquestionnaire> questionnaireList) {
		int message = EXCEPTION;
		String sql = "select * "
				+ "from db_16.questionnaire "
				+ "where s_id=? "
				+ "order by qn_starttime desc ";
		questionnaireList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Dbquestionnaire questionnaire = new Dbquestionnaire();
				questionnaire.setAll(rs);
				questionnaireList.add(questionnaire);
			}
			message = SUCCESS;
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
	
	public int getExQuestionnairesByUId(String s_id, ArrayList<ExDbquestionnaire> exQuestionnaireList) {
		int message = EXCEPTION;
		String sql = "select * from "
				+ "(select * from db_16.questionnaire where s_id=?) questionnaire "
				+ "join (select u_id s_id, u_name s_name from db_16.user) user using(s_id) "
				+ "order by qn_starttime desc ";
		System.out.println(sql);
		exQuestionnaireList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ExDbquestionnaire exQuestionnaire = new ExDbquestionnaire();
				exQuestionnaire.setAll(rs);
				exQuestionnaireList.add(exQuestionnaire);
			}
			message = SUCCESS;
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
	
	public int getAnswersByUId(String u_id, ArrayList<Dbanswer> answerList) {
		int message = EXCEPTION;
		String sql = "select * "
				+ "from db_16.answer "
				+ "where u_id=? "
				+ "order by a_timestamp desc ";
		System.out.println(sql);
		answerList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Dbanswer answer = new Dbanswer();
				answer.setAll(rs);
				answerList.add(answer);
			}
			message = SUCCESS;
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
	
	public int getExAnswersByUId(String u_id, ArrayList<ExDbanswer> exAnswerList) {
		int message = EXCEPTION;
		String sql = "select * from "
				+ "(select * from db_16.answer where u_id=?) answer "
				+ "join (select u_id, u_name from db_16.user) user using(u_id)"
				+ "join (select qn_id, qn_title from db_16.questionnaire) questionnaire using(qn_id) "
				+ "join (select q_id, q_stem from db_16.question) question using(q_id) "
				+ "join (select i_id, i_des from db_16.item) item using(i_id) "
				+ "order by a_timestamp desc ";
		System.out.println(sql);
		exAnswerList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				ExDbanswer exAnswer = new ExDbanswer();
				exAnswer.setAll(rs);
				exAnswerList.add(exAnswer);
			}
			message = SUCCESS;
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
}
