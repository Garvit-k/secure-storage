package Authentication;

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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String salt = new PasswordUtils().createCryptoRandomString();
        String hash = null;
        try {
            hash = new PasswordUtils().getPasswordHash(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        String htmlResponse;
        DBObject object = new BasicDBObject("email",email).append("hash",hash).append("salt",salt).append("name", name);
        DBHelper dbHelper = new DBHelper();
        //System.out.println(object.toString());
        try {
            dbHelper.insert("authentication", object);
            htmlResponse = buildResponse(true,"Success");
        } catch (DuplicateKeyException exception) {
            htmlResponse = buildResponse(false,"Email already exists");
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
        htmlRespone+="<title>Secure Storage - Registered</title>";
        htmlRespone+="<head><meta http-equiv=\"refresh\" content=\"3; URL=index.html\" /></head>";
        htmlRespone+="<body style=\"text-align=center\">";

        if(isSuccess) {
            htmlRespone += "<h1>Your ID has been Registered Successfully</h1><br/>";
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
