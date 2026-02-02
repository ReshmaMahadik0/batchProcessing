package com.example.BatchProcessing_app.config;

import com.example.BatchProcessing_app.entity.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    // JOB
    @Bean
    public Job job(JobRepository jobRepository,
                   JobCompletionNotificationImpl listener,
                   Step step) {

        return new JobBuilder("productJob", jobRepository)
                .listener(listener)
                .start(step)
                .build();
    }

    // STEP
    @Bean
    public Step step(JobRepository jobRepository,
                     PlatformTransactionManager transactionManager,
                     ItemReader<Product> reader,
                     ItemProcessor<Product, Product> processor,
                     ItemWriter<Product> writer) {

        return new StepBuilder("productStep", jobRepository)
                .<Product, Product>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
    // READER
    @Bean
    public FlatFileItemReader<Product> reader() {

        return new FlatFileItemReaderBuilder<Product>()
                .name("productItemReader")
                .resource(new ClassPathResource("products_50_records.csv"))
                .linesToSkip(1)
                .delimited()
                .names("productId", "title", "description", "price", "discount")
                .targetType(Product.class)
                .build();
    }

    // PROCESSOR
    @Bean
    public ItemProcessor<Product, Product> processor() {
        return new CustomItemProcesssor();
    }

    // WRITER
    @Bean
    public ItemWriter<Product> writer(DataSource dataSource) {

        return new JdbcBatchItemWriterBuilder<Product>()
                .dataSource(dataSource)
                .sql("""
                     INSERT INTO products
                     (product_id, title, description, discount, discounted_price)
                     VALUES (:productId, :title, :description, :discount, :discountedPrice)
                     """)
                .beanMapped()
                .build();
    }
}
