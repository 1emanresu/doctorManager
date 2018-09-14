var address = sessionStorage.getItem("address");
var url = address + 'gravidainfo/findByPage.do';
var typeId;
var oTable;
var queryList = function(queryParams, tableId) {
	if(tableId == undefined) tableId = "user_list";
	typeId = queryParams.typeId;
	var oTableInit = new Object();
	oTable = new TableInit(url, tableId, returnColumn(typeId), true);
	oTable.Init(queryParams);
}
var columnParams;
var countParams;
var returnColumn = function(tId) {
	columnParams = [];
	var countParams = {
		"checkbox": {
			title: 'checkbox',
			width: '4%',
			align: 'center',
			checkbox: true
		},
		"num": {
			title: '序号',
			align: 'center',
			sortable: true,
			width: '4%',
			clickToSelect: false, //点击是否选择此行
			formatter: function(value, row, index) {
				return "<span>" + (parseInt(index) + 1) + "</span>";
			}
		},
		"medicalrecordno": {
			field: 'medicalRecordNo',
			title: '病历号',
			width: '8%',
			align: 'center',
			clickToSelect: false,
			sortable: true
		},
		"name": {
			field: 'gName',
			title: '姓名',
			width: '6%',
			align: 'center',
			clickToSelect: false,
			sortable: true,
			formatter: function(value, row, index) {
				return "<a style='cursor: pointer;' onclick='setMid(\"" + row.mId + "\",\"" + row.gName + "\")'>" + row.gName + "</a>";
			}
		},
		"age": {
			field: 'birthYears',
			title: '年龄',
			align: 'center',
			width: '6%',
			clickToSelect: false,
			sortable: true,
			formatter: function(value) {
				return getAge(longToDate(value));
			}
		},
		"weeks": {
			field: 'endDate',
			title: '孕周',
			width: '6%',
			align: 'center',
			clickToSelect: false,
			sortable: true,
			formatter: function(value) {
				return getWeeks(value).weeks
			}
		},
		"high_grade": {
			field: 'risklist',
			title: '高危级别',
			sortable: true,
			width: '8%',
			align: 'center',
			clickToSelect: false,
			formatter: function(value, row, index) {
				var str = JSON.stringify(row);
				var score = 0;
				for(var i = 0; i < value.length; i++) {
					score += value[i].riskscore;
				}
				score = score * 0.2;
				var riskType = getriskType(score);
				if(riskType.indexOf('red') >= 0) {
					return "<div style='cursor: pointer;'  id='select-gravida-" + index + "'  onclick='showMoreRisk(this.id," + str + ")'>" + riskType + "</div>";
				} else {
					return riskType;
				}
			}
		},
		"risk_factor": {
			title: '风险因素',
			align: 'center',
			valign: 'middle',
			formatter: function(value, row, index) {
				var risklist = row.risklist;
				var str = JSON.stringify(row);
				var riskcont = "";
				if(risklist.length != 0) {
					riskcont = risklist[0].cname + "&nbsp;" + (risklist[0].abnormity == null ? "" : risklist[0].abnormity) + "&nbsp;" + (risklist[0].cunit == null ? "" : risklist[0].cunit);
					riskcont = "<div style='color:red;cursor: pointer;'  id='select-gravida-" + index + "'  onclick='showMoreRisk(this.id," + str + ")'>" + riskcont + "</div>";
				} else {
					riskcont = "暂无风险";
				}
				return riskcont;
			}
		},
		"report_integrity": {
			field: 'mId',
			title: '报告上传完整度',
			align: 'center',
			width: '10%',
			clickToSelect: false,
			formatter: function(value, row, index) {
				return getPercentage(row);
			}
		},
		"mul_service": {
			title: '健康套餐',
			align: 'center',
			width: '10%',
			clickToSelect: false,
			formatter: function(value, row, index) {
				return getVipGrade(value, row, index);
			}
		},
		/**
		 * 处理状态 (未处理,已处理) 可排序
		 */
		"make_State": {
			title: '处理状态',
			align: 'center',
			width: '10%',
			sortable: true,
			clickToSelect: false,
			formatter: function(value, row, index) {
				return make_State(row);
			}
		},
		"mul_healthy": {
			field: 'vipGradeName',
			title: '健康套餐',
			align: 'center',
			width: '10%',
			clickToSelect: false,
		},
		"test_integrity": {
			field: 'mId',
			title: '自测上传完整度',
			align: 'center',
			width: '10%',
			clickToSelect: false,
			formatter: function(value, row, index) {
				return getTestPercentage(row);
			}
		},

		"report_examine": {
			title: '报告审核',
			align: 'center',
			clickToSelect: false,
			formatter: function(value, row, index) {
				return getHealthy(tId, row);
			}
		},
		"operation": {
			field: '',
			title: '操作',
			align: 'center',
			clickToSelect: false,
			width: '8%',
			formatter: function(value, row, index) {
				return operation(row, tId);
			}
		}
	}
	columnParams.push(countParams.checkbox)
	switch(tId) {
		case 1:
			//建档审核
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险提示
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.mul_service); //服务套餐
			columnParams.push(countParams.operation); //操作
			break;
		case 2:
			//已建档 表格样式 
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险提示
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.mul_service); //健康套餐
			columnParams.push(countParams.report_examine); //报告审核
			columnParams.push(countParams.operation); //操作
			break;
		case 3:
			//患者未处理
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险提示
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.test_integrity); //自测上传完整度
			columnParams.push(countParams.mul_service); //健康套餐
			columnParams.push(countParams.operation); //操作
			break;
		case 4:
			//患者已处理
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险提示
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.test_integrity); //自测上传完整度
			columnParams.push(countParams.mul_service); //健康套餐
			columnParams.push(countParams.operation); //操作
			break;
		case 5:
			//医生嘱咐 发送医嘱
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险因素
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.test_integrity); //自测上传完整度
			columnParams.push(countParams.mul_service); //服务套餐
			columnParams.push(countParams.make_State); //处理状态
			columnParams.push(countParams.operation); //操作
			break;
		case 6:
			//医生嘱咐已经处理
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险因素
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.test_integrity); //自测上传完整度
			columnParams.push(countParams.mul_service); //健康套餐
			columnParams.push(countParams.operation); //操作
			break;
		case 7:
			//微报告  发送报告
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险因素
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.test_integrity); //自测上传完整度
			columnParams.push(countParams.mul_service); //服务套餐
			columnParams.push(countParams.operation); //操作
			break;
		case 8:
			//微报告已处理
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险因素
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.test_integrity); //自测上传完整度
			columnParams.push(countParams.mul_service); //健康套餐
			columnParams.push(countParams.operation); //操作
			break;
		case 9:
			//档案信息管理
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险因素
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.test_integrity); //自测上传完整度
			columnParams.push(countParams.mul_service); //服务套餐
			columnParams.push(countParams.operation); //操作
			break;
		case 10:
			//发送提醒
			columnParams.push(countParams.num); //序号
			columnParams.push(countParams.medicalrecordno); //病历号
			columnParams.push(countParams.name); //名称
			columnParams.push(countParams.age); //年龄
			columnParams.push(countParams.weeks); //孕周
			columnParams.push(countParams.high_grade); //高危级别
			columnParams.push(countParams.risk_factor); //风险因素
			columnParams.push(countParams.report_integrity); //报告上传完整度
			columnParams.push(countParams.test_integrity); //自测上传完整度
			columnParams.push(countParams.mul_service); //服务套餐
			columnParams.push(countParams.operation); //操作
			break;
		default:
			alert("typeId params error");
	}
	return columnParams;
}