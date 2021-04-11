package anchal;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.*;
import javax.servlet.http.*;



class Counter{

    private static  Counter single_instance = null;
    private AtomicInteger count;

    private Counter(){
    	count = new AtomicInteger(0);
    }
  
    public synchronized static  Counter getInstance(){
        if (single_instance == null)
            single_instance = new Counter();
  
        return single_instance;
    }
    
    public int incrementCounter() {
       return count.incrementAndGet();
    }

}

public class DemoTest  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		out.write("<html><body><h1>Counter: "+ Counter.getInstance().incrementCounter()+ "\n</h1></body></html>");

	}

}
