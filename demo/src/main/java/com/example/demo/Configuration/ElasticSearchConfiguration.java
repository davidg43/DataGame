package com.example.demo.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticSearchConfiguration extends ElasticsearchConfiguration{
    @Override
    public ClientConfiguration clientConfiguration(){
        return ClientConfiguration.builder().connectedToLocalhost().build();
    }
}
