package vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Dbquestionnaire {
	
	private String qn_id;
	private String s_id;
	private String qn_title;
	private String qn_des;
	private String qn_type;
	private String qn_tag;
	private String qn_state;
	private String qn_validity;
	private BigDecimal qn_q_count;
	private BigDecimal qn_a_count;
	private Timestamp qn_starttime;
	private Timestamp qn_endtime;
	
	
	public String getQn_id() {
		return qn_id;
	}
	
	public void setQn_id(String qn_id) {
		this.qn_id = qn_id;
	}
	
	public String getS_id() {
		return s_id;
	}
	
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	
	public String getQn_title() {
		return qn_title;
	}
	
	public void setQn_title(String qn_title) {
		this.qn_title = qn_title;
	}
	
	public String getQn_des() {
		return qn_des;
	}
	
	public void setQn_des(String qn_des) {
		this.qn_des = qn_des;
	}
	
	public String getQn_type() {
		return qn_type;
	}
	
	public void setQn_type(String qn_type) {
		this.qn_type = qn_type;
	}

	public String getQn_tag() {
		return qn_tag;
	}

	public void setQn_tag(String qn_tag) {
		this.qn_tag = qn_tag;
	}
	
	public String getQn_state() {
		return qn_state;
	}
	
	public void setQn_state(String qn_state) {
		this.qn_state = qn_state;
	}
	
	public String getQn_validity() {
		return qn_validity;
	}
	
	public void setQn_validity(String qn_validity) {
		this.qn_validity = qn_validity;
	}
	
	public BigDecimal getQn_q_count() {
		return qn_q_count;
	}
	
	public void setQn_q_count(BigDecimal qn_q_count) {
		this.qn_q_count = qn_q_count;
	}

	public Timestamp getQn_starttime() {
		return qn_starttime;
	}

	public void setQn_starttime(Timestamp qn_starttime) {
		this.qn_starttime = qn_starttime;
	}

	public Timestamp getQn_endtime() {
		return qn_endtime;
	}

	public void setQn_endtime(Timestamp qn_endtime) {
		this.qn_endtime = qn_endtime;
	}

	public BigDecimal getQn_a_count() {
		return qn_a_count;
	}

	public void setQn_a_count(BigDecimal qn_a_count) {
		this.qn_a_count = qn_a_count;
	}
	
}
