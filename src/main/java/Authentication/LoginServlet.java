package Authentication;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import database.DBHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside doPost");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Email: " + email);
        System.out.println("password: " + password);

        DBObject object = new BasicDBObject("email",email);
        DBHelper dbHelper = new DBHelper();
        object = dbHelper.fetch("authentication", object);
        String htmlResponse;
        if(object == null) {
            htmlResponse = buildResponse(false,"incorrect");
        }
        else {

            //System.out.println(object.toString());

            boolean isCorrect = false;
            try {
                String hashgen = new PasswordUtils().getPasswordHash(password, (String) object.get("salt"));
                isCorrect = hashgen.equals(object.get("hash"));
//                System.out.println("hashgen : " + hashgen);
//                System.out.println("database : " + object.get("hash"));
//                System.out.println("db salt " + object.get("salt"));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }
            htmlResponse = buildResponse(isCorrect,(String)object.get("name"));
        }

        PrintWriter writer = response.getWriter();
        response.setContentType("text/HTML");
        response.addCookie(setCookie((String) object.get("name")));
        Cookie cookies[] = request.getCookies();
        for (Cookie c: cookies) {
            System.out.println("Cookie Value "+c.getValue());
        }
        writer.println(htmlResponse);

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

    Cookie setCookie(String name) {
        Cookie cookie = null;
        try {
            cookie = new Cookie("name", URLEncoder.encode( name, "UTF-8" ));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Cookie "+ cookie.toString());
        System.out.println("Cookie "+cookie.getName());
        cookie.setMaxAge(60);
        return cookie;
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
