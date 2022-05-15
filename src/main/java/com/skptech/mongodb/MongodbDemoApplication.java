package com.skptech.mongodb;

import com.skptech.mongodb.model.Address;
import com.skptech.mongodb.model.Gender;
import com.skptech.mongodb.model.Student;
import com.skptech.mongodb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongodbDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Address address = new Address(
                    "India", "Mumbai", "400703"
            );
            String email1 = "sparaseth@gmail.com";
            String email2 = "eparaseth@gmail.com";
            Student maleStudent = new Student(
                    "Sujit",
                    "Paraseth",
                    email1,
                    Gender.MALE,
                    address,
                    List.of("Computer Science", "Maths"),
                    BigDecimal.ONE,
                    LocalDateTime.now()
            );
            Student femaleStudent = new Student(
                    "Eka",
                    "Paraseth",
                    email2,
                    Gender.FEMALE,
                    address,
                    List.of("Computer Science", "Maths"),
                    BigDecimal.ONE,
                    LocalDateTime.now()
            );

            studentRepository.findStudentByEmail(email1).ifPresentOrElse(s -> {
                System.out.println(maleStudent + " already exists");
            }, () -> {
                System.out.println("Inserting student " + maleStudent);
                studentRepository.insert(maleStudent);
            });

            studentRepository.findStudentByEmail(email2).ifPresentOrElse(s -> {
                System.out.println(femaleStudent + " already exists");
            }, () -> {
                System.out.println("Inserting student " + femaleStudent);
                studentRepository.insert(femaleStudent);
            });
        };
    }

}
