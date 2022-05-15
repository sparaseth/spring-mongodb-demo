package com.skptech.mongodb.service;

import com.skptech.mongodb.model.Student;
import com.skptech.mongodb.model.UpdateRequest;
import com.skptech.mongodb.repository.StudentCustomRepository;
import com.skptech.mongodb.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentCustomRepository studentCustomRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Email"));
    }

    public Student getStudentByName(String fullName) {
        String[] fullNameArray = fullName.trim().split("\\s+");
        String firstName = fullNameArray[0];
        String lastName = fullNameArray[1];
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Student getStudentByFirstName(String firstName) {
        return studentRepository.findCustomByFirstName(firstName);
    }

    public List<Student> getStudentsByFirstName(String firstName) {
        return studentRepository.findCustomByRegExFirstName(firstName);
    }

    public void updateStudentEmail(UpdateRequest updateRequest) {
        studentCustomRepository.updateEmail(updateRequest.getEmail(), updateRequest.getNewEmail());
    }

}
