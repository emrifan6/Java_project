package web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.model.entities.User;
import web.repos.UserRepository;
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

        // Check user_id in users table
        User user = userServiceImpl.FindByUserId(user_id);
        List<User> user_list = new ArrayList<User>();
        user_list.add(user);

        if (user_list.get(0) != null) {
            // user_id already in users_table
            System.out.println("user_id already in users table");
            validate_code = 1;
            return validate_code;
        }

        System.out.println("InsertUser");
        boolean result = userServiceImpl.InsertUser(user_id, email, nomor_kartu,
                nomor_hp);
        if (result) {
            // insert data to passwords table
            user = userServiceImpl.FindByUserId(user_id);
            passwordServiceImpl.InsertPassword(user, password);
            validate_code = 2;
            return validate_code;
        }
        return validate_code;
    }

    public boolean DeleteAccount(String user_id) {
        User user = userServiceImpl.FindByUserId(user_id);
        passwordServiceImpl.DetelePassword(user);
        userServiceImpl.DeteleUser(user_id);
        return true;
    }

    public String HelloWorld() {
        return "Hello World!";
    }
}
