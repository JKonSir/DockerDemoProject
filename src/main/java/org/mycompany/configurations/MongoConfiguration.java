package org.mycompany.configurations;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by konstantinamp on 7/11/17.
 */
@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Override
    protected String getDatabaseName() {
        return new MongoClientURI(mongoUri).getDatabase();
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(new MongoClientURI(mongoUri));
    }
}
