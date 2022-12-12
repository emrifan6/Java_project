package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.entities.Password;
import web.model.entities.User;
import web.repos.PasswordRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PasswordServiceImpl {

    @Autowired
    private PasswordRepository passwordRepository;

    public List<Password> listAllPassword() {
        return (List<Password>) passwordRepository.findAll();
    }

    public Password FindByUserId(User user_id) {
        System.out.println("FindByUserId");
        Password data = passwordRepository.findByUserid(user_id);
        System.out.println("FindByUserId FINISH");
        return data;
    }

    public void UpdateRetry(int retry, User user_id) {
        Password password = passwordRepository.findByUserid(user_id);
        password.setRetry(retry);
        passwordRepository.save(password);
    }

    public boolean UpdateLastLogin(User user_id) {
        Password password = passwordRepository.findByUserid(user_id);
        Date date = new Date();
        Timestamp date_now = new Timestamp(date.getTime());
        password.setLastlogindate(date_now);
        password = passwordRepository.save(password);
        if (password.getLastlogindate() == null) {
            return false;
        }
        return true;
    }

    public boolean UpdateIslock(boolean status, User user_id) {
        Password password = passwordRepository.findByUserid(user_id);
        if (password == null) {
            return false;
        }
        password.setIslock(status);
        Password output = new Password();
        try {
            output = passwordRepository.save(password);
        } catch (Exception e) {
            System.out.println("Exception = " + e);
            return false;
        }
        if (output.getPassword().isEmpty()) {
            return false;
        }
        System.out.println("Succes UPDATE data Islock from passwords table");
        return true;
    }

    public boolean InsertPassword(User user_id, String password) {
        Date date = new Date();
        Timestamp createddate = new Timestamp(date.getTime());
        Password passMod = new Password(null, user_id, password, createddate, null,
                false, 0, null);
        Password output = new Password();
        try {
            output = passwordRepository.save(passMod);
        } catch (Exception e) {
            return false;
        }
        if (output.getPassword().isEmpty()) {
            return false;
        }
        System.out.println("Succes INSERT data to passwords table");
        return true;
    }

    public boolean DetelePassword(User user_id) {
        Password password = passwordRepository.findByUserid(user_id);
        try {
            passwordRepository.delete(password);
        } catch (Exception e) {
            return false;
        }
        System.out.println("Succes DELETE data from passwords table");
        return true;
    }
}
