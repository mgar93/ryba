package ryba;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PatientManager pm = new PatientManager();
		Patient patient = new Patient();
		
		patient.setAddress(request.getParameter("address"));
		patient.setDate(request.getParameter("date"));
		patient.setLastname(request.getParameter("lastname"));
		patient.setMass(Long.parseLong(request.getParameter("mass")));
		patient.setPesel(Long.parseLong(request.getParameter("pesel")));
		patient.setName(request.getParameter("name"));
		patient.setSize(Long.parseLong(request.getParameter("size")));
		patient.setTelephone(Long.parseLong(request.getParameter("tel")));
		
		pm.addPatient(patient);
		
		response.sendRedirect("index.jsp");
	}

}