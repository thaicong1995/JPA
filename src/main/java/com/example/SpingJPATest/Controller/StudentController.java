package com.example.SpingJPATest.Controller;

import com.example.SpingJPATest.Model.Student;
import com.example.SpingJPATest.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private StudentService sudentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.sudentService = studentService;
    }
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id) {
        return sudentService.findById(id);
    }
}
