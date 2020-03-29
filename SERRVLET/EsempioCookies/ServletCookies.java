/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hudoj
 */
@WebServlet(urlPatterns = {"/ServletCookies"})
public class ServletCookies extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //creo una cookie
        int i=0;
        String name = request.getParameter("cookiename");
        Cookie c=null;
        if (name != null && name.length() > 0) {
            String value = request.getParameter("cookievalue");
            c = new Cookie(name, value);
            response.addCookie(c);
        }
        else{
            return;
        }
        Cookie[] cookies = request.getCookies();
        Cookie[] cookiesall= new Cookie[cookies.length+1];
        for(i=0; i<cookies.length;i++){
            cookiesall[i]=cookies[i];
        }
        cookiesall[cookies.length]= c;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCookies</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>ESEMPIO COOKIES<br><p>I <span style=\"color: red;\">\"cookies\" </span>sono file di testo in cui sono scritte informazioni riguardo il sito visitato ed il computer usato per navigare.</p></p><br>");
            if(name!=null)
            if (cookiesall.length > 0) {
                for (Cookie cookie : cookiesall) {
                    //c.setMaxAge(0);
                    //response.addCookie(c);
                    String namecookie = cookie.getName();
                    String value = cookie.getValue();
                    out.println("<br>Nome cookie: "+namecookie + " <br> Valore: " + value);
                }
            }
            out.println("<br><br><form action=\"ServletCookies\" method=\"POST\">");
            out.println("Name:  <input type=\"text\" name=\"cookiename\"><br>");
            out.println("Value:  <input type=\"text\" name=\"cookievalue\"><br>");
            out.println("<input type=\"submit\"><br></form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
