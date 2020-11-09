package Authentication;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import database.DBHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("Inside doPost");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //System.out.println("Email: " + email);
        //System.out.println("password: " + password);

        DBObject object = new BasicDBObject("email",email);
        DBHelper dbHelper = new DBHelper();
        object = dbHelper.fetch("authentication", object);
        String htmlResponse;
        boolean isCorrect = false;
        String destPage = "index.html";
        if(object == null) {
            htmlResponse = buildResponse(false,"incorrect");
        }
        else {

            isCorrect = false;
            try {
                String hashgen = new PasswordUtils().getPasswordHash(password, (String) object.get("salt"));
                isCorrect = hashgen.equals(object.get("hash"));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }
            htmlResponse = buildResponse(isCorrect,(String)object.get("name"));
        }
        if (isCorrect) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("name" , (String)object.get("name"));
            destPage = "dashboard.jsp";
        } else {
        String message = "Invalid email/password";
        request.setAttribute("message", message);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);

        /*PrintWriter writer = response.getWriter();
        response.setContentType("text/HTML");
        writer.println(htmlResponse);*/

    }

    public String buildResponse(boolean passwordValidity,String name) {

        String htmlRespone = "<!DOCTYPE html>";
        htmlRespone+="<html>";
        htmlRespone+="<title>Login Form</title>";
        htmlRespone+="<body style=\"text-align=center\">";

        if(passwordValidity) {
            htmlRespone += "<h1>Welcome " + name + "</h1><br/>";
        }
        else {
            htmlRespone += "<h1>Your Email/Password is incorrect</h1>";
        }

        htmlRespone+="</body>";
        htmlRespone += "</html>";
        return htmlRespone;
    }


//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
