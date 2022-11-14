package org.profile;

import com.google.gson.Gson;
import org.profile.model.CustomObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("My Custom servlet's doGet() method invoked");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<p>Hello World!</p>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("My Custom Servlet's doPost() method invoked");
//        super.doPost(request, response);
        BufferedReader reader = request.getReader();
        String line = null;
        StringBuffer jsonString = new StringBuffer();
        while((line = reader.readLine()) != null) {
            jsonString.append(line);
        }
        CustomObject customObject = new Gson().fromJson(String.valueOf(jsonString), CustomObject.class);
        System.out.println(customObject);
    }
}
