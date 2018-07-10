<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style type="text/css">
    .toolbar {
        border: 1px solid #ccc;
        width: 1000px;
    }

    .text {
        border: 1px solid #ccc;
        height: 250px;
        width: 1000px;
    }
</style>
<script type="text/javascript">
    $(function () {
        $("#btn2").linkbutton({
            onClick: function () {
                $("#article").val(editor.txt.html());
                var article = $("#article").val();
                var m ="";
                if( article = m){
                    $.messager.alert("警告","文章内容不能为空！");
                }else {
                    $.messager.confirm("确认","您确认保存该文章吗？",function (r) {
                        if (r){
                            $("#form_article").form("submit",{
                                url:"${pageContext.request.contextPath}/article/addarticle",
                                onSubmit:function () {
                                    var isValid = $(this).form('validate');
                                    if (!isValid){
                                        $.messager.progress('close');	// 如果表单是无效的则隐藏进度条
                                    }
                                    return isValid;	// 返回false终止表单提交
                                },
                                success:function (date) {
                                    if(date){
                                        $.messager.progress({text:'正在提交'});	// 如果提交成功则隐藏进度条
                                        $.messager.progress('close');
                                    }else{
                                        $.messager.alert("警告","修改失败!");
                                    }
                                }
                            });
                        }
                    })

                }
            }
        });
        $('#cc1').combobox({
            url:"${pageContext.request.contextPath}/article/guruall",
            valueField:'guruid',
            textField:'guruname'
        });
        $("#btn1").linkbutton({
            onClick:function () {
                editor.txt.clear();
                $("#form_article").form('reset');
            }
        });
    });
</script>
<form id="form_article" method="post">
    <div style="margin-left: 50px;margin-top: 20px">
        <table style="border-collapse:separate; border-spacing:0px 15px;">
            <tr>
                <td>文章标题:</td>
                <td><input class="easyui-validatebox" type="text" name="articlename" data-options="required:true"
                           style="width:200px;"/></td>
            </tr>
            <tr>
                <td>文章作者:</td>
                <td>
                    <select id="cc1"  name="guruid"  value="请选择上师" style="width:200px;">
                    </select>
                </td>
            </tr>
            <tr>
                <td>文章状态:</td>
                <td>
                    &nbsp;&nbsp;不上架:<input  type="radio" name="articlestatus" value="不上架" checked="checked"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    上&nbsp;&nbsp;架:<input  type="radio" name="articlestatus" value="上架"/>
                </td>
            </tr>
            <tr>
                <td>文章内容:</td>
                <td>
                    <input type="hidden" name="articleintroduction" id="article"/>
                </td>
            </tr>
        </table>
    </div>
</form>
<div id="div1" class="toolbar" style="margin-left: 50px;margin-top: 5px">
</div>
<div style="padding: 5px 0; color: #ccc;margin-left: 50px"></div>
<div id="div2" class="text" style="margin-left: 50px"> <!--可使用 min-height 实现编辑区域自动增加高度-->
</div>
<div  style="margin-left: 470px;margin-top: 20px;margin-bottom: 20px">
    <a id="btn2" class="easyui-linkbutton">提交文章</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a id="btn1" class="easyui-linkbutton">重置文章</a>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#div1', '#div2')
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}//uploadfiled/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    editor.create()
</script>

