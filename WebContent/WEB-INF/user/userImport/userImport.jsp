<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="${pageContext.request.contextPath }/js/huploadify/Huploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/huploadify/jquery.Huploadify.js"></script>

<script type="text/javascript">
$(function(){
	var up = $('#upload').Huploadify({
		auto:false,
		fileTypeExts:'*.*',
		multi:true,
		formData:{key:123456,key2:'vvvv'},
		fileSizeLimit:99999999999,
		showUploadedPercent:true,
		showUploadedSize:true,
		removeTimeout:9999999,
		uploader:'${pageContext.request.contextPath }/manage/doUpload',
		onUploadStart:function(file){
			console.log(file.name+'开始上传');
		},
		onInit:function(obj){
			console.log('初始化');
			console.log(obj);
		},
		onUploadComplete:function(file){
			console.log(file.name+'上传完成');
		},
		onCancel:function(file){
			console.log(file.name+'删除成功');
		},
		onClearQueue:function(queueItemCount){
			console.log('有'+queueItemCount+'个文件被删除了');
		},
		onDestroy:function(){
			console.log('destroyed!');
		},
		onSelect:function(file){
			console.log(file.name+'加入上传队列');
		},
		onQueueComplete:function(queueData){
			console.log('队列中的文件全部上传完成',queueData);
		}
	});

	$('#btn2').click(function(){
		up.upload('*');
	});
	$('#btn3').click(function(){
		up.cancel('*');
	});
	$('#btn4').click(function(){
		//up.disable();
		up.Huploadify('disable');
	});
	$('#btn5').click(function(){
		up.ennable();
	});
	$('#btn6').click(function(){
		up.destroy();
	});
});
</script>
<div id="upload"></div>
<button id="btn2">upload</button>
<button id="btn3">cancel</button>
<button id="btn4">disable</button>
<button id="btn5">ennable</button>
<button id="btn6">destroy</button>