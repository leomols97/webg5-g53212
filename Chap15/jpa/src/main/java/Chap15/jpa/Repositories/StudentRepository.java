package Chap15.jpa.Repositories;

import org.springframework.data.repository.CrudRepository;

import Chap15.jpa.DB.dto.StudentDTO;

public interface StudentRepository extends CrudRepository<StudentDTO, Integer> {

}
