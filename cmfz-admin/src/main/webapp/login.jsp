<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="css/login.css" type="text/css"></link>
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript">
		$(function(){
		    var f=[false,false,false];
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码
                $("#captchaImage").attr("src","${pageContext.request.contextPath}/manager/validatecode?flag="+Math.random());
			});
			$("#txtusername").change(function(){
			    var id=$(this).val();
			    if (id.length==0){
                    $("#usernameinfo").html("<span style='color:red;font-size: 3px'><img src='../img/wrong.gif'/>&nbsp;不能为空</span>");
				}else {
			        $.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/manager/validatemgrid",
						data:{id:id},
						dataType:"json",
						success:function(data){
                           if(data){
                               $("#usernameinfo").html("<span style='color:green;font-size: 5px'><img src='../img/right.gif'/>&nbsp;用户存在</span>");
							   f[0]=true;
						   }else{
                               $("#usernameinfo").html("<span style='color:red;font-size: 5px'><img src='../img/wrong.gif'/>&nbsp;用户不存在</span>");
                           }
						}
					});
				}
            });
			$("#txtpassword").change(function(){
				var pwd=$(this).val();
				if (pwd.length == 0){
                    $("#passwordinfo").html("<span style='color:red;font-size: 5px'><img src='../img/wrong.gif'/>&nbsp;密码不能为空</span>");
                }else{
                    $("#passwordinfo").html("<span style='color:green;font-size: 5px'><img src='../img/right.gif'/></span>");
					f[1]=true;
				}
            });
			$("#enCode").change(function(){
				var code=$(this).val();
				if (code == 0){
                    $("#codeinfo").html("<span style='color:red;font-size: 5px'><img src='../img/wrong.gif'/>&nbsp;验证码为空</span>");
                }else{
                    $.ajax({
						type:"post",
						url:"${pageContext.request.contextPath}/manager/checkvalidatecode",
						data:{ecode:code},
						dataType:"json",
						success:function(data){
							if(data){
                                $("#codeinfo").html("<span style='color:red;font-size: 5px'><img src='../img/right.gif'/></span>");
                                f[2]=true;
							}else{
                                $("#codeinfo").html("<span style='color:red;font-size: 5px'><img src='../img/wrong.gif'/></span>");
                            }
                        }
					});
                }
            });
			//  form 表单提交
			$("#loginForm").bind("submit",function(){
                if (f[0]&&f[1]&&f[2]){
                     return true;
				}else {
                    return false;
                }
			});
		});
	</script>
</head>
<body>
	
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/manager/login" method="post" >
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  name="id" class="text" placeholder="请输入用户名" maxlength="20" id="txtusername"/>
								<span id="usernameinfo"></span>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" name="password" class="text" placeholder="请输入密码" maxlength="20" autocomplete="off" id="txtpassword"/>
								<span id="passwordinfo"></span>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="enCode" class="text captcha" placeholder="请输入验证码" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="${pageContext.request.contextPath}/manager/validatecode" title="点击更换验证码"/>
								<span id="codeinfo"></span>
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" id="isRememberUsername" value="true"/> 记住用户名
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>