/**
 * @author wangzw
 * 
 * 封装的词条检索 js
 * 
 * 说明：如需使用详细请参照 fastSearch文件下的页面使用方式
 *   		    
 */
var address = sessionStorage.getItem("address");
var UtilAddress = address.replace('doctormanager','knowledge');
//var UtilAddress = "http://192.168.1.60:8080/knowledge/";

var sunCount; //词条相关的内容 的查询总数量 变量

/**
 * 提供的接口 如需修改在此处查询的值
 * 获取用户输入的值
 */
function getInputValue() {
	var value = $("#word_search").val();
	return value;
}
$(function() {
	dynamicHtml();
});
var index = 1;
/**
 * 点击索检按钮查询词条相关的内容
 */
$("#btn_search").click(function() {
	$("#keyword").html(getInputValue());
	if(index == 1) {
		$("#suggest_data").append(dictionaryContent());
		index = 2;
	}
	changeSize();
	 if(sym == 1) {
			$("#symptom_data").append(ymptomContent());
		sym = 2;
	}
      changesymptomSize();
	 
	  if(disease == 1) {
		$("#disease").append(diseaseContent());
		disease = 2;
		}
	  changesdiseaseSize();
	  
	   if(medicine == 1) {
		$("#pharmacy").append(medicineContent());
		medicine = 2;
		}
	   changesmedicineSize();
});

/**
 * 初始化页面js
 * 动态生成html页面内容
 */
function dynamicHtml() {
	var content = "<div id='container_dictionaries'><div id='keyword'></div>" +
		"<div id='suggest_data'></div><div id='symptom_data'></div><div id='disease'></div><div id='pharmacy'></div>" +
		"</div>";
	$("#sun_container").append(content);
}
/**
 * 词条相关的内容 
 */
function dictionaryContent() {
	var content = "<div class='segmentation'>" +
		"<div class='wire_border'></div>" +
		"<div class='title_info'>词条相关的内容</div>" +
		"<div class='line_style'></div>" +
		"</div>" +
		"<!--词条相关的内容div-->" +
		"<div id='container' class='padd_left' style='height:auto'>" +
		"</div>" +
		"<div style='clear: both; border-bottom: 1px solid #EBEBEB;width: 100%;'></div>" +
		"<div class='class_bottom_container'>" +
		"<p class='class_left_float'>" +
		"当前显示第<span class='stratNum'>1</span> 到第 <span class='endNum'></span> 条数据，共有数据：<span class='perSun'>6</span>条" +
		"</p>" +
		"<div class='class_right_float ui-page' id='ui-page' onselectstart='return false;'>" +
		"</div>" +
		"</div>";

	return content;
}

/**
 * 动态生成词条相关的内容底部分页按钮及功能
 */
function changeSize() {
	$("#ui-page").html("");
	getSunCount(getInputValue());
	var count = sunCount;
	if(sunCount <= 0) {
		$("#suggest_data").html("");
		index = 1;
	} else {
		var size = 6; //parseInt(6);
		var initTotalPageNum = Math.ceil(count / size);
		/* 初始化页面 */
		$("#ui-page").paging({
			//显示数字为3个
			pageSize: 3,
			totalPage: initTotalPageNum
		});
		$(".stratNum").html(1);
		$(".endNum").html(size);
		//默认显示第一页
		selectDictionary(0, size);
		$(".perSun").text(count);
	}
}
/**
 * 查询词条相关的内容的总数量
 */
function getSunCount(filename) {
	$.ajax({
		type: "post",
		url: UtilAddress + "wordSearch/findValueDetail.do",
		dataType: "json",
		data: {
			"keyword": filename,
			"pageIndex": null,
			"pageSize": null
		},
		async: false,
		success: function(result) {
			sunCount = result.total;
		}
	});
}
/**
 * 查询词条相关的内容 
 */
function selectDictionary(pageIndex, pageSize) {
	var keyword = getInputValue();
	$.ajax({
		type: "post",
		url: UtilAddress + "wordSearch/findValueDetail.do",
		dataType: "json",
		data: {
			"keyword": keyword,
			"pageIndex": pageIndex,
			"pageSize": pageSize
		},
		async: true,
		success: function(result) {
			var data = result.data;
			if(result.total > 0) {
				var data = result;
				$("#container").html("");
				var obj = {};
				for(var i = 0; i < data.rows.length; i++) {
					var content = "<div class='content_show'>" +
						"<div class='content_info'>" + data.rows[i].value + "</div>" +
						"</div>";
					$("#container").append(content);
				}
			}
		}
	});
}

/**
 * ---------------------------------------代码分割线
 * 症状相关的内容
 */


/**
 * 症状相关的内容 
 */
function ymptomContent() {
	var content = "<div class='segmentation'>" +
		"<div class='wire_border'></div>" +
		"<div class='title_info'>相关症状</div>" +
		"<div class='line_style'></div>" +
		"</div>" +
		"<!--词条相关的内容div-->" +
		"<div id='container2' class='padd_left'>" +
		"</div>" +
		"<div style='clear: both; border-bottom: 1px solid #EBEBEB;width: 100%;'></div>" +
		"<div class='class_bottom_container'>" +
		"<p class='class_left_float'>" +
		"当前显示第<span class='stratNum2'>1</span> 到第 <span class='endNum2'></span> 条数据，共有数据：<span class='perSun2'>6</span>条" +
		"</p>" +
		"<div class='class_right_float ui-page' id='ui-page2' onselectstart='return false;'>" +
		"</div>" +
		"</div>";

	return content;
}
 var sym=1;
 var symptomCount;
/**
 * 动态生成症状相关的内容底部分页按钮及功能
 */
function changesymptomSize() {
	$("#ui-page2").html("");
	getSunsymptomCount(getInputValue());
	var count = symptomCount;
	if(symptomCount <= 0) {
		$("#symptom_data").html("");
		sym = 1;
	} else {
		var size = 6; //parseInt(6);
		var initTotalPageNum = Math.ceil(count / size);
		/* 初始化页面 */
		$("#ui-page2").paging2({
			//显示数字为3个
			pageSize: 3,
			totalPage: initTotalPageNum
		});
		$(".stratNum2").html(1);
		$(".endNum2").html(size);
		//默认显示第一页
		selectsymptom(0, size);
		$(".perSun2").text(count);
	}
}
/**
 * 查询症状相关的内容的总数量
 */
function getSunsymptomCount(filename) {
	$.ajax({
		type: "post",
		url: UtilAddress + "pregnancySymptom/getSymptom.do",
		dataType: "json",
		data: {
			"keyword": filename,
			"pageIndex": null,
			"pageSize": null
		},
		async: false,
		success: function(result) {
			symptomCount = result.total;
		}
	});
}
/**
 * 查询症状相关的内容 
 */
function selectsymptom(pageIndex, pageSize) {
	var keyword = getInputValue();
	$.ajax({
		type: "post",
		url: UtilAddress + "pregnancySymptom/getSymptom.do",
		dataType: "json",
		data: {
			"keyword": keyword,
			"pageIndex": pageIndex,
			"pageSize": pageSize
		},
		async: true,
		success: function(result) {
			var data = result.data;
			if(result.total > 0) {
				var data = result;
				$("#container2").html("");
				for(var i = 0; i < data.rows.length; i++) {
					var symptomName=data.rows[i].symptomName;
					if(symptomName==null||symptomName=="")symptomName="无"; 
					var advice=data.rows[i].advice;
					if(advice==null||advice=="")advice="无"; 
					var medicine=data.rows[i].medicine;
					if(medicine==null||medicine=="")medicine="无"; 
					var content = "<div class='content_show'>" +
					"<div class='content_title'>症状：" + symptomName + "</div>" +
						"<div class='content_info'>医嘱：" +  advice + " </div>" +
						"<div class='content_info'>建议用药：" +  medicine + " </div>" +
						"</div>";
					$("#container2").append(content);
				}
			}
		}
	});
}
/**
 * --------------------代码分割线---------------------------------
 * 病症
 * 
 */


/**
 * 病症相关的内容 
 */
function diseaseContent() {
	var content = "<div class='segmentation'>" +
		"<div class='wire_border'></div>" +
		"<div class='title_info'>相关病症</div>" +
		"<div class='line_style'></div>" +
		"</div>" +
		"<!--词条相关的内容div-->" +
		"<div id='container3' class='padd_left'>" +
		"</div>" +
		"<div style='clear: both; border-bottom: 1px solid #EBEBEB;width: 100%;'></div>" +
		"<div class='class_bottom_container'>" +
		"<p class='class_left_float'>" +
		"当前显示第<span class='stratNum3'>1</span> 到第 <span class='endNum3'></span> 条数据，共有数据：<span class='perSun3'>6</span>条" +
		"</p>" +
		"<div class='class_right_float ui-page' id='ui-page3' onselectstart='return false;'>" +
		"</div>" +
		"</div>";

	return content;
}
 var disease=1;
 var diseaseCount;
/**
 * 动态生成病症相关的内容底部分页按钮及功能
 */
function changesdiseaseSize() {
	$("#ui-page3").html("");
	getSunsdiseaseCount(getInputValue());
	var count = diseaseCount;
	if(diseaseCount <= 0) {
		$("#disease").html("");
		disease = 1;
	} else {
		var size = 6; //parseInt(6);
		var initTotalPageNum = Math.ceil(count / size);
		/* 初始化页面 */
		$("#ui-page3").paging3({
			//显示数字为3个
			pageSize: 3,
			totalPage: initTotalPageNum
		});
		$(".stratNum3").html(1);
		$(".endNum3").html(size);
		//默认显示第一页
		selectdisease(0, size);
		$(".perSun3").text(count);
	}
}
/**
 * 查询病症相关的内容的总数量
 */
function getSunsdiseaseCount(filename) {
	$.ajax({
		type: "post",
		url: UtilAddress + "disease/findDetail.do",
		dataType: "json",
		data: {
			"name": filename,
			"pageIndex": null,
			"pageSize": null
		},
		async: false,
		success: function(result) {
			diseaseCount = result.total;
		}
	});
}
/**
 * 查询病症相关的内容 
 */
function selectdisease(pageIndex, pageSize) {
	var keyword = getInputValue();
	$.ajax({
		type: "post",
		url: UtilAddress + "disease/findDetail.do",
		dataType: "json",
		data: {
			"name": keyword,
			"pageIndex": pageIndex,
			"pageSize": pageSize
		},
		async: true,
		success: function(result) {
			var data = result.data;
			if(result.total > 0) {
				var data = result;
				$("#container3").html("");
				for(var i = 0; i < data.rows.length; i++) {
					var dname=data.rows[i].dname;
					if(dname==null||dname=="")dname="无"; 
					var manifestation=data.rows[i].manifestation;
					if(manifestation==null||manifestation=="")manifestation="无"; 
					var content = "<div class='content_show'>" +
					"<div class='content_title'> 病症：" + dname+ "</div>" +
						"<div class='content_info'>临床表现：" + manifestation + " </div>" +
						"</div>";
					$("#container3").append(content);
				}
			}
		}
	});
}
/**
 * ----------------------------代码分割线---------------------------------
 * 用药
 */
/**
 * medicine
 * 用药相关的内容 
 */
function medicineContent() {
	var content = "<div class='segmentation'>" +
		"<div class='wire_border'></div>" +
		"<div class='title_info'>相关用药</div>" +
		"<div class='line_style'></div>" +
		"</div>" +
		"<!--词条相关的内容div-->" +
		"<div id='container4' class='padd_left'>" +
		"</div>" +
		"<div style='clear: both; border-bottom: 1px solid #EBEBEB;width: 100%;'></div>" +
		"<div class='class_bottom_container'>" +
		"<p class='class_left_float'>" +
		"当前显示第<span class='stratNum4'>1</span> 到第 <span class='endNum4'></span> 条数据，共有数据：<span class='perSun4'>6</span>条" +
		"</p>" +
		"<div class='class_right_float ui-page' id='ui-page4' onselectstart='return false;'>" +
		"</div>" +
		"</div>";

	return content;
}
 var medicine=1;
 var medicineCount;
/**
 * 动态生成用药相关的内容底部分页按钮及功能
 */
function changesmedicineSize() {
	$("#ui-page4").html("");
	getSunsmedicineCount(getInputValue());
	var count = medicineCount;
	if(diseaseCount <= 0) {
		$("#pharmacy").html("");
		medicine = 1;
	} else {
		var size = 6; //parseInt(6);
		var initTotalPageNum = Math.ceil(count / size);
		/* 初始化页面 */
		$("#ui-page4").paging4({
			//显示数字为3个
			pageSize: 3,
			totalPage: initTotalPageNum
		});
		$(".stratNum4").html(1);
		$(".endNum4").html(size);
		//默认显示第一页
		selectmedicine(0, size);
		$(".perSun4").text(count);
	}
}
/**
 * 查询用药相关的内容的总数量
 */
function getSunsmedicineCount(filename) {
	$.ajax({
		type: "post",
		url: UtilAddress + "medicine/getmedicines.do",
		dataType: "json",
		data: {
			"effect": filename,
			"pageIndex": null,
			"pageSize": null
		},
		async: false,
		success: function(result) {
			medicineCount = result.total;
		}
	});
}
/**
 * 查询用药相关的内容 
 */
function selectmedicine(pageIndex, pageSize) {
	var keyword = getInputValue();
	$.ajax({
		type: "post",
		url: UtilAddress + "medicine/getmedicines.do",
		dataType: "json",
		data: {
			"effect": keyword,
			"pageIndex": pageIndex,
			"pageSize": pageSize
		},
		async: true,
		success: function(result) {
			var data = result.data;
			if(result.total > 0) {
				var data = result;
				$("#container4").html("");
				for(var i = 0; i < data.rows.length; i++) {
					var medicineName= data.rows[i].medicineName;
					if(medicineName==null||medicineName=="")medicineName="无"; 
					var useWay= data.rows[i].useWay 
					if(useWay==null||useWay=="")useWay="无"; 
					var taboo=data.rows[i].taboo ;
					if(taboo==null||taboo=="")taboo="无"; 
					var ADR=data.rows[i].ADR;
					if(ADR==null||ADR=="") ADR="无";
					var content = "<div class='content_show'>" +
					"<div class='content_title'> 药物名称：" + medicineName + "</div>" +
						"<div class='content_info'>用药方式：" + useWay + " </div>" +
						"<div class='content_info'>作用：" + data.rows[i].effect + " </div>" +
						"<div class='content_info'>禁忌：" +taboo + " </div>" +
						"<div class='content_info'>不良反应：" +ADR  + " </div>" +
						"</div>";
					$("#container4").append(content);
				}
			}
		}
	});
}