<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@include file="/WEB-INF/include/head.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
</style>
    <script>

        $(function () {

            $("#code").click(function(){
                this.src = "code"
            })
            $("#sub_btn").click(function () {

                var username = $("[name=username]").val();
                var password = $("[name=password]").val();
                var repwd = $("[name=repwd]").val();
                var email = $("[name=email]").val();
                var code = $("[name=code]").val();

                var reg = /^[a-z0-9_-]{3,16}$/;
                if(!reg.test(username)){
                   alert("请正确输入用户名，要求3至16位，由小字字母和数字组成");
                   return false;
                }

                reg= /^[a-z0-9_-]{6,18}$/;
                if(!reg.test(password)){
                    alert("请正确输入密码，要求6至18位，由小字字母和数字组成");
                    return false;
                }

                if(password!=repwd){
                    alert("请设置确认密码或两次密码设置不一致，请重新设置");
                    return false;
                }

                reg= /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                if(!reg.test(email)){
                    alert("请正确输入邮箱格式");
                    return false;
                }

                if(code==""){
                    alert("请输入验证码");
                    return false;
                }


                // alert("恭喜注册成功")
                //  return false;


            })

        })

    </script>

</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
                                     <%--<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
                                      ${empty msg?"":msg}
                                </span>
							</div>
							<div class="form">
								<form action="UserServlet?method=regist" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="${param.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<%--<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" value="<%=request.getParameter("password")==null?"":request.getParameter("password")%>" />--%>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"  />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd"  />
									<br />
									<br />
									<label>电子邮件：</label>
									<%--<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" value="<%=request.getParameter("email")==null?"":request.getParameter("email")%>" />--%>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" value="${param.email}" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code" value="${param.code}"/>
									<img alt="" src="code" style="float: right; margin-right: 40px" id="code">
									<br />
									<br />
									<input type="submit"  value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2018
		</span>
	</div>
</body>
</html>