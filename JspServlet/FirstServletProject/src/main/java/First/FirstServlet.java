package First;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class FirstServlet extends GenericServlet {
   //public class FirstServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
      //protected void doPost(HttpServletRequest request, HttpServletResponse response)
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      pw.println("<html><body>");
      pw.println("<h1>Subhamoy comming...</h1>");

      String nameString = request.getParameter("uname");
      pw.println("Welcome : " + nameString);
      pw.println("</body></html>");
   }
}

