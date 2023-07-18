package org.flowable.bpm.extension.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskFilterRequest {

        @JsonProperty("assignees")
    private List<String> assignees;

    @JsonProperty("candidateGroups")
    private List<String> candidateGroups;

    @JsonProperty("processKeys")
    private List<String> processKeys;

    @JsonCreator
    public TaskFilterRequest(
            @JsonProperty("assignees") List<String> assignees,
            @JsonProperty("candidateGroups") List<String> candidateGroups,
            @JsonProperty("processKeys") List<String> processKeys
    ) {
        this.assignees = assignees;
        this.candidateGroups = candidateGroups;
        this.processKeys = processKeys;
    }


    public List<String> getAssignees() {
        return assignees;
    }
    public void setAssignees(List<String> assignees) {
        this.assignees = assignees;
    }
    public List<String> getCandidateGroups() {
        return candidateGroups;
    }
    public void setCandidateGroups(List<String> candidateGroups) {
        this.candidateGroups = candidateGroups;
    }
    public List<String> getProcessKeys() {
        return processKeys;
    }
    public void setProcessKeys(List<String> processKeys) {
        this.processKeys = processKeys;
    }


}
