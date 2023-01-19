package com.myapps.springbatchxmlreader.step;

import com.myapps.springbatchxmlreader.domain.Trade;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StepConfig {

    public final StepBuilderFactory stepBuilderFactory;


    public StepConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Step step(ItemReader<Trade> xmlReader, ItemWriter<Trade> xmlWriter) {
        return stepBuilderFactory
            .get("step")
            .<Trade, Trade>chunk(1)
            .reader(xmlReader)
            .writer(xmlWriter)
            .build();
    }

}
