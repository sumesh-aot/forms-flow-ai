package org.flowable.bpm.extension;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.flowable.spring.boot.RestApiAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// import org.flowable.ui.admin.config.FlowableAdminAppSecurityConfiguration;
// import org.flowable.ui.admin.properties.FlowableAdminAppProperties;
// import org.flowable.ui.common.security.DefaultPrivileges;
// import org.flowable.ui.common.security.FlowableCommonAppSecurityConfiguration;
// import org.flowable.ui.common.security.RemoteIdmAuthenticationFilter;
// import org.flowable.ui.common.service.idm.RemoteIdmService;
// import org.flowable.ui.common.service.idm.RemoteIdmServiceImpl;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Import;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@SpringBootApplication
@EnableAutoConfiguration(exclude = LdapAutoConfiguration.class)
public class FormsFlowFlowableApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormsFlowFlowableApplication.class, args);
	}

	@Bean
    public CommandLineRunner init(final RepositoryService repositoryService,
                                  final RuntimeService runtimeService,
                                  final TaskService taskService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("Number of process definitions : "
                    + repositoryService.createProcessDefinitionQuery().count());
                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
                runtimeService.startProcessInstanceByKey("oneTaskProcess");
                System.out.println("Number of tasks after process start: "
                    + taskService.createTaskQuery().count());
            }
        };
    }

    //     @Bean
    // public EngineConfigurationConfigurer<SpringProcessEngineConfiguration> customProcessEngineConfigurationConfigurer() {
    //     return engineConfiguration -> engineConfiguration.setDatabaseSchemaUpdate("true");
    // }


}
