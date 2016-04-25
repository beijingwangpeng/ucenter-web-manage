<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
td,th{border:1px solid #DDD;padding-top:15px;padding-bottom: 15px;padding-left: 5px;text-align: left;}
.selected{ background:#f1f1f1;font-weight: bold;}
.even{background:#F9F9F9;} 
</style>
<script>
function delUser(){
	if(window.confirm('你确定删除吗？')){
		var idlist = ""; 
		$("#dataTab tbody tr input[type='checkbox']:checked").each(function(){
			idlist = idlist+this.value+",";
		});
		idlist=idlist.substring(0,idlist.length-1);
		$("#userQuery").attr("action","${pageContext.request.contextPath }/manage/deleteUser");
		$("#idlist").val(idlist);
		$("#userQuery").submit();
	}
}
function delOneUser(UID){
	if(window.confirm('你确定删除吗？')){
		$("#userQuery").attr("action","${pageContext.request.contextPath }/manage/deleteUser");
		$("#idlist").val(UID);
		$("#userQuery").submit();
	}
}
function changePge(pageNo){
	$("#pageNo").val(pageNo);
	$("#userQuery").submit();
}
function userQuery(){
	$("#pageNo").val(0);
	$("#userQuery").submit();
}
function userDetails(UID){
	//window.location.href="${pageContext.request.contextPath }/manage/userDetails?UID="+UID;
	window.open("${pageContext.request.contextPath }/manage/userDetails?UID="+UID);
}
$(function(){
	$("#dataTab tbody>tr:even").addClass("even");
	$("#dataTab tbody>tr").mouseover(function(){
		$(this).removeClass("even");
		$(this).addClass('selected').siblings(this).removeClass("selected");
	}).mouseout(function(){
		$("#dataTab tbody>tr:even").addClass("even");
		$(this).removeClass("selected");
	});
	$("#dataTab tbody tr").bind("click",function(){
		//判断当前是否选中
		var isCheckbox = $(this).find(':checkbox').is(':checked');
		if(isCheckbox==true){
			$("#dataTab #allChecked").prop('checked', false);
		}
		//$(this).find(':checkbox').attr('checked',!isCheckbox);
		$(this).find(':checkbox').prop('checked',!isCheckbox);
	});
	$("#dataTab #allChecked").click(function(){
		if(this.checked){
			$("#dataTab tbody tr input[type='checkbox']").prop('checked', true);
		}else{
			$("#dataTab tbody tr input[type='checkbox']").prop('checked', false);
		}
	});
});
</script>
<div style="padding-left: 20px;font-size: 14px;">
	<div style=" border-bottom-width: thin;border-bottom-style: solid;border-bottom-color: #E5E5E5;">
		<br />
		<form id="userQuery" action="${pageContext.request.contextPath }/manage/userQuery" method="post">
			<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
			<input id="idlist" name="idlist" type="hidden" value=""/>
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
		<thead>
			<tr>
				<th><input id="allChecked" type="checkbox" />全选</th>
				<th>UID</th>
				<th>昵称</th>
				<th>真实姓名</th>
				<th>电话号码</th>
				<th>创建时间</th>
				<th style="width: 150px;">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${page.dataList}">
				<tr>
					<th><input type="checkbox" value="${user.UID }"/></th>
					<td>
						<c:if test="${user.STATUS==-1}"><font color="red">${user.UID}</font></c:if>
						<c:if test="${user.STATUS!=-1}">${user.UID}</c:if>
					</td>
					<td>${user.NICKNAME}</td>
					<td>${user.REAL_NAME}</td>
					<td>${user.MOBILE}</td>
					<td>${user.CREATE_TIME}</td>
					<td><button onclick="delOneUser(${user.UID})">删除</button>&nbsp;<button onclick="userDetails(${user.UID})">查看和修改</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="changePge(1)">首页</a>
	&nbsp;<a href="javascript:void(0)" onclick="changePge(${page.pageNo-1})">上一页</a>
	&nbsp;<a href="javascript:void(0)" onclick="changePge(${page.pageNo+1})">下一页</a>
	&nbsp;<a href="javascript:void(0)" onclick="changePge(${page.pageCount})">尾页</a>
	&nbsp;当前第${page.pageNo }页
	&nbsp;共${page.pageCount}页
</div>