package people.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import people.dao.PeopleDao;
import people.domain.People;
import people.service.PeopleException;
import people.service.PeopleService;

/**
 * Servlet implementation class UserServlet
 */

public class PeopleServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeopleServletUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Map<String, String> form = new HashMap<String,String>();
		PeopleService peopleservice = new PeopleService();
		Map<String,String[]> paramMap = request.getParameterMap();
		People form = new People();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		//form.setNumber(Integer.parseInt(info.get(1)));
		form.setID(Integer.parseInt(info.get(1)));
		form.setName(info.get(2));
		form.setAge(Integer.parseInt(info.get(3)));
		form.setDateOfBirth(info.get(4));
		
		
		try {
			peopleservice.update(form);
			
			response.sendRedirect( request.getContextPath() + "/jsps/people/people.jsp");
		} catch (ClassNotFoundException | PeopleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
