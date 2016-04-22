<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ch">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户中心管理后台</title>
<style type="text/css">
body {
	background-color: #323B55;
	margin: 0px;
	padding: 0px;
	text-align: center;
	height:100%;
}
.slick-login{
	margin-top:-110px;
	margin-left:-110px;

	position: absolute;
	top: 50%;
	left:50%;
}
.slick-login input{
	width: 220px;
	border-radius:10px;
	-moz-border-radius:10px; /* 老的 Firefox */
	margin-bottom:10px;
	height: 38px;
	 background:no-repeat 0 0 scroll ＃EEEEEE;
    border:none;
    outline:medium;
	padding-left:10px;
}
.submit {
	text-align:center;
	cursor: pointer;
	background:#667BDF;
	color: #FFF;
	font-weight: bold;
	font-size: 18px;
	padding-left:-10px;
}
</style>
<script type="text/javascript">
	function loginAnimation(){
			
	}
</script>
</head>

<body>
 <form class="slick-login" action="${pageContext.request.contextPath }/manage/login" method="post">
       <input type="text" name="username" class="placeholder" placeholder="username"><br />
       <input type="password" name="password" class="placeholder" placeholder="password"><br/>
       <input  class="submit" type="submit" value="Log In" onMouseOver="loginAnimation()" />
 </form>
</body>
</html>
