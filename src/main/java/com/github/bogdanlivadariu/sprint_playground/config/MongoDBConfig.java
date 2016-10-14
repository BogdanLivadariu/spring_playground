package com.github.bogdanlivadariu.sprint_playground.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Collections;

@Configuration
public class MongoDBConfig extends AbstractMongoConfiguration {
    @Override protected String getDatabaseName() {
        return "test_re";
    }

    @Override public Mongo mongo() throws Exception {
        return new MongoClient(
            new ServerAddress("ds013222.mlab.com", 13222),
            Collections.singletonList(MongoCredential.createCredential("test", "test_re", "test".toCharArray()))
        );
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(new SimpleMongoDbFactory(mongo(), "test_re"));
    }
}
