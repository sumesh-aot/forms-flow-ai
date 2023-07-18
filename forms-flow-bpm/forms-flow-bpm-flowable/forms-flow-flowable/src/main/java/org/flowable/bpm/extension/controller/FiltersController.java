package org.flowable.bpm.extension.controller;

import java.util.List;

import org.flowable.bpm.extension.dto.TaskFilterRequest;
import org.flowable.bpm.extension.dto.TaskRepresentation;
import org.flowable.bpm.extension.services.FilterService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task-filters")
public class FiltersController {

    @Autowired
    private FilterService filterService;
    
    @PostMapping("")
    public ResponseEntity<List<TaskRepresentation>> getTasksByFilter(@RequestBody TaskFilterRequest filterRequest) {
        List<TaskRepresentation> tasks = filterService.getTasksByFilter(filterRequest);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

}
