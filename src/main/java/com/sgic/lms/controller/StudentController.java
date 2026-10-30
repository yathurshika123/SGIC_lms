package com.sgic.lms.controller;

import com.sgic.lms.entity.Student;
import com.sgic.lms.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private Studentservice studentService;

    @GetMapping("/print")
    public String print(){
        return studentService.getAppInfo();
    }

}
