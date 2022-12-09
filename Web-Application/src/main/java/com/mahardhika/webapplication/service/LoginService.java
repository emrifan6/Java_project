package com.mahardhika.webapplication.service;

import com.mahardhika.webapplication.config.passData;
import com.mahardhika.webapplication.config.userData;
import com.mahardhika.webapplication.repository.passDataRepository;
import com.mahardhika.webapplication.repository.userDataRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private userDataRepository userRepo;
    @Autowired
    private passDataRepository passRepo;
    public List<userData> listAllUser(){
        return (List<userData>) userRepo.findAll();
    }
    public List<passData> listAllPass(){
        return (List<passData>) passRepo.findAll();
    }

    public int validateUser(String userid, String pas) {
        // in28minutes, dummy
        int id = 0;
        for(userData user : listAllUser()){
            if(userid.equals(user.getUserName())){
                id = user.getId();
            }
        }

        for(passData pass : listAllPass()){
            userData user = new userData();
            user = pass.getUsers();
            if(id == user.getId()){
                if(pas.equals(pass.getPass()) && pass.getLock() == false){
                    pass.setRetry(0);
                    passRepo.save(pass);
                    return 3;
                }
                else if(pas.equals(pass.getPass()) && pass.getLock() == true){
                    return 2;
                }
                int retry = pass.getRetry();
                pass.setRetry(retry+1);
                passRepo.save(pass);
                retry = pass.getRetry();
                if(retry >= 3){
                    pass.setLock(true);
                    passRepo.save(pass);
                }
                return 1;
            }
        }

        return 0;
    }

}
