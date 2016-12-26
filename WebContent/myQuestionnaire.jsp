<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@
	page import = "dao.*"
		 import = "vo.*"
		 import = "java.util.*"
 %>
 <%
 	ArrayList<ExDbquestionnaire> myQustionnaireList = (ArrayList<ExDbquestionnaire>)request.getAttribute("myQustionnaireList");
 %>

<%@ include file="mdzz.jsp" %>

            <!-- 页面的主要内容 -->
            <div id="q-content" class="col-md-offset-1 col-md-8">
                <div class="content">
                    <%
                    for (int i = 0; i < myQustionnaireList.size(); ++i)
                    {%>
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <h3 clas="panel-title"><%=myQustionnaireList.get(i).getQuestionnaire().get_transQn_title() %></h3>
                        </div>
                        <div class="panel-body">
                            <%=myQustionnaireList.get(i).get_transS_name() + ' ' + myQustionnaireList.get(i).getQuestionnaire().get_transQn_state() %>
                        </div>
                        <div class="panel-footer"><%=myQustionnaireList.get(i).getQuestionnaire().get_transQn_starttime() %></div>
                    </div>
                    <%}
                    %>
                </div>
            </div>
            <!-- END: 页面的主要内容 -->
        </div>
    </div>
    <!-- END: 页面主要内容 -->

    <footer id="footer" role="contentinfo">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <div class="footer-widget border">
                        <p class="pull-left">
                            <small>&copy;所有权利保留</small>
                        </p>
                        <p class="pull-right">
                            <small>由大尹帝国创建 !!!</small>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- END: footer -->
</div>
<!-- END: box-wrap -->
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
</body>
</html>