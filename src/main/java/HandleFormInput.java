

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HandleFormInput
 * 
 * This class handles validating the form input and displaying an error screen if necessary
 */
@WebServlet("/HandleFormInput")
public class HandleFormInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HandleFormInput() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Get params
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		
		//Validate params and set error message if appropriate
		if (firstname == null || firstname.isEmpty()) {
			request.setAttribute("message", "the firstname was empty");
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		} else if (lastname == null || lastname.isEmpty()) {
			request.setAttribute("message", "the lastname was empty");
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		} else {
			request.setAttribute("firstname", firstname);
			request.setAttribute("lastname", lastname);
			request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
