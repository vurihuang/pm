<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>试卷管理分析系统(教师端)</title>
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<!-- Bootstrap Core CSS -->
    <link href="<c:url value='/index/bower_components/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="<c:url value='/index/bower_components/metisMenu/dist/metisMenu.min.css'/>" rel="stylesheet">
    <!-- Timeline CSS -->
    <link href="<c:url value='/index/dist/css/timeline.css'/>" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<c:url value='/index/dist/css/sb-admin-2.css'/>" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="<c:url value='/index/bower_components/morrisjs/morris.css'/>" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="<c:url value='/index/bower_components/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="<c:url value='/index/css/drop-down.css'/>"/>
	
	<style type="text/css">
		.sec{
			position:absolute;
			right:50px;
		}
	</style>
</head>
<body>
	<div class="text-center" style="font-size:25px;margin-bottom:50px;">个人成长轨迹</div>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->	
	<div id="mainchinese" style="height:400px"></div>	
	<div id="mainmath" style="height:400px"></div>	
	<div id="mainenglish" style="height:400px"></div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
    

        // 语文   路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        // 使用
    require(
        [
            'echarts',
            'echarts/chart/line',
			'echarts/chart/bar'// 使用柱状图就加载bar模块，按需加载
        ],
		 function (ec) {
		
							// 基于准备好的dom，初始化echarts图表
								var myChart = ec.init(document
										.getElementById('mainchinese'));
			var option = {
									
							
							title : {
										text : '语文',
										subtext : ''
									},
							tooltip : {
								trigger : 'axis'
							},
							legend : {
								data : [ '各阶段学习PR值' ]
							},
							toolbox : {
								show : true,
								feature : {
									//mark : {show: true},
									//dataView : {show: true, readOnly: false},
									magicType : {
										show : true,
										type : [ 'line', 'bar' ]
									},
									restore : {
										show : true
									},
								//saveAsImage : {show: true}
								}
							},
							calculable : true,
							xAxis : [ 
							          {
										type : 'category',
										boundaryGap : false,
										data : [ '一年级上', '一年级下', '二年级上', '二年级下',
												'三年级上', '三年级下', '四年级上', '四年级下', '五年级上',
												'五年级下', '六年级上' ]
									  } 
							        ],
							
							
							yAxis : [ {
										type : 'value',
										axisLabel : {
											formatter : '{value} '
										}
									} ],
							series : [ {
										name : '各阶段学习PR值',
										type : 'line',
										data : [ 81, 51, 75, 63, 92, 83, 70, 71, 88,
												75, 60, 55, 77 ],
										markPoint : {
											data : [ {
												type : 'max',
												name : '最大值'
											}, {
												type : 'min',
												name : '最小值'
											} ]
										},
										markLine : {
											data : [ {
														type : 'average',
														name : '平均值'
													} ]
												   }
										} ]
						 	
						};
			//为语文折线图赋值
			var value0 = [];
			var value1 = [];
			<c:forEach items="${chineseList}" var="studentPr">
				value0.push("${studentPr.classyear}");
			</c:forEach>
			<c:forEach items="${chineseList}" var="studentPr">
				value1.push("${studentPr.avgPR}");
			</c:forEach>
						
			option['xAxis'][0]['data'] = value0;
			option['series'][0]['data']= value1;
		
			// 为echarts对象加载数据 
			myChart.setOption(option);																	
		});
    

					
		// 数学   路径配置
		require.config({
			paths : {
				echarts : 'http://echarts.baidu.com/build/dist'
			}
		});

		// 使用
		require([ 'echarts', 'echarts/chart/line',
				'echarts/chart/bar'// 使用柱状图就加载bar模块，按需加载
		], function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document
					.getElementById('mainmath'));

			var option = {
				title : {
					text : '数学',
					subtext : ''
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : [ '各阶段学习PR值' ]
				},
				toolbox : {
					show : true,
					feature : {
						//mark : {show: true},
						//dataView : {show: true, readOnly: false},
						magicType : {
							show : true,
							type : [ 'line', 'bar' ]
						},
						restore : {
							show : true
						},
					//saveAsImage : {show: true}
					}
				},
				calculable : true,
				xAxis : [ {
					type : 'category',
					boundaryGap : false,
					data : [ '一年级上', '一年级下', '二年级上', '二年级下',
							'三年级上', '三年级下', '四年级上', '四年级下', '五年级上',
							'五年级下', '六年级上', '六年级下' ]
				} ],
				yAxis : [ {
					type : 'value',
					axisLabel : {
						formatter : '{value} '
					}
				} ],
				series : [ {
					name : '各阶段学习PR值',
					type : 'line',
					data : [ 81, 50, 75, 63, 96, 83, 70, 57, 88,
							75, 90, 55, 77, 79 ],
					markPoint : {
						data : [ {
							type : 'max',
							name : '最大值'
						}, {
							type : 'min',
							name : '最小值'
						} ]
					},
					markLine : {
						data : [ {
							type : 'average',
							name : '平均值'
						} ]
					}
				} ]
			};
			//为图赋值
			var value2 = [];
			var value3 = [];
			<c:forEach items="${mathList}" var="studentPr">
				value2.push("${studentPr.classyear}");
			</c:forEach>
			<c:forEach items="${mathList}" var="studentPr">
				value3.push("${studentPr.avgPR}");
			</c:forEach>
						
			option['xAxis'][0]['data'] = value2;
			option['series'][0]['data']= value3;

			// 为echarts对象加载数据 
			myChart.setOption(option);
		});

	// 英语   路径配置
	require.config({
		paths : {
			echarts : 'http://echarts.baidu.com/build/dist'
		}
	});

	// 使用
	require([ 'echarts', 'echarts/chart/line',
			'echarts/chart/bar'// 使用柱状图就加载bar模块，按需加载
	], function(ec) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = ec.init(document
				.getElementById('mainenglish'));

		var option = {
			title : {
				text : '英语',
				subtext : ''
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '各阶段学习PR值' ]
			},
			toolbox : {
				show : true,
				feature : {
					//mark : {show: true},
					//dataView : {show: true, readOnly: false},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
				//saveAsImage : {show: true}
				}
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				boundaryGap : false,
				data : [ '一年级上', '一年级下', '二年级上', '二年级下',
						'三年级上', '三年级下', '四年级上', '四年级下', '五年级上',
						'五年级下', '六年级上', '六年级下' ]
			} ],
			yAxis : [ {
				type : 'value',
				axisLabel : {
					formatter : '{value} '
				}
			} ],
			series : [ {
				name : '各阶段学习PR值',
				type : 'line',
				data : [ 81, 51, 75, 63, 92, 83, 70, 71, 88,
						75, 60, 55, 77, 79 ],
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			} ]
		};
		var value4 = [];
		var value5 = [];
		<c:forEach items="${englishList}" var="studentPr">
			value4.push("${studentPr.classyear}");
		</c:forEach>
		<c:forEach items="${englishList}" var="studentPr">
			value5.push("${studentPr.avgPR}");
		</c:forEach>
				
		option['xAxis'][0]['data'] = value4;
		option['series'][0]['data']= value5;

		// 为echarts对象加载数据 
		myChart.setOption(option);
	});
</script>
	<%-- <c:forEach items="${chineseList}" var="studentPr">
		<div>
			<span>年级</span>
			<span>${studentPr.classyear}</span>
			<span>pr</span>
			<span>${studentPr.avgPR}</span>
			
		</div>
	</c:forEach> --%>
	

	<script src="<c:url value='/index/bower_components/jquery/dist/jquery.min.js'/>"></script>
	<script src="<c:url value='/index/js/jquery-ui.min.js'/>"></script>
	<script src="<c:url value='/index/js/select-widget-min.js'/>"></script>
	<script src="<c:url value='/index/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value='/index/bower_components/metisMenu/dist/metisMenu.min.js'/>"></script>
    <!-- Morris Charts JavaScript -->
    <script src="<c:url value='/index/bower_components/raphael/raphael-min.js'/>"></script>
    <script src="<c:url value='/index/bower_components/morrisjs/morris.min.js'/>"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value='/index/dist/js/sb-admin-2.js'/>"></script>
</body>
</html>