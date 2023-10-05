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

@WebServlet("/Dd")
public class D_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public D_data() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int password=Integer.parseInt(request.getParameter("pass"));
		String fname=request.getParameter("fname");
		String add=request.getParameter("add");
		String degree=request.getParameter("degree");
		int pass_out=Integer.parseInt(request.getParameter("pass_out"));
		String Criminal_r=request.getParameter("c_r");
		
		try {
		 String driver="com.mysql.cj.jdbc.Driver";
    	   String url="jdbc:mysql://localhost:3306/hospital?CharacterEncoding=latin1";
    	   String user="root";
    	   String pass="1234";
    	   String quary="INSERT INTO staff (Email_id,Password,Name, Fathers_Name,Address,Degree,Adhar_Number,Criminal_recourd,Pass_out_year)VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? );";
    	     
    	  Class.forName(driver);
    	   
    	   Connection con=DriverManager.getConnection(url,user,pass);
    	   PreparedStatement stm=con.prepareStatement(quary);
    	   stm.setString(1, email);
    	   stm.setInt(2, password);
    	   stm.setString(3,name);
    	   stm.setString(4,fname);
    	   stm.setString(5, add);
    	   stm.setString(6, degree);
    	   stm.setInt(7, Integer.parseInt(request.getParameter("adhar")));
    	   stm.setString(8, Criminal_r);
    	   stm.setInt(9, pass_out);
    	   stm.executeUpdate();
    	   
    	      RequestDispatcher rd=request.getRequestDispatcher("doctor.html");
    	      rd.forward(request, response);
    	      
    	     }catch(Exception ex) {
    	    	 System.out.print(ex);
    	     }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
