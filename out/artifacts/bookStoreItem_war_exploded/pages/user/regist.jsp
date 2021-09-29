<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%@include file="../common/header.jsp"%>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	.errorMsg{
		color: #dc143c;
	}
	
</style>

	<script type="text/javascript">
$(function() {
	$("#image").click(function(){
		this.src="${basePath}kaptcha.jpg?a="+new Date();
	});

	$("#username").blur(function(){
		var username = this.value;
		$.getJSON("http://localhost:8080/bookStoreItem_war_exploded/userServlet","action=ajax&username="+username,function(data){
			if(data.existusername){//hashmap<existsusername,result>
				$("span.errorMsg").text("用户名已存在");
			}else if(data.existusername==""){
				$("span.errorMsg").text("用户名为空");

			}
			else{
				$("span.errorMsg").text("用户名可用");
			}
		});

	});


	$("#sub_btn").click(function () {
		var username = $("#username").val();
		var password = $("#password").val();
		var repwd = $("#repwd").val();
		var email = $("#email").val();
		var code = $("#code").val();
		var matchReg = /^\w{5,12}$/

		if (!matchReg.test(username)) {
			$("span.errorMsg").text("用户名格式错误");
			return false;
		}

		if (!matchReg.test(password) || repwd !== password) {
			$("span.errorMsg").text("密码格式错误");
			return false;//阻止表单提交
		}

		if (email.trim() === "") {
			$("span.errorMsg").text("邮箱格式错误");
			return false;//阻止表单提交

		}
		if (code.trim() === "") {
			$("span.errorMsg").text("验证码格式错误");
			return false;//阻止表单提交

		}


		return true;

	});
});


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
								<span class="errorMsg">${requestScope.errormsg}</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input hidden="hidden" name="action" value="regist" >
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
										   value = "${ requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"
										   value = "${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input  class="itxt" type="text" style="width: 60px;height:8px" id="code" name="code"/>
									<img id="image" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width:80px;height:30px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="../common/footer.jsp" %>
</body>
</html>