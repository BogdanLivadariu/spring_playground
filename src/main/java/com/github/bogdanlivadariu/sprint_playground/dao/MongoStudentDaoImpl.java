package com.github.bogdanlivadariu.sprint_playground.dao;

import com.github.bogdanlivadariu.sprint_playground.entity.Student;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.MongoCollectionUtils;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {
    @Autowired
    private MongoOperations mongoOperation;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override public Collection<Student> getAllStudents() {
        return mongoOperation.findAll(Student.class);
    }

    @Override public Student getStudentById(int id) {
        Query findQuery = new Query(Criteria.where("id").is(id));
        return mongoOperation.findOne(findQuery, Student.class);
    }

    @Override public WriteResult removeStudentById(int id) {
        Query findQuery = new Query(Criteria.where("id").is(id));

        return mongoOperation.remove(findQuery, Student.class);

    }

    @Override public WriteResult updateStudent(Student student) {
        Query findQuery = new Query(Criteria.where("id").is(student.getId()));
        Update update = Update.fromDBObject((DBObject) mongoTemplate.getConverter().convertToMongoType(student));
        return mongoOperation.updateFirst(findQuery, update,Student.class);

    }

    @Override public void insetStudent(Student student) {
        mongoOperation.upsert()ave(student);
    }
}
