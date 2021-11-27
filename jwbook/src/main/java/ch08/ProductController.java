package ch08;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/pcontrol")
public class ProductController extends HttpServlet {
	ProductService service;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
    	service = new ProductService();
    }
    
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	String view = "";
    	
    	if(request.getParameter("action") == null) {
    		getServletContext().getRequestDispatcher("/pcontrol?action=list").forward(request, response);
    	} else {
    		switch (action) {
			case "list": view = list(request, response); break;
			case "info": view = info(request, response); break;
			}
    		getServletContext().getRequestDispatcher("/ch08/"+view).forward(request, response);
    	}
    }

	private String info(ServletRequest request, ServletResponse response) {
		request.setAttribute("p", service.find(request.getParameter("id")));
		return "productInfo.jsp";
	}

	private String list(ServletRequest request, ServletResponse response) {
		request.setAttribute("products", service.findAll());
		return "productList.jsp";
	}

}
