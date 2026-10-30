package com.sgic.lms.service;

import com.sgic.lms.entity.Student;
import com.sgic.lms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
@RequiredArgsConstructor
public class Studentservice {

    private final StudentRepository repository;

    public Student saveStudent(Student student){
        return repository.save(student);
    }
    public List<Student>getAllStudents(){
        return repository.findAll();
    }

    public Student findbyid(long id){
        return repository.findById(id).orElse(null);

    }
    public  void deletebyid(long id){
        repository.deleteById(id);
    }

    public Student updateStudent(long id, Student updatedStudent) {

        Student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAddress(updatedStudent.getAddress());

            return repository.save(existingStudent);
        }

        return null;
    }

    public Page<Student> getAllStudents(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    public String getAppInfo(){
        return "App Name:" +appName+ "App Version" + appVersion;
    }


}
