package Main;

import Main.DbUtil.DbUtil;
import Main.User.User;
import Main.User.UserDAO;

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        User user = new User(14, "galileo@gmail.com", "Blue", "21321455");

 //       UserDAO.createUser(user);
//        System.out.println(UserDAO.read(6));
//        System.out.println(UserDAO.read("Maciek_swietny_programista@gmail.com"));

 //       UserDAO.update(user);

        for (int i = 0; i < UserDAO.findAll().length; i++) {
            System.out.println(UserDAO.findAll()[i]);
        }
    }
}
