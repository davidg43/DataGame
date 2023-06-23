package com.example.demo.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Objects.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Integer>{
    
}
