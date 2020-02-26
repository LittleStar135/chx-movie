<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@  taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <script type="text/javascript" src="<%=path%>/jquery/jquery-1.8.2.js"></script>
  <script type="text/javascript" src="jquery/jquery.validate.js"></script>
  <link rel="stylesheet" href="<%=path%>/css/css.css" type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="/chx-movie/list.do" method="post">
	电影名称: <input type="text" name="name" value="${vo.name }"> &nbsp;上映时间<input type="text" name="t1" value="${vo.t1 }">--<input type="text" name="t2" value="${vo.t2 }"><br>
	导演： <input type="text" name="actor" value="${vo.actor }"> &nbsp;价格<input type="text" name="p1" value="${vo.p1 }">--<input type="text" name="p2" value="${vo.p2 }"><br>
	年代： <input type="text" name="years" value="${vo.years }">&nbsp;电影时长<input type="text" name="l1" value="${vo.l1 }">--<input type="text" name="l2" value="${vo.l2 }"><br>
	<input type="submit" style="height: 30px;width: 60px;" value="查询影片">
	<input type="submit" onclick="dels()"  style="height: 30px;width: 60px;" value="删除影片">
	
	<table>
		<tr>
			<td>
				<input type="checkbox" onclick="choose(this)">
			</td>
			<td>序号</td>
			<td>电影名称</td>
			<td>导演</td>
			<td><a href="javascript:morder('pice')" style="color: blue">价格</a></td>
			<td>上映日期</td>
			<td><a href="javascript:morder('longtime')" style="color: blue">电影时长</a></td>
			<td><a href="javascript:morder('years')" style="color: blue">年代</a></td>
			<td>类型</td>
			<td>区域</td>
			<td>状态</td>

		</tr>
		<c:forEach items="${list }" var="movie" >

			<tr>
				<td>
					<input type="checkbox" name="ck" value="${movie.id}">
				</td>
				<td>${movie.id }</td>
				<td>${movie.name }</td>
				<td>${movie.actor }</td>
				<td>${movie.pice }</td>
				<td>${movie.startime }</td>
				<td>${movie.longtime }</td>
				<td>${movie.years }</td>
				<td>${movie.type }</td>
				<td>${movie.area }</td>
				<td>${movie.status==1?"即将上映":movie.status==2?"正在热映":"已经下线" }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="20"> 
				<button name="pageNum" value="1">首页</button>
				<button name="pageNum" value="${page.prePage==0?page.pageNum:page.prePage }">上一页</button>
				<button name="pageNum" value="${page.nextPage==0?page.pages:page.nextPage }">下一页</button>
				<button name="pageNum" value="${page.pages }">尾页</button>
				当前${page.pageNum }/${page.pages }页，共${page.total }条

			</td> 
		</tr>


	</table>
</form>

<script type="text/javascript">
	function choose(id) {
		$("[name=ck]").attr("checked",id.checked)
	}

	function morder(orderName) {
		var orderMethod='${vo.orderMethod}';
		orderMethod=orderMethod=='desc'?'asc':'desc';
		location.href="/chx-movie/list.do?orderName="+orderName+"&orderMethod="+orderMethod;
	}
	
	
	function dels() {
		
		var sids=$("[name=ck]:checked").map(function () {
			return $(this).val();
		}).get().join();
		
		$.post(
			"/chx-movie/del.do",
			{ids:sids},
			function (i) {
				if (i>0) {
					alert("删除成功！");
					location="/chx-movie/list.do";
				}else {
					alert("删除失败！");
				}
			},"json"
		)
	}
	
	
</script>

</body>
</html>