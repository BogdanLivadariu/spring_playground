package com.github.bogdanlivadariu.sprint_playground.dao;

import com.github.bogdanlivadariu.sprint_playground.entity.Student;

import java.util.Collection;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insetStudent(Student student);
}
