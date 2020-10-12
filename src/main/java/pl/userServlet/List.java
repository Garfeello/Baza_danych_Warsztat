package pl.userServlet;

import pl.userDao.User;
import pl.userDao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UserList", urlPatterns = "/list")
public class List extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        java.util.List<User> users = UserDAO.findAll();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
    }
}
