<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/6
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $('#tt2').datagrid({
            width: 500,
            height: 250,
            remoteSort: false,
            singleSelect: true,
            nowrap: false,
            fit:true,
            fitColumns: true,
            url: '${pageContext.request.contextPath}/guru/queryall',
            columns: [[
                {field: 'guruid', title: '上师标识编号', width: 100,sortable: true, align: 'center'},
                {field: 'guruname', title: '上师法号', width: 80, sortable: true, align: 'center'},
                {field: 'gurusummary', title: '上师个人简介', width: 150, sortable: true, align: 'center'},
                {field: 'gurupic', title: '上师个人照片名称', width: 80,sortable: true, align: 'center'},
                {field: 'createtime', title: '上次修改时间', width: 80,sortable: true, align: 'center'},
                {field: 'gurustatus', title: '上师状态', width: 60, align: 'center'}
            ]],
            toolbar : "#tb1",
            pagination: true,
            pagePosition: "bottom",
            pageList: [2, 4, 6, 8, 10],
            pageSize: 10,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.gurupic + '" style="height:70px;"></td>' +
                    '<td style="border:0">' +
                    '<p>上师法号: ' + rowData.guruname + '</p>' +
                    '<p>上师状态: ' + rowData.gurusummary + '</p>' +
                    '<a id="modifypic" class="easyui-linkbutton" href="#">上师</a>' +
                    '</td>' +
                    '</tr></table>';
            }
        });

        $("#add1").linkbutton({
            onClick :function() {
                $("#dd2").dialog({
                    title:"新增上师信息",
                    shadow:true,
                    modal:true,
                    width:500,
                    height:400,
                    href:"${pageContext.request.contextPath}/addguru.jsp", //包含子页面
                    buttons:[{
                        text:'提交',
                        handler:function(){
                            $.messager.progress();	// 显示进度条
                            $('#ff3').form('submit', {
                                url:"${pageContext.request.contextPath}/guru/addguru" ,
                                onSubmit: function(){
                                    var isValid = $(this).form('validate');
                                    if (!isValid){
                                        $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                                    }
                                    return isValid;	// 返回false终止表单提交
                                },
                                success: function(date){
                                    if(date){
                                        $.messager.progress('close',{
                                            text:'正在提交'
                                        });	// 如果提交成功则隐藏进度条
                                        $("#dd2").window('close');
                                        $('#tt2').datagrid('reload');//自动刷新
                                    }else{
                                        $.messager.alert("警告","添加失败!");
                                    }
                                }
                            });
                        }
                    },{
                        text:'取消',
                        handler:function(){
                            $("#dd2").window('close');
                        }
                    }]
                });
            }});
        $("#edit1").linkbutton({
            onClick :function() {
                // 获取当前datagrid选中的这行记录 json
                var rowData = $("#tt2").datagrid("getSelected");
                if(rowData==null){
                    $.messager.alert("警告","请选择一个上师信息!");
                }else{
                    $("#dd3").dialog({
                        title:"修改上师信息",
                        shadow:true,
                        modal:true,
                        width:500,
                        height:350,
                        href:"${pageContext.request.contextPath}/modifyguru.jsp", //包含子页面
                        onLoad:function(){
                            $("#ff4").form("load",rowData); //在加载表单时将行数据加载到表单元素中
                        },
                        buttons:[{
                            text:'保存',
                            iconCls:"icon-save",
                            handler:function(){
                                $.messager.progress();	// 显示进度条
                                $('#ff4').form('submit', {
                                    url:"${pageContext.request.contextPath}/guru/modifyguru",
                                    onSubmit: function(){
                                        var isValid = $(this).form('validate');
                                        if (!isValid){
                                            $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                                        }
                                        return isValid;	// 返回false终止表单提交
                                    },
                                    success: function(date){
                                        if(date){
                                            $.messager.progress({
                                                text:'正在提交',
                                                //interval:5000,
                                            });	// 如果提交成功则隐藏进度条
                                            $.messager.progress('close');
                                            $("#dd3").window('close');
                                            $('#tt2').datagrid('reload');//自动刷新
                                        }else{
                                            $.messager.alert("警告","修改失败!");
                                        }
                                    }
                                });
                            }
                        },{
                            text:'取消',
                            iconCls : "icon-cancel",
                            handler:function(){
                                $("#dd3").window('close');
                            }
                        }]
                    });
                }
            }
        });

        $("#cancel1").linkbutton({
            onClick :function() {
                // 获取当前datagrid选中的这行记录 json
                var rowData = $("#tt2").datagrid("getSelected");
                if(rowData==null){
                    $.messager.alert("警告","请选择一个上师的信息!");
                }else{
                    $.messager.confirm("确认","您确认想要删除【"+rowData.guruname+"】信息吗？",function(r){
                        if (r){
                            $.ajax({
                                type:"POST",
                                url:"${pageContext.request.contextPath}/guru/removeguru",
                                data:{guruid:rowData.guruid},
                                success:function(msg){
                                    if(msg){
                                        $('#tt2').datagrid('reload');//自动刷新
                                    }else {
                                        $.messager.alert("警告","删除上师信息失败！");
                                    }
                                }
                            });
                        }
                    });
                }
            }
        });
        $("#upload").linkbutton({
            onClick :function() {
                $("#dd4").dialog({
                    title:"批量上传上师信息",
                    shadow:true,
                    modal:true,
                    width:400,
                    height:150,
                    href:"${pageContext.request.contextPath}/uploadformbyguru.jsp", //包含子页面
                    buttons:[{
                        text:'上传',
                        handler:function(){
                            $.messager.progress();	// 显示进度条
                            $('#ff5').form('submit', {
                                url:"${pageContext.request.contextPath}/guru/uploadexcel" ,
                                onSubmit: function(){
                                    var isValid = $(this).form('validate');
                                    if (!isValid){
                                        $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                                    }
                                    return isValid;	// 返回false终止表单提交
                                },
                                success: function(date){
                                    if(date){
                                        $.messager.progress('close',{
                                            text:'正在提交'
                                        });	// 如果提交成功则隐藏进度条
                                        $("#dd4").window('close');
                                        $('#tt2').datagrid('reload');//自动刷新
                                    }else{
                                        $.messager.alert("警告","上传失败失败!");
                                    }
                                }
                            });
                        }
                    },{
                        text:'取消',
                        handler:function(){
                            $("#dd4").window('close');
                        }
                    }]
                });
            }});
    });
    function qq(value, name) {
        // 加载第一页的数据 并且携带额外的请求参数
        $('#tt2').datagrid('load', {
            name: name,
            value: value,
        });
    }
</script>
<table id="tt2"></table>
<div id="tb1" style="display: none">
    <a id="edit1" class="easyui-linkbutton"
       data-options="iconCls:'icon-edit',plain:true,text:'修改'"></a>
    <a id="add1" class="easyui-linkbutton"
       data-options="iconCls:'icon-add',plain:true,text:'新增'"></a>
    <a id="cancel1" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true,text:'删除'">
    </a>
    <input id="ss" class="easyui-searchbox" style="width:300px"
           data-options="searcher:qq,prompt:'请您输入你的查找选项',menu:'#mm'"></input>
    <div id="mm" style="width:150px">
        <div data-options="name:'',iconCls:'icon-ok'">全部上师</div>
        <div data-options="name:'guruid',iconCls:'icon-ok'">上师标识编号</div>
        <div data-options="name:'guruname',iconCls:'icon-ok'">上师法号</div>
        <div data-options="name:'status',iconCls:'icon-ok'">上师状态</div>
    </div>
    <a id="upload" class="easyui-linkbutton"
       data-options="iconCls:'icon-arrow_up',plain:true,text:'批量添加上师'"></a>
    <a id="download" class="easyui-linkbutton" data-options="iconCls:'icon-page_excel',plain:true,text:'导出上师信息'"
       href="${pageContext.request.contextPath}/guru/downloadguru"></a>
</div>
<div id="dd2"></div>
<div id="dd3"></div>
<div id="dd4"></div>