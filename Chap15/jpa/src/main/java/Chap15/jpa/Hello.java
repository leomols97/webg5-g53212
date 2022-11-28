package Chap15.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Chap15.jpa.DB.UserDB;
import Chap15.jpa.DB.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Hello implements CommandLineRunner {

    @Autowired
    private UserDB userDB;

    @Override
    public void run(String... args) {
        log.info(userDB.findAll().toString());
        userDB.save(new UserDTO("PBT", "Bettens"));
        log.info(userDB.findAll().toString());
    }
}