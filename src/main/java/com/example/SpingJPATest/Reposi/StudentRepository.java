package com.example.SpingJPATest.Reposi;

import com.example.SpingJPATest.Common.GenericRepository;
import com.example.SpingJPATest.Model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends GenericRepository<Student, Long> {

}