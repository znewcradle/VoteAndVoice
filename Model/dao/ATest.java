package dao;

public class ATest {
	public static void main(String args[]) {
		//ChangePwdDAO
		/*int result = DAOFactory.getChangePwdDAO().changePwd("zhz123", "123", "zhz123");
		System.out.println(result);*/
		
		//FollowDAO
		/*int result;
		ArrayList<Dbuser> friendsList = new ArrayList<Dbuser>();
		//result = DAOFactory.getFollowDAO().getFriends("zhz123", friendsList);
		//result = DAOFactory.getFollowDAO().getFollowedUser("zhz123", friendsList);
		result = DAOFactory.getFollowDAO().getFollowingUser("zhz123", friendsList);
		//result = DAOFactory.getFollowDAO().follow("zhz123", "yyf123");
		//result = DAOFactory.getFollowDAO().unfollow("zhz123", "yyf123");
		System.out.println(result);
		System.out.println("size:\t" + friendsList.size());
		for(int i = 0; i != friendsList.size(); i++) {
			System.out.println("No." + i + ":\t" + friendsList.get(i).getU_name());
		}*/
		
		//LoginDAO
		/*int result;
		ArrayList<Dbuser> userList = new ArrayList<Dbuser>();
		result = DAOFactory.getLoginDAO().login("zhz123", "zhz12", userList);
		System.out.println(result + "\nsize:\t" + userList.size());
		if(userList.size() > 0) System.out.println("Pass:\t" + userList.get(0).getU_pwd());*/
		
		//NewsDAO
		/*int result;
		ArrayList<Dbanswer> list = new ArrayList<Dbanswer>();
		result = DAOFactory.getNewsDAO().getAnswersByUId("guest0000", list);
		//ArrayList<ExDbanswer> list = new ArrayList<ExDbanswer>();
		//result = DAOFactory.getNewsDAO().getExAnswersByUId("yyf123", list);
		//ArrayList<Dbquestionnaire> list = new ArrayList<Dbquestionnaire>();
		//result = DAOFactory.getNewsDAO().getQuestionnairesByUId("yyf123", list);
		//ArrayList<ExDbquestionnaire> list = new ArrayList<ExDbquestionnaire>();
		//result = DAOFactory.getNewsDAO().getExQuestionnairesByUId("zhz123", list);
		System.out.println(result + "\nsize:\t" + list.size());
		for(int i = 0; i != list.size(); i++) {
			System.out.println(list.get(0).getA_content() + list.get(0).getA_timestamp());
		}*/
		
		//RegisterDAO
		/*int result;
		Dbuser user = new Dbuser();
		user.setU_id("001");
		user.setU_pwd("123");
		user.setU_name("test");
		user.setU_gender("");
		result = DAOFactory.getRegisterDAO().register(user);
		System.out.println(result);*/
		
		//UserInfoDAO
		/*int result;
		ArrayList<Dbuser> userList = new ArrayList<Dbuser>();
		result = DAOFactory.getUserInfoDAO().getUserInfo("zhz123", userList);
		System.out.println(result);
		if(userList.size()>0)System.out.println(userList.get(0).getU_validity());
		userList.get(0).setU_ad_city("…œ∫£");;
		result = DAOFactory.getUserInfoDAO().changeUserInfo(userList.get(0));
		System.out.println(result);*/
		
		//SearchQnDAO
		/*int result;
		//ArrayList<ExDbquestionnaire> list = new ArrayList<ExDbquestionnaire>();
		//result = DAOFactory.getSearchQnDAO().getExQnsByQnTitle("ti", list);
		//result = DAOFactory.getSearchQnDAO().getExQnsByQnTitleByQnTypeOrTag("ACG", list);
		ArrayList<ExDbquestion> list = new ArrayList<ExDbquestion>();
		result = DAOFactory.getSearchQnDAO().getExQByAStem(" «", list);
		System.out.println(result + "\nsize:\t" + list.size());
		for(int i = 0; i != list.size(); i++) {
			System.out.println(list.get(i).getQn_title() + list.get(i).getQuestion().getQ_stem());
		}*/
	}
}
