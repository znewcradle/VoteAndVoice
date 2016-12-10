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
		result = DAOFactory.getUserInfoDAO().getUserInfoByName("张", userList, -1);
		System.out.println(result);
		if(userList.size()>0)System.out.println(userList.get(0).getU_validity());
		userList.get(0).setU_ad_country("China");
		result = DAOFactory.getUserInfoDAO().changeUserInfo(userList.get(0));
		System.out.println(result);*/
		
		//SearchQnDAO
		/*int result;
		ArrayList<ExDbquestionnaire> list = new ArrayList<ExDbquestionnaire>();
		//result = DAOFactory.getSearchQnDAO().getExQnsByQnTitle("ti", list, -1);
		result = DAOFactory.getSearchQnDAO().getExQnsByQnTitleByQnTypeOrTag("ACG", list, -1);
		//ArrayList<ExDbquestion> list = new ArrayList<ExDbquestion>();
		//result = DAOFactory.getSearchQnDAO().getExQByAStem("是", list, -1);
		System.out.println(result + "\nsize:\t" + list.size());
		for(int i = 0; i != list.size(); i++) {
			System.out.println(list.get(i).getS_name() + list.get(i).getQuestionnaire().getQn_title());
		}*/
		
		//CreateQnDAO
		/*int result;
		ArrayList<Dbquestionnairetype> qnTypeList = new ArrayList<Dbquestionnairetype>();
		result = DAOFactory.getCreateQnDAO().getQnTypes(qnTypeList);
		System.out.println(result + "\nsize:\t" + qnTypeList.size());
		for(int i = 0; i != qnTypeList.size(); i++)
			System.out.println(qnTypeList.get(i).getQn_type_name());
		ExDbquestionnaire exQn = new ExDbquestionnaire();
		exQn.getQuestionnaire().setQn_id("00000000000000000010");
		exQn.getQuestionnaire().setS_id("yyf123");
		exQn.getQuestionnaire().setQn_title("大学生读书时间调查");
		exQn.getQuestionnaire().setQn_des("读书使人进步");
		exQn.getQuestionnaire().setQn_type("文化");
		exQn.getQuestionnaire().setQn_tag("ACG");
		exQn.getQuestionnaire().setQn_authority("pri");
		exQn.getQuestionnaire().setQn_endtime(Timestamp.valueOf("2017-12-10 03:06:15"));
		//result = DAOFactory.getCreateQnDAO().createQn(exQn.getQuestionnaire());
		//result = DAOFactory.getCreateQnDAO().setVCoin("yyf123", 100);
		for(int i = 0; i != 2; i++) {
			ExDbquestion exQ = new ExDbquestion();
			exQ.getQuestion().setQ_stem("测试题目");
			exQ.getQuestion().setQ_des("测试描述");
			exQ.getQuestion().setQ_type("sig");
			for(int j = 0; j != 3; j++) {
				ExDbitem exI = new ExDbitem();
				exI.getItem().setI_type("sig");
				exI.getItem().setI_des("测试选项");
				exQ.getExItemList().add(exI);
			}
			exQn.getExQuestionList().add(exQ);
		}
		result = DAOFactory.getCreateQnDAO().createQsIs(exQn);
		ArrayList<Dbown> ownList = new ArrayList<Dbown>();
		for(int i = 0; i != 3; i++) {
			Dbown own = new Dbown();
			own.setQn_id("00000000000000000002");
			ownList.add(own);
		}
		ownList.get(0).setU_id("zhz123");
		ownList.get(1).setU_id("bty123");
		ownList.get(2).setU_id("xyj123");
		result = DAOFactory.getCreateQnDAO().createOwnList(ownList);
		System.out.println(result);*/
	}
}
