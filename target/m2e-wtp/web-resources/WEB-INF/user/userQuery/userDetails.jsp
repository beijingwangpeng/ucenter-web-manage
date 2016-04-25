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
<script type="text/javascript">
$(function(){
	var info = "${flag}";
	if(info=="true"){
		alert("操作成功");
	}
	if(info=="false"){
		alert("操作失败");
	}
})
</script>
<title>无标题文档</title>
</head>
	<body>
		<form action="${pageContext.request.contextPath }/manage/userUpdate" method="post">
			<table id="dataTab"  cellpadding="0" cellspacing="0">
				<tr>
					<td>UID</td>
					<td><input name="UID" value="${user.UID}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>PASSPORT</td>
					<td><input name="PASSPORT" value="${user.PASSPORT}"/></td>
				</tr>
				<tr>
					<td>昵称</td>
					<td><input name="NICKNAME" value="${user.NICKNAME}"/></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td><input name="REAL_NAME" value="${user.REAL_NAME}"/></td>
				</tr>
				<tr>
					<td>MOBILE</td>
					<td><input name="MOBILE" value="${user.MOBILE}"/></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input name="EMAIL" value="${user.EMAIL}"/></td>
				</tr>
				<tr>
					<td>ID_CARD</td>
					<td><input name="ID_CARD" value="${user.ID_CARD}"/></td>
				</tr>
				<tr>
					<td>激活状态</td>
					<td><input name="ACTI_FLAG" value="${user.ACTI_FLAG}"/></td>
				</tr>
				<tr>
					<td>用户状态</td>
					<td><input name="STATUS" value="${user.STATUS}"/></td>
				</tr>
				<tr>
					<td>用户来源</td>
					<td><input name="REG_APP_ID" value="${user.REG_APP_ID}"/></td>
				</tr>
				<tr>
					<td>创建时间</td>
					<td><input name="CREATE_TIME" value="${user.CREATE_TIME}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>修改时间</td>
					<td><input name="MODIFY_TIME" value="${user.MODIFY_TIME}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>是否迁移</td>
					<td><input name="IS_MIGRATED" value="${user.IS_MIGRATED}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>区域ID</td>
					<td><input name="areaID" value="${user.areaID}"/></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input name="sex" value="${user.sex}"/></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><input name="age" value="${user.age}"/></td>
				</tr>
				<tr>
					<td>学校ID</td>
					<td><input name="schoolID" value="${user.schoolID}"/></td>
				</tr>
				<tr>
					<td>学科</td>
					<td><input name="subject" value="${user.subject}"/></td>
				</tr>
				<tr>
					<td>学段</td>
					<td><input name="stage" value="${user.stage}"/></td>
				</tr>
				<tr>
					<td>年级</td>
					<td><input name="grade" value="${user.grade}"/></td>
				</tr>
				<tr>
					<td>qq</td>
					<td><input name="qq" value="${user.qq}"/></td>
				</tr>
			</table>
			<input type="submit" value="修改"/>
		</form>
	</body>
</html>