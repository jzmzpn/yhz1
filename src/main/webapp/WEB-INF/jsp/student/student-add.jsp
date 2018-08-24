<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>幼兒園</title>
<meta name="description" content="Sufee Admin - HTML5 Admin Template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="apple-touch-icon" href="../apple-icon.png">
<link rel="shortcut icon" href="../favicon.ico">

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/normalize.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/themify-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/flag-icon.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/cs-skin-elastic.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/lib/datatable/dataTables.bootstrap.min.css">
<!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/scss/style.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-table.css">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

</head>
<body>
	<!-- Left Panel -->
	<jsp:include page="../left-panel.jsp" flush="true" />
	<!-- /#left-panel -->

	<!-- Left Panel -->

	<!-- Right Panel -->

	<div id="right-panel" class="right-panel">

		<!-- Header-->
		<jsp:include page="../header.jsp" flush="true" />
		<!-- /header -->
		<!-- Header-->


		<div class="content mt-3">
			<div class="animated fadeIn">
				<div class="row">

					<div class="col-md-12">
						<div class="card">
							
						<div class="card-body">
							<!-- <div class="input-group-addon" style="width: 8%;float: left;"> -->
								<select name="newsType" id="newsType" class="form-control" style="width: 12%;height: 38px;float: left;">
	                                <option value="0">未知</option>
	                                <option value="301">院所新闻</option>
	                                <option value="302">保健知识</option>
	                                <option value="303">育儿分享</option>
	                              </select>
							<!-- </div> -->
							<div style="float:left; width:1%">&nbsp;</div>
							<input type="text" style="width: 87%;float: left;" id="title_text" name="title" class="form-control">
							</div>
							<div class="card-body">
								
							
							<div id="div_text"></div>

							</div>
							
							<!-- <input type="file" accept="image/png,image/jpeg,image/gif" name="myPic" id="imageId" style="
								    margin-left: 20px;
								    margin-bottom: 20px;
								"> -->
								
								
								
								
								
							</div>
							<div class="card-body">
								<form id="infoLogoForm" enctype='multipart/form-data'>
								    <div class="cnt-updateWrapper" >
								        <div>
								            <div id="loadImg" class="cnt-img-content">
								                <div id="licenseBox" class="ctn-licence">
								                    <input type="file" id="ctn-input-file" name="imageFile" accept="image/*" style="height:40px" >
								                	<input type="hidden" name="imageId" id="imageId"/>
								                </div>
								            </div>
								        </div>
								    </div>
								</form>
							</div>
							<div class="card-body">
								<div class="form-actions form-group"><button id="addBtn" type="submit" class="btn btn-success btn-sm">Submit</button></div>
							</div>
						</div>
					</div>


				</div>
			</div>
			<!-- .animated -->
		</div>
		<!-- .content -->


	</div>
	<!-- /#right-panel -->

	<!-- Right Panel -->


	<script src="${pageContext.request.contextPath}/assets/js/vendor/jquery-2.1.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>


	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/datatables.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/dataTables.buttons.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/jszip.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/pdfmake.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/vfs_fonts.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/buttons.html5.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/buttons.print.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/buttons.colVis.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/lib/data-table/datatables-init.js"></script>

	<!-- <script src="assets/js/jquery.min.js"></script> -->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap-table.js"></script>
	<!-- put your locale files after bootstrap-table.js -->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap-table-zh-CN.js"></script>
	<script type="text/javascript" src="https://unpkg.com/wangeditor@3.1.1/release/wangEditor.min.js"></script>


	<script type="text/javascript">
	var E = window.wangEditor
	var editor2 = new E('#div_text')
	editor2.customConfig.uploadImgShowBase64 = true
	editor2.create()
        
    document.getElementById('addBtn').addEventListener('click', function () {
        // 读取 text
        var news = editor2.txt.text();
        var newsType = $("#newsType").val();
        var imageId = $("#imageId").val();
        $.ajax({
            url:"${pageContext.request.contextPath}/newInfos/add",
            type:"post",
            data:{newsType:newsType, news:news, imageId:imageId},
            success:function(data){
                alert("成功")
            },
            error:function(e){
                alert("错误！！");
            }
        });        
        
    }, false);
	
	
	var uploading = false;

	$("#ctn-input-file").on("change", function(){
	    if(uploading){
	        alert("文件正在上传中，请稍候");
	        return false;
	    }
	    $.ajax({
	        url: "${pageContext.request.contextPath}/image/upload",
	        type: 'POST',
	        cache: false,
	        data: new FormData($('#infoLogoForm')[0]),
	        processData: false,
	        contentType: false,
	        dataType:"json",
	        beforeSend: function(){
	            uploading = true;
	        },
	        success : function(data) {
	        	$("#imageId").val(data);
	            uploading = false;
	        }
	    });
	});
	
	
    </script>


</body>
</html>
