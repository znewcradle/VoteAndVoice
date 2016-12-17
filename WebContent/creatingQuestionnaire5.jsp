<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
                    <span class="order">4</span>
                    <span class="order"><a href="#">5</a></span>
                    <span class="order-title">创建成功</span>
                </div>
                <hr/>
                <div id="success">
                    <section id="work">
                        <div class="fh5co-grid animate-box" style="background-image: url(images/cheer2.jpg);">
                            <a class="image-popup text-center" href="constructingQuestionnaire.html">
                                <div class="work-title">
                                    <h3>现在开始创建您的问卷吧^_^</h3>
                                </div>
                            </a>
                        </div>
                    </section>
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