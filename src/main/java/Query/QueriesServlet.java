package Query;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoException;
import database.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet("/QueriesServlet")
public class QueriesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String htmlResponse;
        DBObject object = new BasicDBObject("fname",fname).append("lname",lname).append("email",email).append("query",subject);
        DBHelper dbHelper = new DBHelper();
        //System.out.println(object.toString());
        try {
            dbHelper.insert("queries", object);
            htmlResponse = buildResponse(true,"Success");
        } catch (Exception e) {
            htmlResponse = buildResponse(false, "Something Went wrong : " + e.getMessage());
        }

        PrintWriter writer = response.getWriter();
        response.setContentType("text/HTML");
        writer.println(htmlResponse);
    }
    public String buildResponse(boolean isSuccess,String name) {

        String htmlRespone = "<!DOCTYPE html>";
        htmlRespone+="<html>";
        htmlRespone+="<title>Secure Storage - Request submitted</title>";
        htmlRespone+="<head><meta http-equiv=\"refresh\" content=\"5; URL=contact.html\" /></head>";
        htmlRespone+="<body style=\"text-align=center\">";

        if(isSuccess) {
            htmlRespone += "<h1>Your Query has been Registered Successfully </h1><br/>";
        }
        else {
            htmlRespone += "<h1>"+name+"</h1>";
        }

        htmlRespone+="</body>";
        htmlRespone += "</html>";
        return htmlRespone;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
