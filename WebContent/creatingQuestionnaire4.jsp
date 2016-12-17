<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*, vo.*, dao.*" %>
<%!
String current_u_id = "yyf123";
ArrayList<Dbuser> followed_users = new ArrayList<Dbuser>();
%>
<%
followed_users.clear();
int message = DAOFactory.getFollowDAO().getAllFollowedUser(current_u_id, followed_users);
if(message < 0) {
	response.getWriter().append("各种失败");
}
else {
%>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Voice&amp;Vote</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- Animate.css -->
    <link rel="stylesheet" href="style/animate.css"/>
    <!-- Icomoon Icon Fonts -->
    <link rel="stylesheet" href="style/icomoon.css"/>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="style/bootstrap.css"/>
    <!-- self-defined main css file -->
    <link rel="stylesheet" href="style/style.css"/>
    <!-- self-defined user-template css file -->
    <link rel="stylesheet" href="style/user.css" />
    <!-- self-defined questionnaire css file -->
    <link rel="stylesheet" href="style/questionnaire.css" />
</head>
<body>
	
<div class="box-wrap">
	<%@ include file="creatingQuestionnaireHeader.jsp" %>
    <!-- 页面主要内容 -->
    <div id="main" class="container">
        <div class="row">
            <div class="col-md-offset-2 col-md-8">
                <div>
                    <span class="order">1</span>
                    <span class="order">2</span>
                    <span class="order">3</span>
                    <span class="order"><a href="#">4</a></span>
                    <span class="order-title">结果分享</span>
                    <span class="order">5</span>
                </div>
                <hr/>
                <div id="share">
                    <div id="choose">
                        <p>(可以通过点击取消结果分享)</p>
                        <span class="btn btn-success chose">只有我</span>
                    </div>
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">选择可以查看您问卷结果的好友：</h3>
                        </div>
                        <ul class="list-group" id="friend-list">
                            <%for(int i = 0; i != followed_users.size(); i++) { %>
                            <li class="list-group-item"><%=followed_users.get(i).get_transU_name() + "#" +  followed_users.get(i).get_transU_id()%>
                                <button type="button" aria-hidden="true" class="close add"><span class="glyphicon glyphicon-plus"></span>Add</button>
                            </li>
                            <%} %>
                        </ul>
                    </div>
                    <!-- <div>
                        <ul class="pagination">
                            <li><a href="#" class="active">&laquo;</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li><a href="#">&raquo;</a></li>
                        </ul>
                    </div> -->
                    <form action="CreateQuestionnaire_main" method="post">
                    <input type="hidden" id="people_chose" name="followed_users" value="[]" />
                    <div class="col-md-offset-4 col-md-8 next-button">
                        <a>
                            <button type="submit" class="btn btn-primary btn-lg">
                                <span class="glyphicon glyphicon-chevron-right"></span>下一步
                            </button>
                        </a>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- END: 页面主要内容 -->
	<%@ include file="creatingQuestionnaireFooter.jsp" %>
</div>
    
</body>

<!-- jQuery -->
<script src="script/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="script/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="script/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="script/jquery.waypoints.min.js"></script>
<!-- Main JS (Do not remove) -->
<script src="script/main.js"></script>
</html>
<%}%>