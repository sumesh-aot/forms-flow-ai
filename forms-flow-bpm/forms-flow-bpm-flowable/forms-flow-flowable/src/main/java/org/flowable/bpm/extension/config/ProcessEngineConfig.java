package org.flowable.bpm.extension.config;

import org.flowable.spring.boot.process.ProcessEngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessEngineConfig {

    @Bean
    public ProcessEngineConfigurationConfigurer processEngineConfigurationConfigurer() {
        return processEngineConfiguration -> {
            // Configure the process engine as needed
            processEngineConfiguration.setDatabaseSchemaUpdate("true");
            // Add any additional configurations

            // Enable Flowable Admin UI
            processEngineConfiguration.setEnableProcessDefinitionInfoCache(true);
            processEngineConfiguration.setEnableSafeBpmnXml(true);
        };
    }
}

