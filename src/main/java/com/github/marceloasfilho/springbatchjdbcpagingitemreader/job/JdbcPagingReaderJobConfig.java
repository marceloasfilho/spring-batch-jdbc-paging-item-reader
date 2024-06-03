package com.github.marceloasfilho.springbatchjdbcpagingitemreader.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcPagingReaderJobConfig {
    @Bean
    public Job jdbcPagingReaderJob(Step jdbcPagingReaderStep,
                                   @Qualifier("batchJobRepository") JobRepository jobRepository) {
        return new JobBuilder("jdbcPagingReaderJob", jobRepository)
                .start(jdbcPagingReaderStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }
}
