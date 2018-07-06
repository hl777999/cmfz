<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/6
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="ff2" method="post" >
    <div style="margin-left: 40px;margin-top: 20px">
        <table style="border-collapse:separate; border-spacing:0px 15px;" >
            <tr >
                <td>
                    轮播图描述:
                </td>
                <td>
                    <input class="easyui-textbox"  name="picturedescription" style="width:150px" required ="required" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td>
                    轮播图状态:
                </td>
                <td>
                    <select id="cc" class="easyui-combobox" placeholder="请选择轮播图状态" name="picturestatus" style="width:150px" required ="required">
                        <option value="不展示">不展示</option>
                        <option value="展示">展示</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="hidden" name="pictureid"/></td>
            </tr>
        </table>
    </div>
</form>