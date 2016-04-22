<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ch">
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">   
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="${pageContext.request.contextPath }/js/jquery-1.12.3.js" type="text/javascript"></script>
<style type="text/css">
	td,th{border:1px solid #DDD;padding-top:15px;padding-bottom: 15px;padding-left: 5px;text-align: left;}
</style>
<title>无标题文档</title>
</head>
	<body>
		<table id="dataTab"  cellpadding="0" cellspacing="0">
			<tr>
				<td>UID</td>
				<td>${user.UID}</td>
			</tr>
			<tr>
				<td>PASSPORT</td>
				<td>${user.PASSPORT}</td>
			</tr>
			<tr>
				<td>昵称</td>
				<td>${user.NICKNAME}</td>
			</tr>
			<tr>
				<td>真实姓名</td>
				<td>${user.REAL_NAME}</td>
			</tr>
		</table>
	</body>
</html>