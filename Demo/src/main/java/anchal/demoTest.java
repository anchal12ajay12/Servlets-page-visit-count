package anchal;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class demoTest  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private int count; 

   public void init() { 
	   count = 0;
   } 

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      response.setContentType("text/html");

      count++; 
      PrintWriter out = response.getWriter();
      String title = "Count: ";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body>\n" +
               "<h1>" + title + "</h1>\n" +
               "<h2>" + count + "</h2>\n" +
            "</body>" +
         "</html>"
      );
   }
   
   public void destroy() { 
     
   } 
} 
