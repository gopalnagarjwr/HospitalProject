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

@WebServlet("/At")
public class Attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Attendance() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String At=request.getParameter("at");
		String date=request.getParameter("date");
		String Ltime=request.getParameter("ltime");
		String Etime=request.getParameter("etime");
		String check=request.getParameter("Choose");
		response.setContentType("text/html");
		if(check.equals("staff")){
		  try {
			  String driver="com.mysql.cj.jdbc.Driver";
	    	   String url="jdbc:mysql://localhost:3306/hospital?CharacterEncoding=latin1";
	    	   String user="root";
	    	   String pass="1234";
	      	   String quary="INSERT INTO staff_attendence (Name,attendence,Date,Login_Time, Exit_Time) VALUES( ? , ? , ? , ? , ?)";
	      	 
	      	  Class.forName(driver);
	      	   
	      	   Connection con=DriverManager.getConnection(url,user,pass);
	      	   PreparedStatement stm=con.prepareStatement(quary);
	               stm.setString(1, name);
	               stm.setString(2, At);
	               stm.setString(3,date);
	               stm.setString(4, Ltime);
	               stm.setString(5, Etime);
	               stm.execute();
	               RequestDispatcher rd=request.getRequestDispatcher("home.html");
	               rd.forward(request, response);
	         }
	         catch(Exception e) {
	      	   System.out.println(e);
	         }
		}else {
		  try {
			  String driver="com.mysql.cj.jdbc.Driver";
	    	   String url="jdbc:mysql://localhost:3306/hospital?CharacterEncoding=latin1";
	    	   String user="root";
	    	   String pass="1234";
	      	   String quary="INSERT INTO Doctor_attendence (Name,attendence,Date,Login_Time, Exit_Time) VALUES( ? , ? , ? , ? , ?)";
	     
	      	  Class.forName(driver);
	      	   
	      	   Connection con=DriverManager.getConnection(url,user,pass);
	      	   PreparedStatement stm=con.prepareStatement(quary);
	               stm.setString(1, name);
	               stm.setString(2, At);
	               stm.setString(3,date);
	               stm.setString(4, Ltime);
	               stm.setString(5, Etime);
	               stm.execute();
	              
	               RequestDispatcher rd=request.getRequestDispatcher("home.html");
	               rd.forward(request, response);
	         }
	         catch(Exception e) {
	      	   System.out.println(e);
	         }
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
