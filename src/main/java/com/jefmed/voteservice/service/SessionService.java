package com.jefmed.voteservice.service;


import com.jefmed.voteservice.model.VoteSchedule;
import com.jefmed.voteservice.model.dto.SessionDTO;

public interface SessionService {
    public SessionDTO openSession(SessionDTO sessionDto);
    public Boolean isSessionOpenOfVoteSchedule(VoteSchedule voteSchedule);
}
