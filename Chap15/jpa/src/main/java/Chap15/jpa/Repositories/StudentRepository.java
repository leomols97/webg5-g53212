package Chap15.jpa.Repositories;

import org.springframework.data.repository.CrudRepository;

import Chap15.jpa.DB.dto.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
