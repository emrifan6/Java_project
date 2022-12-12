package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.entities.User;
import web.repos.UserRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUser() {
        return (List<User>) userRepository.findAll();
    }

    public User FindByUserId(String user_id) {
        User data = new User();
        try {
            data = userRepository.findByUserid(user_id);
        } catch (Exception e) {
            System.out.println("Exception = " + e);
            return null;
        }
        if (data == null) {
            System.out.println("USER ID TIDAK DITEMUKAN");
            return null;
        }
        return data;
    }

    public boolean InsertUser(String user_id, String email, String nomor_kartu,
            String nomor_hp) {
        Date date = new Date();
        Timestamp createddate = new Timestamp(date.getTime());
        User user = new User(null, email, user_id, nomor_kartu, nomor_hp,
                createddate, null, true);
        User output = new User();
        try {
            output = userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        if (output.getUserid().isEmpty()) {
            return false;
        }
        System.out.println("Succes INSERT data to users table");
        return true;
    }

    public boolean DeteleUser(String user_id) {
        User user = userRepository.findByUserid(user_id);
        try {
            userRepository.delete(user);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        System.out.println("Succes DELETE data to users table");
        return true;
    }
}
