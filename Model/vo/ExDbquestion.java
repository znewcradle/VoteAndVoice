package vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExDbquestion {
	private Dbquestion question = new Dbquestion();
	private String qn_title;
	public Dbquestion getQuestion() {
		return question;
	}
	public String getQn_title() {
		return qn_title;
	}
	public void setQn_title(String qn_title) {
		this.qn_title = qn_title;
	}
	public void setAll(ResultSet rs) throws SQLException{
		try {
			this.getQuestion().setAll(rs);
			this.setQn_title(rs.getString("qn_title"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
