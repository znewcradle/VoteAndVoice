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


function prepareSearchType(){
    var list = document.getElementsByClassName("user-button");
    if(list == null) return;
    for(var i  = 0; i < list.length; ++ i){
        list[i].onclick = function(){
            submitType(this);
        }
    }
}
addLoadEvent(prepareSearchType);
function submitType(btn){
    var label = btn.getElementsByTagName("label")[0];
    if(label == null) return;
    label = label.innerText;

    var keyType = document.getElementById("keyType");
    var typeClick = document.getElementById("typeClick");

    keyType.value = label;
    typeClick.onclick();
}

/******************************This is for the searchQuestionnaire*************************************************/
function getChosenValue(){
	var selist = document.getElementsByTagName("select");
	if(selist == null) return;
	document.getElementById("orderby").value = selist[0].value;
	document.getElementById("totalNum").value = selist[1].value;
	document.getElementById("qType").value = selist[2].value;
	document.getElementById("collectNum").value = selist[3].value;
}

function getQChosenValue(){
	var selist = document.getElementsByTagName("select");
	if(selist == null) return;
	document.getElementById("questionType").value  = selist[0].value;
	document.getElementById("questionnaireType").value = selist[1].value;
}




