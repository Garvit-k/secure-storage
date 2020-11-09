<%--
  Created by IntelliJ IDEA.
  User: garvit
  Date: 08-11-2020
  Time: 05:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Secure Storage</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body class="back">
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#defaultNavbar1"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
            <a href="index.html"><img src="assets/lock.svg" width="50" height="50" alt="Logo"></a></div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="defaultNavbar1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index.html">Home<span class="sr-only">(current)</span></a></li>
                <li><button class="open-button" onclick=""><a href="about.html">About<span class="sr-only">(current)</span></a></button></li>
                <li><button class="open-button" onclick=""><a href="contact.html">Contact Us<span class="sr-only">(current)</span></a></button></li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Features<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">File Encryption</a></li>
                        <li><a href="#">Zero-Access Encryption Policy</a></li>
                        <li><a href="#">Password Hashing & Salting</a></li>
                        <li><a href="#">Something</a></li>
                        <li><a href="#">Something</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<h1 class="welcomename name">Welcome ${name} </h1>
<table width="100%" border="1" cellspacing="10" cellpadding="15">
  <tbody>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </tbody>
</table>


</body>
</html>
