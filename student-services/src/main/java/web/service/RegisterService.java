package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.entities.User;
import web.service.impl.PasswordServiceImpl;
import web.service.impl.UserServiceImpl;

@Service
public class RegisterService {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PasswordServiceImpl passwordServiceImpl;

    public int Registration(String user_id, String email,
            String password, String nomor_kartu, String nomor_hp) {
        int validate_code = 0;
        /*
         * Register Validate Code
         * 0 = fail
         * 1 = user_id already in users table
         * 2 = succes registration
         */

        // Check user_id in users tables
        List<User> user_validation = userServiceImpl.FindByUserId(user_id);

        if (user_validation.get(0) != null) {
            validate_code = 1;
            // user_id already in users_tables
            System.out.println("user_id already in users_tables");
            return validate_code;
        }

        validate_code = 2;
        System.out.println("InsertUser");
        userServiceImpl.InsertUser(user_id, email, nomor_kartu, nomor_hp);
        passwordServiceImpl.InsertPassword(user_id, password);
        return validate_code;
    }

    public boolean DeleteAccount(String user_id) {
        userServiceImpl.DeteleUser(user_id);
        passwordServiceImpl.DetelePassword(user_id);

        return true;
    }

    public String HelloWorld() {
        return "Hello World!";
    }
}
