<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
 <link href="http://localhost:8080/spring/resources/css/bootstrap-3.1.1-dist/css/bootstrap.css" rel="stylesheet" type="text/css">
 <script src="http://localhost:8080/spring/resources/js/jquery-1.11.1.min.js"></script>
 <script src="http://localhost:8080/spring/resources/css/bootstrap-3.1.1-dist/js/bootstrap.js"></script>
 </head>
 
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Grupy<b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="/spring/group/add">Stwórz grupę</a></li>
            <li><a href="/spring/group/mylist">Moje grupy</a></li>
            
            
          </ul>
        </li>
      </ul>
      <a href="/spring/logout">WYLOGUJ</a>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
   
</nav>