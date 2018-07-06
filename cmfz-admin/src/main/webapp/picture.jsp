<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/5
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    $('#tt').datagrid({
        toolbar: "#tb",
        width: 500,
        height: 250,
        fit: true,
        remoteSort: false,
        singleSelect: true,
        nowrap: false,

        url: "${pageContext.request.contextPath}/pic/picall",
        columns: [[
            {field: 'pictureid', title: '标识编号', width: 80, align: 'center'},
            {field: 'picturepath', title: '文件名', width: 80, sortable: true, align: 'center'},
            {
                field: 'picturedate',
                title: '创建时间',
                formatter: function (value, row, index) {
                    var unixTimestamp = new Date(value);
                    //return unixTimestamp.toLocaleString();
                    var y = unixTimestamp.getFullYear();
                    var m = unixTimestamp.getMonth() + 1;
                    var d = unixTimestamp.getDate();
                    var s = unixTimestamp.getHours();
                    var M = unixTimestamp.getMinutes();
                    var S = unixTimestamp.getSeconds();
                    return y + "年" + m + "月" + d + "日" + s + "时" + M + "分" + S + "秒";
                },
                width: 110,
                align: 'right',
                sortable: true,
                align: 'center'
            },
            {field: 'picturedescription', title: '描述信息', width: 80, align: 'right', sortable: true, align: 'center'},
            {field: 'picturestatus', title: '轮播图状态', width: 30, sortable: true, align: 'center'},
            {
                field: "123435",
                title: '操作',
                width: 100,
                align: 'center',
                formatter: function (value, rec, index) {
                    var modify='<a name="modify" id="edit"></a>';
                    return modify;
                }
            }
        ]],
        fitColumns: true,
        onLoadSuccess:function (data) {
              $("a[name='modify']").linkbutton({
                   height:20,
                   width:80,
                   text:'双击修改',
                   iconCls:"icon-edit",
                   id:'edit',
                   onClick:function() {
                      // 获取当前datagrid选中的这行记录 json
                      var rowData = $("#tt").datagrid("getSelected");
                      console.log(rowData);
                       if(rowData != null){
                           $("#dd").dialog({
                               title:"修改图片信息",
                               shadow:true,
                               modal:true,
                               width:300,
                               height:251,
                               href:"${pageContext.request.contextPath}/modifypicture.jsp", //包含子页面
                               onLoad:function(){
                                   $("#ff2").form("load",rowData); //在加载表单时将行数据加载到表单元素中
                               },
                               buttons:[{
                                   text:'保存',
                                   iconCls :"icon-save",
                                   handler:function(){
                                       $.messager.progress();	// 显示进度条
                                       $('#ff2').form('submit', {
                                           url:"${pageContext.request.contextPath}/pic/modifypic",
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
                                                       text:'正在提交'
                                                   });	// 如果提交成功则隐藏进度条
                                                   $.messager.progress('close');
                                                   $("#dd").window('close');
                                                   $('#tt').datagrid('reload');//自动刷新
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
                                       $("#dd").window('close');
                                   }
                               }]
                           });
                       }
                  }
              });
        },
        pagination: true,
        pagePosition: "bottom",
        pageList: [2, 4, 6, 8, 10],
        pageSize: 10,
        view: detailview,
        detailFormatter: function (rowIndex, rowData) {
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.picturepath + '" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>图片详细信息: ' + rowData.picturedescription + '</p>' +
                '<p>轮播状态: ' + rowData.picturestatus + '</p>' +
                '</td>' +
                '</tr></table>';
        }
    });
    $(function () {
        $("#add").linkbutton({
            onClick: function () {
                $("#dd1").dialog({
                    title: "新增图片信息",
                    iconCls:"icon-large-picture",
                    shadow: true,
                    modal: true,
                    width: 400,
                    height: 300,
                    maximizable: true,
                    minimizable: true,
                    collapsible: true,
                    href: "${pageContext.request.contextPath}/addpicture.jsp", //包含子页面
                    buttons: [{
                        text: '提交',
                        handler: function () {
                            $.messager.progress();	// 显示进度条
                            $('#ff1').form('submit', {
                                url: "${pageContext.request.contextPath}/uploadfiled/filed",
                                onSubmit: function () {
                                    var isValid = $(this).form('validate');
                                    if (!isValid) {
                                        $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                                    }
                                    return isValid;	// 返回false终止表单提交
                                },
                                success: function (date) {
                                    if (date) {
                                        $.messager.progress('close', {
                                            text: '正在提交'
                                        });	// 如果提交成功则隐藏进度条
                                        $("#dd1").window('close');
                                        $('#tt').datagrid('reload');//自动刷新
                                    } else {
                                        $.messager.alert("警告", "添加失败!");
                                    }
                                }
                            });
                        }
                    }, {
                        text: '取消',
                        handler: function () {
                            $("#dd1").window('close');
                        }
                    }]
                });
            }
        });
        $("#cancel").linkbutton({
            onClick :function() {
                // 获取当前datagrid选中的这行记录 json
                var rowData = $("#tt").datagrid("getSelected");
                if(rowData==null){
                    $.messager.alert("警告","请选择一行图片信息!");
                }else{
                    $.messager.confirm("确认","您确认想要删除图片【"+rowData.picturedescription+"】信息吗？",function(r){
                        if (r){
                            $.ajax({
                                type:"POST",
                                url:"${pageContext.request.contextPath}/pic/deletepic",
                                data:{id:rowData.pictureid},
                                success:function(msg){
                                    if(msg){
                                        $('#tt').datagrid('reload');//自动刷新
                                    }else {
                                        $.messager.alert("警告","删除图片失败！");
                                    }
                                }
                            });
                        }
                    });
                }
            }
        });
//        $("#edit").linkbutton({
//            onClick: function () {
//                // 获取当前datagrid选中的这行记录 json
//                var rowData = $("#tt1").datagrid("getSelected");
//                console.log(rowData);
//            }
//        });
    });
</script>
<table id="tt"></table>
<div id="tb" style="display: none">
    <a id="add" class="easyui-linkbutton"
       data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'">
    </a>
    <a id="cancel" class="easyui-linkbutton"
       data-options="iconCls:'icon-cancel',plain:true,text:'删除'">
    </a>
</div>
<div id="dd1"></div>
<div id="dd"></div>
