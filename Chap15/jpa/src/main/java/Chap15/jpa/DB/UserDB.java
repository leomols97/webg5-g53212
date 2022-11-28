package Chap15.jpa.DB;

import org.springframework.data.repository.CrudRepository;

import Chap15.jpa.DB.dto.UserDTO;

public interface UserDB extends CrudRepository<UserDTO, String> {

}