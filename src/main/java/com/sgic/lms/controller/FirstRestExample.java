package com.sgic.lms.controller;


import com.sgic.lms.entity.Student;
import com.sgic.lms.service.Studentservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FirstRestExample {


    @ RequestMapping("/hello")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok("api connected");
    }

    @GetMapping("/hello-first")
   public Map<String,String> callAll(){
         Map<String,String> map =new HashMap<>();
        map.put("message","Yathu");
        map.put("message","Arthy");
        map.put("message1","Tina");
        map.put("message1","Caroline");



        return map;
    }



}
