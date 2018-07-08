<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/7
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#fb2').filebox({
            buttonText: '选择上传文件',
            buttonAlign: 'right',
            accept:'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel'
        })
    });
</script>
<form id="ff5" method="post" enctype="multipart/form-data">
    <div style="margin-left: 20px;margin-top: 20px">
        <table style="border-collapse:separate; border-spacing:0px 15px;" >
            <tr>
                <td>
                    选择上传的文件:
                </td>
                <td>
                    <input id="fb2" type="text" name="myfiled" style="width:250px" required ="required"/>
                </td>
            </tr>
        </table>
    </div>
</form>