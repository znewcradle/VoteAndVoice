package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbc.DatabaseConnection;
import vo.Dbown;
import vo.Dbquestionnaire;
import vo.Dbquestionnairetype;
import vo.Dbuser;
import vo.ExDbitem;
import vo.ExDbquestion;
import vo.ExDbquestionnaire;

public class CreateQnDAO {
	private DatabaseConnection dbconn = null;
	private Connection conn = null;

	static public final int EXCEPTION = -1;
	static public final int SUCCESS = 1;
	static public final int FAILED = -2;
	static public final int INSUFFICIENT = -5;
	
	public CreateQnDAO() {
		try {
			dbconn = new DatabaseConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = dbconn.getConnection();
	}
	
	public int getQnTypes(ArrayList<Dbquestionnairetype> qnTypeList) {
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
	
	public int createQn(Dbquestionnaire questionnaire) {
		int message = EXCEPTION;
		String sql = "insert into db_16.questionnaire(qn_id, s_id, qn_title, qn_des, qn_type, qn_tag, qn_authority, qn_endtime) "
				+ "values(?,?,?,?,?,?,?,?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, questionnaire.getQn_id());
			pstmt.setString(2, questionnaire.getS_id());
			pstmt.setString(3, questionnaire.getQn_title());
			pstmt.setString(4, questionnaire.getQn_des());
			pstmt.setString(5, questionnaire.getQn_type());
			pstmt.setString(6, questionnaire.getQn_tag());
			pstmt.setString(7, questionnaire.getQn_authority());
			pstmt.setTimestamp(8, questionnaire.getQn_endtime());
			int i = pstmt.executeUpdate();
			if(i > 0) {
				message = SUCCESS;
			}
			else {
				message = FAILED;
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
	
	public int setVCoin(String u_id, long vCoinChange) {
		int message = EXCEPTION;
		String sql = "update db_16.user "
				+ "set v_coin = ? "
				+ "where u_id = ? ";
		try {
			ArrayList<Dbuser> userList = new ArrayList<Dbuser>();
			int checkMessage = DAOFactory.getUserInfoDAO().getUserInfo(u_id, userList);
			if(checkMessage < 0) {
				message = checkMessage;
				dbconn.close();
				return message;
			}
			long oldVCoin = userList.get(0).getV_coin().longValue();
			long newVCoin = oldVCoin + vCoinChange;
			if(newVCoin < 0) {
				message = INSUFFICIENT;
				dbconn.close();
				return message;
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setBigDecimal(1, BigDecimal.valueOf(newVCoin));
			pstmt.setString(2, u_id);
			int i = pstmt.executeUpdate();
			if(i > 0) {
				message = SUCCESS;
			}
			else {
				message = FAILED;
			}
		} catch (Exception e) {
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
	
	public int createOwnList(ArrayList<Dbown> ownList) {
		int message = EXCEPTION;
		String sql = "insert into db_16.own(u_id, qn_id) "
				+ "values(?,?) ";
		try {
			conn.setAutoCommit(false);
			for(int i = 0; i != ownList.size(); i++) {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ownList.get(i).getU_id());
				pstmt.setString(2, ownList.get(i).getQn_id());
				int count = pstmt.executeUpdate();
				if(count == 0){
					message = FAILED;
					conn.rollback();
					dbconn.close();
					return message;
				}
			}
			conn.commit();
			message = SUCCESS;
		} catch (Exception e) {
			message = EXCEPTION;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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

	public int createQsIs(ExDbquestionnaire exQuestionnaire) {
		int message = EXCEPTION;
		String sqlQn = "update db_16.questionnaire "
				+ "set qn_q_count = ? "
				+ "where qn_id = ? ";
		String sqlQ = "insert into db_16.question(qn_id, q_id, q_type, q_stem, q_des, q_i_count) "
				+ "values(?,?,?,?,?,?)";
		String sqlI = "insert into db_16.item(qn_id, q_id, i_id, i_type, i_des) "
				+ "values(?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			String qn_id = exQuestionnaire.getQuestionnaire().getQn_id();
			ArrayList<ExDbquestion> exQuestionList = exQuestionnaire.getExQuestionList();
			PreparedStatement pstmtQn = conn.prepareStatement(sqlQn);
			pstmtQn.setBigDecimal(1, BigDecimal.valueOf((long)exQuestionList.size()));
			pstmtQn.setString(2, qn_id);
			int countQn = pstmtQn.executeUpdate();
			if(countQn == 0){
				message = FAILED;
				conn.rollback();
				dbconn.close();
				return message;
			}
			for(int i = 0; i != exQuestionList.size(); i++) {
				ExDbquestion exQuestion = exQuestionList.get(i);
				ArrayList<ExDbitem> exItemList = exQuestionList.get(i).getExItemList();
				PreparedStatement pstmtQ = conn.prepareStatement(sqlQ);
				pstmtQ.setString(1, qn_id);
				pstmtQ.setBigDecimal(2, BigDecimal.valueOf((long)i + 1));
				pstmtQ.setString(3, exQuestion.getQuestion().getQ_type());
				pstmtQ.setString(4, exQuestion.getQuestion().getQ_stem());
				pstmtQ.setString(5, exQuestion.getQuestion().getQ_des());
				pstmtQ.setBigDecimal(6, BigDecimal.valueOf((long)exItemList.size()));
				int countQ = pstmtQ.executeUpdate();
				if(countQ == 0){
					message = FAILED;
					conn.rollback();
					dbconn.close();
					return message;
				}
				for(int j = 0; j != exItemList.size(); j++) {
					ExDbitem exItem = exItemList.get(i);
					PreparedStatement pstmtI = conn.prepareStatement(sqlI);
					pstmtI.setString(1, qn_id);
					pstmtI.setBigDecimal(2, BigDecimal.valueOf((long)i + 1));
					pstmtI.setBigDecimal(3, BigDecimal.valueOf((long)j + 1));
					pstmtI.setString(4, exItem.getItem().getI_type());
					pstmtI.setString(5, exItem.getItem().getI_des());
					int countI = pstmtI.executeUpdate();
					if(countI == 0){
						message = FAILED;
						conn.rollback();
						dbconn.close();
						return message;
					}
				}
			}
			conn.commit();
			message = SUCCESS;
		} catch (Exception e) {
			message = EXCEPTION;
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
