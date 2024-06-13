package com.example.SpingJPATest.Service;

import com.example.SpingJPATest.Common.GenericRepository;
import com.example.SpingJPATest.Model.Student;
import com.example.SpingJPATest.Reposi.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(Long id) {
        return studentRepository.findById(id);
    }
}
