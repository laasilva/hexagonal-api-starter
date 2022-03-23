package com.hexa.starter.application.configuration;

import com.hexa.starter.core.business.SaveUser;
import com.hexa.starter.core.port.adapter.PersistUserAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.hexa.starter"})
public class BeanConfiguration {
    @Bean
    SaveUser saveUser(PersistUserAdapter persistUserAdapter)  {
        return  new SaveUser(persistUserAdapter);
    }
}
