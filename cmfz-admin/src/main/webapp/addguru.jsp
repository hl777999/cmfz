<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/7
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#fb1').filebox({
            buttonText: '选择上传图片',
            buttonAlign: 'right'
        })
    });
</script>
<form id="ff3" method="post" enctype="multipart/form-data">
    <div style="margin-left: 85px;margin-top: 45px">
        <table style="border-collapse:separate; border-spacing:0px 15px;" >
            <tr >
                <td>
                    上&nbsp;&nbsp;师&nbsp;&nbsp;法&nbsp;&nbsp;号:
                </td>
                <td>
                    <input class="easyui-textbox"  name="guruname" style="width:200px" required ="required"/>
                </td>
            </tr>
            <tr>
                <td>
                    上&nbsp;&nbsp;师&nbsp;&nbsp;情&nbsp;&nbsp;况:
                </td>
                <td>
                    <select id="cc" class="easyui-combobox"  name="gurustatus" style="width:200px" required ="required">
                        <option value="健在">健在</option>
                        <option value="已故">已故</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    上传上师照片:
                </td>
                <td>
                    <input id="fb1" type="text" name="myfiled" style="width:200px" required ="required"/>
                </td>
            </tr>
            <tr>
                <td>
                    填写上师简介:
                </td>
                <td>
                    <input class="easyui-textbox" data-options="multiline:true" name="gurusummary"  style="width:200px;height:100px" required ="required">
                </td>
            </tr>
        </table>
    </div>
</form>
