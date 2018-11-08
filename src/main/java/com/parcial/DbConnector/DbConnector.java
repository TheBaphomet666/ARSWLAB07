package com.parcial.DbConnector;

import com.parcial.DbConnector.Metadata.Information;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DbConnector extends MongoRepository<Information, String> {
    public Information findByMetaData(String metadata);




}