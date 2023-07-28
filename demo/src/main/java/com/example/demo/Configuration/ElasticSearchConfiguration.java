package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticSearchConfiguration extends ElasticsearchConfiguration{
    @Override
    @Bean
    public ClientConfiguration clientConfiguration(){
        return ClientConfiguration.builder().connectedToLocalhost().build();
    }
}
