package pl.User;

import pl.UserDao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SignIn", urlPatterns = "/sign")
public class SignIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if (UserDAO.checkPassword(password, email)){
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", email);
            response.sendRedirect("/list");
        } else {
            request.setAttribute("errorLogin", "Błędny email lub haslo !!");
            request.getRequestDispatcher("/users/loginForm.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/users/loginForm.jsp").forward(request, response);
    }
}
