package vo;

public class ExDbquestionnaire {
	private Dbquestionnaire questionnaire = new Dbquestionnaire();
	private String s_name;
	
	public Dbquestionnaire getQuestionnaire() {
		return questionnaire;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}	
}
