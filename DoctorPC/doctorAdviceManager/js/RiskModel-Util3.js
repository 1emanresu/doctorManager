/*******  封装风险模型工具     @yinzx    ********/
var address = sessionStorage.getItem("address");
var UtilAddress = address.replace('doctormanager', 'knowledge');
//var UtilAddress = "http://192.168.1.60:8080/knowledge/";
//var address = "http://192.168.1.60:8080/doctormanager/";
//var mid = 'dg000001';
var mid = sessionStorage.getItem("mid");
var flag2 = true;
var aname = sessionStorage.getItem("gName");

$(function() {
	//网页加载即获取孕妇的风险信息
	getGravidato2();
})
var getGravidato2 = function() {
	var url = address + "gravidainfo/getabnormity.do";

	$.ajax({
		type: "post",
		url: url,
		dataType: "json",
		async: true,
		data: {
			mid: mid
		},
		success: function(result) {
			if(result != null || result != '') {
				var a = result;

				//alert(111);
				getRiskModel2('div-modelChart2', JSON.stringify(a), 'risk_result2');
				//console.log(data);
			}
		}
	});

}

/**
 * 生成风险评估雷达图
 * @param {Object} ChartID  存放echart的容器 id
 * @param {Object} gdata    孕妇风险信息 Json格式   {"risklist":[{"abnormity":"98","checkDate":"2017/9/24","riskscore":10,"cunit":"g/L","cid":116,"factortype":0,"cname":"血红蛋白"},{"checkDate":"2017/9/24","riskscore":5,"factortype":2,"cname":"恶心呕吐"},{"abnormity":"3.5","checkDate":"2017/10/8","riskscore":5,"cunit":"mmol/L","cid":41,"factortype":4,"cname":"空腹葡萄糖"},{"checkDate":"2017/9/24","riskscore":5,"cid":15,"factortype":3,"cname":"贫血（血红蛋白<100g/L）"}],"gweeks":26,"name":"张晓华","advicelist":["血红蛋白低,适当多吃富含铁的食物，每周吃一次动物肝脏对预防贫血很有好处。<非标>","血红蛋白低,经常食用动物血和豆腐做的羹汤，具有良好的防治缺铁性贫血的作用。<非标>","恶心呕吐,少食多餐，忌油腻食物。<标>"],"mid":"dg000002"}
 *                                   factortype 因子类型  0:化验，1：基因，2：症状，3：高危自评，4：自测
 * @param {Object} showID   存放风险信息的div id
 */
function getRiskModel2(ChartID, gradata, showID) {
	var gdata = JSON.parse(gradata)
	if(flag2) {
		creatDiv2(ChartID, showID);
		flag2 = false;
	}

	//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
	var resizemyChart2 = function() {
		document.getElementById('modelChart2').style.width = window.innerWidth / 4 + 'px';
		document.getElementById('riskChart2').style.width = window.innerWidth / 4.5 + 'px';
	};
	//设置容器高宽
	resizemyChart2();

	var ModelChart = echarts.init(document.getElementById('modelChart2'));
	var RiskChart = echarts.init(document.getElementById('riskChart2'));
	ModelOption = {
		title: {
			text: '妊娠风险评估雷达',
			textStyle: {
				color: '#666',
				fontSize: '18',
				fontFamily: '微软雅黑'
			},

		},
		tooltip: {},
		radar: [{
				indicator: [{
						name: '化验检查',
						max: 30
					},
					{
						name: '基因检查',
						max: 30
					},
					{
						name: '症状',
						max: 30
					},
					{
						name: '高危自评',
						max: 50
					},
					{
						name: '自测',
						max: 50
					}
				],
				center: ['50%', '55%'],
				radius: 110,
				startAngle: 90,
				splitNumber: 4,

				shape: 'circle',
				name: {
					formatter: '{value}',
					textStyle: {
						color: '#666666'
					}
				},

				splitArea: {
					areaStyle: {
						//              	color: ['#FFF5CF', 
						//                  '#FFE3A5','#FFDB85',
						//                  '#FBCB56'],
						//                	color: ['rgba(255,201,191,0.8)', 
						//                  'rgba(255,157,143,0.7)','rgba(255,129,106,0.8)',
						//                  '#FF5E3C'],
						color: ['rgba(255,229,12,0.3)',
							'rgba(255,179,0, 0.5)', 'rgba(255,127,80, 0.9)',
							'rgba(255, 50, 14, 0.8)'
						],
						shadowColor: 'rgba(0, 0, 0, 0.1)',
						shadowBlur: 10
					}
				},
				axisLine: {
					lineStyle: {
						color: 'rgba(255, 255, 255, 0.5)'
					}
				},
				splitLine: {
					lineStyle: {
						color: 'rgba(255, 255, 255, 0.5)'
					}
				}
			}

		],

		series: [{
			name: '妊娠风险评估雷达',
			type: 'radar',
			itemStyle: {
				emphasis: {
					// color: 各异,
					lineStyle: {
						width: 4
					}
				}
			},
			data: [{
				value: [],
				//name: 'demo',
				areaStyle: {
					normal: {
						opacity: 0.9,
						color: 'rgba(255, 255, 255, 0.5)'
					}
				}
			}]
		}]
	}
	RiskOption = {

		legend: {
			right: '5%',
			top: 35,
			data: []
		},
		tooltip: {},
		grid: [{
			left: 40,
			right: 20,
			top: '20%',
			height: '60%'
		}],
		toolbox: {
			show: true,
			right: 20,
			feature: {
				mark: {
					show: true
				},
				dataView: {
					show: true,
					readOnly: false
				},
				magicType: {
					show: true,
					type: ['line', 'bar', 'pie']
				},
				restore: {
					show: true
				}
			}
		},
		xAxis: [{
			type: 'category',
			data: ['化验检查', '基因检查', '症状', '高危自评', '自测'],
			axisTick: {
				alignWithLabel: true
			},
			splitNumber: 5,
		}],
		yAxis: [{
			name: '风险分值',
			nameTextStyle: {
				fontSize: 12
			},
			nameGap: 15,
			max: 30,
			min: 0,
			splitNumber: 6,
			type: 'value'
		}],
		series: [{
			type: 'bar',
			barWidth: '50%',
			itemStyle: {
				normal: {
					color: '#f8d351',
				}
			},
			data: []

		}]
	}
	ModelChart.setOption(ModelOption);
	RiskChart.setOption(RiskOption);

	/*********  指标各项异常信息    **********/
	var tablecont = "<label>姓名：" + aname + "</label><table id='riskfactor-table2'><tr><td>序号</td><td>出现时间</td><td>风险因素</td> <td>因素来源</td><td>风险分值</td></tr></table>"
	$('#' + showID + " .riskfactor-Msg2").html(tablecont);
	var risk = gdata;
	var length = risk.length;
	if(length > 0) {
		for(var i = 0; i < length; i++) {
			var riskcontent = risk[i].cname + "&nbsp;" + (risk[i].abnormity == null ? "" : risk[i].abnormity) + "&nbsp;" + (risk[i].cunit == null ? "" : risk[i].cunit);
			var factortype = getFactorType(risk[i].factortype)
			trcontent = "<tr><td>" + (i + 1) + "</td><td>" + longToDate(risk[i].checkDate) + "</td>" +
				"<td style='color:rgb(255, 50, 14)'>" + riskcontent + "</td><td>" + factortype + "</td><td>" + risk[i].riskscore + "</td></tr>";
			$("#riskfactor-table2").append(trcontent)
		}
	}

	var advice = gdata.advicelist;
	//console.log("advice:"+JSON.stringify(advice));
	$('#' + showID + " .riskfactor-Advice2").html("");
	if(advice != null && advice.length > 0) {
		for(var i = 0; i < advice.length; i++) {
			var advicecont = "<p>" + (i + 1) + "&nbsp;&nbsp;" + advice[i] + "</p>";
			$('#' + showID + " .riskfactor-Advice2").append(advicecont)

		}
		var tipcont = "<p style='margin-top:20px;color:#888888;'><标>：来源自国家卫生和计划生育委员会“十二五”规划教材《妇女保健学》、《妇产科学》第二版&第八版</p>" +
			"<p style='color:#888888;'><非标>：来源自百度文库、豆丁网、道客巴巴等网络资源，供参考</p>";
		$('#' + showID + " .riskfactor-Advice2").append(tipcont)
	}

	/***************     计算各项风险得分         *****************/
	var data = gdata;
	//console.log(data)
	var length = data.length;
	var lscore = 0; //化验得分
	var litem = "" //化验列表
	var egscore = 0; //基因得分
	var egitem = ""; //基因列表
	var symptomscore = 0; //症状得分
	var symptomitem = ""; //症状列表
	var hscore = 0; //高危得分
	var hitem = ""; //高危列表
	var sfscore = 0; //自测得分
	var sfitem = ""; //自测列表
	if(length > 0) {
		for(var i = 0; i < length; i++) {
			var factortype = data[i].factortype;
			switch(factortype) {
				case 0:
					{ //"化验检查"
						lscore += data[i].riskscore;
						litem += data[i].cname + "&nbsp;" + (data[i].abnormity == null ? "" : data[i].abnormity) + "&nbsp;" + (data[i].cunit == null ? "" : data[i].cunit) + "<br />";
						break;
					}

				case 1:
					{ //"基因检查"
						egscore += data[i].riskscore;
						egitem += data[i].cname + "&nbsp;" + (data[i].abnormity == null ? "" : data[i].abnormity) + "&nbsp;" + (data[i].cunit == null ? "" : data[i].cunit) + "<br />";

						break;
					}
				case 2:
					{ // "症状"
						symptomscore += data[i].riskscore;
						symptomitem += data[i].cname + "&nbsp;" + (data[i].abnormity == null ? "" : data[i].abnormity) + "&nbsp;" + (data[i].cunit == null ? "" : data[i].cunit) + "<br />";

						break;
					}
				case 3:
					{ //"高危自评"
						hscore += data[i].riskscore;
						hitem += data[i].cname + "&nbsp;" + (data[i].abnormity == null ? "" : data[i].abnormity) + "&nbsp;" + (data[i].cunit == null ? "" : data[i].cunit) + "<br />";

						break;
					}
				case 4:
					{ //"自测"
						sfscore += data[i].riskscore;
						sfitem += data[i].cname + "&nbsp;" + (data[i].abnormity == null ? "" : data[i].abnormity) + "&nbsp;" + (data[i].cunit == null ? "" : data[i].cunit) + "<br />";

						break;
					}
			}

		}
	}
	var sumScore = lscore * 0.2 + egscore * 0.2 + symptomscore * 0.2 + hscore * 0.2 + sfscore * 0.2;
	var content = "<p style='margin-top:10px;color:#FD8A5F;'>本次风险评估总分=" + sumScore + "分</p>" +
		"<p style='color:#888888;'>风险总分=化验检查得分*20%+基因检查得分*20%+症状得分*20%+高危自评得分*20%+自测得分*20%</p>" +
		"<p style='color:#888888;'>风险总分：2~4分属于轻度高危；5~7分属于中度高危；8分以上属于重度高危</p>"

	$('.riskfactor-Msg2').append(content)
	var score = [lscore, egscore, symptomscore, hscore, sfscore];
	//console.log(score)
	ModelChart.hideLoading(); //隐藏加载动画
	ModelChart.setOption({ //加载数据图表
		legend: {
			right: '5%',
			top: 35,
			data: gdata.name

		},
		series: [{
			name: gdata.name,
			type: 'radar',
			itemStyle: {
				emphasis: {
					// color: 各异,
					lineStyle: {
						width: 4
					}
				}
			},
			data: [{
				value: score,
				name: gdata.name,
				areaStyle: {
					normal: {
						color: 'rgba(255, 255, 255, 0.5)'
					}
				}
			}]
		}]

	});
	RiskChart.setOption({

		series: [{
			type: 'bar',
			barWidth: '50%',
			itemStyle: {
				normal: {
					color: '#f8d351',
				}
			},
			data: score
		}]

	});
	//echart 聚焦事件

	RiskChart.on('mouseover', function(params) {
		if(params.componentType === 'series' && (params.seriesType === 'bar' || params.seriesType === 'line')) {
			var dataIndex = params.dataIndex;
			var itemname = "";
			var itemcontent = ""
			switch(dataIndex) {
				case 0:
					{ //"化验检查"
						itemname = "化验检查";
						itemcontent = litem;
						break;
					}

				case 1:
					{ //"基因检查"

						itemname = "基因检查"
						itemcontent = egitem;
						break;
					}
				case 2:
					{ // "症状"

						itemname = "症状";
						itemcontent = symptomitem;
						break;
					}
				case 3:
					{ //"高危自评"

						itemname = "高危自评"
						itemcontent = hitem;
						break;
					}
				case 4:
					{ //"自测"

						itemname = "自测"
						itemcontent = sfitem;
						break;
					}
			}
			RiskChart.setOption({
				tooltip: {
					formatter: function(params, ticket, callback) {
						return itemname + "：" + params.value + "分<br />风险因素：<br />" + itemcontent;
					}
				}
			});

		}

	});

	/*********  指标医嘱建议    **********/
	//var advice = gdata.advicelist;
	$(".riskfactor-Advice2").html("");
	if(advice != null && advice.length > 0) {
		for(var i = 0; i < advice.length; i++) {
			var advicecont = "<p>" + (i + 1) + "&nbsp;&nbsp;" + advice[i] + "</p>";
			$("#" + showID + " .riskfactor-Advice2").append(advicecont)

		}
		var tipcont = "<p style='margin-top:20px;color:#888888;'><标>：来源自国家卫生和计划生育委员会“十二五”规划教材《妇女保健学》、《妇产科学》第二版&第八版</p>" +
			"<p style='color:#888888;'><非标>：来源自百度文库、豆丁网、道客巴巴等网络资源，供参考</p>";
		$("#" + showID + " .riskfactor-Advice2").append(tipcont)
	}

}

/**
 * 风险因素类型
 * @author yinzx
 * @param {Object} factortype 0:化验，1：基因，2：症状，3：高危自评，4：自测
 */
function getFactorType(factortype) {
	var msg = "";
	switch(factortype) {
		case 0:
			msg = "化验检查"
			break;
		case 1:
			msg = "基因检查"
			break;
		case 2:
			msg = "症状"
			break;
		case 3:
			msg = "高危自评"
			break;
		case 4:
			msg = "自测"
			break;
	}
	return msg;
}

//生成所需的DIV
function creatDiv2(ChartID, showID) {
	$('#' + ChartID).append("<div id='modelChart2'></div><div id='riskChart2'></div>")

	var divCont = "<div class='row'><div class='col-md-6'><label>风险因素:</label><div class='riskfactor-Msg2'>" +
		"</div></div></div>";
	$('#' + showID).append(divCont);
}