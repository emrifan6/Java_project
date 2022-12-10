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

    public List<User> FindByUserId(String user_id) {
        List<User> data = new ArrayList<User>();
        data.add(userRepository.findByUserid(user_id));
        return data;
    }

    public void InsertUser(String user_id, String email, String nomor_kartu, String nomor_hp) {
        Date date = new Date();
        Timestamp createddate = new Timestamp(date.getTime());
        User user = new User(null, email, user_id, nomor_kartu, nomor_hp, createddate, null, true);
        User output = userRepository.save(user);
        System.out.println("*******************************");
        System.out.println("InsertUser");
        System.out.println(output.getUserid().isEmpty());
        System.out.println("*******************************");
    }

    public void DeteleUser(String user_id) {
        System.out.print("*******************************");
        System.out.print("DeteleUser = " + user_id);
        User user = userRepository.findByUserid(user_id);
        userRepository.delete(user);
    }
}
