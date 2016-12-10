package vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExDbitem {
	private Dbitem item = new Dbitem();
	private String qn_title;
	private String q_stem;
	private ArrayList<ExDbanswer> exAnswerList = null;
	
	public Dbitem getItem() {
		return item;
	}
	public String getQn_title() {
		return qn_title;
	}
	public void setQn_title(String qn_title) {
		this.qn_title = qn_title;
	}
	public String getQ_stem() {
		return q_stem;
	}
	public void setQ_stem(String q_stem) {
		this.q_stem = q_stem;
	}

	public void setAll(ResultSet rs) throws SQLException{
		try {
			this.getItem().setAll(rs);
			this.setQn_title(rs.getString("qn_title"));
			this.setQ_stem(rs.getString("q_stem"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setPart(ResultSet rs) throws SQLException{
		try {
			this.getItem().setAll(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<ExDbanswer> getExAnswerList() {
		if(exAnswerList == null){
			exAnswerList = new ArrayList<ExDbanswer>();
		}
		return exAnswerList;
	}
}
