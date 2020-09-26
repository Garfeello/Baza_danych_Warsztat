package pl.Filter;

import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@WebFilter(filterName = "LoginSession", urlPatterns = "/*" )
public class LoginSession implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//
//        if (!request.getSession().isNew() && request.getSession().getAttribute("loggedUser") != null) {
//            chain.doFilter(req, resp);
//        }
    }


    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
