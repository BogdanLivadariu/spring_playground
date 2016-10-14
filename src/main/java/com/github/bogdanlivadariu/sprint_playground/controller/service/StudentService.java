package com.github.bogdanlivadariu.sprint_playground.controller.service;

import com.github.bogdanlivadariu.sprint_playground.dao.StudentDao;
import com.github.bogdanlivadariu.sprint_playground.entity.Student;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    @Qualifier("mongoData")
    private StudentDao studentDao;

    public Collection<Student> getAllStudents() {
        return this.studentDao.getAllStudents();
    }

    public Student getStudentById(int id) {
        return this.studentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    public Object updateStudent(Student student) {
       return studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        studentDao.insetStudent(student);
    }
}
