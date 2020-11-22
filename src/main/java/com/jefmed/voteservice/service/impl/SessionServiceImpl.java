package com.jefmed.voteservice.service.impl;

import com.jefmed.voteservice.exception.Messages;
import com.jefmed.voteservice.model.Session;
import com.jefmed.voteservice.model.VoteSchedule;
import com.jefmed.voteservice.model.dto.SessionDTO;
import com.jefmed.voteservice.model.mapper.SessionMapper;
import com.jefmed.voteservice.repository.SessionRepository;
import com.jefmed.voteservice.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    private SessionRepository sessionRepository;
    private SessionMapper sessionMapper;
    private VoteScheduleServiceImpl voteScheduleService;

    @Autowired
    public SessionServiceImpl(SessionRepository sessionRepository, SessionMapper sessionMapper, VoteScheduleServiceImpl voteScheduleService) {
        this.sessionRepository = sessionRepository;
        this.sessionMapper = sessionMapper;
        this.voteScheduleService = voteScheduleService;
    }

    @Override
    public SessionDTO openSession(SessionDTO sessionDto) {
        Optional<VoteSchedule> voteSchedule = voteScheduleService.findById(sessionDto.getVoteScheduleId());
        if (voteSchedule.isPresent()) {
            Session session = sessionMapper.sessionFromDto(voteSchedule.get(), LocalDateTime.now(), sessionDto);
            Session sessionSaved = sessionRepository.save(session);
            return sessionMapper.dtoFromEntity(sessionSaved);
        }
        throw new IllegalArgumentException(Messages.THE_TOPIC_VOTING_NOT_EXISTS);
    }

    @Override
    public Boolean isSessionOpenOfVoteSchedule(VoteSchedule voteSchedule) {
        Optional<Session> optionalSession = sessionRepository.findByVoteSchedule(voteSchedule);
        if (optionalSession.isPresent()) {
            return LocalDateTime.now().isBefore(optionalSession.get().getFinalVoting());
        }
        throw new IllegalArgumentException(Messages.THE_SESSION_NOT_EXISTS);
    }
}
