import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class provaCookie extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
		String cookieName= request.getParameter("cookiename");
		String cookieValue= request.getParameter("cookievalue");
		Cookie aCookie= null;
		if(cookieName!=null && cookieValue != null){
			aCookie= new Cookie(cookieName, cookieValue);
			response.addCookie(aCookie);
		}
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<html>");
        out.println("<head>");
		 out.println("<title>" + "Esempio Cookie" + "</title>");
        out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		
		//print out cookie
		Cookie[] cookies= request.getCookies();
		if((cookies!=null) && (cookies.length>0))
		for (int i=0; i<cookies.length;i++){
			Cookie c= cookies[i];
			String name= c.getName();
			out.print("Cookie Name: "+name+"<br>");
			String value= c.getValue();
			out.println("Cookie Value: "+value+"<br><br>");
		}
		else
			out.println("<h4 style='color: red'> Non cookie found</h4>");
		//set a cookie
		String name= request.getParameter("cookiename");
		if(name != null && name.length()>0){
			String value= request.getParameter("cookievalue");
			Cookie c= new Cookie(name, value);
			response.addCookie(c);
		}
		
		out.println("<form action=provaCookie method=POST>");
		out.println("Name: <input type=text length=20 name=cookiename><br>");
		out.println("Value: <input type=text length=20 name=cookievalue><br>");
		out.println("<input type=submit><form>");
		out.println("</form>");
		out.println("</body>");
        out.println("</html>");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		doGet(request, response);
	}
}