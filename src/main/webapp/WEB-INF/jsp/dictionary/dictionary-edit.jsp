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
							<div id="div_text">	修改款项：</div>
					<input type="hidden"  id="id_text" value="${dictionaryInfo.id}">
									<input type="hidden"  id="code_text"  value="${dictionaryInfo.code}">
							<input type="text" style="width: 100%;float: left;" id="value_text" name="value" class="form-control" value="${dictionaryInfo.value}">
							<div id="div_text">	金额（元）：</div>
							<input type="text" style="width: 100%;float: left;" id="remark_text" name="remark" class="form-control" value="${dictionaryInfo.remark}">
						</div>
							</div>
							<div class="card-body">
							</div>
							<div class="card-body">
								<div class="form-actions form-group"><button id="addBtn" type="submit" class="btn btn-success btn-sm" onclick="submit()">Submit</button></div>
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
    function submit() {
    	var idText=$("#id_text").val();
    	var valueText=$("#value_text").val();
    	var remarkText=$("#remark_text").val();

        // 读取 text
        $.ajax({
            url:"/yhz/dictionary/dictionary-edit/"+idText,
            type:"post",
            data:{
            	value:valueText,
            	remark:remarkText
            },
            success:function(data){
                alert("成功");
        		window.location.href="/yhz/dictionary/dictionary-list";

            },
            error:function(e){
                alert("错误！！");
            }
        });        
        
    }
    </script>


</body>
</html>
