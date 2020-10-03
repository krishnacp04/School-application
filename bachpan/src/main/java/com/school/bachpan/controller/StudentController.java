package com.school.bachpan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.bachpan.model.Address;
import com.school.bachpan.model.Student;
import com.school.bachpan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/getStudents")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(value = "/saveStudent", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void saveStudent(@RequestBody String studentObj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        Student student = objectMapper.readValue(studentObj, Student.class);
        studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if(student.isPresent()) {
            studentService.delete(student.get());
            if(studentService.getStudentById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        }else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }
}
