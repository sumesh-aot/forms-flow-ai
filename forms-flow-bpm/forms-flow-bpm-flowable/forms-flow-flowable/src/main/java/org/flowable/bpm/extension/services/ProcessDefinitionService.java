package org.flowable.bpm.extension.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessDefinitionService {

    private RepositoryService repositoryService;

    @Autowired
    public ProcessDefinitionService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    //********************************************************** deployment service methods **********************************************************

    public void deployProcessDefinition() {

        Deployment deployment =
                repositoryService
                        .createDeployment()
                        .addClasspathResource("holiday-request.xml")
                        .deploy();
    }
}
