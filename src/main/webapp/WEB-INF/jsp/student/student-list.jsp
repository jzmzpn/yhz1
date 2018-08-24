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
<link rel="stylesheet" href="https://v4-alpha.getbootstrap.com/dist/css/bootstrap.min.css">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css"> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-table.css"> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/normalize.css">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/themify-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/flag-icon.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/cs-skin-elastic.css">
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/lib/datatable/dataTables.bootstrap.min.css"> --%>
<!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/scss/style.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-table.css">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
<style type="text/css">
	.table td, .table th {
    padding: 0.2rem!important;
    vertical-align: top;
    border-top: 1px solid #dee2e6;
    
    top: 0!important;
    left: 0!important;
    right: 0!important;
    bottom: 0!important;
}
</style>
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
								<div id="toolbar" class="btn-group">
						            <button id="btn_add" type="button" style="margin-right:5px" class="btn btn-primary" onclick="window.location.href='${pageContext.request.contextPath}/newInfos/toAddArticle'">
						                新增
						            </button>
						            <button id="btn_edit" type="button" style="margin-right:5px"  class="btn btn-primary">
						                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
						            </button>
						            <button id="btn_delete" type="button" style="margin-right:5px"  class="btn btn-primary">
						                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
						            </button>
						            <button id="btn_delete" type="button" style="margin-right:5px"  class="btn btn-primary" onclick="javascript:importStudents();">
						                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>導入
						            </button>
						            
						            <form id="infoLogoForm" enctype='multipart/form-data' style="display:none;">
								    <div class="cnt-updateWrapper" >
								        <div>
								            <div id="loadImg" class="cnt-img-content">
								                <div id="licenseBox" class="ctn-licence">
								                    <input type="file" id="ctn-input-file" name="imageFile" style="height:40px" >
								                	<input type="hidden" name="imageId" id="imageId"/>
								                </div>
								            </div>
								        </div>
								    </div>
								</form>
						        </div>
								<table id="table">

								</table>


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


	<script type="text/javascript">
	
	function importStudents() {
		$("#ctn-input-file").trigger("click");
	}
	
	var uploading = false;
	
	$("#ctn-input-file").on("change", function(){
	    if(uploading){
	        alert("文件正在上传中，请稍候");
	        return false;
	    }
	    $.ajax({
	        url: "${pageContext.request.contextPath}/xls/upload/stu",
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
	        	//location.reload()；
	        	window.location.reload()
	            uploading = false;
	        }
	    });
	});
	
	
    var $table;
    //初始化bootstrap-table的内容
    function InitMainTable () {
        //记录页面bootstrap-table全局变量$table，方便应用
        var queryUrl = 'query'
        $table = $('#table').bootstrapTable({
            url: queryUrl,                      //请求后台的URL（*）
            method: 'POST',                      //请求方式（*）
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
            toolbar: '#toolbar',              //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
            pageSize: 10,                     //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                      //是否显示表格搜索
            strictSearch: true,
            dataField: "list",
            showColumns: true,                  //是否显示所有的列（选择显示的列）
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                   //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                  //是否显示父子表
            //得到查询的参数
            queryParams : function (params) {
                //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                console.log(params.search)
                var temp = {   
                    rows: params.limit,                         //页面大小
                    page: (params.offset / params.limit) + 1,   //页码
                    sort: params.sort,      //排序列名  
                    sortOrder: params.order, //排位命令（desc，asc）
                    search: params.search
                };
                return temp;
            },
            columns: [{
                checkbox: true,  
                visible: true                  //是否显示复选框  
            }, {
                field: 'id',
                title: 'ID',
                sortable: true
            }, {
                field: 'name',
                title: '姓名',
                sortable: true
            }, {
                field: 'sex',
                title: '性別',
                formatter: function (value, row, index) {
                    if(value == 'F') {
                    	return '女';
                    }
                    if(value == 'M') {
                    	return '男';
                    }
                    return "未知";
                }
            },
            {
                field: 'enterDate',
                title: '入学时间'
            },
            {
                field: 'createDate',
                title: '创建时间'
            },],
            onLoadSuccess: function () {
            },
            onLoadError: function () {
                showTips("数据加载失败！");
            },
            onDblClickRow: function (row, $element) {
                var id = row.ID;
                EditViewById(id, 'view');
            },
        });
    };
    
    function changeDateFormat(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            
            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
            
            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        }
    }
    
    InitMainTable()
        
        
    </script>


</body>
</html>
