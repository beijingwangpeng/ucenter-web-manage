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
<script src="${pageContext.request.contextPath }/js/ztree/jquery.ztree.core.js" type="text/javascript"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css" type="text/css">

<title>无标题文档</title>
<SCRIPT type="text/javascript">
		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: zTreeOnClick
			}
		};
		function zTreeOnClick(event, treeId, treeNode){
			//$("#myiframe").attr('src',"${pageContext.request.contextPath}"+treeNode.myurl;);
			//setNav(treeNode);
			if(treeNode.myurl!=""){
				window.location.href="${pageContext.request.contextPath}"+treeNode.myurl+"?tId="+treeNode.tId+"&myurl="+treeNode.myurl;
			}
		}
		$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/manage/initTree",
			   dataType:"json",
			   success: function(data){
				   var treeObj = $.fn.zTree.init($("#treeDemo"), setting, data);
				   //得到上一次用户点击的node id;
				   var tId = "${sessionScope.tId}";
				   var node = treeObj.getNodeByTId(tId);
				   //设置改节点为选中状态
				   treeObj.selectNode(node);
				   //设置导航栏
				   setNav(node);
			   }
		});
		var navStr = "";
		function setNav(node){
			if(node!=null){
				navStr = ">"+node.name+navStr;
				var parentNode = node.getParentNode();
				if(parentNode!=null){
					navStr = ">"+parentNode.name + navStr;
					setNav(parentNode.getParentNode());
				}
				$("#navStr").html(navStr);
			}
		}
	</SCRIPT>
   <style type="text/css">
   ul,li{
	 margin: 0;padding: 0;
	   }
   body{
	margin: 0px;
	padding: 0px;
	font-size: 12px;
	min-width: 1300px;
	font-family: "Courier New", Courier, monospace;
	   }

	.content_wrap{
		background-color: #F5F5F5;
		OVERFLOW-Y: auto;
		OVERFLOW-X:auto;
		width:230px;
		float: left;
		
		border-right-width: thin;border-right-style: solid;border-right-color: #CCC;
	}
	
   </style>
</head>
<body>
	
    <div class="content_wrap" id="content_wrap">
        <div class="zTreeDemoBackground left" id="zTreeDemoBackground">
                <ul id="treeDemo" class="ztree"></ul>
        </div>
    </div>
   	  <div id="navStr" style="clear:right; width:auto; height:30px; padding-top:15px; background-color:#F5F5F5;	border-bottom-width: thin;border-bottom-style: solid;border-bottom-color: #CCC;">
   		
   	</div>
   	<c:if test="${sessionScope.myurl eq '/manage/userQuery'}">
   		<jsp:include page="/WEB-INF/user/userQuery/userQuery.jsp"></jsp:include>
   	</c:if>
	  
    
    
<script type="text/javascript">
$(document).ready(function(){
	//设置左边div的高度
	initWH();;
});
window.onresize=function(){  
   	initWH();
}
function initWH(){
	var height = $(document).height();
	var width =  document.documentElement.clientWidth;
	$("#content_wrap").height(height);
}
</script>

</body>
</html>
