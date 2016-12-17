<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
                    <span class="order"><a href="creatingQuestionnaire1.html">1</a></span>
                    <span class="order-title">选择问卷类型</span>
                    <span class="order">2</span>
                    <span class="order">3</span>
                </div>
                <hr/>
                <div>
                    <p class="content-title" id="type-title">您想创建哪种问卷呢？--- </p>
                    <div  class="btn-group-lg qtype">
                        <button type="button" class="btn btn-default">文化</button>
                        <button type="button" class="btn btn-default">教育</button>
                        <button type="button" class="btn btn-default">旅游</button>
                        <button type="button" class="btn btn-default">法律</button>
                        <button type="button" class="btn btn-default">生活</button>
                    </div>
                    <div class="btn-group-lg qtype">
                        <button type="button" class="btn btn-default">科技</button>
                        <button type="button" class="btn btn-default">艺术</button>
                        <button type="button" class="btn btn-default">政治</button>
                        <button type="button" class="btn btn-default">娱乐</button>
                        <button type="button" class="btn btn-default">商业</button>
                    </div>
                    <div class="btn-group-lg qtype">
                        <button type="button" class="btn btn-default">体育</button>
                        <button type="button" class="btn btn-default">健康</button>
                        <button type="button" class="btn btn-default">其他</button>
                    </div>
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