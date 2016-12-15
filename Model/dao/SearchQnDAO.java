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
	//message return
	static public final int SUCCESS = 1;
	static public final int EXCEPTION = -1;
	//authority parameter
	static public final int ALL = 0;
	static public final int PUBONLY = 1;
	
	public SearchQnDAO() {
		try {
			dbconn = new DatabaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		conn = dbconn.getConnection();
	}
	
	public int getExQnsByQnTitle(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int authority,  int totalCount, String orderBy) {
		int message = EXCEPTION;
		String authorityString = "";
		switch(authority) {
		case ALL:
			authorityString = "";
			break;
		case PUBONLY:
			authorityString = " and qn_authority = 'pub' ";
			break;
		default:
			break;	
		}
		if(!orderBy.equals("")) {
			orderBy = "order by " + orderBy;
		}
		String sql = "select * from "
				+ "(select * from db_16.questionnaire where qn_title like ? " + authorityString + " ) questionnaire "
				+ "join (select u_id s_id, u_name s_name from db_16.user) user using(s_id) "
				+ orderBy;
		exQuestionnaireList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + qn_title + "%");
			ResultSet rs = pstmt.executeQuery();
			for(int i = 0; rs.next() && i != totalCount; i++) {
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
	public int getExQnsByQnTitle(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int authority, int totalCount) {
		return this.getExQnsByQnTitle(qn_title, exQuestionnaireList, authority, totalCount, "");
	}
	public int getAllExQnsByQnTitle(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int totalCount, String orderBy) {
		return this.getExQnsByQnTitle(qn_title, exQuestionnaireList, ALL, totalCount, orderBy);
	}
	public int getAllExQnsByQnTitle(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int totalCount) {
		return this.getAllExQnsByQnTitle(qn_title, exQuestionnaireList, totalCount, "");
	}
	public int getPubExQnsByQnTitle(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int totalCount, String orderBy) {
		return this.getExQnsByQnTitle(qn_title, exQuestionnaireList, PUBONLY, totalCount, orderBy);
	}
	public int getPubExQnsByQnTitle(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int totalCount) {
		return this.getPubExQnsByQnTitle(qn_title, exQuestionnaireList, totalCount, "");
	}
	
	public int getExQnsByQnTitleByQnTypeOrTag(String qn_typeOrTag, ArrayList<ExDbquestionnaire> exQuestionnaireList, int authority, int totalCount, String orderBy) {
		int message = EXCEPTION;
		String authorityString = "";
		switch(authority) {
		case ALL:
			authorityString = "";
			break;
		case PUBONLY:
			authorityString = " and qn_authority = 'pub' ";
			break;
		default:
			break;	
		}
		if(!orderBy.equals("")) {
			orderBy = "order by " + orderBy;
		}
		String sql = "select * from "
				+ "(select * from db_16.questionnaire where qn_type = ? or qn_tag = ? " + authorityString + ") questionnaire "
				+ "join (select u_id s_id, u_name s_name from db_16.user) user using(s_id) "
				+ orderBy;
		exQuestionnaireList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qn_typeOrTag);
			pstmt.setString(2, qn_typeOrTag);
			ResultSet rs = pstmt.executeQuery();
			for(int i = 0; rs.next() && i != totalCount; i++) {
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
	public int getExQnsByQnTitleByQnTypeOrTag(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int authority, int totalCount) {
		return this.getExQnsByQnTitleByQnTypeOrTag(qn_title, exQuestionnaireList, authority, totalCount, "");
	}
	public int getAllExQnsByQnTitleByQnTypeOrTag(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int totalCount, String orderBy) {
		return this.getExQnsByQnTitleByQnTypeOrTag(qn_title, exQuestionnaireList, ALL, totalCount, orderBy);
	}
	public int getAllExQnsByQnTitleByQnTypeOrTag(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int totalCount) {
		return this.getAllExQnsByQnTitleByQnTypeOrTag(qn_title, exQuestionnaireList, totalCount, "");
	}
	public int getPubExQnsByQnTitleByQnTypeOrTag(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int totalCount, String orderBy) {
		return this.getExQnsByQnTitleByQnTypeOrTag(qn_title, exQuestionnaireList, PUBONLY, totalCount, orderBy);
	}
	public int getPubExQnsByQnTitleByQnTypeOrTag(String qn_title, ArrayList<ExDbquestionnaire> exQuestionnaireList, int totalCount) {
		return this.getPubExQnsByQnTitleByQnTypeOrTag(qn_title, exQuestionnaireList, totalCount, "");
	}	
	
	public int getExQByAStem(String q_stem, ArrayList<ExDbquestion> exQuestionList, int authority, int totalCount, String orderBy) {
		int message = EXCEPTION;
		String authorityString = "";
		switch(authority) {
		case ALL:
			authorityString = "";
			break;
		case PUBONLY:
			authorityString = " where qn_authority = 'pub' ";
			break;
		default:
			break;	
		}
		if(!orderBy.equals("")) {
			orderBy = "order by " + orderBy;
		}
		String sql = "select * from "
				+ "(select * from db_16.question where q_stem like ?) question "
				+ "join (select qn_id, qn_title from db_16.questionnaire " + authorityString + " ) questionnaire using(qn_id) "
				+ orderBy;
		exQuestionList.clear();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + q_stem + "%");
			ResultSet rs = pstmt.executeQuery();
			for(int i = 0; rs.next() && i != totalCount; i++) {
				ExDbquestion exQuestion = new ExDbquestion();
				exQuestion.setAll(rs);
				exQuestionList.add(exQuestion);
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
	public int getExQByAStem(String q_stem, ArrayList<ExDbquestion> exQuestionList, int authority, int totalCount) {
		return this.getExQByAStem(q_stem, exQuestionList, authority, totalCount, "");
	}
	public int getAllExQByAStem(String q_stem, ArrayList<ExDbquestion> exQuestionList, int totalCount, String orderBy) {
		return this.getExQByAStem(q_stem, exQuestionList, ALL, totalCount, orderBy);
	}
	public int getAllExQByAStem(String q_stem, ArrayList<ExDbquestion> exQuestionList, int totalCount) {
		return this.getAllExQByAStem(q_stem, exQuestionList, totalCount, "");
	}
	public int getPubExQByAStem(String q_stem, ArrayList<ExDbquestion> exQuestionList, int totalCount, String orderBy) {
		return this.getExQByAStem(q_stem, exQuestionList, PUBONLY, totalCount, orderBy);
	}
	public int getPubExQByAStem(String q_stem, ArrayList<ExDbquestion> exQuestionList, int totalCount) {
		return this.getPubExQByAStem(q_stem, exQuestionList, totalCount, "");
	}
}
