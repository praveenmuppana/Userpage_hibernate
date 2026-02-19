package com.user.webpage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class UpdateDeleteUser
 */
@WebServlet("/UpdateDelete")
public class UpdateDeleteUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        String ids = request.getParameter("id");
        String columnName = request.getParameter("columnName");
        String newData = request.getParameter("newData");
        
        if(ids!=null) {
        	int id=Integer.parseInt(ids);
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tranx = null;

        try {
            tranx = session.beginTransaction();
            
                User user = session.get(User.class, id);
                if ("update".equalsIgnoreCase(action)) {
                    if ("name".equals(columnName)) user.setName(newData);
                    else if ("mail".equals(columnName)) user.setMail(newData);
                    else if ("city".equals(columnName)) user.setCity(newData);
                    
                    session.update(user);
            } else if ("delete".equalsIgnoreCase(action)) {
                    session.delete(user);
            }

            tranx.commit();            
            response.sendRedirect("UserAdmin");

        } catch (Exception e) {
            if (tranx != null&& tranx.isActive()) tranx.rollback();
            e.printStackTrace();
            response.sendRedirect("UserAdmin?status=error");
        } finally {
        	if(session!=null)
            session.close();
            factory.close();
        }
        }
		
	}

}
