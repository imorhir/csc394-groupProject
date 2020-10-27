package com.csc394.capStoneProject.dto;

import lombok.Data;

import java.util.List;
@Data
public class AssignStdToTeamDTO {

    private Long teamId;
    private List<Long> listUserId;

    public Long getTeamId () {
        return this.teamId;
    }

    public List<Long> getListUserId () {
        return this.listUserId;
    }




}
