package vo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbown {
	
	private String u_id;
	private String qn_id;
	
	public String getU_id() {
		return u_id;
	}
	
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
	public String getQn_id() {
		return qn_id;
	}
	
	public void setQn_id(String qn_id) {
		this.qn_id = qn_id;
	}
	
	public void setAll(ResultSet rs) throws SQLException{
		try {
			this.setU_id(rs.getString("u_id"));
			this.setQn_id(rs.getString("qn_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
