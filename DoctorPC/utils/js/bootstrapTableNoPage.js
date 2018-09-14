//列表通用--参数url--访问地址、tableId--表格Id、columnParams--列的参数
var TableInit = function(url, tableId, columnParams,pagination) {
	var oTableInit = new Object();
	//初始化Table  
	oTableInit.Init = function(queryParams) {
		$("#" + tableId).bootstrapTable('destroy');
		oTableInit.qParams = queryParams;
		$("#" + tableId).bootstrapTable({
			url: url, //请求后台的URL（*）  
			method: 'post', //请求方式（*）  
			toolbar: '#toolbar', //工具按钮用哪个容器  
			striped: true, //是否显示行间隔色   
			cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）  
			pagination: false, //是否显示分页（*）  
			sortable: true, //是否启用	后端排序  
			onLoadSuccess: function() { //加载成功后的时间
				prfSearch(); //当前页面table数据搜索
				var bool = $("#" + tableId).html();
				if(bool.indexOf('没有找到匹配的记录') > 0) {
					$("#" + tableId + ' tr th div').removeClass('sortable both');
				} else {
					new tableSort(tableId); //使用前端排序
				}
			},
			queryParams: oTableInit.queryParams, //传递参数（*）
			sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）  
			pageNumber: 1, //初始化加载第一页，默认第一页  
			pageSize: 5, //每页的记录行数（*）  
			pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
			showColumns: false,
			//showHeader: true, //是否显示列头
			showColumns: false, //是否显示 内容列下拉框
			clickToSelect: false, //是否启用点击选中行  
			//height: 500, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度  
			uniqueId: "id", //每一行的唯一标识，一般为主键列  
			cardView: false, //是否显示详细视图  
			detailView: false, //是否显示父子表
			showRefresh: false, //是否显示刷新按钮
			showPaginationSwitch: false, //是否显示 数据条数选择框
			//showToggle: true, //是否显示 切换试图（table/card）按钮
			//search: true, //是否启用搜索框
			//searchAlign: 'right', //指定 搜索框 水平方向的位置。’left’ or ‘right’
			//strictSearch: true, //设置为 true启用 全匹配搜索，否则为模糊搜索
			columns: columnParams
		});
	};

	//得到查询的参数  
	oTableInit.queryParams = function(params) {
		oTableInit.qParams.pageIndex = params.offset;
		oTableInit.qParams.pageSize = params.limit;
		//oTableInit.qParams.sortName = this.sortName;
		//oTableInit.qParams.sortOrder = this.sortOrder;
		return oTableInit.qParams;
	};
	return oTableInit;
};

/* 
 * js 调用排序用法
 * 需放在页面table数据加载完后调用执行
 * 	  new tableSort('user_list');
 * 参数一：   需要排序的table ID
 * 参数二：	需要绑定点击事件（点击排序用）的开始行    
 * 参数三：	从第几行开始排序
 * 参数四：	遍历排序当列的最大行数
 * 参数五：	默认up  已支持升序 
 * 参数六：	down  已支持降序
 * 参数七：	排序table  class属性值
 */
var tableSort = function() {
	this.initialize.apply(this, arguments);
}
tableSort.prototype = {
	initialize: function(tableId) {
		var clickRow = 1;
		var startRow = 2;
		var endRow = 999;
		var classUp = "up";
		var classDown = "down";
		var selectClass = "tr_width tr_colo";
		this.Table = document.getElementById(tableId);
		this.rows = this.Table.rows; //所有行 
		this.Tagass = this.rows[clickRow - 1].cells; //标签td 
		this.up = classUp;
		this.down = classDown;
		this.startRow = startRow;
		this.selectClass = selectClass;
		this.endRow = (endRow == 999 ? this.rows.length : endRow);
		this.T2Arr = this._td2Array(); //所有受影响的td的二维数组 
		this.setShow(this);
	},
	//设置标签切换 
	setShow: function(that) {
		var defaultClass = that.Tagass[0].className;
		for(var Tag, i = 0; i < that.Tagass.length; i++) {
			Tag = that.Tagass[i];
			Tag.index = i;
			if(that.Tagass[i].innerText.trim() == "") {
				continue;
			}
			if(that.Tagass[i].innerText.trim() == "报告审核") {
				continue;
			}
			/*if(that.Tagass[i].innerText.trim() == "健康套餐") {
				continue;
			}*/
			if(that.Tagass[i].innerText.trim() == "风险因素") {
				continue;
			}
			if(that.Tagass[i].innerText.trim() == '报告上传完整度') {
				continue;
			}
			if(that.Tagass[i].innerText.trim() == '自测上传完整度') {
				continue;
			}
			if(that.Tagass[i].innerText.trim() == '操作') {
				continue;
			}
			//绑定 sortable asc
			addEventListener(Tag, 'click', Bind(Tag, statu));
			//addSortable(that.Tagass[i]);
		}
		var _this = that;
		var turn = 0;

		function statu() {
			for(var i = 0; i < _this.Tagass.length; i++) {
				_this.Tagass[i].className = defaultClass;
			}
			//遍历列值 ，判断是否需要排序
			var colValue = '';
			var j = 0;
			for(var i = 0; i < _this.T2Arr.length; i++) {
				if($(_this.T2Arr[i][this.index]).text().trim() == "") {
					if(i == 0) {
						colValue = "";
						colValue = _this.T2Arr[i][this.index];
					}
					if(_this.T2Arr[i][this.index] == colValue) {
						j++;
					}
				} else {
					if(i == 0) {
						colValue = "";
						colValue = $(_this.T2Arr[i][this.index]).text().trim();
					}
					if($(_this.T2Arr[i][this.index]).text().trim() == colValue) {
						j++;
					}
				}
			}
			if(j == _this.T2Arr.length) {
				return;
			}
			if(turn == 0) {
				addClass(this, _this.down)
				_this.startArray(1, this.index);
				turn = 1;
			} else {
				addClass(this, _this.up)
				_this.startArray(0, this.index);
				turn = 0;
			}
		}
	},
	//设置选中列样式 
	colClassSet: function(num, cla) {
		return; //得到关联到的td 
		for(var i = (this.startRow - 1); i < (this.endRow); i++) {
			for(var n = 0; n < this.rows[i].cells.length; n++) {
				removeClass(this.rows[i].cells[n], cla);
			}
			addClass(this.rows[i].cells[num], cla);
		}
	},
	//开始排序 num 根据第几列排序 aord 逆序还是顺序 
	startArray: function(aord, num) {
		var afterSort = this.sortMethod(this.T2Arr, aord, num); //排序后的二维数组传到排序方法中去 
		this.array2Td(num, afterSort); //输出 
	},
	//将受影响的行和列转换成二维数组 
	_td2Array: function() {
		var arr = [];
		for(var i = (this.startRow - 1), l = 0; i < (this.endRow); i++, l++) {
			arr[l] = [];
			for(var n = 0; n < this.rows[i].cells.length; n++) {
				var html = this.rows[i].cells[n].innerHTML;
				arr[l].push(this.rows[i].cells[n].innerHTML);
			}
		}
		return arr;
	},
	//根据排序后的二维数组来输出相应的行和列的 innerHTML 
	array2Td: function(num, arr) {
		this.colClassSet(num, this.selectClass);
		for(var i = (this.startRow - 1), l = 0; i < (this.endRow); i++, l++) {
			for(var n = 0; n < this.Tagass.length; n++) {
				this.rows[i].cells[n].innerHTML = arr[l][n];
			}
		}
	},
	//传进来一个二维数组，根据二维数组的子项中的w项排序，再返回排序后的二维数组 
	sortMethod: function(arr, aord, w) {
		arr.sort(function(a, b) {
			if(a[w] == b[w]) {
				return;
			}
			x = killHTML(a[w]);
			y = killHTML(b[w]);
			x = x.replace(/,/g, '');
			y = y.replace(/,/g, '');
			switch(isNaN(x)) {
				case false:
					return Number(x) - Number(y);
					break;
				case true:
					return x.localeCompare(y);
					break;
			}
		});
		arr = aord == 0 ? arr : arr.reverse();
		return arr;
	}
}
/*-----------------------------------*/
function addEventListener(o, type, fn) {
	if(o.attachEvent) {
		o.attachEvent('on' + type, fn);
	} else if(o.addEventListener) {
		o.addEventListener(type, fn, false);
	} else {
		o['on' + type] = fn;
	}
}

function hasClass(element, className) {
	var reg = new RegExp('(\s|^)' + className + '(\s|$)');
	return element.className.match(reg);
}

function addClass(element, className) {
	if(!this.hasClass(element, className)) {
		element.className += " " + className;
	}
}

function removeClass(element, className) {
	if(hasClass(element, className)) {
		var reg = new RegExp('(\s|^)' + className + '(\s|$)');
		element.className = element.className.replace(reg, ' ');
	}
}
var Bind = function(object, fun) {
	return function() {
		return fun.apply(object, arguments);
	}
}
//去掉所有的html标记 
function killHTML(str) {
	return str.replace(/<[^>]+>/g, "");
}
//前端搜索
function prfSearch() {
	try {
		$("#form-control").keyup(function() {
			var searchTerm = $("#form-control").val();
			var listItem = $('#user_list tbody').children('tr');
			var searchSplit = searchTerm.replace(/ /g, "'):containsi('")

			$.extend($.expr[':'], {
				'containsi': function(elem, i, match, array) {
					return(elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
				}
			});
			$("#user_list tbody tr").not(":containsi('" + searchSplit + "')").each(function(e) {
				$(this).attr('visible', 'false');
			});

			$("#user_list tbody tr:containsi('" + searchSplit + "')").each(function(e) {
				$(this).attr('visible', 'true');
			});

			var jobCount = $('#user_list tbody tr[visible="true"]').length;
			$('.counter').text(jobCount + ' item');

			if(jobCount == '0') {
				//$('.no-result').show();
			} else {
				//$('.no-result').hide();
			}
		});
	} catch(e) {}
}

/* js 调用排序end*/