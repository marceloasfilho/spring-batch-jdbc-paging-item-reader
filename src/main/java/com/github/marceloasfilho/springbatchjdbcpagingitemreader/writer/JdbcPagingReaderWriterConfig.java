package com.github.marceloasfilho.springbatchjdbcpagingitemreader.writer;

import com.github.marceloasfilho.springbatchjdbcpagingitemreader.entity.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcPagingReaderWriterConfig {
    @Bean
    public ItemWriter<Cliente> jdbcPagingReaderWriter() {
        return clientes -> clientes.forEach(System.out::println);
    }
}
