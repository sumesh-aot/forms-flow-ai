package org.flowable.bpm.extension.services;

import java.util.List;
import java.util.ArrayList;

import org.flowable.bpm.extension.dto.TaskFilterRequest;
import org.flowable.bpm.extension.dto.TaskRepresentation;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilterService {

    @Autowired
    private TaskService taskService;

    public List<TaskRepresentation> getTasksByFilter(TaskFilterRequest filterRequest) {
        TaskQuery query = taskService.createTaskQuery();
        if (filterRequest.getAssignees()!=null && !filterRequest.getAssignees().isEmpty()) {
            query.taskAssigneeIds(filterRequest.getAssignees());
        }

        if (filterRequest.getCandidateGroups()!=null && !filterRequest.getCandidateGroups().isEmpty()) {
            query.taskCandidateGroupIn(filterRequest.getCandidateGroups());
        }
        
        if (filterRequest.getProcessKeys()!=null && !filterRequest.getProcessKeys().isEmpty()) {
            query.processDefinitionKeyIn(filterRequest.getProcessKeys());
        }
        
        List<Task> tasks = query.list();
        List<TaskRepresentation> taskDTOs = new ArrayList<>();
        for (Task task : tasks) {
            TaskRepresentation taskDTO = new TaskRepresentation(task.getId(), task.getName());
            // Set other relevant properties in taskDTO
            taskDTOs.add(taskDTO);
        }
        return taskDTOs;


    }
    
}
