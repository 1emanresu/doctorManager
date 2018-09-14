/********   工具类js   yinzx        ******/
var address = sessionStorage.getItem("address");
if(address == null) {
	address = "http://localhost:8080/knowledge/";
}

/**
 * 按表名查询对应的字典记录
 * @author yinzx   2017/10/17
 * @param {Object} table 表名
 * @param {Object} classname select标签的class选择器名
 */
function getSelectOption(table, classname) {
	$.ajax({
		type: "post",
		url: address + "datadictionary/findByTable.do",
		dataType: "json",
		data: {
			table: table
		},
		async: false, 
		success: function(result) {
			var data = result.data;
			if(data != null && data.length > 0) {
				for(var i = 0; i < data.length; i++) {
					$("." + classname).append("<option value='" + data[i].indexvalue + "'>" + data[i].namevalue + "</option>");

				}
			}
		}
	});
}
/**
 * 按表名查询对应的字典记录
 * @author yinzx   2017/10/17
 * @param {Object} table 表名
 * @param {Object} index 索引值
 * @param {Object} classname select标签的class选择器名
 */
function getSelectOptionByIndex(table, index, classname) {

	$.ajax({
		type: "post",
		url: address + "datadictionary/findByTableAndIndex.do",
		dataType: "json",
		data: {
			table: table,
			index: index
		},
		async: false,
		success: function(result) {
			var data = result.data;

			if(data != null && data.length > 0) {
				for(var i = 0; i < data.length; i++) {
					var cont = "<option value='" + data[i].namevalue + "'>" + data[i].namevalue + "</option>"

					$("." + classname).append(cont);

				}
			}

		}
	});
}

/**
 * 分页
 */
$.fn.extend({
	paging: function(option) {
		var obj = $(this);
		//设置元素不可被选中
		var defaults = {
			pageSize: 10, //可视页码数量
			totalPage: 10, //数据总页码
		};
		var settings = $.extend(defaults, option || {}); //初始化
		var totalPage = settings.totalPage;
		var pageSize = settings.pageSize;
		if(totalPage < pageSize) {
			pageSize = totalPage;
		}
		init();

		function light(currentspan) { //点击页码高亮样式，当前页码
			currentspan.addClass("current").siblings().removeClass("current");
		}

		function getCurrentIndex() {
			return obj.find(".current").index();
		}

		function getCurrentPage() {
			return parseInt(obj.find("span").eq(getCurrentIndex()).text());
		}

		function resetPage(start) {
			var objPage = obj.find("span");
			for(var i = 2; i < pageSize + 2; i++) {
				$(objPage[i]).text(start++);
			}
		}

		function showHome(ishome) {
			/* var homeObj = obj.find(".home");
            if(ishome){
                homeObj.show();
            } else{
                homeObj.hide();
            }*/

		}

		function showEnd(isend) {
			/* var endObj = obj.find(".end");
			 if(isend){
			     endObj.show();
			 } else{
			     endObj.hide();
			 }*/
		}

		function makePage(start, isHome, isEnd) { //生成页码
			var index = 0;
			var html = '';
			var endPage = start + pageSize - 1;
			if(totalPage <= pageSize) {
				endPage = totalPage;
			}
			html = '<div><span class="home" id="home">首页</span><span id="pre" class="home">上一页</span>';
			for(var i = start; i <= endPage; i++) {
				html += '<span class="page" id="uipage-nav' + i + '">' + i + "</span>";
			}
			html += '<span id="next" class="end">下一页</span><span  class="end" id="end">末页</span>';
			obj.html(html + "</div>");
			if(!isHome || start == 1) {
				showHome(false);
			}
			if(!isEnd) {
				showEnd(false);
			}
		}

		function refreshPage(start, nextPage) { //刷新页码
			var end = start + pageSize - 1;
			if(start <= 1) {
				start = 1;
				resetPage(start);
				showHome(false);
				showEnd(true);
				light($("#uipage-nav" + nextPage));
			} else if(start > 1 && start + pageSize < totalPage) {
				resetPage(start);
				showHome(true);
				showEnd(true);
				light($("#uipage-nav" + pageSize));
			} else if(end > totalPage) {
				start = totalPage - pageSize + 1;
				showEnd(false);
				showHome(true);
				resetPage(start);
				var endPage = parseInt($("#uipage-nav" + pageSize).text()); //末页页数
				var showPageIndex = pageSize - (endPage - nextPage);
				light($('#uipage-nav' + showPageIndex));
			} else if(end == totalPage) {
				resetPage(start);
				showEnd(false);
				showHome(true);
				light($('#uipage-nav1'));
			} else {
				resetPage(start);
				showEnd(true);
				showHome(true);
				light($('#uipage-nav1'));
			}

		}

		function init() { //初始化页码
			if(totalPage < 1) {
				return false
			} else if(totalPage <= pageSize) {
				makePage(1, false, false)
			} else {
				makePage(1, false, true);
			}
			light(obj.find("span").eq(2));
		}
		obj.find(".page").click(function() {
			var _this = $(this);
			var showPage = _this.text();
			light(_this);
			selectDictionary((showPage - 1) * 6, 6);
		});
		//下一页
		obj.find("#next").click(function() {
			var currentIndex = getCurrentIndex();
			var currentPage = getCurrentPage();
			var showPageIndex = currentIndex + 1;
			var nextPage = currentPage + 1;
			if(nextPage > totalPage) {
				alert("没有下一页了");
				return;
			}
			if(currentIndex == pageSize + 1) {
				refreshPage(currentPage + 1, nextPage);
			} else {
				light(obj.find("span").eq(showPageIndex));
			}
			selectDictionary((nextPage - 1) * parseInt(6), 6);
		});

		//上一页
		obj.find("#pre").click(function() {
			var currentIndex = getCurrentIndex();
			var currentPage = getCurrentPage();
			var showPageIndex = currentIndex - 1;
			var nextPage = currentPage - 1;
			if(nextPage == 0) {
				alert("当前已经是第一页了");
				return;
			}
			if(currentIndex == 2) {
				refreshPage(currentPage - pageSize, nextPage);
			} else {
				light(obj.find("span").eq(showPageIndex));
			}
			selectDictionary((nextPage - 1) * parseInt(6), 6);
		});

		//首页
		obj.find("#home").click(function() {
			refreshPage(1);
			showEnd(true);
			showHome(false);
			light(obj.find("span").eq(2));
			selectDictionary(0, 6);
		});
		//末页
		obj.find("#end").click(function() {
			var t = totalPage - pageSize + 1;
			refreshPage(t);
			showEnd(false);
			showHome(true);
			light(obj.find("span").eq(pageSize + 1));
			selectDictionary((totalPage - 1) * parseInt(6), 6);
		});
		//刷新显示条数
		obj.click(function() {
			var size = parseInt(6);
			var startNum = size * (getCurrentPage() - 1) + 1;
			var endNum = size * getCurrentPage();
			$(".stratNum").html(startNum);
			$(".endNum").html(endNum);
		});
	},
 	paging2: function(option) {
		var obj = $(this);
		//设置元素不可被选中
		var defaults = {
			pageSize: 10, //可视页码数量
			totalPage: 10, //数据总页码
		};
		var settings = $.extend(defaults, option || {}); //初始化
		var totalPage = settings.totalPage;
		var pageSize = settings.pageSize;
		if(totalPage < pageSize) {
			pageSize = totalPage;
		}
		init();

		function light(currentspan) { //点击页码高亮样式，当前页码
			currentspan.addClass("current").siblings().removeClass("current");
		}

		function getCurrentIndex() {
			return obj.find(".current").index();
		}

		function getCurrentPage() {
			return parseInt(obj.find("span").eq(getCurrentIndex()).text());
		}

		function resetPage(start) {
			var objPage = obj.find("span");
			for(var i = 2; i < pageSize + 2; i++) {
				$(objPage[i]).text(start++);
			}
		}

		function showHome(ishome) {
			/* var homeObj = obj.find(".home");
            if(ishome){
                homeObj.show();
            } else{
                homeObj.hide();
            }*/

		}

		function showEnd(isend) {
			/* var endObj = obj.find(".end");
			 if(isend){
			     endObj.show();
			 } else{
			     endObj.hide();
			 }*/
		}

		function makePage(start, isHome, isEnd) { //生成页码
			var index = 0;
			var html = '';
			var endPage = start + pageSize - 1;
			if(totalPage <= pageSize) {
				endPage = totalPage;
			}
			html = '<div><span class="home" id="home2">首页</span><span id="pre2" class="home">上一页</span>';
			for(var i = start; i <= endPage; i++) {
				html += '<span class="page2" id="uipage-nav_' + i + '">' + i + "</span>";
			}
			html += '<span id="next2" class="end">下一页</span><span  class="end" id="end2">末页</span>';
			obj.html(html + "</div>");
			if(!isHome || start == 1) {
				showHome(false);
			}
			if(!isEnd) {
				showEnd(false);
			}
		}

		function refreshPage(start, nextPage) { //刷新页码
			var end = start + pageSize - 1;
			if(start <= 1) {
				start = 1;
				resetPage(start);
				showHome(false);
				showEnd(true);
				light($("#uipage-nav_" + nextPage));
			} else if(start > 1 && start + pageSize < totalPage) {
				resetPage(start);
				showHome(true);
				showEnd(true);
				light($("#uipage-nav_" + pageSize));
			} else if(end > totalPage) {
				start = totalPage - pageSize + 1;
				showEnd(false);
				showHome(true);
				resetPage(start);
				var endPage = parseInt($("#uipage-nav_" + pageSize).text()); //末页页数
				var showPageIndex = pageSize - (endPage - nextPage);
				light($('#uipage-nav_' + showPageIndex));
			} else if(end == totalPage) {
				resetPage(start);
				showEnd(false);
				showHome(true);
				light($('#uipage-nav_1'));
			} else {
				resetPage(start);
				showEnd(true);
				showHome(true);
				light($('#uipage-nav_1'));
			}

		}

		function init() { //初始化页码
			if(totalPage < 1) {
				return false
			} else if(totalPage <= pageSize) {
				makePage(1, false, false)
			} else {
				makePage(1, false, true);
			}
			light(obj.find("span").eq(2));
		}
		obj.find(".page2").click(function() {
			var _this = $(this);
			var showPage = _this.text();
			light(_this);
			selectsymptom((showPage - 1) * 6, 6);
		});
		//下一页
		obj.find("#next2").click(function() {
			var currentIndex = getCurrentIndex();
			var currentPage = getCurrentPage();
			var showPageIndex = currentIndex + 1;
			var nextPage = currentPage + 1;
			if(nextPage > totalPage) {
				alert("没有下一页了");
				return;
			}
			if(currentIndex == pageSize + 1) {
				refreshPage(currentPage + 1, nextPage);
			} else {
				light(obj.find("span").eq(showPageIndex));
			}
			selectsymptom((nextPage - 1) * parseInt(6), 6);
		});

		//上一页
		obj.find("#pre2").click(function() {
			var currentIndex = getCurrentIndex();
			var currentPage = getCurrentPage();
			var showPageIndex = currentIndex - 1;
			var nextPage = currentPage - 1;
			if(nextPage == 0) {
				alert("当前已经是第一页了");
				return;
			}
			if(currentIndex == 2) {
				refreshPage(currentPage - pageSize, nextPage);
			} else {
				light(obj.find("span").eq(showPageIndex));
			}
			selectsymptom((nextPage - 1) * parseInt(6), 6);
		});

		//首页
		obj.find("#home2").click(function() {
			refreshPage(1);
			showEnd(true);
			showHome(false);
			light(obj.find("span").eq(2));
			selectsymptom(0, 6);
		});
		//末页
		obj.find("#end2").click(function() {
			var t = totalPage - pageSize + 1;
			refreshPage(t);
			showEnd(false);
			showHome(true);
			light(obj.find("span").eq(pageSize + 1));
			selectsymptom((totalPage - 1) * parseInt(6), 6);
		});
		//刷新显示条数
		obj.click(function() {
			var size = parseInt(6);
			var startNum = size * (getCurrentPage() - 1) + 1;
			var endNum = size * getCurrentPage();
			$(".stratNum2").html(startNum);
			$(".endNum2").html(endNum);
		});
	},
	paging3: function(option) {
		var obj = $(this);
		//设置元素不可被选中
		var defaults = {
			pageSize: 10, //可视页码数量
			totalPage: 10, //数据总页码
		};
		var settings = $.extend(defaults, option || {}); //初始化
		var totalPage = settings.totalPage;
		var pageSize = settings.pageSize;
		if(totalPage < pageSize) {
			pageSize = totalPage;
		}
		init();

		function light(currentspan) { //点击页码高亮样式，当前页码
			currentspan.addClass("current").siblings().removeClass("current");
		}

		function getCurrentIndex() {
			return obj.find(".current").index();
		}

		function getCurrentPage() {
			return parseInt(obj.find("span").eq(getCurrentIndex()).text());
		}

		function resetPage(start) {
			var objPage = obj.find("span");
			for(var i = 2; i < pageSize + 2; i++) {
				$(objPage[i]).text(start++);
			}
		}

		function showHome(ishome) {
			/* var homeObj = obj.find(".home");
            if(ishome){
                homeObj.show();
            } else{
                homeObj.hide();
            }*/

		}

		function showEnd(isend) {
			/* var endObj = obj.find(".end");
			 if(isend){
			     endObj.show();
			 } else{
			     endObj.hide();
			 }*/
		}

		function makePage(start, isHome, isEnd) { //生成页码
			var index = 0;
			var html = '';
			var endPage = start + pageSize - 1;
			if(totalPage <= pageSize) {
				endPage = totalPage;
			}
			html = '<div><span class="home" id="home3">首页</span><span id="pre3" class="home">上一页</span>';
			for(var i = start; i <= endPage; i++) {
				html += '<span class="page3" id="uipage-nava' + i + '">' + i + "</span>";
			}
			html += '<span id="next3" class="end">下一页</span><span  class="end" id="end3">末页</span>';
			obj.html(html + "</div>");
			if(!isHome || start == 1) {
				showHome(false);
			}
			if(!isEnd) {
				showEnd(false);
			}
		}

		function refreshPage(start, nextPage) { //刷新页码
			var end = start + pageSize - 1;
			if(start <= 1) {
				start = 1;
				resetPage(start);
				showHome(false);
				showEnd(true);
				light($("#uipage-nava" + nextPage));
			} else if(start > 1 && start + pageSize < totalPage) {
				resetPage(start);
				showHome(true);
				showEnd(true);
				light($("#uipage-nava" + pageSize));
			} else if(end > totalPage) {
				start = totalPage - pageSize + 1;
				showEnd(false);
				showHome(true);
				resetPage(start);
				var endPage = parseInt($("#uipage-nava" + pageSize).text()); //末页页数
				var showPageIndex = pageSize - (endPage - nextPage);
				light($('#uipage-nava' + showPageIndex));
			} else if(end == totalPage) {
				resetPage(start);
				showEnd(false);
				showHome(true);
				light($('#uipage-nava1'));
			} else {
				resetPage(start);
				showEnd(true);
				showHome(true);
				light($('#uipage-nava1'));
			}

		}

		function init() { //初始化页码
			if(totalPage < 1) {
				return false
			} else if(totalPage <= pageSize) {
				makePage(1, false, false)
			} else {
				makePage(1, false, true);
			}
			light(obj.find("span").eq(2));
		}
		obj.find(".page3").click(function() {
			var _this = $(this);
			var showPage = _this.text();
			light(_this);
			selectdisease((showPage - 1) * 6, 6);
		});
		//下一页
		obj.find("#next3").click(function() {
			var currentIndex = getCurrentIndex();
			var currentPage = getCurrentPage();
			var showPageIndex = currentIndex + 1;
			var nextPage = currentPage + 1;
			if(nextPage > totalPage) {
				alert("没有下一页了");
				return;
			}
			if(currentIndex == pageSize + 1) {
				refreshPage(currentPage + 1, nextPage);
			} else {
				light(obj.find("span").eq(showPageIndex));
			}
			selectdisease((nextPage - 1) * parseInt(6), 6);
		});

		//上一页
		obj.find("#pre3").click(function() {
			var currentIndex = getCurrentIndex();
			var currentPage = getCurrentPage();
			var showPageIndex = currentIndex - 1;
			var nextPage = currentPage - 1;
			if(nextPage == 0) {
				alert("当前已经是第一页了");
				return;
			}
			if(currentIndex == 2) {
				refreshPage(currentPage - pageSize, nextPage);
			} else {
				light(obj.find("span").eq(showPageIndex));
			}
			selectdisease((nextPage - 1) * parseInt(6), 6);
		});

		//首页
		obj.find("#home3").click(function() {
			refreshPage(1);
			showEnd(true);
			showHome(false);
			light(obj.find("span").eq(2));
			selectdisease(0, 6);
		});
		//末页
		obj.find("#end3").click(function() {
			var t = totalPage - pageSize + 1;
			refreshPage(t);
			showEnd(false);
			showHome(true);
			light(obj.find("span").eq(pageSize + 1));
			selectdisease((totalPage - 1) * parseInt(6), 6);
		});
		//刷新显示条数
		obj.click(function() {
			var size = parseInt(6);
			var startNum = size * (getCurrentPage() - 1) + 1;
			var endNum = size * getCurrentPage();
			$(".stratNum3").html(startNum);
			$(".endNum3").html(endNum);
		});
	},
	paging4: function(option) {
		var obj = $(this);
		//设置元素不可被选中
		var defaults = {
			pageSize: 10, //可视页码数量
			totalPage: 10, //数据总页码
		};
		var settings = $.extend(defaults, option || {}); //初始化
		var totalPage = settings.totalPage;
		var pageSize = settings.pageSize;
		if(totalPage < pageSize) {
			pageSize = totalPage;
		}
		init();

		function light(currentspan) { //点击页码高亮样式，当前页码
			currentspan.addClass("current").siblings().removeClass("current");
		}

		function getCurrentIndex() {
			return obj.find(".current").index();
		}

		function getCurrentPage() {
			return parseInt(obj.find("span").eq(getCurrentIndex()).text());
		}

		function resetPage(start) {
			var objPage = obj.find("span");
			for(var i = 2; i < pageSize + 2; i++) {
				$(objPage[i]).text(start++);
			}
		}

		function showHome(ishome) {
			/* var homeObj = obj.find(".home");
            if(ishome){
                homeObj.show();
            } else{
                homeObj.hide();
            }*/

		}

		function showEnd(isend) {
			/* var endObj = obj.find(".end");
			 if(isend){
			     endObj.show();
			 } else{
			     endObj.hide();
			 }*/
		}

		function makePage(start, isHome, isEnd) { //生成页码
			var index = 0;
			var html = '';
			var endPage = start + pageSize - 1;
			if(totalPage <= pageSize) {
				endPage = totalPage;
			}
			html = '<div><span class="home" id="home4">首页</span><span id="pre4" class="home">上一页</span>';
			for(var i = start; i <= endPage; i++) {
				html += '<span class="page4" id="uipage-navb' + i + '">' + i + "</span>";
			}
			html += '<span id="next4" class="end">下一页</span><span  class="end" id="end4">末页</span>';
			obj.html(html + "</div>");
			if(!isHome || start == 1) {
				showHome(false);
			}
			if(!isEnd) {
				showEnd(false);
			}
		}

		function refreshPage(start, nextPage) { //刷新页码
			var end = start + pageSize - 1;
			if(start <= 1) {
				start = 1;
				resetPage(start);
				showHome(false);
				showEnd(true);
				light($("#uipage-navb" + nextPage));
			} else if(start > 1 && start + pageSize < totalPage) {
				resetPage(start);
				showHome(true);
				showEnd(true);
				light($("#uipage-navb" + pageSize));
			} else if(end > totalPage) {
				start = totalPage - pageSize + 1;
				showEnd(false);
				showHome(true);
				resetPage(start);
				var endPage = parseInt($("#uipage-navb" + pageSize).text()); //末页页数
				var showPageIndex = pageSize - (endPage - nextPage);
				light($('#uipage-navb' + showPageIndex));
			} else if(end == totalPage) {
				resetPage(start);
				showEnd(false);
				showHome(true);
				light($('#uipage-navb1'));
			} else {
				resetPage(start);
				showEnd(true);
				showHome(true);
				light($('#uipage-navb1'));
			}

		}

		function init() { //初始化页码
			if(totalPage < 1) {
				return false
			} else if(totalPage <= pageSize) {
				makePage(1, false, false)
			} else {
				makePage(1, false, true);
			}
			light(obj.find("span").eq(2));
		}
		obj.find(".page4").click(function() {
			var _this = $(this);
			var showPage = _this.text();
			light(_this);
			selectmedicine((showPage - 1) * 6, 6);
		});
		//下一页
		obj.find("#next4").click(function() {
			var currentIndex = getCurrentIndex();
			var currentPage = getCurrentPage();
			var showPageIndex = currentIndex + 1;
			var nextPage = currentPage + 1;
			if(nextPage > totalPage) {
				alert("没有下一页了");
				return;
			}
			if(currentIndex == pageSize + 1) {
				refreshPage(currentPage + 1, nextPage);
			} else {
				light(obj.find("span").eq(showPageIndex));
			}
			selectmedicine((nextPage - 1) * parseInt(6), 6);
		});

		//上一页
		obj.find("#pre4").click(function() {
			var currentIndex = getCurrentIndex();
			var currentPage = getCurrentPage();
			var showPageIndex = currentIndex - 1;
			var nextPage = currentPage - 1;
			if(nextPage == 0) {
				alert("当前已经是第一页了");
				return;
			}
			if(currentIndex == 2) {
				refreshPage(currentPage - pageSize, nextPage);
			} else {
				light(obj.find("span").eq(showPageIndex));
			}
			selectmedicine((nextPage - 1) * parseInt(6), 6);
		});

		//首页
		obj.find("#home4").click(function() {
			refreshPage(1);
			showEnd(true);
			showHome(false);
			light(obj.find("span").eq(2));
			selectmedicine(0, 6);
		});
		//末页
		obj.find("#end4").click(function() {
			var t = totalPage - pageSize + 1;
			refreshPage(t);
			showEnd(false);
			showHome(true);
			light(obj.find("span").eq(pageSize + 1));
			selectmedicine((totalPage - 1) * parseInt(6), 6);
		});
		//刷新显示条数
		obj.click(function() {
			var size = parseInt(6);
			var startNum = size * (getCurrentPage() - 1) + 1;
			var endNum = size * getCurrentPage();
			$(".stratNum4").html(startNum);
			$(".endNum4").html(endNum);
		});
	}
});

