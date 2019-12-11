<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
<%@include file="/WEB-INF/include/head.jsp"%>

<script>

        $(function () {
            $("#sub_btn").click(function () {

                var username = $("[name=username]").val();
                var password = $("[name=password]").val();

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


                //alert("恭喜登录成功")
               // return false;

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
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="regist.html">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">
                                    <%--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
                                    ${empty msg?"请输入用户名和密码":msg}
                                </span>
							</div>
							<div class="form">
								<form action="UserServlet?method=login" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" value="${param.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
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