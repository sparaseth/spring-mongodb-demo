package com.skptech.mongodb.repository;

import com.skptech.mongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findStudentByEmail(String email);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("{firstName:'?0'}")
    Student findCustomByFirstName(String firstName);

    @Query("{firstName: { $regex: ?0 } })")
    List<Student> findCustomByRegExFirstName(String firstName);

}
