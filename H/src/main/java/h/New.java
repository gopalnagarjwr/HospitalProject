package h;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/n")
public class New extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public New() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter p=response.getWriter();
		p.print("<div style='background:  url(https://dataman.in/wp-content/uploads/2020/05/Hospital-Management-System-1024x576.jpg) center;\r\n"
				+ "   text-align: right;\r\n"
				+ "   height: 97.5vh;'><form action='n' method='post' style='padding: 50px;'>");
		p.print("<select  required name=\"s\" style=' background-color: transparent;\r\n"
				+ "			      border-radius: 12px;\r\n"
				+ "				  margin-right:10px;\r\n"
				+ "				  font-size: 16px;\r\n"
				+ "			      color: white;\r\n"
				+ "			   	  padding: 12px;\r\n\"'>\r\n"
				+ "					       <option>Choose Option</option >                 \r\n"
				+ "                          <option value=\"patient\">patient</option>\r\n"
				+ "                          <option value=\"staff\">Staff</option>\r\n"
				+ "                                               </select>");
		p.print("<button type=\"submit\" style=' position: relative;\r\n"
				+ "  background-color: #4CAF50;\r\n"
				+ "  border-radius: 12px;\r\n"
				+ "  border :none;\r\n"
				+ "  font-size: 16px;\r\n"
				+ "  color: white;\r\n"
				+ "  padding: 15px;\r\n"
				+ "  width: 100px;\r\n"
				+ "  text-align: center;\r\n"
				+ "  transition-duration: 1.5s;\r\n"
				+ "  text-decoration: none;\r\n"
				+ "  overflow: hidden;\r\n"
				+ "  cursor: pointer;'> Submit</button><br>");
		p.print("</form></div>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String d=request.getParameter("s");
		if(d.equals("patient")) {
			RequestDispatcher rd=request.getRequestDispatcher("Patient.html");
			rd.forward(request, response);
			
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("Staff.html");
			rd.forward(request, response);
		}
	
	}

}













