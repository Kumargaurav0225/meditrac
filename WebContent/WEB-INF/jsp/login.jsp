<%@ page language="java" session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
    <style>
        .header {margin:0px auto;width:70%;height: 50px;border-bottom: 1px solid #EEE;}
        .header > .logo {width: 160px;height: 100%;margin:0px auto;background-image: url("assets/img/logo-mediatrac.png");}
        .login-form {margin: 70px auto;width:420px;float:none;margin-bottom: 0px;}
        .form-content {padding: 30px;}
        .home-det > .col-lg-4 {border:1px solid #EEE;margin:20px;}
        .navbar {position: fixed;bottom: 0px;width: 100%;margin-bottom: 0px;}
        .or-encircled {margin:15px auto;width:45px;height: 45px;border: 3px solid #BBBBBB;border-radius: 45px;line-height: 39px;text-align: center;font-weight: bold;color: #BBB;}
    </style>
</head>
<body>  
    <div class="row header">
        <div class="logo"></div>
        <div></div>
    </div>
    <div class="login-form">
        <form class="panel panel-default" action="AccountsController" method="post" onSubmit="return MT.verify(this)">
            <div class="panel-heading"><b>Sign In</b></div>
            <div class="form-content">
                <div class="form-group">
                    <input class="form-control" placeholder="Member ID" name="mem_id" type="text">
                </div>
                <div class="form-group">
                    <input class="form-control" placeholder="Password" name="mem_pass" type="password" />
                </div>
                            
                <input type="submit" class="btn btn-success btn-block" value="Login" />
            </div>
        </form>
    </div>
    <div class="or-encircled">OR</div>
    <div style="width:360px;margin: 0px auto;">
        <button class="btn btn-default btn-block" onclick="">Register</button>
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
                    <li><a href="#">G & M Inc.</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <script>
    	var MT = window.MT || {};
    	
    	MT.verify = function(form){
    		return true;
    	}
    </script>
</body>
</html>
