package com.user.webpage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
				
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
				
		try {
			String hq="FROM User WHERE user_name=:name AND password=:pass";
			Query<User> query=session.createQuery(hq,User.class);
			query.setParameter("name", user_name);
			query.setParameter("pass", password);
			
			User user=(User)query.uniqueResult();
			if(user.getName()==null||user.getName().isEmpty()||
					user.getPassword()==null||user.getPassword().isEmpty()) {
				request.setAttribute("status", "invalid");
				request.getRequestDispatcher("userLogin.jsp").forward(request, response);
			}else {
				response.sendRedirect("UserDashboard.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("status", "error");
			request.getRequestDispatcher("userLogin.jsp").forward(request, response);
		}finally {
			session.close();
			factory.close();
		}
	}

}
