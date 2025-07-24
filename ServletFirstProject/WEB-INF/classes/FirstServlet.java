import jakarta.servlet.*;
import java.io.*;

public class FirstServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();  
        pw.println("Hello Subhamoy");
        pw.close();
    }

    @Override
    public void init() throws ServletException {
        // Initialization code (if needed)
    }

    @Override
    public void destroy() {
        // Cleanup code (if needed)
    }
}


//jar cvf first.war .