package com.mahardhika.webapplication;

import com.mahardhika.webapplication.config.passData;
import com.mahardhika.webapplication.config.userData;
import com.mahardhika.webapplication.repository.userDataRepository;
import com.mahardhika.webapplication.repository.passDataRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class userRepositoryTests {
    @Autowired
    private userDataRepository userRepo;
    @Autowired
    private passDataRepository passRepo;
    @Test
    public void testAddNew(){
        userData user = new userData();
        passData password = new passData();
        Date thisTime = new Date();
        user.setEmail("hafidz.mahardika236@gmail.com");
        user.setUserName("hafizdM");
        user.setNomorHp("082297980164");

        int random_int1 = (int)Math.floor(Math.random()*(999-100+1)+100);
        int random_int2 = (int)Math.floor(Math.random()*(999-100+1)+100);
        int random_int3 = (int)Math.floor(Math.random()*(999-100+1)+100);

        String nomorKartu = Integer.toString(random_int1)+"-"+Integer.toString(random_int2)+"-"+Integer.toString(random_int3);

        user.setNomorKartu(nomorKartu);
        user.setStatusUserId(true);

        password.setLock(false);
        password.setRetry(0);
        password.setPass("4321");
        password.setLastLoginDate(thisTime);
        password.setUsers(user);

        userData savedUser = userRepo.save(user);
        passData savedPass = passRepo.save(password);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<userData> users = userRepo.findAll();
        Iterable<passData> password = passRepo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        Assertions.assertThat(password).hasSizeGreaterThan(0);

        int id = 0;
        String email = "farisyukla@gmail.co.id";
        String pas = "1234567";
        for(userData user : users){
            if(email.equals(user.getEmail())){
                id = user.getId();
            }
        }

        for(passData pass : password){
            userData user = new userData();
            user = pass.getUsers();
            if(id == user.getId()){
                if(pas.equals(pass.getPass())){
                    System.out.println("LOGIN");
                }
                System.out.println("pass salah");
            }
        }


    }

    @Test
    public void testUpdate(){
        Integer userId = 9;
        Optional<userData> optionalUser = userRepo.findById(userId);
        userData user = optionalUser.get();
        user.setEmail("jikriz@student.ub.ac.id");

        userRepo.save(user);

        userData updatedUser = userRepo.findById(userId).get();
        Assertions.assertThat(updatedUser.getEmail()).isEqualTo("jikriz@student.ub.ac.id");
    }

    @Test
    public void testGet(){
        Integer userId = 9;
        Optional<userData> optionalUser = userRepo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
    }

    @Test
    public void testDelete(){
        Integer userId = 9;
        userRepo.deleteById(userId);
    }


}
