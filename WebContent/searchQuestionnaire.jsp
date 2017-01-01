<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*, vo.*, dao.*" %>
<%!
ArrayList<ExDbquestionnaire> exQnList = null;
%>
<%
HttpSession httpSession = request.getSession(true);
exQnList = (ArrayList<ExDbquestionnaire>) httpSession.getAttribute("exQnListSearch");
%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>searchQuestion</title>
    <link rel="stylesheet" href="style/bootstrap.css">
    <script src="script/jquery.min.js"></script>
    <script src="script/bootstrap.min.js"></script>
    <script src="script/global.js"></script>
    <script type="text/javascript" src="script/jquery.page.js"></script>
    <link rel="stylesheet" href="style/index.css"/>
    <link rel="stylesheet" href="style/search.css">
    <link rel="stylesheet" href="style/style.css"/>
</head>
<body>

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
                            <li><a data-toggle="modal" data-target="#register"><span class="glyphicon glyphicon-log-in">注册</span></a>
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
                    <form action="SearchQuestionnaire" name="searchform" id="searchform" method="post" >
                        <input type="text" class="text gray" required placeholder="输入您想填写的问卷关键字" name="key" ID="key_S"/>
                        <input type="hidden" name="orderby"  id="orderby" />
                        <input type="hidden" name="totalNum" id="totalNum" />
                        <input type="hidden" name="qType" id="qType" />
                        <input type="hidden" name="collectNum" id="collectNum" />
                        <a href="javascript:void(0);" class="del-keywords"></a>
                        <div class="select">
                            <input type="hidden" name="stype" id="stype" value="0"/>
                            <span id="lm">&nbsp;问卷</span>
                            <span class="glyphicon glyphicon-chevron-down"></span>
                            <span id="s_all" class="select_pop">
                    		    <a href="searchQuestionnaire.jsp"><span class="qn">&nbsp;问卷</span></a>
                                <a href="searchQuestion.jsp"><span class="q">&nbsp;问题</span></a>
                            </span>
                        </div>
                        <input type="submit" class="sbtn" value="搜索" onclick="getChosenValue()">
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
                    if(exQnList != null) {
                        for(int i = 0; i != exQnList.size() && i < 10; i++) {
                    %>
                    <div class="row">
                        <div class="col-xs-3 col-sm-3">
                            <div class="event-img">
                                <a href="#">
                                    <img class="img-responsive" src="images/so_icon.png">
                                </a>
                                <div class="over-image"></div>
                            </div>
                        </div>
                        <div class="col-xs-9 col-sm-9 event-desc">
                            <div class="row">
                                <div class="col-xs-9 col-sm-9">
                                    <h2><a href="#" id="qn_title"><%=exQnList.get(i).get_transQuestionnaire().get_transQn_title() %></a></h2>
                                </div>
                                <div class="col-xs-3 col-sm-3">
                                    <h2><span class="label label-warning"><%=exQnList.get(i).get_transQuestionnaire().get_transQn_state() %></span></h2>
                                </div>
                            </div>
                            <div class="event_right">
                                <div class="event-info-middle">
                                    <p><strong>描述: &nbsp;</strong><%=exQnList.get(i).get_transQuestionnaire().get_transQn_des() %></p>
                                    <p style="display:inline;"><strong>类型 :&nbsp;</strong></p>
                                    <ul class="event-speakers" style="display:inline">
                                        <li><a href="#" class="link-font"><%=exQnList.get(i).get_transQuestionnaire().get_transQn_type() %></a></li>
                                        <li><p><%=exQnList.get(i).get_transQuestionnaire().get_transQn_tag() %></p></li>
                                    </ul>
                                    <p><strong>问题数量 : &nbsp;</strong><%=exQnList.get(i).get_transQuestionnaire().get_transQn_q_count() %>个</p>
                                    <p style="margin-top: 4px"><strong>收集数量 : &nbsp;</strong><%=exQnList.get(i).get_transQuestionnaire().get_transQn_a_count() %>份</p>
                                </div>
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
                    		<span class="select-title">排序</span>
                    		<select>
                    			<option value="默认">默认</option>
                    			<option value="最近开始">最近开始</option>
                    			<option value="最近结束">最近结束</option>
                    			<option value="最多问题">最多问题</option>
                    			<option value="最少问题">最少问题</option>
                    			<option value="最多回答">最多回答</option>
                    		</select>
                    	</div>
                        <div class="select-block">
                            <span class="select-title">问题数量</span>
                            <select>
                            	<option value="全部">全部</option>
                                <option value="1-10">1-10</option>
                                <option value="11-20">11-20</option>
                                <option value="21-30">21-30</option>
                                <option value="30-more">30-more</option>
                            </select>
                        </div>
                        <!-- select-block -->
                        <div class="select-block">
                            <span class="select-title">问卷所属类型</span>
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
                        <div class="select-block">
                            <span class="select-title">收集数量：</span>
                            <select>
                            	<option value="默认">全部</option>
                                <option value="0-100">0-100</option>
                                <option value="101-500">101-500</option>
                                <option value="501-1000">501-1000</option>
                                <option value="1000-more">1000-more</option>
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