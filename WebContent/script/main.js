;(function () {

	'use strict';



	// iPad and iPod detection
	var isiPad = function(){
		return (navigator.platform.indexOf("iPad") != -1);
	};

	var isiPhone = function(){
	    return (
			(navigator.platform.indexOf("iPhone") != -1) ||
			(navigator.platform.indexOf("iPod") != -1)
	    );
	};

	// Parallax
	var parallax = function() {
		$(window).stellar();
	};



	// Burger Menu
	var burgerMenu = function() {

		$('body').on('click', '.js-fh5co-nav-toggle', function(event){

			event.preventDefault();

			if ( $('#navbar').is(':visible') ) {
				$(this).removeClass('active');
			} else {
				$(this).addClass('active');
			}



		});

	};


	var goToTop = function() {

		$('.js-gotop').on('click', function(event){

			event.preventDefault();

			$('html, body').animate({
				scrollTop: $('html').offset().top
			}, 500);

			return false;
		});

	};


	// Page Nav
	var clickMenu = function() {

		$('#navbar a:not([class="external"])').click(function(event){
			var section = $(this).data('nav-section'),
				navbar = $('#navbar');

				if ( $('[data-section="' + section + '"]').length ) {
			    	$('html, body').animate({
			        	scrollTop: $('[data-section="' + section + '"]').offset().top
			    	}, 500);
			   }

		    if ( navbar.is(':visible')) {
		    	navbar.removeClass('in');
		    	navbar.attr('aria-expanded', 'false');
		    	$('.js-fh5co-nav-toggle').removeClass('active');
		    }

		    event.preventDefault();
		    return false;
		});


	};

	// Reflect scrolling in navigation
	var navActive = function(section) {

		var $el = $('#navbar > ul');
		$el.find('li').removeClass('active');
		$el.each(function(){
			$(this).find('a[data-nav-section="'+section+'"]').closest('li').addClass('active');
		});

	};

	var navigationSection = function() {

		var $section = $('section[data-section]');

		$section.waypoint(function(direction) {

		  	if (direction === 'down') {
		    	navActive($(this.element).data('section'));
		  	}
		}, {
	  		offset: '150px'
		});

		$section.waypoint(function(direction) {
		  	if (direction === 'up') {
		    	navActive($(this.element).data('section'));
		  	}
		}, {
		  	offset: function() { return -$(this.element).height() + 155; }
		});

	};





	// Window Scroll
	var windowScroll = function() {
		var lastScrollTop = 0;

		$(window).scroll(function(event){

		   	var header = $('#fh5co-header'),
				scrlTop = $(this).scrollTop();

			if ( scrlTop > 500 && scrlTop <= 2000 ) {
				header.addClass('navbar-fixed-top fh5co-animated slideInDown');
			} else if ( scrlTop <= 500) {
				if ( header.hasClass('navbar-fixed-top') ) {
					header.addClass('navbar-fixed-top fh5co-animated slideOutUp');
					setTimeout(function(){
						header.removeClass('navbar-fixed-top fh5co-animated slideInDown slideOutUp');
					}, 100 );
				}
			}

		});
	};



	// Animations

	var contentWayPoint = function() {
		var i = 0;
		$('.animate-box').waypoint( function( direction ) {

			if( direction === 'down' && !$(this.element).hasClass('animated') ) {

				i++;

				$(this.element).addClass('item-animate');
				setTimeout(function(){

					$('body .animate-box.item-animate').each(function(k){
						var el = $(this);
						setTimeout( function () {
							el.addClass('fadeInUp animated');
							el.removeClass('item-animate');
						},  k * 200, 'easeInOutExpo' );
					});

				}, 100);

			}

		} , { offset: '85%' } );
	};

    // Document on load.
	$(function(){

		contentWayPoint();

	});


}());
/****************************基础函数*******************************/
function addLoadEvent(func) {
    var oldonload = window.onload;
    if (typeof window.onload != 'function') {
        window.onload = func;
    } else {
        window.onload = function() {
            oldonload();
            func();
        }
    }
}

function insertAfter(newElement,targetElement) {
    var parent = targetElement.parentNode;
    if (parent.lastChild == targetElement) {
        parent.appendChild(newElement);
    } else {
        parent.insertBefore(newElement,targetElement.nextSibling);
    }
}
/*************************************index.html****************************/
function prepareClick()
{
    var links = document.getElementsByClassName("modal-btn");
    for(var i = 0; i < links.length; ++i){
        links[i].onclick = function(){
            $('#login').modal('hide');
            $('#register').modal('hide');
            $('#charge').modal('hide')
            return false;
        }
    }

}
addLoadEvent(prepareClick);

/**************************basicInfo.html*******************************/
function editUserInfo(type)
{
    var infoForm = document.getElementById("b-info");
    var inputItem = infoForm.getElementsByTagName("input");
    for(var i = 0;i < inputItem.length; ++ i) {
        if(type == true) {
            inputItem[i].disabled = "";
            inputItem[i].style.border = "solid #1ABC9C 1px";
        }
        else{
            inputItem[i].disabled = "disabled";
            inputItem[i].style.border = "none";
        }
    }
    var btn = infoForm.getElementsByTagName("button")[0];
    if(type == true)
    {
        btn.innerText = "确定";
        btn.setAttribute("class", "btn btn-success");
        btn.onclick = function(){
            editUserInfo(false);
            location.href += "confirm";   
        }
    }
    else{
        btn.innerText = "修改";
        btn.setAttribute("class", "btn btn-warning");
        btn.onclick = function(){
            editUserInfo(true);
        }
    }
}
/********************************creatingQuestionnaire.html*******************************************/
var is_click = false;
var is_a_click = false;
var txtNode;
var tagdiv;
//选择类型
function onClickType(btn) {
    if(btn.is_click == "false" && is_click == false){
        //改变button的样式
        btn.is_click = "true"
        is_click = true;
        btn.style.backgroundColor = "#f0735a";
        //增添标签
        var question = document.getElementById("type-title");
        txtNode = document.createTextNode(btn.innerText);
        question.appendChild(txtNode);

        tagdiv = document.createElement("form");
        tagdiv.setAttribute("action", "CreateQuestionnaire_authority");///
        tagdiv.setAttribute("method", "post");///
        var type = document.createElement("input");///
        type.setAttribute("type", "hidden");///
        type.setAttribute("name", "type");///
        type.setAttribute("value", btn.innerText);///
        var tag = document.createElement("input");
        tag.setAttribute("placeholder", "为您的问卷添加一个tag，说明其内容吧^_^");
        tag.setAttribute("class", "tag");
        tag.setAttribute("name", "tag");///
        var submit = document.createElement("button");
        submit.setAttribute("class", "btn btn-success");
        submit.setAttribute("id", "tag-btn");
        submit.setAttribute("type", "submit");///
        submit.appendChild(document.createTextNode("提交"));
        tagdiv.appendChild(type);///
        tagdiv.appendChild(tag);
        tagdiv.appendChild(submit);
        insertAfter(tagdiv, question);
    }
    else if(is_click == true && btn.is_click == "true"){
        btn.is_click = "false";
        btn.style.backgroundColor = "white";
        is_click = false;

        var question = document.getElementById("type-title");
        question.parentNode.removeChild(tagdiv);
        question.removeChild(txtNode);
        //取消链接
        var first_link = document.getElementsByClassName("first-link");
        for(var i = 0;i < first_link.length; ++ i){
            first_link[i].setAttribute("href", "#");
        }
    }
}

function prepareClickType(){
    if(document.getElementsByClassName("qtype") == null) return;
    var qtype = document.getElementsByClassName("qtype");
    var links = [];
    for(var j = 0;j < qtype.length; ++ j){
        var row = qtype[j].getElementsByTagName("button");
        for(var k = 0; k < row.length; ++ k){
            links[links.length] = row[k];
        }
    }
    if(links == null) return false;

    for(var i = 0;i < links.length; ++ i){
        links[i].is_click = "false";
        links[i].onclick = function() {
            onClickType(this);
        };
        links[i].onkeypress = links[i].onclick;
    }
}
//选择权限
function onClickAuthority(btn){
    if(btn.is_click == "false" && is_a_click == false){
        btn.is_click = "true";
        is_a_click = true;
        var question = document.getElementById("type-title");
        txtNode = document.createTextNode(btn.innerText);
        question.appendChild(txtNode);
        document.getElementById("form-authority").setAttribute("value", btn.innerText);///
    }
    else if(is_a_click == true && btn.is_click == "true"){
        btn.is_click = "false";
        is_a_click = false;
        var question = document.getElementById("type-title");
        question.removeChild(txtNode);
        document.getElementById("form-authority").setAttribute("value", "");///
    }
}
function prepareClickAuthority(){
    var links = [];
    if(document.getElementById("public-authority") == null || document.getElementById("private-authority") == null) return;
    var pub = document.getElementById("public-authority").getElementsByTagName("button")[0];
    var pri = document.getElementById("private-authority").getElementsByTagName("button")[0];
    links[0] = pub;
    links[1] = pri;
    for(var i = 0; i < links.length; ++ i){
        links[i].is_click = "false";
        links[i].onclick = function(){
            onClickAuthority(this);
        };
        links[i].onkeypress = links[i].onclick;
    }
}
//For the page which to choose the friends
function prepareClickAdd(){
    var fadd = [];
    if(document.getElementById("friend-list") == null) return;
    var fadd = document.getElementById("friend-list").getElementsByTagName("button");

    for(var i = 0; i < fadd.length; ++ i){
        fadd[i].onclick = function(){
            onClickAdd(this);
        }
    }
}
addLoadEvent(prepareClickAuthority);
addLoadEvent(prepareClickType);
/*************************creatingQuestionnaire4.html****************************************/
var cpeople = [];
function assignJson(name, is_add){
    var chose = document.getElementById("people_chose");
    if(is_add == true){
        cpeople.push(name);
    }
    else{
        var i = 0;
        var temp = [];
        for( ;i < cpeople.length; ++ i) {
            if (cpeople[i] == name) {
                break;
            }
            else temp[i] = cpeople[i];
        }
        for(;i < cpeople.length - 1; ++ i){
            temp[i] = cpeople[i + 1];
        }
        cpeople = temp;
    }
    var arrString = "[";
    for(var i = 0; i < cpeople.length; ++ i){
        if(i != cpeople.length - 1) arrString += '"' + cpeople[i] + '"' +  ",";
        else arrString += '"' + cpeople[i] + '"';
    }
    arrString += "]";
    var jsonString = arrString;//JSON.stringify(arrString);
    alert(jsonString);
    chose.value = jsonString;
}
function onClickAdd(btn){
    //开头进行判断
    if(btn.is_click == "true") return;
    else btn.is_click = "true";

    var txt = btn.parentNode.innerText;
    var chose = document.createElement("span");
    var pdiv = document.getElementById("choose");

    txt = txt.substring(0, txt.length - 4);
    var txtNode = document.createTextNode(txt);
    assignJson(txt, true);

    chose.setAttribute("class", "btn btn-default chose");
    chose.appendChild(txtNode);
    chose.onclick = function(){
        assignJson(txt, false);
        btn.is_click = "false";
        onClickChose(this);
    }
    insertAfter(chose, pdiv.lastElementChild);
}
function onClickChose(btn){
    var pdiv = document.getElementById("choose");
    pdiv.removeChild(btn);
}
addLoadEvent(prepareClickAdd);

/*************************constructingQuestionnaire.html**************************************/
//让sidebar随着滚动条一起滚动
$(document).scroll(function (){

    //固定SideBar
    if ($(document).scrollTop() > '180') {
        $('#questionType').offset({top:$(document).scrollTop()+10});
    }else if($(document).scrollTop() <= '180') {
        $('#questionType').offset({top:191});
    };

});
//逻辑设置
function setLogic(item){

}
//复制
function questionCopy(item){
    var out = item.parentNode.parentNode.parentNode;
    if(out == null) return;
    var copy = out.cloneNode(true);
    var qorder = copy.getElementsByClassName("qorder")[0];
    qorder.innerText = question_num;
    var li_list = copy.getElementsByTagName("li");
    bindHandle(li_list);
    insertAfter(copy, out);
    var order_list = questionnaire.getElementsByClassName("qorder");
    if(order_list == null) return;
    for(var i = 0;i < order_list.length; ++ i){
        order_list[i].innerText = i + 1;
    }
}
//绑定操作
function bindHandle(li_list)
{
    if(li_list == null ) return;
    li_list[0].onclick = function(){
        questionUp(this, true);
    }
    li_list[1].onclick = function(){
        questionUp(this, false);
    }
    li_list[2].onclick = function(){
        setLogic(this);
    };
    li_list[3].onclick = function(){
        ++ question_num;
        questionCopy(this);
    };
    li_list[4].onclick = function(){
        -- question_num;
        questionDelete(this);
    };
}
//删除
function questionDelete(item){
    var out = item.parentNode.parentNode.parentNode;
    if(out == null) return;
    var questionnaire = document.getElementById("questionnaire");
    questionnaire.removeChild(out);

    var order_list = questionnaire.getElementsByClassName("qorder");
    if(order_list == null) return;
    for(var i = 0;i < order_list.length; ++ i){
        order_list[i].innerText = i + 1;
    }
}
//增加问题
var question_num = 0;
function prepareQuestionType() {
    var single = document.getElementById("single");
    var multiple = document.getElementById("multiple");
    var qanda = document.getElementById("qanda");
    var preview = document.getElementById("preview");
    if (single == null || multiple == null || qanda == null) return;
    single.onclick = function () {
        ++ question_num;
        onClickSingle_Mulitple(true);
    };
    multiple.onclick = function () {
        ++ question_num;
        onClickSingle_Mulitple(false);
    };
    qanda.onclick = function () {
        ++ question_num;
        onClickQandA();
    };
    preview.onclick = function(){
        onClickPreview();
    }
}
addLoadEvent(prepareQuestionType);

//增加单选题或者多选题
function onClickSingle_Mulitple(is_single){
    var questionnaire = document.getElementById("questionnaire");
    if(questionnaire == null) return;

    var out = document.createElement("div");
    if(is_single == true) {
        out.setAttribute("class", "qnaire-out qnaire-single-question");
    }
    else{
        out.setAttribute("class", "qnaire-out qnaire-multiple-question");
    }
    var inside = document.createElement("div");
    inside.setAttribute("class", "qnaire-out-inside");

    var order = document.createElement("span");
    order.setAttribute("class", "qorder");
    order.appendChild(document.createTextNode(question_num));

    var title = document.createElement("div");
    title.setAttribute("contenteditable", "true");
    title.setAttribute("class", "qnaire qnaire-title");
    if(is_single == true) {
        title.appendChild(document.createTextNode("这是一个单选题"));
    }
    else {
        title.appendChild(document.createTextNode("这是一个多选题"));
    }
    var add = document.createElement("div");
    add.setAttribute("class", "add");
    var sign = document.createElement("span");
    if(is_single == true) {
        sign.onclick = function () {
            addOption(this, true);
        };
    }
    else{
        sign.onclick = function () {
            addOption(this, false);
        };
    }
    var operate = document.createElement("div");
    operate.setAttribute("class", "operate");
    var unorder = document.createElement("ul");
    var li_list = [];
    for(var i = 0; i < 5; ++ i){
        li_list[i] = document.createElement("li");
        unorder.appendChild(li_list[i]);
    }
    li_list[0].setAttribute("class", "question-up");
    li_list[0].setAttribute("title", "上移题目");

    li_list[1].setAttribute("class", "question-down");
    li_list[1].setAttribute("title", "下移题目");

    li_list[2].setAttribute("class", "set-logic");
    li_list[2].setAttribute("title", "逻辑设置");

    li_list[3].setAttribute("class", "question-copy");
    li_list[3].setAttribute("title", "复制");

    li_list[4].setAttribute("class", "question-delete");
    li_list[4].setAttribute("title", "删除");
    bindHandle(li_list);

    operate.appendChild(unorder);
    add.appendChild(sign);
    inside.appendChild(order);
    inside.appendChild(title);
    out.appendChild(inside);
    out.appendChild(add);
    out.appendChild(operate);
    questionnaire.appendChild(out);
    sign.onclick();
    sign.onclick();
}
//增加选择题选项
function addOption(btn, is_single){
    var option_out = document.createElement("div");
    var input = document.createElement("input");
    var option = document.createElement("div");
    var txtNode = document.createTextNode("新选项");

    option_out.setAttribute("class", "qnaire-out-inside");
    if(is_single == true) {
        input.setAttribute("type", "radio");
        input.setAttribute("name", "radio");
    }
    else{
        input.setAttribute("type", "checkbox");
        input.setAttribute("name", "checkbox");
    }
    option.setAttribute("class", "qnaire qnaire-option");
    option.setAttribute("contenteditable", "true");
    option.appendChild(txtNode);
    option_out.appendChild(input);
    option_out.appendChild(option);
    insertAfter(option_out, btn.parentNode.previousElementSibling);
}


//问答题
function onClickQandA(){
    var questionnaire = document.getElementById("questionnaire");
    if(questionnaire == null) return;

    var out = document.createElement("div");
    out.setAttribute("class", "qnaire-out qnaire-qanda-question");

    var inside = document.createElement("div");
    inside.setAttribute("class", "qnaire-out-inside");

    var order = document.createElement("span");
    order.setAttribute("class", "qorder");
    order.appendChild(document.createTextNode(question_num));

    var title = document.createElement("div");
    title.setAttribute("contenteditable", "true");
    title.setAttribute("class", "qnaire qnaire-title");
    title.appendChild(document.createTextNode("这是一个问答题"));

    var content = document.createElement("div");
    content.setAttribute("class", "qnaire-out-inside");
    var content_inside = document.createElement("div");
    content_inside.setAttribute("class", "qnaire qnaire-content");
    content_inside.setAttribute("contenteditable", "true");
    content.appendChild(content_inside);

    var add = document.createElement("div");
    add.setAttribute("class", "pse-add");
    var sign = document.createElement("span");

    var operate = document.createElement("div");
    operate.setAttribute("class", "operate");
    var unorder = document.createElement("ul");
    var li_list = [];
    for(var i = 0; i < 5; ++ i){
        li_list[i] = document.createElement("li");
        unorder.appendChild(li_list[i]);
    }
    li_list[0].setAttribute("class", "question-up");
    li_list[0].setAttribute("title", "上移题目");

    li_list[1].setAttribute("class", "question-down");
    li_list[1].setAttribute("title", "下移题目");

    li_list[2].setAttribute("class", "set-logic");
    li_list[2].setAttribute("title", "逻辑设置");

    li_list[3].setAttribute("class", "question-copy");
    li_list[3].setAttribute("title", "复制");

    li_list[4].setAttribute("class", "question-delete");
    li_list[4].setAttribute("title", "删除");
    bindHandle(li_list);

    operate.appendChild(unorder);
    add.appendChild(sign);
    inside.appendChild(order);
    inside.appendChild(title);
    out.appendChild(inside);
    out.appendChild(content);
    out.appendChild(add);
    out.appendChild(operate);
    questionnaire.appendChild(out);
}
//预览页面
function onClickPrview(){

}
//上移和下移题目
function questionUp(btn, is_up){
    var question = btn.parentNode.parentNode.parentNode;
    if(question == null) return;
    var out = question.parentNode;
    if (is_up == true) {
        var prev = question.previousElementSibling;
        if (prev.getAttribute("class") == "qnaire-out qnaire-des") return;

        prev = prev.previousElementSibling;
        out.removeChild(question);
        insertAfter(question, prev);
    }
    else{
        var next = question.nextElementSibling;
        if(next == null) return;
        out.removeChild(question);
        insertAfter(question, next);
    }
    var order_list = out.getElementsByClassName("qorder");
    for(var i = 0; i < order_list.length; ++ i){
        order_list[i].innerText = i + 1;
    }
}

























