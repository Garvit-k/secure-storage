
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Information Received</title>
</head>

<style>
    table{
        background:#9CFFBD;
    }
</style>

<%

    String studentName = request.getParameter("stuname");
    String contactNo = request.getParameter("conno");
    String gender = request.getParameter("g1");
    String date = request.getParameter("dob");
    String year = request.getParameter("y1");
    String uni = request.getParameter("university");
    String ques = request.getParameter("ques");


%>

<body>
<h1 style="text-align :center; font-family: arial black;">Output</h1>
<table border="1" align="center">
    <tbody>
    <tr>
        <td>Student name :</td>
        <td><%= studentName %></td>
    </tr>
    <tr>
        <td>Contact Number :</td>
        <td><%= contactNo %></td>
    </tr>
    <tr>
        <td>Gender :</td>
        <td><%= gender %></td>
    </tr>
    <tr>
        <td>Date of birth :</td>
        <td><%= date %></td>
    </tr>
    <tr>
        <td>Subject Major:</td>
        <td><%= year %></td>
    </tr>
    <tr>
        <td>University :</td>
        <td><%= uni %></td>
    </tr>
    <tr>
        <td>Questions :</td>
        <td><%= ques %></td>
    </tr>



    </tbody>
</table>

</body>
</html>
