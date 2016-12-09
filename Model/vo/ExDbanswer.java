package vo;

public class ExDbanswer {
	private Dbanswer answer = new Dbanswer();
	private String u_name;
	private String qn_title;
	private String q_stem;
	private String i_des;
	
	public Dbanswer getAnswer() {
		return answer;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
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
	public String getI_des() {
		return i_des;
	}
	public void setI_des(String i_des) {
		this.i_des = i_des;
	}
	
}
