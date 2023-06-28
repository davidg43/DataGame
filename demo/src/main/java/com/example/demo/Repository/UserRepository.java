package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Objects.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, Integer>{
   User findByName(String name);
   List<User> findAll();
}
