//pc端发送医嘱的html
var adviceEncapsulation = function(){
	var htm = "<div class='tab-pane data-show'>"+
							
							"<div class='advice-input'>"+
								
								"<div class='inputs' id='inputs' >"+
									"<div id='tools_bar'>"+
										"<img src='../../images/ask.png' alt='' />"+
										"<img src='../../images/adviceManager.png' alt='' />"+
										"<img src='../../images/wf_fonts.png' alt='' />"+
										"<img src='../../images/ask1.png' alt=' id='gravida_ask_img' />"+
										"<img src='../../images/whatshort.png' alt='' id='slide_img' style='float: right;' />"+
									"</div>"+
									
								"<div class='div_container'>"+
									"<div class='class_serious_risk div_border kangaroo_ask_div'>"+

									"<div class='changeMari'>"+
										"<img src='../../images/ask.png' alt=''   />"+
										"<span>袋鼠爱问</span>"+
									"</div>"+
									"<div id='img_firstDiagnos_serious_close' class='img_close'>"+
										"<img src='../../images/guanbi.png' />"+
									"</div>"+
									"<div id='kangaroo_ask'>"+
										"<div class='row'>"+
											"<div class='col-md-7 col-md-offset-1'>"+
												"<span>关键词：</span>"+
												"<input type='text' class='form-control' id='word_search' placeholder='请输入词条，例如：红细胞' />"+
											"</div>"+
											"<div class='col-md-4'>"+
												"<span>&nbsp;</span>"+
												"<button type='button' id='btn_search' class='btn btn-primary btn-block'>检索</button>"+
											"</div>"+
										"</div>"+
										"<div class='row'> </div>"+
										"<div class='panel-body info_show_container' id='sun_container'>"+

										"</div>"+
										"</div>"+
									"</div>"+
								"</div>"+
									"<div class='div_container'>"+
										"<div class='class_serious_risk div_border kangaroo_ask_div'>"+
											"<div class='changeMari'>"+
												"<img src='../../images/adviceManager.png' alt='' />"+
												"<span>管理</span>"+
											"</div>"+
											"<div id='img_firstDiagnos_serious_close' class='img_close'>"+
												"<img src='../../images/guanbi.png'/>"+
											"</div>"+
											"<div>"+
												
												"<div class='main_cont'>"+
													"<div class='row'>"+
														"<div id='gravidaList-tips'></div>"+
														"<table id='gravidaList'>"+
			
														"</table>"+
													"</div>"+
			
													"<div class='div_RiskModel'>"+
														
														"<div id='div-modelChart'>"+
															
															"<div id='modelChart'>"+
			
															"</div>"+
			
														
															"<div id='riskChart' style='margin-left: 150px;'>"+
			
															"</div>"+
			
														"</div>"+
			
														"<div id='risk_result'>"+
															"<div class='row'>"+
			
																"<div class='col-md-6'>"+
																	"<label>风险因素:</label>"+
																	"<div class='riskfactor-Msg'>"+
			
																	"</div>"+
																"</div>"+
																"<div class='col-md-5'>"+
																	"<label>评估建议:</label>"+
																	"<div class='riskfactor-Advice'>"+
			
																	"</div>"+
			
																"</div>"+
															"</div>"+
														"</div>"+
			
													"</div>"+
											
													"<div id='modal_RiskFactor' class='modal fade' tabindex='-1' role='dialog'>"+
														"<div class='modal-dialog' role='document'>"+
															"<div class='modal-content'>"+
																
																"<div id='content_RiskFactor'>"+
																	"<div class='closeMove'>"+
																		"<img id='riskmodal_close' src='../images/guanbi.png' />"+
																	"</div>"+
																	"<div id='risk-gravida'>"+
																		"<label>姓名：<span id='risk-gname'></span></label>"+
																		"<label>孕周：<span id='risk-gweeks'></span></label>"+
																	"</div>"+
																	"<table id='risk-table'>"+
																		"<tr>"+
																			"<td>序号</td>"+
																			"<td>出现时间</td>"+
																			"<td>风险因素</td>"+
																			"<td>因素来源</td>"+
																			"<td>风险分值</td>"+
																		"</tr>"+
																	"</table>"+
			
																"</div>"+
															"</div>"+
														"</div>"+
													"</div>"+
			
												"</div>"+
											"</div>"+
										"</div>"+
									"</div>"+
									"<div class='div_container'>"+
										"<div class='class_serious_risk div_border message-div'>"+
		
											"<div class='changeMari'>"+
												"<img src='../../images/wf_fonts.png' alt='' />"+
												"<span>快捷建提示</span>"+
											"</div>"+
											"<div id='img_firstDiagnos_serious_close' class='img_close'>"+
												"<img src='../../images/guanbi.png'/>"+
											"</div>"+
											"<div class='toolbar_input_tips'>"+
												"快捷键说明：<br /> Alt+/ 键：提示信息<br /> Alt+s 键：切换关键词长度<br /> 空格键：选中信息条"+
												"<br /> 词条例子："+
												"<br /> 失眠/sm：失眠,避免含咖啡因饮料..."+
												"<br /> 心率加快/xljk：心率加快,避免... <br /> 腹泻/fx： 腹泻,易引起脱水...<br /> 胸闷气短/xmqd：胸闷气短,侧睡... <br /> 血红蛋白/xhdb： 血红蛋白低,定期...<br /> 血红蛋白/xhdb： 血红蛋白高,注意...<br /> 白细胞/bxb：白细胞偏高,注意..."+
												"<br /> 红枣/hz：红枣,补充维生素..."+
												"<br /> 呕吐/ot：呕吐,少食多餐... <br />"+
											"</div>"+
										"</div>"+
									"</div>"+
									
									"<div class='div_container'>"+
										"<div class='class_serious_risk div_border message-div'>"+
										
											"<div class='changeMari'>"+
												"<img src='../../images/ask1.png' alt='' />"+
												"<span>孕妇提问</span>"+
											"</div>"+
											
											"<div id='img_firstDiagnos_serious_close' class='img_close'>"+
												"<img src='../../images/guanbi.png'/>"+
											"</div>"+
											"<div id='gravida_ask_div'>"+
												"<div>"+
													"<p>2017年11月</p>"+
													"<p>豆腐干大概对方是个顺丰大概士大夫</p>"+
													"<p>地方士大夫大师傅似的"+
														"<a href="" style='color: #0088CC;'>查看医嘱</a>"+
													"</p>"+
												"</div>"+
											"</div>"+
										"</div>"+
									"</div>"+
									
									"<div class='thisAdvice_content' id='thisAdvice_content' contenteditable='true'>"+
										
									"</div>"+
									"<div class='input-img'>"+
										"<img src='images/add.png' width='25px'/>"+
										"<a href='#key_value_insert_modal' id='insert_btn'>保存至我的医嘱</a>"+
									"</div>"+
								"</div>"+
								
								"<div class='inputs-right' id='inputs-right'>"+
									"<div class='row'>"+
							      		"<div class='col-md-9'><input  id='search_box' class='form-control'/></div>"+
								      	"<div class='col-md-3'><button id='search' type='button' class='btn btn-primary form-control'>搜&nbsp;&nbsp;索</button></div>"+
							      	"</div>"+
							      	"<table class='advice-table1' id='advice-table1'>"+
										"<tr>"+
											"<td class='advice' keyword='pregnancysymptom'>症状</td>"+
											"<td class='advice' keyword='food'>饮食</td>"+
											"<td class='advice' keyword='medicine'>用药</td>"+
											"<td class='advice' keyword='exercise'>运动</td>"+
											"<td class='advice' keyword='disease'>疾病</td>"+
											"<td class='my_advice'>我的医嘱</td>"+
										"</tr>"+
									"</table>"+
									"<div class='right-span' id='right-span' contenteditable='true'>"+
										
									"</div>"+
									
								      "<div id='page' class='row'>"+
								      	"<div class='col-md-8' style='color: #0099FF;'>双击指定医嘱可快速添加</div>"+
								      	"<div class='col-md-2'>"+
								      		"<button class='btn btn-default' id='prev' style='margin-left: -20px;margin-top: -8px;padding: 5px 12px!important;'>上一页</button>"+
								      	"</div>"+		      	
								      	"<div class='col-md-2'>"+
								      		"<button class='btn btn-primary only' id='next' style='margin-left: -20px;margin-top: -8px;padding: 5px 12px!important;background-color: #78A9ED;border: 1px solid #78A9ED;'>下一页</button>"+
								      	"</div>"+
								      "</div>"+
								"</div>"+
								"<div class='row'>"+
							      	  "<div class='col-md-5' id='tips' >"+
							      	  	
							        "</div>"+
							          
							    "</div>"+
							"</div>"+
						"</div>"+
						
						
						"<div class='modal fade' id='key_value_insert_modal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>"+
						  "<div class='modal-dialog' role='document'>"+
						    "<div class='modal-content modal-body4'>"+
						      "<div class='modal-header'>"+
						        "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><img src='../../images/guanbi.png'/></button>"+
						        "<p class='modal-title' id='myModalLabel'>添加自定义医嘱</p>"+
						      "</div>"+
						      "<div class='modal-body'>"+
						      	"<div class='row'>"+
						      		"<div class='col-md-9'><input  id='key_value_input' class='form-control'/></div>"+
							      	"<div class='col-md-3'><button id='ok_btn' type='button' class='btn btn-primary form-control'>确定</button></div>"+
						      	"</div>"+
						      	
							      "<div id='key_value_show' class='row show_div' contenteditable='true' style='border: 1px solid #ccc;height: 385px;'></div>"+
							      
						      "</div>"+
						      "<div class='modal-footer'>"+
						       "<p style='color:#337AB7;'>请你输入自定义的关键字</p>"+
						      "</div>"+
						   " </div>"+
						  "</div>"+
						"</div>";
						return htm;
					}
						
						
