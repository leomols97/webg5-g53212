package Chap15.jpa.Repositories;

import org.springframework.data.repository.CrudRepository;

import Chap15.jpa.DB.dto.UserDTO;

public interface UserRepository extends CrudRepository<UserDTO, String> {

}