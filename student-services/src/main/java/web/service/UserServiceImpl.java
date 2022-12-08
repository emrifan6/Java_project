package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.entities.User;
import web.repos.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUser() {
        return (List<User>) userRepository.findAll();
    }

    public List<User> FindByUserId(String user_id) {
        return (List<User>) userRepository.findByUserid(user_id);
    }

}
