package vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExDbquestionnaire {
	private Dbquestionnaire questionnaire = new Dbquestionnaire();
	private String s_name;
	private ArrayList<ExDbquestion> exQuestionList = null;
	
	public Dbquestionnaire getQuestionnaire() {
		return questionnaire;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}	
	
	public void setAll(ResultSet rs) throws SQLException{
		try {
			this.getQuestionnaire().setAll(rs);
			this.setS_name(rs.getString("s_name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setPart(ResultSet rs) throws SQLException{
		try {
			this.getQuestionnaire().setAll(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<ExDbquestion> getExQuestionList() {
		if(exQuestionList == null) {
			exQuestionList = new ArrayList<ExDbquestion>();
		}
		return exQuestionList;
	}
}
