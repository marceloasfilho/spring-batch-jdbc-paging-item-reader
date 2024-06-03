package com.github.marceloasfilho.springbatchjdbcpagingitemreader.step;

import com.github.marceloasfilho.springbatchjdbcpagingitemreader.entity.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JdbcPagingReaderStepConfig {
    @Bean
    public Step jdbcPagingReaderStep(ItemReader<Cliente> jdbcPagingItemReader,
                                     ItemWriter<Cliente> jdbcPagingReaderWriter,
                                     @Qualifier("batchJobRepository") JobRepository jobRepository,
                                     @Qualifier("batchTransactionManager") PlatformTransactionManager transactionManager) {
        return new StepBuilder("jdbcCursorReaderStep", jobRepository)
                .<Cliente, Cliente>chunk(1, transactionManager)
                .reader(jdbcPagingItemReader)
                .writer(jdbcPagingReaderWriter)
                .build();
    }
}
