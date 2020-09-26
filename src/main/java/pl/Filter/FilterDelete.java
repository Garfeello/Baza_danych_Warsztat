package pl.Filter;

import pl.DbUtil.DbUtil;
import pl.MainLog.MainLog;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebFilter(filterName = "FilterDelete", urlPatterns = "/delete")
public class FilterDelete implements Filter {

    private static final String SET = "SET  @num := 0;";
    private static final String UPDATE = "UPDATE workshop2.users SET id = @num := (@num+1);";
    private static final String ALTER = "ALTER TABLE workshop2.users AUTO_INCREMENT =1;";


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try (Connection con = DbUtil.connect()) {
            PreparedStatement statement = con.prepareStatement(SET);
            statement.executeUpdate();
            PreparedStatement statement1 = con.prepareStatement(UPDATE);
            statement1.executeUpdate();
            PreparedStatement statement2 = con.prepareStatement(ALTER);
            statement2.executeUpdate();
        } catch (SQLException e) {
            MainLog.log.error(e.getStackTrace());
        }
        chain.doFilter(req, resp);
    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
