package com.scent;

import com.mongodb.MongoClientURI;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.scent.core.util.ConfigServiceImpl;
import com.scent.core.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

@SpringBootApplication
public class FeedServiceApplication extends AbstractReactiveMongoConfiguration {

    @Autowired
    private ConfigServiceImpl configServiceImpl;


    private final Environment environment;

    public FeedServiceApplication(Environment environment) {
        this.environment = environment;
    }
    public static void main(String[] args) {
        SpringApplication.run(FeedServiceApplication.class, args);

    }
    @Override
    @Bean
    public MongoClient reactiveMongoClient() {
        String url = configServiceImpl.getPropertyValueAsString(Constants.GLOBAL_CONFIG, Constants.MONGO_DB_PATH);
        MongoClientURI uri = new MongoClientURI(url);
        System.out.println(uri.getURI());
        return MongoClients.create(uri.getURI());
    }

    @Override
    protected String getDatabaseName() {
        return configServiceImpl.getPropertyValueAsString(Constants.GLOBAL_CONFIG, Constants.MONGO_DB_NAME);
    }

}
