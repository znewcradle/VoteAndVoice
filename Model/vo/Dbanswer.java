package vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Dbanswer {
	
	private String u_id;
	private String qn_id;
	private BigDecimal q_id;
	private BigDecimal i_id;
	private Timestamp a_timestamp;
	private String a_content;
	
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
	
	public BigDecimal getQ_id() {
		return q_id;
	}
	
	public void setQ_id(BigDecimal q_id) {
		this.q_id = q_id;
	}
	
	public BigDecimal getI_id() {
		return i_id;
	}
	
	public void setI_id(BigDecimal i_id) {
		this.i_id = i_id;
	}
	
	public Timestamp getA_timestamp() {
		return a_timestamp;
	}
	
	public void setA_timestamp(Timestamp a_timestamp) {
		this.a_timestamp = a_timestamp;
	}
	
	public String getA_content() {
		return a_content;
	}
	
	public void setA_content(String a_content) {
		this.a_content = a_content;
	}

}
