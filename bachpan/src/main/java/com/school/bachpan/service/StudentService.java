package com.school.bachpan.service;

import com.school.bachpan.model.Student;
import com.school.bachpan.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }

    @Transactional
    public void saveOrUpdate(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void updateStudent(Long id) {
        
    }
}
