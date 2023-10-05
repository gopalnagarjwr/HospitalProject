package h;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/d")
public class Dp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Dp() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String email=request.getParameter("email");
		        String c=request.getParameter("s");
		        response.setContentType("text/html");
		        
		        
		        try {
		        	String driver="com.mysql.cj.jdbc.Driver";
			    	   String url="jdbc:mysql://localhost:3306/hospital?CharacterEncoding=latin1";
			    	   String user="root";
			    	   String pass="1234";
		        	if(c.equals("staff")) {
			      	   String quary1="SELECT * FROM staff WHERE  Email_id= ? ";
			      	      Class.forName(driver);
			      	      Connection con=DriverManager.getConnection(url,user ,pass);
			      	    PreparedStatement stm=con.prepareStatement(quary1);
				      	   stm.setString(1, email);
				      	 ResultSet rs = stm.executeQuery();
				    	 if(rs.next()) {
				        	 RequestDispatcher rd = request.getRequestDispatcher("Attendence.html");
				        	 rd.forward(request, response);

				        	 }else { 
				        		  response.getWriter().print("<center><div>Wrong email</div></center>");
				        		 RequestDispatcher rd = request.getRequestDispatcher("docter.html");
					        	 rd.include(request, response);
				        	 }
				    	 con.close();
		        	 }else {
		        		 String quary="SELECT * FROM patient WHERE  Email= ? ";
			      	      Class.forName(driver);
			      	      Connection con=DriverManager.getConnection(url,user ,pass);
			      	    PreparedStatement stm=con.prepareStatement(quary);
				      	   stm.setString(1, email);
				      	 ResultSet rs = stm.executeQuery();
				    	 if(rs.next()) {
				        	 RequestDispatcher rd = request.getRequestDispatcher("Attendence.html");
				        	 rd.forward(request, response);

				        	 }else { 
				        		  response.getWriter().print("<center><div>Wrong email</div></center>");
				        		 RequestDispatcher rd = request.getRequestDispatcher("docter.html");
					        	 rd.include(request, response);
				        	 }
				    	 con.close();
		        	 }
				      	      
		        }catch( Exception e) {
		        	System.out.print(e);
		        }
		       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
