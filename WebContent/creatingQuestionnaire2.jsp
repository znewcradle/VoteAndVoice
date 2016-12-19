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
                    <span class="order">1</span>
                    <span class="order"><a href="creatingQuestionnaire2.html">2</a></span>
                    <span class="order-title">选择问卷类型</span>
                    <span class="order">3</span>
                </div>
                <hr/>
                <div>
                    <p class="content-title" id="type-title">您想拥有何种权限呢？--- </p>
                    <div id="public-authority" class="col-md-5">
                        <button type="button" class="btn btn-success col-md-offset-4">公开</button>
                        <hr/>
                        <p>
                            公开问卷的结果将会收录到问卷库中，对平台所有用户开放，感谢您的分享
                        </p>
                    </div>
                    <div id="private-authority" class="col-md-5">
                        <button type="button" class="btn btn-warning col-md-offset-4">私有</button>
                        <hr/>
                        <p>
                            私有问卷的结果仅对您和您选择的好友开放，但是需要消耗一些v币。
                        </p>
                    </div>
                    <div class="col-md-offset-4 col-md-8 next-button">
                        <!-- <a href="#" class="second-link">
                            <button type="button" class="btn btn-primary btn-lg">
                                <span class="glyphicon glyphicon-chevron-right"></span>下一步
                            </button>
                        </a> -->
                        <form action="CreateQuestionnaire_payment" method="post">
                        	<input id="form-authority" type="hidden" name="authority" value="" />
                            <button type="submit" class="btn btn-primary btn-lg">
                                <span class="glyphicon glyphicon-chevron-right"></span>下一步
                            </button>
                        </form>
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