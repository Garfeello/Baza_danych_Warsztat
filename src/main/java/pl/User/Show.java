package pl.User;

import pl.UserDao.User;
import pl.UserDao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Show", urlPatterns = "/show")
public class Show extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", UserDAO.read(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("/users/showPage.jsp").forward(request, response);
    }
}
