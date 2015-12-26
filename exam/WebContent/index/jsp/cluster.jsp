<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'cluster.jsp' starting page</title>
    <meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body>

    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:680px"></div>
    <!-- ECharts单文件引入 -->
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/scatter' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                var option = {
                    title : {
        text : '',
        subtext : ''
    },
    tooltip : {
        trigger: 'axis',
        axisPointer:{
            show: true,
            type : 'cross',
            lineStyle: {
                type : 'dashed',
                width : 1
            }
        }
    },
	//右上角工具箱
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
	//显示范围类目
    dataZoom: {
        show: true,
        start : 0,
        end : 100
    },
	//类目种类
    legend : {
        data : ['基础常模','良好常模','进阶常模','优秀常模']
    },
    dataRange: {
        min: 10,
        max: 100,
        orient: 'horizontal',
        y: 30,
        x: 'center',
        //text:['高','低'],           // 文本，默认为数值文本
        color:['lightgreen','orange'],
        splitNumber: 4
    },
    xAxis : [
        {
            type : 'category',
            axisLabel: {
                formatter : function(v) {
                    var arr = ['一年级(上)','一年级(下)','二年级(上)','二年级(下)','三年级(上)','三年级(下)','四年级(上)','四年级(下)','五年级(上)','五年级(下)','六年级(上)','六年级(下)'];
					return arr[v-1];
                }
            },
            data : function (){
                var list = [];
                var len = 0;
				//x轴类目数量
                while (len++ < 12) {
                    list.push(len);
                }
                return list;
            }()
        }
    ],
    yAxis : [
        {
            type : 'value'
        }
    ],
    animation: false,
    series : [
        {
            name:'基础常模',
            type:'scatter',
            tooltip : {
                trigger: 'item',
                formatter : function (params) {
					//标签信息
                    /* return params.seriesName + ' （'  + '类目' + params.value[0] + '）<br/>'
                           + params.value[1] + ', ' 
                           + params.value[2]; */
                    return params.seriesName + '<br/>'
                    			+ params.value[3] + '<br/>'
                    			+ params.value[2] + '次';
                },
                axisPointer:{
                    show: true
                }
            },
            symbolSize: function (value){
                return Math.round(value[2]/2);
            },
            data: (function () {
                var d = [];
                /*var len = 0;
                var value;
                while (len++ < 12) {
                    d.push([
                        len,
						//y轴
                        (Math.random()*30).toFixed(2) - 0,
                        //图形大小值
						(Math.random()*100).toFixed(2) - 0
                    ]);
                }*/
                /*[1,(10).toFixed(2) - 0,(50).toFixed(2) - 0],[1,(10).toFixed(2) - 0,(100).toFixed(2) - 0],[1,(30).toFixed(2) - 0,(150).toFixed(2) - 0]*/
                <c:forEach items="${badList}" var="cluster">
                		var sonOfData1 = [];
					sonOfData1.push("${cluster.gradeNum}");
                		sonOfData1.push((${cluster.yAxis}).toFixed(2) - 0);
                		sonOfData1.push((${cluster.area}).toFixed(2) - 0);
                		sonOfData1.push("${cluster.name}");
                		d.push(sonOfData1);
				</c:forEach> 
				
				
                return d;
            })()
        },
        {
            name:'良好常模',
            type:'scatter',
            tooltip : {
                trigger: 'item',
                formatter : function (params) {

                    return params.seriesName + '<br/>'
                    			+ params.value[3] + '<br/>'
                    			+ params.value[2] + '次';
                },
                axisPointer:{
                    show: true
                }
            },
            symbolSize: function (value){
                return Math.round(value[2]/2);
            },
            data: (function () {
                var d = [];
                <c:forEach items="${middle_badList}" var="cluster">
	        			var sonOfData1 = [];
					sonOfData1.push("${cluster.gradeNum}");
	        			sonOfData1.push((${cluster.yAxis}).toFixed(2) - 0);
	        			sonOfData1.push((${cluster.area}).toFixed(2) - 0);
	        			sonOfData1.push("${cluster.name}");
	        			d.push(sonOfData1);
				</c:forEach> 
                return d;
            })()
        },
        {
            name:'进阶常模',
            type:'scatter',
            tooltip : {
                trigger: 'item',
                formatter : function (params) {
                    return params.seriesName + '<br/>'
        					+ params.value[3] + '<br/>'
        					+ params.value[2] + '次';
                },
                axisPointer:{
                    show: true
                }
            },
            symbolSize: function (value){
                return Math.round(value[2]/2);
            },
            data: (function () {
                var d = [];
                <c:forEach items="${middle_goodList}" var="cluster">
		    			var sonOfData1 = [];
					sonOfData1.push("${cluster.gradeNum}");
		    			sonOfData1.push((${cluster.yAxis}).toFixed(2) - 0);
		    			sonOfData1.push((${cluster.area}).toFixed(2) - 0);
		    			sonOfData1.push("${cluster.name}");
		    			d.push(sonOfData1);
				</c:forEach> 
                return d;
            })()
        },
        {
            name:'优秀常模',
            type:'scatter',
            tooltip : {
                trigger: 'item',
                formatter : function (params) {
                	return params.seriesName + '<br/>'
					+ params.value[3] + '<br/>'
					+ params.value[2] + '次';
                },
                axisPointer:{
                    show: true
                }
            },
            symbolSize: function (value){
                return Math.round(value[2]/2);
            },
            data: (function () {
                var d = [];
                <c:forEach items="${middle_goodList}" var="cluster">
		    			var sonOfData1 = [];
					sonOfData1.push("${cluster.gradeNum}");
		    			sonOfData1.push((${cluster.yAxis}).toFixed(2) - 0);
		    			sonOfData1.push((${cluster.area}).toFixed(2) - 0);
		    			sonOfData1.push("${cluster.name}");
		    			d.push(sonOfData1);
				</c:forEach> 
                return d;
            })()
        }
    ]
                };
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
    </script>
</body>
</html>
