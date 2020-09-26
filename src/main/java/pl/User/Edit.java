package pl.User;

import pl.DbUtil.DbUtil;
import pl.UserDao.User;
import pl.UserDao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Edit", urlPatterns = "/edit")
public class Edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("email"),
                request.getParameter("user"),
                request.getParameter("password")
        );
        UserDAO.update(user);
        response.sendRedirect("/list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", UserDAO.read(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("/users/editForm.jsp").forward(request, response);
    }
}
