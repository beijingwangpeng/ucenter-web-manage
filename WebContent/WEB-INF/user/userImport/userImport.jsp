<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
td, th {
	border: 1px solid #DDD;
	padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 5px;
	text-align: left;
}

.selected {
	background: #f1f1f1;
	font-weight: bold;
}

.even {
	background: #F9F9F9;
}
</style>
<link href="${pageContext.request.contextPath }/js/fileUpload/css/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/fileUpload/jquery.uploadify.js"></script>

<script type="text/javascript">
$(function() {
    $('#file_upload').uploadify({
        'swf'      : '${pageContext.request.contextPath }/js/fileUpload/uploadify.swf',
        'uploader' : 'uploadify.php'
        // Put your options here
    });
});
</script>
<input type="file" name="file_upload" id="file_upload" />  