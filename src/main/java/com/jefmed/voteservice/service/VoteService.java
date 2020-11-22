package com.jefmed.voteservice.service;

import com.jefmed.voteservice.model.VoteSchedule;
import com.jefmed.voteservice.model.dto.VoteDTO;

import java.util.Optional;

public interface VoteService {
    public VoteDTO vote(VoteDTO voteDto);
    public VoteDTO result(Long id);
    public VoteDTO executeVote(VoteDTO voteDto, Optional<VoteSchedule> optionalVoteSchedule);
}
