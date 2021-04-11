package anchal;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


class Counter{

    private static  Counter single_instance = null;
    private int count;

    private Counter(){
    	count = 0;
    }
  
    public static  Counter getInstance(){
        if (single_instance == null)
            single_instance = new Counter();
  
        return single_instance;
    }
    
    public synchronized void incrementCounter() {
    	count++;
    }
    
    public int getCount() {
    	return count;
    }
}

public class DemoTest  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Counter pageHit;
	
	public void init(ServletConfig config) throws ServletException {
		pageHit = Counter.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
			out.write("<html><body><h1>Counter: "+ pageHit.getCount()+ "\n</h1></body></html>");
			
		

	}
	
	public void destroy() {
		
	}

}
