<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, vo.*, dao.*" %>
<%!
ArrayList<ExDbquestion> exQList = null;
%>
<%
HttpSession httpSession = request.getSession(true);
exQList = (ArrayList<ExDbquestion>) httpSession.getAttribute("exQListSearch");
%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>searchQuestion</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="script/global.js"></script>
    <script type="text/javascript" src="script/jquery.page.js"></script>
    <link rel="stylesheet" href="style/style.css"/>
    <link rel="stylesheet" href="style/search.css">
</head>

<div class="box-wrap">
    <header role="banner" id="fh5co-header">
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="row">
                    <div class="col-md-3">
                        <div class="fh5co-navbar-brand">
                            <span class="logo"><a href="index.html">Vote&Voice</a></span>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <ul class="nav text-center">
                            <li class="active"><a href="index.html"><span>主页</span></a></li>
                            <li><a href="#">填问卷</a></li>
                            <li><a href="#">建问卷</a></li>
                            <li><a href="#">搜问卷</a></li>
                        </ul>
                    </div>
                    <div class="col-md-3">
                        <ul class="social">
                            <li><a data-toggle="modal" data-target="#register"><span
                                    class="glyphicon glyphicon-log-in">注册</span></a>
                            </li>
                            <li><a data-toggle="modal" data-target="#login"><span
                                    class="glyphicon glyphicon-user">登陆</span></a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <!--END: header -->
    <!-- 注册模态框 -->
    <div class="modal face" id="register" tabindex="-1" role="dialog" aria-labelledby="register-title"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="register-title">注册</h4>
                </div>
                <div class="modal-body">
                    <p>This is a test</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dimiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">提交更改</button>
                </div>
            </div><!--modal-content -->
        </div><!-- modal -->
    </div>
    <!-- 登陆模态框 -->
    <div class="modal face" id="login" tabindex="-1" role="dialog" aria-labelledby="login-title" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="login-title">注册</h4>
                </div>
                <div class="modal-body">
                    <p>This is a test</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dimiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary">提交更改</button>
                </div>
            </div><!--modal-content -->
        </div><!-- modal -->
    </div>

    <div class="container">
        <!-- 搜索栏 -->
        <div class="row">
            <div class="col-md-12 col-sm-12 column">
                <div class="search">
                    <form action="SearchQuestion" name="searchform"  id="searchform" method="post">
                        <input type="text" class="text gray" required placeholder="输入您想填写的问卷关键字" name="key" ID="key_S"/>
                      	<input type="hidden"  name="questionType" id="questionType" >
                      	<input type="hidden"  name="questionnaireType" id="questionnaireType" />
                        <a href="javascript:void(0);" class="del-keywords"></a>
                        <div class="select">
                            <input type="hidden" name="stype" id="stype" value="0"/>
                            <span id="lm">&nbsp;问题</span>
                            <span class="glyphicon glyphicon-chevron-down"></span>
                            <span id="s_all" class="select_pop">
                    		    <a href="searchQuestionnaire.jsp"><span class="qn">&nbsp;问卷</span></a>
                                <a href="searchQuestion.jsp"><span class="q">&nbsp;问题</span></a>
                            </span>
                        </div>
                        <input type="submit" class="sbtn" value="搜索" onclick="getQChosenValue()">
                </form>
                </div>
            </div>
        </div>
        <!-- 主体 -->
        <div class="row">
            <!-- 问卷列表 -->
            <div class="col-md-8 col-sm-8 column">

                <div class="event-page">
                <%
                if(exQList != null) {
                    for(int i = 0; i != exQList.size() && i < 10; i++) {
                %>
                	<div class="row">
                        <div class="row row-list">
                            <div class="col-xs-9 col-sm-9 question-list">
                                <h2><a href="#" id="q_stem"><%=exQList.get(i).get_transQuestion().get_transQ_stem() %></a></h2>
                            </div>
                            <div class="col-xs-3 col-sm-3">
                            <%
                            String q_type = exQList.get(i).get_transQuestion().get_transQ_type();
                            if(q_type.equals("单选")) {
                            %>
                            <h3><span class="label label-success" id="q_type">单选题</span></h3>
                            <%	
                            }
                            else if(q_type.equals("多选")) {
                            %>
                            <h3><span class="label label-warning" id="q_type">多选题</span></h3>
                            <%	
                            }
                            else if(q_type.equals("问答")) {
                            %>
                            <h3><span class="label label-primary" id="q_type">问答题</span></h3>
                            <%	
                            }
                            %>
                            </div>
                        </div>
                        <div class="row row-list">
                            <div class="ol-xs-12 col-sm-12 question-list" style="bottom:15px">
                                <p><strong>所属问卷 : &nbsp;</strong><%=exQList.get(i).get_transQn_title() %></p>
                            </div>
                        </div>
                    </div>
				<%	
                    }
                }
                %>
                </div>

                <div id="page"></div>
                <script type="text/javascript">
                    $(function () {
                        $("#page").Page({
                            totalPages: 11,//分页总数
                            liNums: 5,//分页的数字按钮数(建议取奇数)
                            activeClass: 'activP', //active 类样式定义
                            callBack: function (page) {
                            }
                        });
                    })
                </script>
            </div>
            <!-- 功能栏 -->
            <div class="col-md-4 col-sm-4 column">
                <div class="select-box">
                    <form>
                        <div class="select-block">
                            <span class="select-title">题目类型：</span>
                            <select>
                            	<option value="全部">全部</option> 
                                <option value="单选题">单选题</option>
                                <option value="多选题">多选题</option>
                                <option value="问答题">问答题</option>
                            </select>
                        </div>
                        <!-- select-block -->
                        <div class="select-block">
                            <span class="select-title">问卷所属类型：</span>
                            <select>
                            	<option value="全部">全部</option>
                                <option value="文化">文化</option>
                                <option value="教育">教育</option>
                                <option value="旅游">旅游</option>
                                <option value="法律">法律</option>
                                <option value="生活">生活</option>
                                <option value="科技">科技</option>
                                <option value="艺术">艺术</option>
                                <option value="政治">政治</option>
                                <option value="娱乐">娱乐</option>
                                <option value="商业">商业</option>
                                <option value="体育">体育</option>
                                <option value="健康">健康</option>
                                <option value="其他">其他</option>
                            </select>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>

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
</body>
</html>