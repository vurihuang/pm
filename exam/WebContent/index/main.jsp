<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>fuckralation</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			font-size:10pt;
		}
		body{
			text-align:center;
		}
		.table{
			width:1024px;
			height:100%;
			border:1px solid gray;/*固定边框,1像素*/
		    border-collapse: collapse;/*单线的列表边框*/
		}
		.table td{
			border:1px solid gray;/*固定边框,1像素*/
		}
		iframe {
			width: 100%;
			height: 100%;
		}
	</style>
	<script type="text/javascript">
			function contactList(jsons){
		var table = document.getElementById("contactTable");
		var arr = eval(jsons);
		for(var i=0; i<arr.length; i++){
			var jsonObj = arr[i]; //获取json对象
			var tr = table.insertRow(table.rows.length);
			var td1 = tr.insertCell(0);
			td1.align = "center";
			var td2 = tr.insertCell(1);
			td2.align = "center";
			var td3 = tr.insertCell(2);
			td3.align = "center";
			//创建标签，添加属性
			var pro = document.createElement("progress");
			var val = jsonObj.value
			pro.setAttribute("max","100");
			pro.setAttribute("value",val);

			var but = document.createElement("input");
			var butc = "change"+i;
			but.setAttribute("type","button");
			but.setAttribute("value","图表");
			but.setAttribute("class",butc);

			var p = document.createElement("p");
			var pc = "p"+i;
			p.setAttribute("class",pc);
			//p.setAttribute("style","display:none");
			//p.setAttribute("onload","init();");
			var canv = document.createElement("canvas");
			var canid = "canvas_circle"+i;
			canv.setAttribute("id",canid);
			canv.setAttribute("width","500");
			canv.setAttribute("height","300");
			canv.setAttribute("style","border:2px solid #0026ff");

			var body = document.getElementById("body");
			p.appendChild(canv);
			//body.appendChild(p);

			td1.innerHTML = jsonObj.knowledgeA;
			td2.innerHTML = jsonObj.knowledgeB;
			td3.appendChild(pro);
			td3.appendChild(but);
			td3.appendChild(p);
			//页面加载时执行init()函数    改，不是屏幕加载就运行一次
			init(canid);
		}
	}
	function drawCircle(canvasId, data_arr, color_arr, text_arr)  
            {  
                var c = document.getElementById(canvasId);  
                var ctx = c.getContext("2d");  
  
                var radius = c.height / 2 - 20; //半径  
                var ox = radius + 20, oy = radius + 20; //圆心  
  
                var width = 30, height = 10; //图例宽和高  
                var posX = ox * 2 + 20, posY = 30;   //  
                var textX = posX + width + 5, textY = posY + 10;  
  
                var startAngle = 0; //起始弧度  
                var endAngle = 0;   //结束弧度  
                for (var i = 0; i < data_arr.length; i++)  
                {  
                    //绘制饼图  
                    endAngle = endAngle + data_arr[i] * Math.PI * 2; //结束弧度  
                    ctx.fillStyle = color_arr[i];  
                    ctx.beginPath();  
                    ctx.moveTo(ox, oy); //移动到到圆心  
                    ctx.arc(ox, oy, radius, startAngle, endAngle, false);  
                    ctx.closePath();  
                    ctx.fill();  
                    startAngle = endAngle; //设置起始弧度  
  
                    //绘制比例图及文字  
                    ctx.fillStyle = color_arr[i];  
                    ctx.fillRect(posX, posY + 20 * i, width, height);  
                    ctx.moveTo(posX, posY + 20 * i);  
                    ctx.font = 'bold 12px 微软雅黑';    //斜体 30像素 微软雅黑字体  
                    ctx.fillStyle = color_arr[i]; //"#000000";  
                    var percent = text_arr[i] + "：" + 100 * data_arr[i] + "%";  
                    ctx.fillText(percent, textX, textY + 20 * i);  
                }  
            }  
  
    function init(canid) {  
                //绘制饼图  
                //比例数据和颜色
				var a = 0.05;
                var data_arr = [a, 0.25, 0.6, 0.1];  
                var color_arr = ["#00FF21", "#FFAA00", "#00AABB", "#FF4400"];  
                var text_arr = ["都对", "都错", "知识点A对B错", "知识点B对A错"];  
  
                drawCircle(canid, data_arr, color_arr, text_arr);  
            }
	/*function pageInit(){
		var contact = "[{knowledgeA:'三角函数',knowledgeB:'恒等变化',value:'90'},{knowledgeA:'三角函数',knowledgeB:'恒等变化',value:'80'},{knowledgeA:'三角函数',knowledgeB:'恒等变化',value:'70'}]";
		contactList(contact);
	}*/
		</script>
		<style type="text/css">
			body{background-color:#efefef;}
			.result{
				width:800px;
				margin:50 auto;
				background-color:#6666cc;
				border-radius:30px;
				opacity:0.6;
			}
			table{
				margin:auto;
				padding:30px;			
			}
			td{
				width:282px;
				height:35px;
				text-align:center;
			}
			.tr{
				font-size:30px;
				color:white;
			}
			.search-box{
				margin-left:220px;
				margin-top:50px;
				width:800px;
				height:30px;
			}
			.sec{
				width:200px;
				padding-left:50px;
			}
			.form-s{
				margin-left:300px;
			}
			.form-f{
				float:left;
				margin-left:50px;
			}
		</style>
  </head>
<body id="body">
	 	<div class="search-box">	
			<form class="form form-f">
				<select name="gradient" class="sec sec-f">
					<option values="Chinese">语文</option>
					<option values="Ma	th">数学</option>
					<option values="English">英语</option>
				</select>
			</form>
			<form class="form form-s">
				<select name="subject" class="sec sec-s">
					<option values="gOne">第一梯度</option>
					<option values="gTwo">第二梯度</option>
					<option values="gThree">第三梯度</option>
					<option values="gFour">第四梯度</option>
				</select>
			</form>
		</div>
		
		<div class="result">
			<table id="contactTable">
				<tr class="tr">
					<td>知识点A</td>
					<td>知识点B</td>
					<td>关联度</td>
					<td>影响程度</td>
					<a href="<c:url value='/fuckServlet?method=fuck'/>">fuck</a>
				</tr>
				
<c:forEach items="${fuckList}" var="fuck">
	<tr>
		<td>${fuck[0]}</td>
		<td>${fuck[1]}</td>
		<td>	<progress max="1" value="${fuck[2] }"></progress></td>
		<td>	<progress max="1" value="${fuck[3] }"></progress></td>
	<tr>
</c:forEach>
				
			</table>
		</div>
	</body>  
</html>
