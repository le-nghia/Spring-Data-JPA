package com.training.trainingdealine.controller;

import com.training.trainingdealine.entity.StudentEntity;
import com.training.trainingdealine.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/student")
    public List<StudentEntity> getAllStudents() {
        return studentsService.getAllStudents();
    }

    @RequestMapping("/student/{id}")
    public StudentEntity getStudent(@PathVariable String id) {
        return studentsService.getStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/student")
    public void addStudent(@RequestBody StudentEntity studentEntity) {
        studentsService.addStudent(studentEntity);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/student/{id}")
    public void addStudent(@RequestBody StudentEntity studentEntity, @PathVariable String id) {
        studentsService.updateStudent(id, studentEntity);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/student/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentsService.deleteStudent(id);
    }

}
