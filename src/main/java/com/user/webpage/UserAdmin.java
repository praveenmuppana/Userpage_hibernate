package com.user.webpage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


/**
 * Servlet implementation class UserAdmin
 */
@WebServlet("/UserAdmin")
public class UserAdmin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        try {
            List<User> allUsers = session.createQuery("From User", User.class).list();
            request.setAttribute("allUsers", allUsers);
            request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String admin_name = request.getParameter("admin_name");
        String aPassword = request.getParameter("aPassword");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try {
            String hql = "FROM AdminUser WHERE adminName=:name AND adminPassword=:pass";
            Query<AdminUser> query = session.createQuery(hql, AdminUser.class);
            query.setParameter("name", admin_name);
            query.setParameter("pass", aPassword);

            AdminUser admin = query.uniqueResult();
            if (admin != null) {
                List<User> allUsers = session.createQuery("From User", User.class).list();
                request.setAttribute("allUsers", allUsers);
                request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
            } else {
                request.setAttribute("status", "invalid");
                request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("status", "error");
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        } finally {
            session.close();
            factory.close();
        }
    }

}
