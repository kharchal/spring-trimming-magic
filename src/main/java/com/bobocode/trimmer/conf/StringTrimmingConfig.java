package com.bobocode.trimmer.conf;

import com.bobocode.trimmer.postprocessor.StingTrimmedBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringTrimmingConfig {

    @Bean
    public StingTrimmedBeanPostProcessor stingTrimmedBeanPostProcessor() {
        return new StingTrimmedBeanPostProcessor();
    }
}
