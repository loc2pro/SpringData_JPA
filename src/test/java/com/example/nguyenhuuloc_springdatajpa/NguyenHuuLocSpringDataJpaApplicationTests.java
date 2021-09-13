package com.example.nguyenhuuloc_springdatajpa;

import com.example.nguyenhuuloc_springdatajpa.Entity.Student;
import com.example.nguyenhuuloc_springdatajpa.Repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NguyenHuuLocSpringDataJpaApplicationTests {


    @Autowired
    private StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

//    JPA - CREATE

    //REPO
    @Test
    public void saveStudent(){
        Student student =  Student.builder()
                .firstName("Huu")
                .lastName("Loc")
                .email("loc@gmail.com")
                .build();
        studentRepository.save(student);
    }

    //JPQL
    //NATIVE
    @Test
    public void createStudent(){
        studentRepository.insertStudent1("tuan@gmail.com","Nguyen",
                "Tuan", Long.valueOf(2));
    }

//    JPA - READ

    //REPO
    @Test
    public void findById(){
        System.out.println(
                studentRepository.findById(Long.valueOf(1))
        );
    }

    //JPQL
    @Test
    public void findByCustemId(){
        System.out.println(
                studentRepository.findByCustemId(Long.valueOf(1))
        );
    }

    //NATIVE
    @Test
    public void findAllStudent(){
        List<Student> students = studentRepository.findAllStudent();
        System.out.println(students);
    }

//    JPA - UPDATE

    //REPO
    //JPQL
    @Test
    public void updateById1(){
        studentRepository.updateById1(Long.valueOf(1),"The");
    }
    //NATIVE
    @Test
    public void updateById2(){
        studentRepository.updateById1(Long.valueOf(1),"Van");
    }

//    JPA - DELETE

    //REPO
    @Test
    public void deleteByID(){
        studentRepository.deleteById(Long.valueOf(1));
        System.out.println("Successull");
    }
    //JPQL
    @Test
    public void deleteByID2(){
        studentRepository.deleteById2(Long.valueOf(1));
        System.out.println("Successull");
    }
    //NATIVE
    @Test
    public void deleteByID3(){
        studentRepository.deleteById3(Long.valueOf(1));
        System.out.println("Successull");
    }

}
