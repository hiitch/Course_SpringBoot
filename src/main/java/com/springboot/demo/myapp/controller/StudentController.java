package com.springboot.demo.myapp.controller;

import com.springboot.demo.myapp.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    private void loadData() {
        Student s1 = new Student(1, "AfName", "AlName", "Aemail");
        Student s2 = new Student(2, "BfName", "BlName", "Bemail");
        Student s3 = new Student(3, "CfName", "ClName", "Cemail");

        students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    @GetMapping("/list")
    public String listStudents(Model m) {
        m.addAttribute("students", students);
        return "list-students";
    }
}
