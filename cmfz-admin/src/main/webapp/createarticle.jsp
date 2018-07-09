<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style type="text/css">
    .toolbar {
        border: 1px solid #ccc;
    }

    .text {
        border: 1px solid #ccc;
        height: 400px;
    }
</style>
<script type="text/javascript">
    $(function () {
        $("#btn1").linkbutton({
            onClick: function () {
                var txt = editor.txt.html();
                $("#article").val(txt);
            }
        });
        $("#btn2").linkbutton({
            onClick: function () {
                var v = $("#article").val();
                if(v==null){
                    $.messager.alert("警告","请先确认编辑!");
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
                                        $.messager.progress({
                                            text:'正在提交',
                                        });	// 如果提交成功则隐藏进度条
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

        $("#btn3").linkbutton({
            onClick: function () {

            }
        });
    });
</script>
<table>
    <tr>
        <td><a id="btn1" class="easyui-linkbutton">确认编辑</a></td>
        <td><a id="btn2" class="easyui-linkbutton">提交文章</a></td>
        <td><a id="btn3" class="easyui-linkbutton">提交文章</a></td>
    </tr>
</table>
<form id="form_article" method="post">
    <div style="margin-left: 20px;margin-top: 20px">
        <table style="border-collapse:separate; border-spacing:0px 15px;">
            <tr>
                <td>文章标题:</td>
                <td><input class="easyui-validatebox" type="text" name="articlename" data-options="required:true"
                           style="width:200px;"/></td>
            </tr>
            <tr>
                <td>文章作者:</td>
                <td>
                    <select id="cc" class="easyui-combobox" name="guruid" style="width:200px;">
                        <option value="1">上师仁波切01</option>
                        <option value="1">上师仁波切02</option>
                        <option value="1">上师仁波切03</option>
                        <option value="1">上师仁波切05</option>
                        <option value="1">上师仁波切014</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>文章状态:</td>
                <td>
                    <input id="switchbutton" class="easyui-switchbutton" name="articlestatus" value="不提交"
                           data-options="onText:'上架',offText:'不上架'">
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
<div id="div1" class="toolbar" style="margin-left: 20px;margin-top: 5px">
</div>
<div style="padding: 5px 0; color: #ccc;margin-left: 20px"></div>
<div id="div2" class="text" style="margin-left: 20px;min-height: 300px"> <!--可使用 min-height 实现编辑区域自动增加高度-->
    <p>请输入内容</p>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#div1', '#div2')
    editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}//uploadfiled/upload';  // 上传图片到服务器
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    editor.create()
</script>

