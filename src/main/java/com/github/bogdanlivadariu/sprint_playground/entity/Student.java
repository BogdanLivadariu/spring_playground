package com.github.bogdanlivadariu.sprint_playground.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "students")
public class Student {
    @Id
    @NotNull
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Student() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}
