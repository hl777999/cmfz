<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/9
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $('#tt3').datagrid({
            url:'${pageContext.request.contextPath}/log/alllog',
            columns:[[
                {field:'id',title:'日志编号',width:150,align:'center',sortable: true},
                {field:'user',title:'管理员',width:150,align:'center'},
                {field:'time',title:'日志生成时间',width:150,align:'center',sortable: true},
                {field:'resource',title:'操作源',width:100,align:'center'},
                {field:'action',title:'操作动作',width:100,align:'center'},
                {field:'message',title:'操作动作',width:350,align:'center'},
                {field:'result',title:'操作结果',width:130,align:'center'}
            ]],
            pagination: true,
            pagePosition: "bottom",
            pageList: [2, 4, 6, 8, 10],
            pageSize: 10,
        });


    });
</script>
<table id="tt3"></table>

