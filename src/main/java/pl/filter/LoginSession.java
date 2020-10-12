package pl.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginSession", urlPatterns = {"/list", "/add", "/delete", "/edit", "/show"})
public class LoginSession implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        if (session != null) {
            try {
                boolean authorization = (boolean) session.getAttribute("loggedUser");
                if (authorization) {
                    chain.doFilter(req, resp);
                }
            } catch (NullPointerException ex) {
                response.sendRedirect("/sign");
            }
        } else {
            response.sendRedirect("/sign");
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
