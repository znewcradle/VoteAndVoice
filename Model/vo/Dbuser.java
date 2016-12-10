package vo;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbuser {
	
	private String u_id;
	private String u_pwd;
	private BigDecimal v_exp;
	private BigDecimal v_level;
	private BigDecimal v_coin;
	private String u_validity;
	private String u_name;
	private String u_gender;
	private String u_phone;
	private String u_ad_country;
	private String u_ad_province;
	private String u_ad_city;
	private String u_ad_street;
	
	public String getU_id() {
		return u_id;
	}
	
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	
	public String getU_pwd() {
		return u_pwd;
	}
	
	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	
	public BigDecimal getV_exp() {
		return v_exp;
	}
	
	public void setV_exp(BigDecimal v_exp) {
		this.v_exp = v_exp;
	}
	
	public BigDecimal getV_level() {
		return v_level;
	}
	
	public void setV_level(BigDecimal v_level) {
		this.v_level = v_level;
	}
	
	public BigDecimal getV_coin() {
		return v_coin;
	}
	
	public void setV_coin(BigDecimal v_coin) {
		this.v_coin = v_coin;
	}
	
	public String getU_validity() {
		return u_validity;
	}
	
	public void setU_validity(String u_validity) {
		this.u_validity = u_validity;
	}
	
	public String getU_name() {
		return u_name;
	}
	
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	
	public String getU_gender() {
		return u_gender;
	}
	
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	
	public String getU_phone() {
		return u_phone;
	}
	
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	
	public String getU_ad_country() {
		return u_ad_country;
	}
	
	public void setU_ad_country(String u_ad_country) {
		this.u_ad_country = u_ad_country;
	}
	
	public String getU_ad_province() {
		return u_ad_province;
	}
	
	public void setU_ad_province(String u_ad_province) {
		this.u_ad_province = u_ad_province;
	}
	
	public String getU_ad_city() {
		return u_ad_city;
	}
	
	public void setU_ad_city(String u_ad_city) {
		this.u_ad_city = u_ad_city;
	}
	
	public String getU_ad_street() {
		return u_ad_street;
	}
	
	public void setU_ad_street(String u_ad_street) {
		this.u_ad_street = u_ad_street;
	}

	public void setAll(ResultSet rs) throws SQLException{
		try {
			this.setU_id(rs.getString("u_id"));
			this.setU_pwd(rs.getString("u_pwd"));
			this.setV_exp(rs.getBigDecimal("v_exp"));
			this.setV_level(rs.getBigDecimal("v_level"));
			this.setV_coin(rs.getBigDecimal("v_coin"));
			this.setU_validity(rs.getString("u_validity"));
			this.setU_name(rs.getString("u_name"));
			this.setU_gender(rs.getString("u_gender"));
			this.setU_phone(rs.getString("u_phone"));
			this.setU_ad_country(rs.getString("u_ad_country"));
			this.setU_ad_province(rs.getString("u_ad_province"));
			this.setU_ad_city(rs.getString("u_ad_city"));
			this.setU_ad_street(rs.getString("u_ad_street"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
