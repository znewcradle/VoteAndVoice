/**
 * Created by Xu on 2016/11/26.
 */
/****************************This is  for the user.html *****************************************/
function insertAfter(newElement,targetElement) {
    var parent = targetElement.parentNode;
    if (parent.lastChild == targetElement) {
        parent.appendChild(newElement);
    } else {
        parent.insertBefore(newElement,targetElement.nextSibling);
    }
}
function toggle(){
	var friend = document.getElementById("friends-management");
	var cName = "list-group-item";
	var list = [];
	var linkList = [];
	var text = ["最新动态", "我的关注", "我的好友", "关注我的", "搜索好友"];
    var textNode  = [];

	for(var i = 0; i < 5; ++ i){
		list[i] = document.createElement("li");
		list[i].setAttribute("class", cName);
        textNode[i] = document.createTextNode(text[i]);
        linkList[i] = document.createElement("a");
        linkList[i].setAttribute("href", "#");
        list[i].appendChild(textNode[i]);
        list[i].appendChild(linkList[i]);
        if(i == 0) insertAfter(friend, list[i]);
        else insertAfter(list[i - 1], list[i]);
	}
}

$(function(){
    $('.select').click(function(){
        $('.select_pop').stop().toggle();
    });
    $('.search .button').hover(function(){
        $(this).addClass('button_hover');
    },function(){
        $(this).removeClass('button_hover');
    });
    $("#s_all a").click(function(){
        var sval=$(this).find("span").html();
        var stype=$(this).find("span").attr("class");
        $("#lm").html(sval);
        $("#stype").val(stype);
    })

});

function check(){
    if($("#stype").val()=="zz"){
        $("#searchform").attr("action","/search.php");
    }
    else if($("#stype").val()=="mb"){
        $("#searchform").attr("action","/search_mj.php");
    }
    else if($("#stype").val()=="jc"){
        $("#searchform").attr("action","/search_jc.php");
    }
}