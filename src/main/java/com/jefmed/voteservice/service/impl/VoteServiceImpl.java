package com.jefmed.voteservice.service.impl;

import com.jefmed.voteservice.exception.Messages;
import com.jefmed.voteservice.model.Vote;
import com.jefmed.voteservice.model.VoteSchedule;
import com.jefmed.voteservice.model.dto.VoteDTO;
import com.jefmed.voteservice.model.mapper.VoteMapper;
import com.jefmed.voteservice.repository.VoteRepository;
import com.jefmed.voteservice.service.SessionService;
import com.jefmed.voteservice.service.VoteService;
import com.jefmed.voteservice.voteauth.UserVoteAuth;
import com.jefmed.voteservice.voteauth.UserVoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    private VoteScheduleServiceImpl voteScheduleService;
    private SessionService sessionService;
    private VoteMapper voteMapper;
    private VoteRepository voteRepository;
    private UserVoteClient userVoteClient;

    @Autowired
    public VoteServiceImpl(VoteScheduleServiceImpl voteScheduleService, SessionService sessionService, VoteMapper voteMapper, VoteRepository voteRepository, UserVoteClient userVoteClient) {
        this.voteScheduleService = voteScheduleService;
        this.sessionService = sessionService;
        this.voteMapper = voteMapper;
        this.voteRepository = voteRepository;
        this.userVoteClient = userVoteClient;
    }


    @Override
    public VoteDTO vote(VoteDTO voteDto) {
        UserVoteAuth userVoteAuth = userVoteClient.getStatus(voteDto.getCpf());
        if (userVoteAuth.getStatus().equalsIgnoreCase("ABLE_TO_VOTE")) {
            Optional<VoteSchedule> optionalVoteSchedule = voteScheduleService.findById(voteDto.getVoteScheduleId());
            if (optionalVoteSchedule.isPresent()) {
                if (sessionService.isSessionOpenOfVoteSchedule(optionalVoteSchedule.get())) {
                    return executeVote(voteDto, optionalVoteSchedule);
                }
                throw new IllegalArgumentException(Messages.THE_SESSION_IS_CLOSED);
            }
            throw new IllegalArgumentException(Messages.THE_TOPIC_VOTING_NOT_EXISTS);
        }
        throw new IllegalArgumentException(Messages.UNABLE_TO_VOTE);
    }

    @Override
    public VoteDTO result(Long id) {
        Optional<VoteSchedule> optionalVoteSchedule = voteScheduleService.findById(id);
        if (optionalVoteSchedule.isPresent()) {
            if (sessionService.isSessionOpenOfVoteSchedule(optionalVoteSchedule.get())) {
                Long countYes = voteRepository.countByVoteScheduleAndVoteTrue(optionalVoteSchedule.get());
                Long countNo = voteRepository.countByVoteScheduleAndVoteFalse(optionalVoteSchedule.get());
                return voteMapper.dtoFromEntity(optionalVoteSchedule.get(), countYes, countNo);
            }
            throw new IllegalArgumentException(Messages.THE_SESSION_IS_NOT_CLOSE);
        }
        throw new IllegalArgumentException(Messages.THE_TOPIC_VOTING_NOT_EXISTS);
    }

    @Override
    public VoteDTO executeVote(VoteDTO voteDto, Optional<VoteSchedule> optionalVoteSchedule) {
        Vote vote = voteMapper.entityFromDto(optionalVoteSchedule.get(), voteDto);
        Vote voteSaved = voteRepository.save(vote);
        return voteMapper.dtoFromEntity(voteSaved);
    }
}
