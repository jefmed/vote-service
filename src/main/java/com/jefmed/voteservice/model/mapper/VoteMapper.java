package com.jefmed.voteservice.model.mapper;

import com.jefmed.voteservice.model.Vote;
import com.jefmed.voteservice.model.VoteSchedule;
import com.jefmed.voteservice.model.dto.VoteDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class VoteMapper {

    public Vote entityFromDto(VoteSchedule voteSchedule, VoteDTO voteDto) {
        return new Vote(voteSchedule, voteDto.getVote(), voteDto.getCpf());
    }

    public VoteDTO dtoFromEntity(Vote entity) {
        return new VoteDTO(Objects.nonNull(entity));
    }

    public VoteDTO dtoFromEntity(VoteSchedule voteSchedule, Long countYes, Long countNo) {
        return new VoteDTO(voteSchedule.getName(), countYes, countNo);
    }
}
