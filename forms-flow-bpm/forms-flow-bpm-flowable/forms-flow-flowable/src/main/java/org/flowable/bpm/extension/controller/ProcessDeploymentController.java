package org.flowable.bpm.extension.controller;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.flowable.bpm.extension.services.ProcessDefinitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequestMapping("/v1/deployment")
public class ProcessDeploymentController {

    private static final Logger logger = LoggerFactory.getLogger(ProcessDefinitionController.class);


    ProcessDefinitionService processDefinitionService;

    @PostMapping("/create")
    public void deployWorkflow() {
        logger.info("Inside deploy controller");
        processDefinitionService.deployProcessDefinition();
        logger.info("Done deploy");
    }

}
