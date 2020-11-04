<%@page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form</title>

</head>
<style>
    table{
        background:#9CFFBD;
    }
</style>

<%
    Date today = new Date();
%>

<body>
<h4> Date: <%= today %> </h4>
<h1 style="text-align :center; font-family:arial black;">Student Details</h1>
<form name="Details" action="output.jsp" method="post">
    <table align="center">
        <tbody>
        <tr>
            <td>Student Name :</td>
            <td><input type="text" name="stuname"></td>
        </tr>
        <tr>
            <td>Contact Number :</td>
            <td><input type="text" name="conno"></td>
        </tr>
        <tr>
            <td>Gender :</td>
            <td><input type="radio" name="g1" value="Male">Male</td></tr>
        <tr><td></td><td><input type="radio" name="g1" value="Female">Female</td></tr>

        <tr>
            <td>Date of birth :</td>
            <td><input type="text" name="dob" value="dd/mm/yy"></td>
        </tr>
        <tr>
            <td> Subject Major :</td>
            <td><input type="checkbox" name="y1" value="Science">Science</td></tr>
        <tr><td></td><td><input type="checkbox" name="y1" value="Math">Mathematics</td></tr>
        <tr><td></td><td><input type="checkbox" name="y1" value="English">Literature</td></tr>
        <tr><td></td><td><input type="checkbox" name="y1" value="Computer">Computer</td></tr>
        <tr>
            <td>University :</td>
            <td><select name="university" multiple>
                <option> Columbia University </option>
                <option> Massachusetts Institute of Technology </option>
                <option> Oxford University </option>
                <option>Harvard University </option>
                <option> Yale University</option>

            </select></td>
        </tr>
        <tr>
            <td> Any questions? </td>
            <td><textarea rows="6" cols="30" name="ques">

                            </textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="reset" value="Clear" id="clear">
                <input type="submit" value="Submit" id="submit"></td>
        </tr>

        </tbody>

    </table>

</form>
</body>
</html>

