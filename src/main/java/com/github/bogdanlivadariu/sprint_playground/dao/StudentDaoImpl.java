package com.github.bogdanlivadariu.sprint_playground.dao;

import com.github.bogdanlivadariu.sprint_playground.entity.Student;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class StudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "name", "course"));
            }

        };
    }

    @Override public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    @Override public Student getStudentById(int id) {
        return this.students.get(id);
    }

    @Override public WriteResult removeStudentById(int id) {
        this.students.remove(id);
        return null;
    }

    @Override public Object updateStudent(Student student) {
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());

        students.put(student.getId(), s);
        return null;
    }

    @Override public void insetStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}
