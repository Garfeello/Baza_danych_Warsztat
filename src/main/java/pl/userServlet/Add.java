package pl.userServlet;

import pl.userDao.User;
import pl.userDao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Add", urlPatterns = "/add")
public class Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                request.getParameter("email"),
                request.getParameter("user"),
                request.getParameter("password")
        );
        UserDAO.createUser(user);
        response.sendRedirect("/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/addForm.jsp").forward(request, response);
    }
}
