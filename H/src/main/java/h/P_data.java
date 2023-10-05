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

@WebServlet("/p")
public class P_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public P_data() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
	      long password=Integer.parseInt(request.getParameter("pass"));
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		int age=Integer.parseInt(request.getParameter("age"));
		String contect=request.getParameter("contect");
		String gendar=request.getParameter("gendar");
		String Tl=request.getParameter("tl");
		
		try {
			String driver="com.mysql.cj.jdbc.Driver";
	    	   String url="jdbc:mysql://localhost:3306/hospital?CharacterEncoding=latin1";
	    	   String user="root";
	    	   String pass="1234";
	    	   String quary="INSERT INTO Patient (Name,Email ,Password ,Fathers_Name ,Mothers_Name , Age ,Contect , Gender ,Test_List ) VALUES (? , ? , ? ,? ,? ,? ,? ,? ,?) ";
	    	     
	    	  Class.forName(driver);
	    	   
	    	   Connection con=DriverManager.getConnection(url,user,pass);
	    	   PreparedStatement stm=con.prepareStatement(quary);
	    	   stm.setString(1,name);
	    	   stm.setString(2, email);
	    	   stm.setLong(3, password);
	    	   stm.setString(4,fname);
	    	   stm.setString(5,mname);
	    	   stm.setInt(6, age);
	    	   stm.setString(7, contect);
	    	   stm.setString(8, gendar);
	    	   stm.setString(9, Tl);
	    	   stm.executeUpdate();
	    	   
	    	      RequestDispatcher rd=request.getRequestDispatcher("docter.html");
	    	      rd.forward(request, response);
	    	      
	    	     }catch(Exception ex) {
	    	    	 System.out.print(ex);
	    	     }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
