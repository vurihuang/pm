<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>试卷管理分析系统(教师端)</title>
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

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
	<script src="<c:url value='/index/bower_components/jquery/dist/jquery.min.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/index/css/drop-down.css'/>"/>
	<script src="<c:url value='/index/js/jquery-ui.min.js'/>"></script>
	<script src="<c:url value='/index/js/select-widget-min.js'/>"></script>
  
	<style type="text/css">
		.sec{
			position:absolute;
			right:20%;
		}
	</style>
</head>
<body>
	<div class="text-center" style="margin-bottom:50px;"><span style="font-size:25px;">个人学习履历</span>
	<div class="sec text-left">
		<!-- 下拉选择框 -->
		<form action="" method="get" class="form">
			<select name="drop1" class="ui-select">
				<option value="1">一年级</option>
				<option value="2">二年级</option>
				<option value="3">三年级</option>
				<option selected value="4">四年级</option>
				<option value="5">五年级</option>
				<option value="6">六年级</option>
			</select>
		</form>
	</div>
	</div>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->	
	<div id="mainchinese" style="height:400px;width:80%;margin:0 auto;"></div>
	<div id="prchinese" style="height:400px;width:80%;margin:0 auto;"></div>	
	<div id="mainmath" style="height:400px;width:80%;margin:0 auto;"></div>
	<div id="prmath" style="height:400px;width:80%;margin:0 auto;"></div>	
	<div id="mainenglish" style="height:400px;width:80%;margin:0 auto;"></div>
	<div id="prenglish" style="height:400px;width:80%;margin:0 auto;"></div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
    
    var chineseBefData = [60, 70, 85, 78, 86, 83, 77, 66, 55, 44];
    var chineseAftData = [80, 74, 81, 90, 73, 80, 88, 77, 90, 88];
    
    var chineseGradeAndPrData = [[21.5,20.34],[32.5,33.33],[45,40.89],[57.5,60.78],[80.8,75.79],[75,80.45]];
    
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
				'echarts/chart/bar'	// 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('mainchinese')); 
                
                var option = {
                    title :{
						text : '语文',
						subtext : ''
					},
					tooltip : {
						trigger: 'axis',
						formatter: function (params){		//显示信息标签
							return params[0].name + ' : '
								   + (params[2].value - params[1].value > 0 ? '+' : '-') 
								   + params[0].value + '<br/>'
								   + params[2].seriesName + ' : ' + params[2].value + '<br/>'
								   + params[3].seriesName + ' : ' + params[3].value + '<br/>'
						}
					},
					toolbox: {
						show : true,
						feature : {
							magicType : {show: true, type: ['line', 'bar']},
							restore : {show: true},
						}
					},
					legend: {
						data:['前测', '后测'],
						selectedMode:false
					},
					xAxis : [
						{
							type : 'category',
							//x轴
							data : ['T1','T2','T3','T4','S1','T5','T6','T7','T8','S2']
						}
					],
					yAxis : [
						{
							type : 'value',
							min : 0,
							max : 100
						}
					],
					
					series : [
						{
							name:'前测',
							type:'line',
							data:chineseBefData
						},
						{		//前测折线图
							name:'后测',
							type:'line',
							symbol:'none',							
							data:chineseAftData
						},
						{		//关于差距柱状图
							name:'前测2',
							type:'bar',
							stack: '1',
							barWidth: 6,
							itemStyle:{
								normal:{
									color:'rgba(0,0,0,0)'
								},
								emphasis:{
									color:'rgba(0,0,0,0)'
								}
							},
							//柱状图起始高度(前后测比较的小的值)
							data:[60, 70, 81, 78, 73, 80, 77, 66, 55, 44]
						},
						{		//差距柱状图
							name:'变化',
							type:'bar',
							stack: '1',
							data:[20, 4, 4, 12, 13, 3, 11, 11, 35, 44]
						}
					]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
//为语文前后侧图赋值
chineseBefData = [];
chineseAftData = [];
<c:forEach items="${chineseGradeBefList}" var="chineseGradeBef">
 	<c:choose>
	<c:when test="${chineseGradeBef.score eq 0}">
	chineseBefData.push("");
	</c:when>
	<c:otherwise>
	chineseBefData.push(${chineseGradeBef.score});
	</c:otherwise>
	</c:choose> 
</c:forEach>

<c:forEach items="${chineseGradeAftList}" var="chineseGradeAft">
	<c:choose>
		<c:when test="${chineseGradeAft.score eq 0}">
			chineseAftData.push("");
		</c:when>
		<c:otherwise>
			chineseAftData.push(${chineseGradeAft.score});
		</c:otherwise>
	</c:choose> 
</c:forEach>

		// 数学   路径配置
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
				'echarts/chart/bar'	// 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('mainmath')); 
                
                var option = {
                    title :{
						text : '数学',
						subtext : ''
					},
					tooltip : {
						trigger: 'axis',
						formatter: function (params){
							return params[0].name + ' : '
								   + (params[2].value - params[1].value > 0 ? '+' : '-') 
								   + params[0].value + '<br/>'
								   + params[2].seriesName + ' : ' + params[2].value + '<br/>'
								   + params[3].seriesName + ' : ' + params[3].value + '<br/>'
						}
					},
					toolbox: {
						show : true,
						feature : {
							magicType : {show: true, type: ['line', 'bar']},
							restore : {show: true}
						}
					},
					legend: {
						data:['前测', '后测'],
						selectedMode:false
					},
					xAxis : [
						{
							type : 'category',
							data : ['T1','T2','T3','T4','S1','T5','T6','T7','T8','S2']
						}
					],
					yAxis : [
						{
							type : 'value',
							min : 0,
							max : 100
						}
					],
					series : [
						{
							name:'前测',
							type:'line',
							data:[60, 70, 85, 78, 86, 83, 77, 66, 55, 44]
						},
						{		//前测折线图
							name:'后测',
							type:'line',
							symbol:'none',
							data:[80, 74, 81, 90, 73, 80, 88, 77, 90, 88]
						},
						{		//关于差距柱状图
							name:'前测2',
							type:'bar',
							stack: '1',
							barWidth: 6,
							itemStyle:{
								normal:{
									color:'rgba(0,0,0,0)'
								},
								emphasis:{
									color:'rgba(0,0,0,0)'
								}
							},
							//柱状图起始高度(前后测比较的小的值)
							data:[60, 70, 81, 78, 73, 80, 77, 66, 55, 44]
						},
						{		//差距柱状图
							name:'变化',
							type:'bar',
							stack: '1',
							data:[20, 4, 4, 12, 13, 3, 11, 11, 35, 44]
						}
					]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );

		// 英语   路径配置
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
				'echarts/chart/bar'	// 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('mainenglish')); 
                
                var option = {
                    title :{
						text : '英语',
						subtext : ''
					},
					tooltip : {
						trigger: 'axis',
						formatter: function (params){
							return params[0].name + ' : '
								   + (params[2].value - params[1].value > 0 ? '+' : '-') 
								   + params[0].value + '<br/>'
								   + params[2].seriesName + ' : ' + params[2].value + '<br/>'
								   + params[3].seriesName + ' : ' + params[3].value + '<br/>'
						}
					},
					toolbox: {
						show : true,
						feature : {
							magicType : {show: true, type: ['line', 'bar']},
							restore : {show: true},
						}
					},
					legend: {
						data:['前测', '后测'],
						selectedMode:false
					},
					xAxis : [
						{
							type : 'category',
							data : ['T1','T2','T3','T4','S1','T5','T6','T7','T8','S2']
						}
					],
					yAxis : [
						{
							type : 'value',
							min : 0,
							max : 100
						}
					],
					series : [
						{
							name:'前测',
							type:'line',
							data:[60, 70, 85, 78, 86, 83, 77, 66, 55, 44]
						},
						{		//前测折线图
							name:'后测',
							type:'line',
							symbol:'none',
							data:[80, 74, 81, 90, 73, 80, 88, 77, 90, 88]
						},
						{		//关于差距柱状图
							name:'前测2',
							type:'bar',
							stack: '1',
							barWidth: 6,
							itemStyle:{
								normal:{
									color:'rgba(0,0,0,0)'
								},
								emphasis:{
									color:'rgba(0,0,0,0)'
								}
							},
							//柱状图起始高度(前后测比较的小的值)
							data:[60, 70, 81, 78, 73, 80, 77, 66, 55, 44]
						},
						{		//差距柱状图
							name:'变化',
							type:'bar',
							stack: '1',
							data:[20, 4, 4, 12, 13, 3, 11, 11, 35, 44]
						}
					]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );

		// 语文散点   路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/scatter'	// 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('prchinese')); 
                
                var option = {
                    title : {
        text: '语文',
        subtext: ''
    },
    tooltip : {
        trigger: 'axis',
        showDelay : 0,
        formatter : function (params) {
            if (params.value.length > 1) {
                return params.seriesName + ' :<br/>'
                   + params.value[0] + '分,PR: ' 
                   + params.value[1] + '% ';
            }
            else {
                return params.seriesName + ' :<br/>'
                   + params.name + ' : '
                   + params.value + '% ';
            }
        },  
        axisPointer:{
            show: true,
            type : 'cross',
            lineStyle: {
                type : 'dashed',
                width : 1
            }
        }
    },
    legend: {
        data:['成绩-PR']
    },
    toolbox: {
        show : true,
        feature : {
            //mark : {show: true},
            dataZoom : {show: true},
            //dataView : {show: true, readOnly: false},
            restore : {show: true},
            //saveAsImage : {show: true}
        }
    },
    xAxis : [
        {
            type : 'value',
            scale:true,
            axisLabel : {
                formatter: '{value} 分'
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            scale:true,
            axisLabel : {
                formatter: '{value} %'
            }
        }
    ],
 
    series : [
        {
            name:'成绩-PR',
            type:'scatter',
            data: chineseGradeAndPrData,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }        
    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );

		// 数学散点   路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/scatter'	// 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('prmath')); 
                
                var option = {
                    title : {
        text: '数学',
        subtext: ''
    },
    tooltip : {
        trigger: 'axis',
        showDelay : 0,
        formatter : function (params) {
            if (params.value.length > 1) {
                return params.seriesName + ' :<br/>'
                   + params.value[0] + '分,PR: ' 
                   + params.value[1] + '% ';
            }
            else {
                return params.seriesName + ' :<br/>'
                   + params.name + ' : '
                   + params.value + '% ';
            }
        },  
        axisPointer:{
            show: true,
            type : 'cross',
            lineStyle: {
                type : 'dashed',
                width : 1
            }
        }
    },
    legend: {
        data:['成绩-PR']
    },
    toolbox: {
        show : true,
        feature : {
            //mark : {show: true},
            dataZoom : {show: true},
            //dataView : {show: true, readOnly: false},
            restore : {show: true},
            //saveAsImage : {show: true}
        }
    },
    xAxis : [
        {
            type : 'value',
            scale:true,
            axisLabel : {
                formatter: '{value} 分'
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            scale:true,
            axisLabel : {
                formatter: '{value} %'
            }
        }
    ],
    series : [
        {
            name:'成绩-PR',
            type:'scatter',
            data: [[21.5,20.34],[32.5,33.33],[45,40.89],[57.5,60.78],[80.8,75.79],[75,80.45]
            ],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }        
    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );

		// 英语散点   路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/scatter'	// 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('prenglish')); 
                
                var option = {
                    title : {
        text: '英语',
        subtext: ''
    },
    tooltip : {
        trigger: 'axis',
        showDelay : 0,
        formatter : function (params) {
            if (params.value.length > 1) {
                return params.seriesName + ' :<br/>'
                   + params.value[0] + '分,PR: ' 
                   + params.value[1] + '% ';
            }
            else {
                return params.seriesName + ' :<br/>'
                   + params.name + ' : '
                   + params.value + '% ';
            }
        },  
        axisPointer:{
            show: true,
            type : 'cross',
            lineStyle: {
                type : 'dashed',
                width : 1
            }
        }
    },
    legend: {
        data:['成绩-PR']
    },
    toolbox: {
        show : true,
        feature : {
            //mark : {show: true},
            dataZoom : {show: true},
            //dataView : {show: true, readOnly: false},
            restore : {show: true},
            //saveAsImage : {show: true}
        }
    },
    xAxis : [
        {
            type : 'value',
            scale:true,
            axisLabel : {
                formatter: '{value} 分'
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            scale:true,
            axisLabel : {
                formatter: '{value} %'
            }
        }
    ],
    series : [
        {
            name:'成绩-PR',
            type:'scatter',
            data: [[21.5,20.34],[32.5,33.33],[45,40.89],[57.5,60.78],[80.8,75.79],[75,80.45]
            ],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        }        
    ]
                };
        
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );

	//下拉选择框
	$(document).ready(function(){		
		$(".ui-select").selectWidget({
			change       : function (changes) {
				return changes;
			},
			effect       : "slide",
			keyControl   : true,
			speed        : 200,
			scrollHeight : 250
		});
		
	});	
	
	chineseGradeAndPrData = [];
	<c:forEach items="${chineseGradeAndPrList}" var="chineseGradeAndPr">
		var tempData = [];
		tempData.push(${chineseGradeAndPr.score});
		tempData.push(${chineseGradeAndPr.pr});
		chineseGradeAndPrData.push(tempData);
	</c:forEach>
	
    </script>
    
    <%-- <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='/index/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value='/index/bower_components/metisMenu/dist/metisMenu.min.js'/>"></script>

    <!-- Morris Charts JavaScript -->
    <script src="<c:url value='/index/bower_components/raphael/raphael-min.js'/>"></script>
    <script src="<c:url value='/index/bower_components/morrisjs/morris.min.js'/>"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<c:url value='/index/dist/js/sb-admin-2.js'/>"></script> --%>
    
    <!-- Bootstrap Core JavaScript -->
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