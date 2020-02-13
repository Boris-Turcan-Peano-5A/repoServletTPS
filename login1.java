import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class login1 extends HttpServlet{
  private static final String PAGE_TOP = ""
    + "<html>"
    + "<head>"
    + "<title>Servlet conferma accesso</title>"
    + "</head>"
    + "<body>"
    + "<h1>Parametri inseriti per accedere all'area riservata </h1>"
   ;
   private static final String PAGE_BOTTOM = ""
    + "</body>"
    + "</html>"
  ;
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    String prm1=request.getParameter("prm1");
    String titolo=request.getParameter("titolo");
    String login=request.getParameter("login");
    String pwd=request.getParameter("pwd");
    //prepara il Writer
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    //genera HTML
    out.println(PAGE_TOP);
    out.println("<h2>Pagina: "+prm1+"</h2>");
    out.println("<h3>Titolo: "+titolo+"</h3>");
    out.println("<h4>Login: "+login+"</h3>");
    out.println("<h4>Password: "+pwd+"</h4>");
    out.println(PAGE_BOTTOM);
    out.close();
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    this.doGet(request, response);
  }
  public String getServletInfo(){
    return "Login Servlet";
  }
}
