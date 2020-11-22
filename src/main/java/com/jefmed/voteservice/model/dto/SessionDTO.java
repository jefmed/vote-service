package com.jefmed.voteservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessionDTO {
    private Long voteScheduleId;
    private LocalDateTime finalVoting;
    private boolean opened;

    public SessionDTO(boolean opened) {
        this.opened = opened;
    }

    public SessionDTO(Long voteScheduleId, LocalDateTime finalVoting) {
        this.voteScheduleId = voteScheduleId;
        this.finalVoting = finalVoting;
    }
}
