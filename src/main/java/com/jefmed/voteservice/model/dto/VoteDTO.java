package com.jefmed.voteservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteDTO {
    private Long voteScheduleId;
    private String cpf;
    private Boolean vote;
    private Boolean computedVote;
    private String voteScheduleName;
    private Long countYes;
    private Long countNo;

    public VoteDTO(Long voteScheduleId) {
        this.voteScheduleId = voteScheduleId;
    }

    public VoteDTO(Boolean vote) {
        this.vote = vote;
    }

    public VoteDTO(Long voteScheduleId, String cpf, Boolean vote) {
        this.voteScheduleId = voteScheduleId;
        this.cpf = cpf;
        this.vote = vote;
    }

    public VoteDTO(String voteScheduleName, Long countYes, Long countNo) {
        this.voteScheduleName = voteScheduleName;
        this.countYes = countYes;
        this.countNo = countNo;
    }
}
