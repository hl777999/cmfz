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
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.gurupic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.guruname + '</p>' +
                    '<p>Status: ' + rowData.gurusummary + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });

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
       data-options="iconCls:'icon-edit',plain:true,text:'批量添加上师'"></a>
</div>