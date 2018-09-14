/********   医嘱编辑 js  @author yinzx      *********/


//var address = sessionStorage.getItem("address");
var address = sessionStorage.getItem("address");
//var address = "http://192.168.1.60:8080/knowledge/";
var UtilAddress = address.replace('doctormanager','knowledge');
//var  UtilAddress = "http://192.168.1.60:8080/knowledge/";   //上传项目后 应注释该句代码

var insert_advice_box;
var getText;
var showTips;
var util;
var edittipsSendWeekly;
$(function() {
	var EditTips = function (divID){
		this.divID = divID;
	}
	EditTips.prototype = {
		init:function(){
				//绑定事件
				$("#"+this.divID).keyup(KeyUpFun);
				$("#"+this.divID).keydown(KeyDownFun);
//				var address = sessionStorage.getItem("address");
//				if(address == null) {
//					address = "http://192.168.1.43:8080/knowledge/";
//				}
				var lastEditRange;  //
				var tips_length = 0; //记录提示信息的条数
				var word_length = 2; //设置默认关键词长度为2
				var downNum = 0; //记录按下向下方向键的次数  
				var divid = this.divID;
				
				$("#"+divid).click(function() {
					$('#tips').hide();
					$('#tips').empty();
					var selection = document.getSelection();
					lastEditRange = selection.getRangeAt(0).getBoundingClientRect();
					$('#tips').css({position: "absolute",'top':lastEditRange.top+15,'left':lastEditRange.left})
				
				});
				$("#"+divid).bind('input propertychange ',function(){
					$('#tips').hide();
					$('#tips').empty();
					var selection = document.getSelection();
					lastEditRange = selection.getRangeAt(0).getBoundingClientRect();
					$('#tips').css({position: "absolute",'top':lastEditRange.top+15,'left':lastEditRange.left})
				})
				/**
				 * 监听键盘按键松开事件
				 */
				function KeyUpFun() {
					//getKeywordValue(word_length)
					//console.log("ele="+text)
					var e = e || event;
					var currKey = e.keyCode || e.which || e.charCode;
					if(!$("#tips").is(":hidden")){
						if(currKey == 38) { //按放开向上键  
							var element = document.getElementById(divid)
					        var cont = getInnerText(element);
					        console.log(cont);
					        $("#"+divid).html("");
							insertHtmlAtCaret(divid,cont);
						}
					}

				}
				/**
				 * 监听键盘按键按下事件，定义快捷键事件
				 * @author yinzx
				 */
				function KeyDownFun() {
					//	var p=$('.worditem').html();
					//	console.log('      |'+p+'|');
					//	console.log(p==null);
					var e = e || event;
					var currKey = e.keyCode || e.which || e.charCode;
					if(currKey == 40) { //按下向下键  
						$(".item").removeClass('tips_selected');
						downNum = downNum + 1;
						$("#" + (downNum - 1)).addClass('tips_selected');
						if(downNum > tips_length) {
							downNum = tips_length;
							$("#" + (downNum - 1)).addClass('tips_selected');
						}
						
					} else if(currKey == 38) { //按下向上键  
						$(".item").removeClass('tips_selected');
						if(downNum > 0) {
							downNum = downNum - 1;
							$("#" + (downNum - 1)).addClass('tips_selected');
						}
						$("#" + (downNum - 1)).addClass('tips_selected');
				
					}else if(currKey == 39) { //右（下一页）						
						page.setNext(page.index+1);
	    				showTips(page.data);				
					}else if(currKey == 37) { //左  
						page.setPrev(page.index-1);
	    				showTips(page.data);			
					} else if(currKey == 32) {//按下空格键
						if($('.item').html() != null) {
							var element = document.getElementById(divid)
					        var cont = getInnerText(element)
					        $("#"+divid).html("");
					        //去除词条
					        insertHtmlAtCaret(divid,cont.substring(0,cont.length-word_length))
							//替换提示信息
							var tipsCont=$("#" + (downNum - 1)).text();
							insertHtmlAtCaret(divid,tipsCont);
							//用户登记
							var sid=$("#"+(downNum-1)).attr("searchid");
							userUtil.userRecord(sid);
				//			var cont = $(this.divID).html();
				//			$(this.divID).html(cont + tipsCont);
							$('#tips').empty();
						}
						if($('.worditem').html() != null) {
							var wlength = $("#word" + (downNum - 1)).text();
							console.log("wlength=" + wlength);
							word_length = wlength;
							$('#tips').html("修改成功");
						}
						$('#tips').hide();
						downNum = 0;
				
					};
					// ctrl+enter 发送消息
					if(e.ctrlKey && e.which == 13) {
						sendAdviceMsg();
					}
					//Alt+s 切换关键字长度
					if(e.altKey && e.which == 83) {
						console.log("切换关键字")
						changeKeyLength();
					}
					//Alt+/ 提示信息
					if(e.altKey && e.which == 191) {
						console.log("提示信息")
						getKeywordValue(word_length);
					}
					
				}
				/****** 切换关键字长度    ******/
				
				/******* 发送消息     ******/
				/*$('#btn_send').click(function() {
				
					sendAdviceMsg();
				})
				
				function sendAdviceMsg() {
					var sendDiv=$("#"+edittips.divID);
					var cont = sendDiv.html();
					console.log(cont);
					//定义发送的数据
					var data=new Date();			
					$('#postMsgArea').append("<div class='sendMsg_div'>"+data.getHours()+":"+data.getMinutes()+"</div>")
					var send = "<div class='sendMsg_div'><div class='sendMsg'>" + cont + "</div></div>";
					$('#postMsgArea').append(send)
					//设置最底滚动条
					$('#postMsgArea').scrollTop( $('#postMsgArea').height());
					$('#tips').empty();
					sendDiv.empty();
				}*/
				
				/**
				 * 检索词条信息 
				 * @author yinzx
				 * @param {Object} length  keyword关键字的长度
				 */
				function getKeywordValue(length) {
					$('#tips').empty();
					var element = document.getElementById(divid)
					var cont = getInnerText(element)
					//var cont = $(this.divID).html();
					var contLength = cont.length;
					console.log("contLength=" + contLength);
					var keyword = '';
				
					if(contLength >= length) {
						keyword = cont.substr(contLength - length, contLength);
						console.log("cont=" + cont + "|");
						console.log("keyword=" + keyword);
					} else {
						keyword = cont;
						console.log("keyword=" + cont);
					}
					
					
					$.ajax({
						type: "post",
						url: UtilAddress + "wordSearch/findValue.do",
						dataType: "json",
						contentType: "application/x-www-form-urlencoded; charset=UTF-8",
						data: {
							keyword: keyword
						},
						async: false,
						success: function(result) {				
							console.log("--------ajax---------")
							var data = result.data;
							page.getData(data);		//为了分页
							console.log(JSON.stringify(data))
							if(data != null && data.length > 0) {
								showTipsItem(data)
							} else {
								
								showTipsItem(null)
							}
						},
						error: function(e) {
							
							
							showTipsItem(null)
						}
					});
				}
				/**
				 * 展示词条提示信息
				 * @author yinzx
				 * @param {Object} data 词条信息集
				 */
				function showTipsItem(data) {
				
					//将分解之后得到的选项添加到tips里面。  
					$('#tips').show();
					$('#tips').empty();
					if(data==null){			
						$("#tips").append("<div class='item form-control'>暂无提示信息</div>");
						return;
					}
					tips_length = data.length;
					//zhujc修改的代码*****************
					
					var index=(page.index-1)*page.eachSize;
					var i,j
					for(i = index,j=0; i<(index+7)&&i<data.length; i++,j++) {
						var id=	data[i].searchid;
						var a = data[i].value;
						$('#tips').append("<div class='item form-control' id='" + j + "' searchid='"+id+"'>" + a + "</div>");
					}
					//添加分页区域
					$('#tips').append("<button class='btn btn-default' id='tipUP'  >上一页</button>");
					$('#tips').append("<button class='btn btn-default' id='tipNext'>"+page.index+"</button>");
					$('#tips').append("<button class='btn btn-primary' id='tipDown'>下一页</button>");
					//对每个选项绑订mouseenter事件,当光标经过，加亮该选项  
					$('.item').mouseenter(function() {
						$(this).addClass('tips_selected').siblings().removeClass('tips_selected');
					});
					//对每个选项绑订click事件,点击某个选项时，将该选项的值,添加到搜索输入框，并且清空所有选项  
					$('.item').click(function() {
						var element = document.getElementById(divid)
					    var cont = getInnerText(element)
					    $("#"+divid).html("");
					    //去除词条
					    insertHtmlAtCaret(divid,cont.substring(0,cont.length-word_length))
						//替换提示信息
						var tipsCont=$(this).text();
						insertHtmlAtCaret(divid,tipsCont)
						//登记用户记录-zhujc:2017-11-01 11:00
						var sid=$(this).attr("searchid");
						$('#tips').empty();
						$('#tips').hide();
						userUtil.userRecord(sid);
						//
						
					})
				}
				
				showTips=showTipsItem;
				/**
				 * 切换关键词长度
				 */
				function changeKeyLength() {
					$('#tips').empty();
					$('#tips').append("<div> 切换关键词长度</div>");
					var a = 2;
					for(var i = 0; a < 7; i++) {
						$('#tips').append("<div class='worditem ' id='word" + i + "'>" + a + "</div>");
						a++;
					}
					tips_length = 5;
					//对每个选项绑订mouseenter事件,当光标经过，加亮该选项  
					$('.worditem').mouseenter(function() {
						$(this).addClass('tips_selected').siblings().removeClass('tips_selected');
					});
					//对每个选项绑订click事件,点击某个选项时，将该选项的值,添加到搜索输入框，并且清空所有选项  
					$('.worditem').click(function() {
						var wlength = $(this).text();
						console.log("wlength=" + wlength);
						word_length = wlength;
						$('#tips').html("修改成功");
						
					});
				}
				
				
				/**
				 * 获取div中的文本内容
				 * @param {Object} element  id选择器的element对象
				 */
				function getInnerText(element) {
					return(typeof element.textContent == "string") ?
						element.textContent : element.innerText;
				}
				getText=getInnerText;
				/**
				 * 在光标处增加html
				 * @param {Object} div编辑器的 id名
				 * @param {Object} html
				 */
				function insertHtmlAtCaret(divId,html) {
					document.getElementById(divId).focus();    //获得焦点   
					var sel, range;
					if(window.getSelection) {
						// IE9 and non-IE
						sel = window.getSelection();
						if(sel.getRangeAt && sel.rangeCount) {
							range = sel.getRangeAt(0);
							range.deleteContents();
							// Range.createContextualFragment() would be useful here but is
							// non-standard and not supported in all browsers (IE9, for one)
							//去除字
							var index=html.indexOf("<");							
							if(index!=-1){				
								html=html.substring(0,index);
								
							}						
							//定义div
							var el = document.createElement("div");
							el.innerHTML = html;
							var frag = document.createDocumentFragment(),
								node, lastNode;
							while((node = el.firstChild)) {
								lastNode = frag.appendChild(node);
							}
							range.insertNode(frag);
							// Preserve the selection
							if(lastNode) {
								range = range.cloneRange();
								range.setStartAfter(lastNode);
								range.collapse(true);
								sel.removeAllRanges();
								sel.addRange(range);
							}
						}
					} else if(document.selection && document.selection.type != "Control") {
						// IE < 9
						document.selection.createRange().pasteHTML(html);
					}
				}
				insert_advice_box=insertHtmlAtCaret;
		}
	}
	
	var edittips = new EditTips("thisAdvice_content");
	
	
	edittips.init();
	util=edittips;
	edittipsSendWeekly=util;
	$("#tips").on("click","#tipDown",function(){		
		page.setNext(page.index+1);   
	    showTips(page.data);
	});
	
	
//	window.EditTips = EditTips;
});

