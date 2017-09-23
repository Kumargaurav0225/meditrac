<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
  <head lang="en">
    <title>Patient Registration</title>
    <link rel="stylesheet" href="/MediTrac/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/MediTrac/assets/css/bootstrap-paper.min.css"/>
    <link rel="stylesheet" href="/MediTrac/assets/css/style.css"/>
    <script src="/MediTrac/assets/js/jquery-2.1.3.min.js"></script>
    <script src="/MediTrac/assets/js/bootstrap.min.js"></script>
  </head>
  <body>
    <nav class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header"><img src="/MediTrac/assets/img/logo-meditrac.png" class="navbar-brand"/></div>
        <div id="bs-example-navbar-collapse-1" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="#">Home</a></li>
            <li><a href="#">Appointments</a></li>
            <li><a href="#">Reports</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href=""><span class="glyphicon glyphicon-plus-sign nav-icon"></span></a></li>
            <li><a data-toggle="dropdown" href="#" class="dropdown-toggle"><span class="glyphicon glyphicon-user nav-icon"></span></a>
              <ul class="dropdown-menu">
                <li><a href="#">Profile</a></li>
                <li><a href="#">Account Settings</a></li>
                <li class="divider"></li>
                <li><a href="/MediTrac/dashboard?action=logout">Logout</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="container-fluid hero">
      <div class="container">
        <div class="row">
          <div class="col-lg-3 user-dp"><img src="/MediTrac/assets/img/a.png" width="160px" height="160px"/></div>
          <div class="col-lg-6 user-details">
            <h3>Suman Kumar Das</h3>
            <h6>Age: 21</h6>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
          <form action="" method="post" class="form-group">
            <input type="text" name="q" placeholder="Search Hospital" class="form-control"/>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
