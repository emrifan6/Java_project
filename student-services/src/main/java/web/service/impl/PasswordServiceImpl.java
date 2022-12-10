package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.entities.Password;
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

    public List<Password> FindByUserId(String user_id) {
        List<Password> data = new ArrayList<Password>();
        data.add(passwordRepository.findByUserid(user_id));
        return data;
    }

    public void UpdateRetry(int retry, String user_id) {
        Password password = passwordRepository.findByUserid(user_id);
        password.setRetry(retry);
        passwordRepository.save(password);
    }

    public void UpdateIslock(boolean status, String user_id) {
        Password password = passwordRepository.findByUserid(user_id);
        password.setIslock(status);
        passwordRepository.save(password);
    }

    public void InsertPassword(String user_id, String password) {
        Date date = new Date();
        Timestamp createddate = new Timestamp(date.getTime());
        Password passMod = new Password(user_id, password, createddate, null, false, 0, null);
        passwordRepository.save(passMod);
    }

    public void DetelePassword(String user_id) {
        System.out.print("*******************************");
        System.out.print("DetelePassword = " + user_id);
        Password password = passwordRepository.findByUserid(user_id);
        passwordRepository.delete(password);
    }
}
