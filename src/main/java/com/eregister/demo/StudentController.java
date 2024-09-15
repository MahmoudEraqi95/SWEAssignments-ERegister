package com.eregister.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/eregistrar")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/search")
    public String searchStudents(@RequestParam("searchTerm") String searchTerm, Model model) {
        model.addAttribute("students", studentService.searchStudents(searchTerm));
        model.addAttribute("searchTerm", searchTerm);
        return "studentList";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        studentService.deleteStudentById(id);
        return "studentList";  // Redirect to list of students after deletion
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        studentService.findStudentById(id).ifPresent(student -> model.addAttribute("student", student));
        return "studentEditForm";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student, Model model) {
        studentService.saveStudent(student);
        model.addAttribute("message", "Student updated successfully!");
        return "registerationSuccess";
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable Long id, Model model) {
        studentService.findStudentById(id).ifPresent(student -> model.addAttribute("student", student));
        return "studentDetail";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "showRegisterationForm";
    }
    @PostMapping("/student/register")
    public String registerStudent(@ModelAttribute Student student, Model model) {
        studentService.saveStudent(student);
        System.out.println(student.getId());
        model.addAttribute("message", "Student registered successfully!");
        return "registerationSuccess";
    }
    @GetMapping("/students")
    public String listStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "studentList"; // Thymeleaf template for the student list
    }
}

