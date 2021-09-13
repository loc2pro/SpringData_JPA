package com.example.nguyenhuuloc_springdatajpa;

import com.example.nguyenhuuloc_springdatajpa.Entity.Student;
import com.example.nguyenhuuloc_springdatajpa.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NguyenHuuLocSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NguyenHuuLocSpringDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(StudentRepository repository){
        return (args -> {
            insertStudent(repository);
            System.out.println(repository.findAll());
        });
    }

    private void insertStudent(StudentRepository repository){
        Student student =  Student.builder()
                .firstName("Huu")
                .lastName("Loc")
                .email("loc@gmail.com")
                .build();
        repository.save(student);
    }


}
