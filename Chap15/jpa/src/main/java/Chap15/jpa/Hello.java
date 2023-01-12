package Chap15.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Chap15.jpa.DB.dto.UserDTO;
import Chap15.jpa.Repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Hello implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        log.info(userRepository.findAll().toString());
        userRepository.save(new UserDTO("PBT", "Bettens"));
        log.info(userRepository.findAll().toString());
    }
}