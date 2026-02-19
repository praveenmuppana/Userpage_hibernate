package com.user.webpage;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String city = request.getParameter("city");
		if (user_name == null || user_name.isEmpty() || password == null || password.isEmpty() || name == null
				|| name.isEmpty() || mail == null || mail.isEmpty() || city == null || city.isEmpty()) {
			request.setAttribute("status", "invalid");
			request.getRequestDispatcher("userRegistration.jsp").forward(request, response);
			return;
		}
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tranx = null;

		try {
		    String hql = "FROM User WHERE user_name = :uname";
		    Query<User> query = session.createQuery(hql,User.class);
		    query.setParameter("uname", user_name);
		    
		    List<User> results = query.list();

		    if (!results.isEmpty()) {
		        request.setAttribute("status", "exists");
		        request.getRequestDispatcher("userRegistration.jsp").forward(request, response);
		    } else {
		        tranx = session.beginTransaction();
		        User u1 = new User();
		        u1.setUser_name(user_name);
		        u1.setPassword(password);
		        u1.setName(name);
		        u1.setMail(mail);
		        u1.setCity(city);
		        
		        session.save(u1);
		        tranx.commit();
		        request.setAttribute("status", "success");
		        request.getRequestDispatcher("userRegistration.jsp").forward(request, response);
		    }
		} catch (Exception e) {
				if (tranx != null)
				tranx.rollback();
			e.printStackTrace();
			request.setAttribute("status", "error");
			request.getRequestDispatcher("userRegistration.jsp").forward(request, response);
		} finally {
			session.close();
			factory.close();
		}

	}

}
