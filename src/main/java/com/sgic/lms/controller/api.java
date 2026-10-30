package com.sgic.lms.controller;

import com.sgic.lms.entity.Student;
import com.sgic.lms.service.Studentservice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class api {
    private final Studentservice service;
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping("/getall")
    public List<Student> getAllStudent(){
        return service.getAllStudents();
    }


    @GetMapping("/{id}")
    public Student findbyid(@PathVariable long id){
        return service.findbyid(id);

    }

    @DeleteMapping("/{id}")
    public String deleteby(@PathVariable long id){
        service.deletebyid(id);
        return  "delete successfully";
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @GetMapping("/pageget")
    public Page<Student> getAllStudent(
            @PageableDefault(size = 10) Pageable pageable) {

        return service.getAllStudents(pageable);
    }
}
