package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.entities.Password;
import web.model.entities.User;

@Service
public class LoginService {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PasswordServiceImpl passwordServiceImpl;

    public boolean validateUser(String userid, String password) {
        // in28minutes, dummy
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
        // Check user_id in users tables
        List<User> user_validation = userServiceImpl.FindByUserId(user_id);
        if (user_validation.isEmpty()) {
            return validate_code;
        }
        System.out.println("user_id found in users tables");
        validate_code = 1;
        List<Password> password_validation = passwordServiceImpl.FindByUserId(user_id);
        String password_from_db = password_validation.get(0).getPassword().toString();
        if (!password.equals(password_from_db)) {
            int retry = password_validation.get(0).getRetry() + 1;
            if (retry > 3) {
                // user_id is locked
                validate_code = 2;
                passwordServiceImpl.UpdateIslock(true, user_id);
                System.out.println("user_id is locked");
                return validate_code;
            }
            // password not valid
            System.out.println("password not valid");
            passwordServiceImpl.UpdateRetry(retry, user_id);
            return validate_code;
        }

        validate_code = 3;
        // Reset retry
        System.out.println("password is valid");
        passwordServiceImpl.UpdateRetry(0, user_id);
        return validate_code;
    }

    public List<User> ListUser() {
        List<User> users = userServiceImpl.listAllUser();
        return users;
    }

}