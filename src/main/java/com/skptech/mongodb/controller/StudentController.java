package com.skptech.mongodb.controller;

import com.skptech.mongodb.model.Student;
import com.skptech.mongodb.model.UpdateRequest;
import com.skptech.mongodb.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable("email") String email) {
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/name/{fullName}")
    public Student getStudentByFullName(@PathVariable("fullName") String fullName) {
        return studentService.getStudentByName(fullName);
    }

    @GetMapping("/firstname/{firstName}")
    public Student getStudentByFirstName(@PathVariable("firstName") String firstName) {
        return studentService.getStudentByFirstName(firstName);
    }

    @GetMapping("/firstnames/{firstName}")
    public List<Student> getStudentsByFirstName(@PathVariable("firstName") String firstName) {
        return studentService.getStudentsByFirstName(firstName);
    }

    @PutMapping("/updateEmail")
    public void updateStudentEmail(@RequestBody UpdateRequest updateRequest) {
        studentService.updateStudentEmail(updateRequest);
    }

}
