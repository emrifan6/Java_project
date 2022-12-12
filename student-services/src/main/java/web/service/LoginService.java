package web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.entities.Password;
import web.model.entities.User;
import web.properties.AppProperties;
import web.service.impl.PasswordServiceImpl;
import web.service.impl.UserServiceImpl;

@Service
public class LoginService {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PasswordServiceImpl passwordServiceImpl;

    @Autowired
    AppProperties myAppProperties;

    public boolean validateUser(String userid, String password) {
        return userid.equalsIgnoreCase("user")
                && password.equalsIgnoreCase("user");
    }

    public int ValidateLogin(String user_id, String password) {
        /*
         * Login Validate Code
         * 0 = user_id not found
         * 1 = user_id found, wrong password
         * 2 = user_id found, user is lock
         * 3 = user_id found, correct password
         */
        int validate_code = 0;

        // Check is user_id in users tables
        User user = userServiceImpl.FindByUserId(user_id);
        if (user == null) {
            return validate_code;
        }
        List<User> user_list = new ArrayList<User>();
        user_list.add(user);

        System.out.println("user_id found in users tables");
        List<Password> pass_list = new ArrayList<Password>();
        user = userServiceImpl.FindByUserId(user_id);
        pass_list.add(passwordServiceImpl.FindByUserId(user));
        System.out.println("pass_list.get(0).isIslock() = " +
                pass_list.get(0).isIslock());
        String password_from_db = pass_list.get(0).getPassword().toString();

        if (password.equals(password_from_db)) {
            if (pass_list.get(0).isIslock()) {
                // user_id is locked
                validate_code = 2;
                System.out.println("user_id is locked");
                return validate_code;
            }
            // Reset retry
            System.out.println("password is valid");
            passwordServiceImpl.UpdateRetry(0, user);
            passwordServiceImpl.UpdateLastLogin(user);
            validate_code = 3;
            return validate_code;
        }

        // password not valid
        System.out.println("password not valid");

        int retry = pass_list.get(0).getRetry() + 1;
        if (retry > myAppProperties.getMax_wrong_password()) {
            // user_id is locked
            validate_code = 2;
            passwordServiceImpl.UpdateIslock(true, user);
            System.out.println("user_id is locked");
            return validate_code;
        }
        validate_code = 1;
        passwordServiceImpl.UpdateRetry(retry, user);
        return validate_code;
    }

    public List<User> ListUser() {
        List<User> users = userServiceImpl.listAllUser();
        return users;
    }

    public List<Password> ListPassword() {
        List<Password> password = passwordServiceImpl.listAllPassword();
        return password;
    }

}