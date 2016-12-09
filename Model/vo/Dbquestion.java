package vo;

import java.math.BigDecimal;

public class Dbquestion {
	
	private String qn_id;
	private BigDecimal q_id;
	private String q_type;
	private String q_stem;
	private String q_des;
	private BigDecimal q_item_count;
	
	public String getQn_id() {
		return qn_id;
	}
	
	public void setQn_id(String qn_id) {
		this.qn_id = qn_id;
	}
	
	public BigDecimal getQ_id() {
		return q_id;
	}
	
	public void setQ_id(BigDecimal q_id) {
		this.q_id = q_id;
	}
	
	public String getQ_type() {
		return q_type;
	}
	
	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}
	
	public String getQ_stem() {
		return q_stem;
	}
	
	public void setQ_stem(String q_stem) {
		this.q_stem = q_stem;
	}
	
	public String getQ_des() {
		return q_des;
	}
	
	public void setQ_des(String q_des) {
		this.q_des = q_des;
	}
	
	public BigDecimal getQ_item_count() {
		return q_item_count;
	}
	
	public void setQ_item_count(BigDecimal q_item_count) {
		this.q_item_count = q_item_count;
	}
	
}
