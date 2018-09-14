var bool = [];

$(function () {
	var address = sessionStorage.getItem("address");
	//address = "http://192.168.1.41:8080/doctormanager/";
	$.ajax({
		type: "get",
		url: address + "menu/getMenuTree.do",
		async: false,
		success: function (result) {
			var data = result.data;
			if (data.length) {
				console.log(data);
				var html = "";
				for (var i = 0; i < data.length; ++i) {
					var menu = data[i];
					if (menu.children.length) {
						//有子节点
						html += '<div class="tb" id="tb' + i + '" onclick="showOrHide(' + i + ')">';
						html += '<img src="' + menu.icon + '" width="20px" class="rilogo" />' + menu.name;
						html += '<img src="images/ri.png" width="6px" class="ri" id="ri' + i + '" style="margin-left: 32px;"/>';
						html += '</div>';
						html += '<div class="nr" id="nr' + i + '">';
						for (var j = 0; j < menu.children.length; ++j) {
							html += '<div class="item_tab click_nav">';
							html += '<div style="" onclick="ifream(\'' + menu.children[j].url + '\')">';
							html += menu.children[j].name;
							html += '</div>';
							html += '</div>';
						}
						html += '</div>';
					} else {
						//无子节点
						html += '<div class="tb click_nav">';
						html += '<div onclick="ifream(\'' + menu.url + '\')">';
						html += '<img src="' + menu.icon + '" width="20px" class="rilogo" />' + menu.name;
						html += '</div>';
						html += '</div>';
					}
				}
				$("#nav_menu").html(html);
				for(var i = 0; i < data.length; i++) {
					bool[i] = false;
					showOrHide(i)//默认隐藏
				}
			} else {
				alert("无菜单数据！");
			}
		},
		error: function () {
			alert("访问服务器失败！");
		}
	});
});

function showOrHide(i) {
	if(bool[i]) {
		for(var j = 1; j < 6; j++) {
			$("#ri" + j).css("-webkit-transform", "rotate(90deg)");
			//$("#tb" + j).css("background", "white");
			$("#nr" + j).hide();
			bool[j] = true;
		}
		$("#ri" + i).css("-webkit-transform", "rotate(270deg)");
		//$("#tb" + i).css("background", "whitesmoke");
		$("#nr" + i).show();
		bool[i] = false;
	} else {
		$("#ri" + i).css("-webkit-transform", "rotate(90deg)");
		//$("#tb" + i).css("background", "white");
		$("#nr" + i).hide();
		bool[i] = true;
	}
}

  
 $(".click_nav").click(function(e){  
    $(".click_nav").css("background", "whitesmoke");
    $(".click_nav").css('border','none');
    $(".click_nav").css('padding-left','25px');
    $(".tb").css("background", "whitesmoke");
    $(".tb").css('border','none');
    $(".tb").css('padding-left','25px');
    $(this).css("background", "#E4E4E4");
    $(this).css("border-left", "8px solid #76b0ff");
    $(this).css('padding-left','17px');
})
 $(".check_project").click(function(e){  
    $(".check_project").css("background", "whitesmoke");
    $(this).css("background", "white");
})

$(function(){
	//判断是否是健康顾问
	var pid=sessionStorage.getItem("pid");
	if(pid!=888){
		$('.server-manager').hide();
		$('.account-manager').hide();
	}
});