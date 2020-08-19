package Main.User;

import Main.DbUtil.DbUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

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


    public static void printTableInfo() {
        try (Connection con = DbUtil.connect()) {
            PreparedStatement statement = con.prepareStatement(PRINT_DATA_QUERY);
            ResultSet rs = statement.executeQuery();
            System.out.println("Printing table USERS info\n");
            while (rs.next()) {
                System.out.print("| " + rs.getString(1) + " " + rs.getString(2) + " " +
                        rs.getString(3) + " " + rs.getString(4) + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
                System.out.println("created ID = " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User read(int userId) {
        User user = null;
        try (Connection con = DbUtil.connect()) {
            PreparedStatement st = con.prepareStatement(READ_QUERY_WHERE_ID);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                user = new User(rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
                    System.out.println("Update uzytkownika i ID = " + id + ". {" + read(user.getId()) + " }");
                    PreparedStatement st2 = con.prepareStatement(UPDATE_QUERRY);
                    st2.setString(1, user.getEmail());
                    st2.setString(2, user.getUsername());
                    st2.setString(3, hashPassword(user.getPassword()));
                    st2.setInt(4, user.getId());
                    st2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int userId) {
        try (Connection con = DbUtil.connect()) {
            PreparedStatement st = con.prepareStatement(DELETE_QUERRY, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, userId);
            System.out.println("Usunieto uzytkownika{ " + read(userId) + " }");
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User[] findAll() {
        User[] users = new User[0];
        try (Connection con = DbUtil.connect()) {
            PreparedStatement st = con.prepareStatement(PRINT_DATA_QUERY);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password")
                );
                users = ArrayUtils.add(users, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}
