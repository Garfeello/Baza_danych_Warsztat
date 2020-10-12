package pl.userDao;


import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pl.DbUtil.DbUtil;
import pl.mainLog.MainLog;

public class UserDAO {

    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String PRINT_DATA_QUERY =
            "SELECT * FROM users;";
    private static final String READ_QUERY_WHERE_ID =
            "SELECT * FROM users WHERE id = ?;";
    private static final String READ_QUERY_WHERE_EMAIL =
            "SELECT * FROM users WHERE email = ?;";
    private static final String DELETE_QUERRY =
            "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_QUERRY =
            "UPDATE users SET email = ?, username = ?, password = ? where id = ? ;";

    public static void createUser(User user) {
        try (Connection con = DbUtil.connect()) {
            PreparedStatement st = con.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, user.getUsername());
            st.setString(2, user.getEmail());
            st.setString(3, hashPassword(user.getPassword()));
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            while (rs.next()) {
                int id = rs.getInt(1);
                MainLog.log.info("created new ID = " + id);
            }
        } catch (SQLException e) {
            MainLog.log.error(e.getStackTrace());
        }
    }

    public static User read(int userId) {
        User user = null;
        try (Connection con = DbUtil.connect()) {
            PreparedStatement st = con.prepareStatement(READ_QUERY_WHERE_ID);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user = getUserObject(rs);
            }
        } catch (SQLException e) {
            MainLog.log.error(e.getStackTrace());
        }
        return user;
    }

    public static User read(String email) {
        User user = null;
        try (Connection con = DbUtil.connect()) {
            PreparedStatement st = con.prepareStatement(READ_QUERY_WHERE_EMAIL);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user = getUserObject(rs);
            }
        } catch (SQLException e) {
            MainLog.log.error(e.getStackTrace());
        }
        return user;
    }

    public static void update(User user) {
        try (Connection con = DbUtil.connect()) {
            PreparedStatement st = con.prepareStatement(PRINT_DATA_QUERY);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                if (user.getId() == id || user.getEmail().equals(email)) {
                    System.out.println("Update użytkownika = .[" + read(user.getEmail()) + " ]");
                    PreparedStatement st2 = con.prepareStatement(UPDATE_QUERRY);
                    st2.setString(1, user.getEmail());
                    st2.setString(2, user.getUsername());
                    st2.setString(3, hashPassword(user.getPassword()));
                    st2.setInt(4, id);
                    st2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            MainLog.log.error(e.getStackTrace());
        }
    }

    public static void delete(int userId) {
        try (Connection con = DbUtil.connect()) {
            PreparedStatement st = con.prepareStatement(DELETE_QUERRY);
            st.setInt(1, userId);
            MainLog.log.info("DELETED: user{ " + read(userId) + " }");
            st.executeUpdate();
        } catch (SQLException e) {
            MainLog.log.error(e.getStackTrace());
        }
    }

    public static List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection con = DbUtil.connect()) {
            PreparedStatement st = con.prepareStatement(PRINT_DATA_QUERY);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                users.add(getUserObject(rs));
            }
        } catch (SQLException e) {
            MainLog.log.error(e.getStackTrace());
        }
        return users;
    }

    public static Boolean checkPassword(String password, String email) {
        boolean result = false;
        try (Connection con = DbUtil.connect()) {
            PreparedStatement statement = con.prepareStatement(PRINT_DATA_QUERY);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (email.equals(rs.getString("email")) && BCrypt.checkpw(password, rs.getString("password"))) {
                    result = true;
                    break;
                }
            }
        } catch (SQLException e) {
            MainLog.log.error(e.getStackTrace());
        }
        return result;
    }

    private static User getUserObject(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("email"),
                rs.getString("username"),
                rs.getString("password")
        );
    }

    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
