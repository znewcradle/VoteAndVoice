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
				questionnaire.setQn_id(rs.getString("qn_id"));
				questionnaire.setS_id(rs.getString("s_id"));
				questionnaire.setQn_title(rs.getString("qn_title"));
				questionnaire.setQn_des(rs.getString("qn_des"));
				questionnaire.setQn_type(rs.getString("qn_type"));
				questionnaire.setQn_tag(rs.getString("qn_tag"));
				questionnaire.setQn_state(rs.getString("qn_state"));
				questionnaire.setQn_validity(rs.getString("qn_validity"));
				questionnaire.setQn_q_count(rs.getBigDecimal("qn_q_count"));
				questionnaire.setQn_a_count(rs.getBigDecimal("qn_a_count"));
				questionnaire.setQn_starttime(rs.getTimestamp("qn_starttime"));
				questionnaire.setQn_endtime(rs.getTimestamp("qn_endtime"));
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
				exQuestionnaire.getQuestionnaire().setQn_id(rs.getString("qn_id"));
				exQuestionnaire.getQuestionnaire().setS_id(rs.getString("s_id"));
				exQuestionnaire.getQuestionnaire().setQn_title(rs.getString("qn_title"));
				exQuestionnaire.getQuestionnaire().setQn_des(rs.getString("qn_des"));
				exQuestionnaire.getQuestionnaire().setQn_type(rs.getString("qn_type"));
				exQuestionnaire.getQuestionnaire().setQn_tag(rs.getString("qn_tag"));
				exQuestionnaire.getQuestionnaire().setQn_state(rs.getString("qn_state"));
				exQuestionnaire.getQuestionnaire().setQn_validity(rs.getString("qn_validity"));
				exQuestionnaire.getQuestionnaire().setQn_q_count(rs.getBigDecimal("qn_q_count"));
				exQuestionnaire.getQuestionnaire().setQn_a_count(rs.getBigDecimal("qn_a_count"));
				exQuestionnaire.getQuestionnaire().setQn_starttime(rs.getTimestamp("qn_starttime"));
				exQuestionnaire.getQuestionnaire().setQn_endtime(rs.getTimestamp("qn_endtime"));
				exQuestionnaire.setS_name(rs.getString("s_name"));
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
				answer.setU_id(rs.getString("u_id"));
				answer.setQn_id(rs.getString("qn_id"));
				answer.setQ_id(rs.getBigDecimal("q_id"));
				answer.setI_id(rs.getBigDecimal("i_id"));
				answer.setA_timestamp(rs.getTimestamp("a_timestamp"));
				answer.setA_content(rs.getString("a_content"));
				answerList.add(answer);
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
				exAnswer.getAnswer().setU_id(rs.getString("u_id"));
				exAnswer.getAnswer().setQn_id(rs.getString("qn_id"));
				exAnswer.getAnswer().setQ_id(rs.getBigDecimal("q_id"));
				exAnswer.getAnswer().setI_id(rs.getBigDecimal("i_id"));
				exAnswer.getAnswer().setA_timestamp(rs.getTimestamp("a_timestamp"));
				exAnswer.getAnswer().setA_content(rs.getString("a_content"));
				exAnswer.setU_name(rs.getString("u_name"));
				exAnswer.setQn_title(rs.getString("qn_title"));
				exAnswer.setQ_stem(rs.getString("q_stem"));
				exAnswer.setI_des(rs.getString("i_des"));
				exAnswerList.add(exAnswer);
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
}
