<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/6
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<script type="text/javascript">
    $(function () {
        $('#fb').filebox({
            buttonText: '选择上传图片',
            buttonAlign: 'right'
        })
    });
</script>
<form id="ff1" method="post" enctype="multipart/form-data">
    <div style="margin-left: 40px;margin-top: 20px">
        <table style="border-collapse:separate; border-spacing:0px 15px;" >
            <tr >
                <td>
                    轮播图描述:
                </td>
                <td>
                    <input class="easyui-textbox" placeholder="请输入描述信息" name="name" style="width:200px" required ="required"/>
                </td>
            </tr>
            <tr>
                <td>
                    轮播图状态:
                </td>
                <td>
                    <select id="cc" class="easyui-combobox" placeholder="请选择轮播图状态" name="dept" style="width:200px" required ="required">
                        <option value="不展示">不展示</option>
                        <option value="展示">展示</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                      上传轮播图:
                </td>
                <td>
                    <input id="fb" type="text" name="myfiled" style="width:200px" required ="required"/>
                </td>
            </tr>
        </table>
    </div>
</form>

