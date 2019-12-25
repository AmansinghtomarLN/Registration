package registration.aman.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registration.aman.bean.RegistrationBean;
import registration.aman.model.RegistrationModel;
import registration.aman.util.ServletUtility;

public class RegistrationCtl extends HttpServlet {

	
	public boolean validate(HttpServletRequest request){
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = 	request.getParameter("email");
		String number = request.getParameter("mobile");
		String password = request.getParameter("pass");
		String repass = request.getParameter("re_pass");
	
		return true;
	}
	
	public RegistrationBean populateBean (HttpServletRequest request){
		RegistrationBean bean = new RegistrationBean();
		bean.setFirstName(request.getParameter("fname"));
		bean.setLastName(request.getParameter("lname"));
		bean.setNumber(request.getParameter("number"));
		bean.setEmail(request.getParameter("email"));
		bean.setPassword(request.getParameter("pass"));
		
		return bean;
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("DoGet is running");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("DoPost method is running");
		ServletOutputStream out = response.getOutputStream();
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = 	request.getParameter("email");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		String repass = 	request.getParameter("re_pass");
	//checkbox	
		RegistrationModel rm  = new RegistrationModel();
		if(validate(request)){
			String ops = request.getParameter("signup");

			if("Register".equalsIgnoreCase(ops)){
				RegistrationBean bean = populateBean(request);
				try {
					rm.add(bean);
					System.out.println("Registation done");
					ServletUtility.redirect("jsp/welcome.jsp", request, response);
				} catch (Exception e) {
					out.println("Registration is not done... Their is an error !!! </b>");
					e.printStackTrace();
				}
			}
			
		}
	
		
	
	}

}
