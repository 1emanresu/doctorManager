/********   医嘱分类分页，提示分页  js  @author zhujc    *********/
var address2, userid;

var userUtil = {
	"userRecord": function(sid) {
		var url = address2 + "userRecord/insertUserRecord.do";
		//user字段的--->非空判断

		//ajax数据
		var map = {
			"uid": userid,
			"sid": sid
		}
		//ajax请求
		$.post(url, map, function(result) {
			if(result.state == 0) {
				var i = result.data;
			}
		});
	}
}

$(function() {
	var obj = {};
	//初始化
	function init() {
		//地址初始化
		address2 = sessionStorage.getItem("address").replace('doctormanager','knowledge');
		//address2 = "http://192.168.1.60:8080/knowledge/";
		//address2 = address2.substring(0,find(address2,'/',2))+"/knowledge/";
		if(address2 == null) {
			address2 = "http://localhost:8080/knowledge/";
		}
		//用户id初始化
		var user = JSON.parse(sessionStorage.getItem("LOGIN_USER"));
		userid = (user == null) ? 1 : user.id;
		//对象初始化
		obj = {
			//提示框
			"tip_box": "#tips",
			//医嘱编辑框
			"advice_box": "#thisAdvice_content",
			//关键字集合
			"keyworks": ".advice",
			//关键字的属性的定义
			"attr": "keyword",
			//搜索按钮
			"search_btn": "#search",
			//搜索输入框
			"search_input_box": "#search_box",
			//显示区域
			"data_display": "#right-span",
			//点击添加键值对_按钮
			"insert_btn": "#insert_btn",
			//键值对_输入框_键
			"input_key": "#key_value_input",
			//键值对_输入框_值
			"input_value": "#key_value_show",
			//确认按钮
			"ok_btn": "#ok_btn",
			//模态框
			"modal1": "#key_value_insert_modal",
			//采纳按钮
			"adopt_btn": "#adopt_btn",
			//采纳框
			"adopt_box": "div.riskfactor-Advice p:not([style])"
		}
	}
	init();

	//关闭清空
	$('#myModal').on('hidden.bs.modal', function() {
		$("#keyword_div div").html("");
		$("#show_div").html("");
		$("#search_box").val("");
	});
	$(".my_advice").click(function() {
		var url = address2 + "wordSearch/queryPersonalOrders.do";
		//alert(url);
		//ajax事件
		$.post(address2 + "wordSearch/queryPersonalOrders.do", {
			"userid": userid
		}, function(result) {
			if(result.state == 0) {
				page.getData(result.data);
				pageShow();
			}
		});
	});
	//分类点击事件
	$(obj.keyworks).click(function() {
		var url = address2 + "wordSearch/findValueByTargetTable.do";
		//alert(url);
		var params = {
			"keyword": $(this).attr(obj.attr)
		};
		//ajax事件
		$.post(url, params, function(result) {
			if(result.state == 0) {
				page.getData(result.data);
				pageShow();
			}
		});
	});
	//双击医嘱添加到编辑框
	$(obj.data_display).on("dblclick", "p", function() {
		var beforeText = getText(document.getElementById("thisAdvice_content"));
		var afterText = $(this).text();
		$(obj.advice_box).text("");
		insert_advice_box("thisAdvice_content", beforeText + afterText);
		//用户登记
		var id = $(this).attr("id");
		userUtil.userRecord(id);
	});

	//搜索一下
	$(obj.search_btn).click(function() {
		var input = $(obj.search_input_box).val();
		//ajax事件
		$.post(address2 + "wordSearch/findValueByInputKeyword.do", {
			"input": input
		}, function(result) {
			if(result.state == 0) {
				var list = result.data;
				page.getData(list);
				pageShow();
			}
		});
	});
	//回车搜索
	$(obj.search_input_box).keydown(function(event) {
		if(event.keyCode == "13") { //keyCode=13是回车键
			$(obj.search_btn).click();
		}
	});

	//上一页
	$("#prev").click(function() {
		page.setPrev(page.index - 1);
		pageShow();
	});
	//下一页
	$("#next").click(function() {
		page.setNext(page.index + 1);
		pageShow();
	});
	//输出显示样式
	function pageShow() {
		var data = page.data;
		$(obj.data_display).html("");
		var index = (page.index - 1) * page.eachSize;

		for(var i = index;
			(data != null || data != undefined) && i < index + 5; i++) {
			var id = data[i].searchid;
			var a = data[i].value;
			$(obj.data_display).append("<p id='" + id + "'>" + a + "</p>");
		}
	}
	//点击打开（添加键值对模态框）
	$(obj.insert_btn).click(function() {
		$(obj.modal1).modal();
		$(obj.input_value).text($(obj.advice_box).text());
	});
	//点击确认添加
	$(obj.ok_btn).click(function() {
		if(
			is_empty($(obj.input_key).val()) ||
			is_empty($(obj.input_value).text())) {
			alert("请输入关键字");
		} else {
			var map = {
				"keyword": $(obj.input_key).val(),
				"value": $(obj.input_value).text(),
				"userid": userid
			}
			$.post(address2 + "wordSearch/insertPersonalOrders.do", map, function(result) {
				if(result.state == 0 && result.data == 2) {
					$(obj.modal1).modal("hide");
					$(obj.input_key).val("");
					alert("添加成功,你试一试");
				} else {
					alert("添加失败，请重新插入");
				}
			});
		}
	});
	//点击采纳为医嘱
	$(obj.adopt_btn).click(function() {
		var p = $(obj.adopt_box),
			str = "";
		for(var i = 0; i < p.length; i++) {
			str += removeStr($(p[i]).text());
		}
		insert_advice_box("thisAdvice_content", str);
	});
	//去除<标><非标>
	function removeStr(str) {
		var index = str.indexOf("<");
		if(index != -1) {
			str = str.substring(0, index);
		}
		return str;
	}
	//判断是否为空的方法1
	function is_empty(text) {
		return text.length == 0;
	}
	//判断是否为空的方法2
	function is_null(obj) {
		var object = $(obj);
		var a = object.text().length == 0;
		var b = object.html().length == 0;
		var c = object.val().length == 0;
		return a && b && c;
	}
	//
	$("#gravidaList").on("click", " tr td input", function() {
		$(".riskfactor-Advice").append('<button class="btn btn-primary" style="float: right;" id="adopt_btn">采纳为医嘱</button>');
	});
	//添加浮动框可拖动功能代码----wuwj
	var index = 0;
	$("#tools_bar img").click(function() {
		index = $(this).index();
		var $div = $(".class_serious_risk");
		$($div[index]).show();
	});
	
	//关闭弹窗事件
	$(".img_close2").click(function() {
		$(this).parent().hide();
	});
	
	//拖动弹窗事件
	$(function() {
		var drag_divs = $(".class_serious_risk");
		for(var i = 0; i < drag_divs.length; i++) {
			drag2($(drag_divs[i]));
		}
	});

	//孕妈妈提问请求
	$("#gravida_ask_img").click(function() {

		//写ajax请求
	});
	//搜索框滑动
	$("#slide_img").click(function() {
		$(this).toggleClass("hh");
		//$('.inputs-right').hide();
		$("#inputs").toggleClass("x");//放大
		$(".inputs-right").toggleClass("y"); //缩小
		
	});
});