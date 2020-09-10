package pl;

import com.mysql.cj.log.Log;
import org.mindrot.jbcrypt.BCrypt;
import pl.User.User;
import pl.User.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;



public class Main {

    public static void main(String[] args) {

        UserDAO.printTableInfo();


    }
}

