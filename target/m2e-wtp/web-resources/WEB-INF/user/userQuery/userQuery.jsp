<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
td,th{border:1px solid #DDD;padding-top:15px;padding-bottom: 15px;padding-left: 5px;text-align: left;}
</style>
<script>
function delUser(){
	var idlist = ""; 
	$("#dataTab input[type='checkbox']:checked").each(function(){
		idlist = idlist+this.value+",";
	});
	 $.ajax({
	     type: "POST",
	     url: "${pageContext.request.contextPath }/operate/deleteConsume!deleteConsume.action",
	     data:"ids="+idlist,
	     dataType:"json",
	     async: false,   
	     success: function(data){
	     }
	 });
} 
function changePge(pageNo){
	$("#pageNo").val(pageNo);
	$("#userQuery").submit();
}
function userQuery(){
	$("#pageNo").val(0);
	$("#userQuery").submit();
}
function userDetails(){
	window.open("${pageContext.request.contextPath }/manage/userDetails");
}
</script>
<div style="padding-left: 20px;font-size: 14px;">
	<div style=" border-bottom-width: thin;border-bottom-style: solid;border-bottom-color: #E5E5E5;">
		<br />
		<form id="userQuery" action="${pageContext.request.contextPath }/manage/userQuery" method="post">
			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
			&nbsp;&nbsp;&nbsp;UID：<input name="UID" value="${param.UID }"/> 
			PASSPORT：<input name="PASSPORT" value="${param.PASSPORT}" />
			MOBILE：<input name="MOBILE" value="${param.MOBILE}" />
			真实姓名：<input name="REAL_NAME" value="${param.REAL_NAME}" />
			<input type="submit" value="查询" onclick="userQuery()" style="background-color: #286A38;color: white;height: 30px;width: 55px;">
		</form>
		<br />
	</div>
	
	<div>
		<br />
		&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" style="margin-top: 0px;color: #286A46;" onclick="delUser()">批量删除</a>
	</div>
	<table id="dataTab" style="width: 1024px; margin-top: 20px; padding-left: 20px;" cellpadding="0" cellspacing="0" >
		<tr>
			<th></th>
			<th>UID</th>
			<th>昵称</th>
			<th>真实姓名</th>
			<th>电话号码</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
		<c:forEach var="user" items="${page.dataList}">
			<tr>
				<td><input type="checkbox" value="${user.UID }"/></td>
				<td>${user.UID}</td>
				<td>${user.NICKNAME}</td>
				<td>${user.REAL_NAME}</td>
				<td>${user.MOBILE}</td>
				<td>${user.CREATE_TIME}</td>
				<td><button>删除</button>&nbsp;<button onclick="userDetails()">详细</button>&nbsp;<button>修改</button></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="changePge(1)">首页</a>
	&nbsp;<a href="javascript:void(0)" onclick="changePge(${page.pageNo-1})">上一页</a>
	&nbsp;<a href="javascript:void(0)" onclick="changePge(${page.pageNo+1})">下一页</a>
	&nbsp;<a href="javascript:void(0)" onclick="changePge(${page.pageCount})">尾页</a>
	&nbsp;当前第${page.pageNo }页
	&nbsp;共${page.pageCount}页
</div>