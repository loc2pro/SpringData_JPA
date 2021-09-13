package com.example.nguyenhuuloc_springdatajpa.Repository;

import com.example.nguyenhuuloc_springdatajpa.Entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findStudentByLastName(String lastName);

    //JPQL - CREATE
    //NATIVE - CREATE
    @Transactional
    @Modifying
    @Query(value = "insert into tbl_student(email, first_name, last_name, studentid) values (?1, ?2, ?3, ?4)",
        nativeQuery = true)
    public void insertStudent1(String FirstName, String LastName, String email, Long id);


    //JPQL - READ
    @Query("Select s from Student s where s.StudentID = ?1")
    public Student findByCustemId(Long id);
    //NATIVE - READ
    @Query(value = "Select * from tbl_student",
        nativeQuery = true)
    public List<Student> findAllStudent();

    //JPQL - UPDATE
    @Transactional
    @Modifying
    @Query("update Student s set s.firstName = ?2 where s.StudentID = ?1")
    public void  updateById1(Long id, String newFirstName);
    //NATIVE - UPDATE
    @Transactional
    @Modifying
    @Query(value = "update tbl_student set first_name = ?2 where studentid = ?1",
        nativeQuery = true)
    public void  updateById2(Long id, String newFirstName);

    //JPQL - DELETE
    @Transactional
    @Modifying
    @Query(value = "delete from Student s where s.StudentID = ?1")
    public void deleteById2(Long id);
    //NATIVE - DELETE
    @Transactional
    @Modifying
    @Query(value = "delete from tbl_student where studentid = ?1",
            nativeQuery = true)
    public void deleteById3(Long id);


}


