package com.parking.config.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean
  public MongoDatabaseFactory configDatabase(){
   return new SimpleMongoClientDatabaseFactory(mongoUri);
  };
  @Bean
    public MongoTemplate mongoTemplate(){
     return  new MongoTemplate(configDatabase());
  }
}
