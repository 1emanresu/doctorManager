var mid = sessionStorage.getItem("mid");
//孕周
var wek;
$(function() {
	wek=sessionStorage.getItem("weeks");
	//获取化验科的院检报告
	getAssayReport();
	//获取影像科的院检报告
	getImgReport();
	//获取基因检查的院检报告
	getGengReport();
});

//获取化验科的院检报告
function getAssayReport() {
	var reportJson = [{
			"reportName": "血常规",
			"img": "images/reportImg/XCG1.png",
			"img2": "images/reportImg/XCG2.png",
			"checkProjectId": 1
		},
		{
			"reportName": "尿常规",
			"img": "images/reportImg/NCG1.png",
			"img2": "images/reportImg/NCG2.png",
			"checkProjectId": 2
		},
		{
			"reportName": "空腹血糖",
			"img": "images/reportImg/KFXT1.png",
			"img2": "images/reportImg/KFXT2.png",
			"checkProjectId": 5
		},
		{
			"reportName": "血型 ",
			"img": "images/reportImg/XX1.png",
			"img2": "images/reportImg/XX2.png",
			"checkProjectId": 30
		},
		{
			"reportName": "肝肾功能 ",
			"img": "images/reportImg/GSGN1.png",
			"img2": "images/reportImg/GSGN2.png",
			"checkProjectId": 3
		},
		{
			"reportName": "HBsAg",
			"img": "images/reportImg/HBsAG1.png",
			"img2": "images/reportImg/HBsAG2.png",
			"checkProjectId": 31
		},
		{
			"reportName": "梅毒螺旋体",
			"img": "images/reportImg/MD1.png",
			"img2": "images/reportImg/MD2.png",
			"checkProjectId": 32
		},
		{
			"reportName": "HIV报告",
			"img": "images/reportImg/HIV1.png",
			"img2": "images/reportImg/HIV2.png",
			"checkProjectId": 33
		},
		{
			"reportName": "宫颈细胞学检查",
			"img": "images/reportImg/GJXB1.png",
			"img2": "images/reportImg/GJXB2.png",
			"checkProjectId": 35
		},
		{
			"reportName": "优生五项",
			"img": "images/reportImg/YS5X1.png",
			"img2": "images/reportImg/YS5X2.png",
			"checkProjectId": 7
		},
		{
			"reportName": "输血八项",
			"img": "images/reportImg/SX8X1.png",
			"img2": "images/reportImg/SX8X2.png",
			"checkProjectId": 29
		}
	]
	var html1 = "";
	var html2 = "";
	for(var i = 0; i < reportJson.length; i++) {
		var report = checkReport({
			checkProjectId: reportJson[i].checkProjectId,
			weeks: wek,
			mid: mid,
			htmlType: 'table-checkbox'
		});
		var picLink = checkReport.prototype.picLink == undefined ? '' : checkReport.prototype.picLink;
		if(report == '') {
			html2 += "<div class='check_project null-report'>" +
				"<div><img id='blood_rout' src='" + reportJson[i].img + "' /></div>" +
				"<div style='margin-left: 12px;'><span>" + reportJson[i].reportName + "</span><span class='nr_tips'>&nbsp;</span></div></div>";
		} else {
			html1 += "<div class='check_project' onclick='openBox(\"" + escape(report) + "\",\"" + reportJson[i].reportName + "\",\"" + picLink + "\")'>" +
				"<div><img id='blood_rout' src='" + reportJson[i].img2 + "' /></div>" +
				"<div style='margin-left: 12px;'><span>" + reportJson[i].reportName + "</span><span class='nr_tips'>&nbsp;</span></div></div>";
		}
	}
	//有数据的报告
	$("#nr1").html('');
	$("#nr1").append(html1);
	//无数据的报告
	$("#nr1").append(html2);
}

//获取影像科的院检报告
function getImgReport() {
	var reportJson = [{
			"reportName": "心电",
			"img": "images/reportImg/XD1.png",
			"img2": "images/reportImg/XD2.png",
			"checkProjectId": 88
		},
		{
			"reportName": "三维彩超",
			"img": "images/reportImg/BC1.png",
			"img2": "images/reportImg/BC2.png",
			"checkProjectId": 88
		},
		{
			"reportName": "四维彩超",
			"img": "images/reportImg/BC1.png",
			"img2": "images/reportImg/BC2.png",
			"checkProjectId": 88
		},
		{
			"reportName": "NST检查 ",
			"img": "images/reportImg/NST1.png",
			"img2": "images/reportImg/NST2.png",
			"checkProjectId": 88
		}
	]
	var html1 = "";
	var html2 = "";
	for(var i = 0; i < reportJson.length; i++) {
		var report = checkReport({
			checkProjectId: reportJson[i].checkProjectId,
			weeks: wek,
			mid: mid,
			htmlType: 'table-checkbox'
		});
		var picLink = checkReport.prototype.picLink == undefined ? '' : checkReport.prototype.picLink;
		if(report == '') {
			html2 += "<div class='check_project null-report'>" +
				"<div><img id='blood_rout' src='" + reportJson[i].img + "' /></div>" +
				"<div style='margin-left: 12px;'><span>" + reportJson[i].reportName + "</span><span class='nr_tips'>&nbsp;</span></div></div>";
		} else {
			html1 += "<div class='check_project' onclick='openBox(\"" + escape(report) + "\",\"" + reportJson[i].reportName + "\",\"" + picLink + "\")'>" +
				"<div><img id='blood_rout' src='" + reportJson[i].img2 + "' /></div>" +
				"<div style='margin-left: 12px;'><span>" + reportJson[i].reportName + "</span><span class='nr_tips'>&nbsp;</span></div></div>";
		}
	}
	//有数据的报告
	$("#nr2").html('');
	$("#nr2").append(html1);
	//无数据的报告
	$("#nr2").append(html2);
}

//获取基因检查的院检报告
function getGengReport() {
	var reportJson = [{
			"reportName": "唐筛",
			"img": "images/reportImg/TS1.png",
			"img2": "images/reportImg/TS2.png",
			"checkProjectId": 10
		},
		{
			"reportName": "NIPT",
			"img": "images/reportImg/NIPT1.png",
			"img2": "images/reportImg/NIPT2.png",
			"checkProjectId": 11
		}
	]
	var html1 = "";
	var html2 = "";
	for(var i = 0; i < reportJson.length; i++) {
		var report = checkReport({
			checkProjectId: reportJson[i].checkProjectId,
			weeks: wek,
			mid: mid,
			htmlType: 'table-checkbox'
		});
		var picLink = checkReport.prototype.picLink == undefined ? '' : checkReport.prototype.picLink;
		if(report == '') {
			html2 += "<div class='check_project null-report'>" +
				"<div><img id='blood_rout' src='" + reportJson[i].img + "' /></div>" +
				"<div style='margin-left: 12px;'><span>" + reportJson[i].reportName + "</span><span class='nr_tips'>&nbsp;</span></div></div>";
		} else {
			html1 += "<div class='check_project' onclick='openBox(\"" + escape(report) + "\",\"" + reportJson[i].reportName + "\",\"" + picLink + "\")'>" +
				"<div><img id='blood_rout' src='" + reportJson[i].img + "' /></div>" +
				"<div style='margin-left: 12px;'><span>" + reportJson[i].reportName + "</span><span class='nr_tips'>&nbsp;</span></div></div>";
		}
	}
	//有数据的报告
	$("#nr3").html('');
	$("#nr3").append(html1);
	//无数据的报告
	$("#nr3").append(html2);
}

//打开院检报告的弹出框
var index = 1;
function openBox(report, reportName, picLink) {
	if(index == 1){
		getMessage();//查询对应的报告信息
		index = 2;
	}
	
	var a = "<p style='cursor:pointer;float:right;height:40px;'  class='click-to-see' data-toggle='modal'  onclick='seeOriginalReport(\"" + picLink + "\")' >点击查看原始报告单</p>";
	$("#readReport").html(a);
	$("#report_name").html(reportName);
	$("#report_table").html(unescape(report));
	$("#div_report").show();
}