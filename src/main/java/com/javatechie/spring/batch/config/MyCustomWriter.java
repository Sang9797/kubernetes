package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Customer;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class MyCustomWriter extends FlatFileItemWriter<Customer> {
    public MyCustomWriter(){
        setResource(new FileSystemResource("templates/output.csv"));
        setLineAggregator(getDelimitedLineAggregator());
    }

    public DelimitedLineAggregator<Customer> getDelimitedLineAggregator() {
        BeanWrapperFieldExtractor<Customer> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<Customer>();
        beanWrapperFieldExtractor.setNames(new String[] {"id","firstName","lastName","email","gender","contactNo","country","dob"});

        DelimitedLineAggregator<Customer> delimitedLineAggregator = new DelimitedLineAggregator<Customer>();

        delimitedLineAggregator.setDelimiter(",");
        delimitedLineAggregator.setFieldExtractor(beanWrapperFieldExtractor);

        return delimitedLineAggregator;
    }
}
