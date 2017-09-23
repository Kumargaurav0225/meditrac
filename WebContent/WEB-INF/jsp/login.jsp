<%@page import="proj.meditrac.core.enums.SessionParams"%>
<%@ page language="java" session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/MediTrac/assets/css/bootstrap-paper.min.css"/>
    <style>
        .header {margin:0px auto;width:70%;height: 50px;border-bottom: 1px solid #EEE;}
        .header > .logo {width: 160px;height: 100%;margin:0px auto;background-image: url("/MediTrac/assets/img/logo-mediatrac.png");}
        .login-form {margin: 70px auto;width:420px;float:none;margin-bottom: 0px;}
        .form-content {padding: 30px;}
        .home-det > .col-lg-4 {border:1px solid #EEE;margin:20px;}
        .navbar {position: fixed;bottom: 0px;width: 100%;margin-bottom: 0px;}
        .or-encircled {margin:15px auto;width:45px;height: 45px;border: 3px solid #BBBBBB;border-radius: 45px;line-height: 39px;text-align: center;font-weight: bold;color: #BBB;}
    	.form-group {position:relative;}
    	.form-group label {position:absolute;top:10px;scale:0.5;transition: all 0.3s ease-in-out;}
    	.form-group input:focus + label{top:-10px;font-size:10px;font-weight:bold;}
    	.has-focus {position:absolute;top:-10px !important;font-size:10px;font-weight:bold;}
    </style>
</head>
<body>  
    <div class="row header">
        <div class="logo"></div>
        <div></div>
    </div>
    <% if(request.getAttribute("login_error") != null && session.getAttribute(SessionParams.ERROR.getParamName()).equals("LOGIN_ERROR")){ %>
	    <div class="container">
	    	<div class="row">
	    		<div class="col-lg-6 col-lg-offset-3">
	    			<div class="alert alert-dismissible alert-danger">
					  <button type="button" class="close" data-dismiss="alert">&times;</button>
					  <strong>Oh snap!</strong> <a href="#" class="alert-link">Change a few things up</a> and try submitting again.
					</div>
	    		</div>
	    	</div>
	    </div>
    <% } %>>
    <div class="login-form">
        <form class="panel panel-default" action="/MediTrac/AccountsController/Authenticate" method="post" onSubmit="return MT.verify(this)">
            <div class="panel-heading"><b>Sign In</b></div>
            <div class="form-content">
                <div class="form-group">
                    <input class="form-control" name="mem_id" type="text" onblur="MT.animateLabel(this)"/>
                    <label>Member ID</label>
                </div>
                <div class="form-group">
                    <input class="form-control" name="mem_pass" type="password" onblur="MT.animateLabel(this)"/>
                    <label>Password</label>
                </div>
                            
                <input type="submit" class="btn btn-primary btn-lg btn-block" value="Login" />
            </div>
        </form>
    </div>
    <div class="or-encircled">OR</div>
    <div style="width:360px;margin: 0px auto;">
        <button class="btn btn-success btn-lg btn-block" onclick="">Register</button>
    </div>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Meditrac</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Facilities</a></li>
                    <li><a href="#">Sitemap</a></li>
                    <li><a href="#">About</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Friends Inc.</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <script type="text/javascript" src="/MediTrac/assets/js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="/MediTrac/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	var MT = window.MT || {};
    	
    	MT.animateLabel = function(el){
    		if(el.value.trim() != "")
   				el.nextElementSibling.className = 'has-focus';
    	}
    </script>
</body>
</html>
