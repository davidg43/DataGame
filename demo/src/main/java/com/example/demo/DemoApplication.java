package com.example.demo;

import java.util.List;

import org.elasticsearch.action.admin.indices.create.CreateIndexAction;
import org.elasticsearch.action.bulk.BulkAction;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Configuration.Configuration;
import com.example.demo.Configuration.ElasticSearchConfiguration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	
	}
}
