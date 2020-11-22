package com.jefmed.voteservice.service;

import com.jefmed.voteservice.model.VoteSchedule;
import com.jefmed.voteservice.model.dto.VoteScheduleDTO;

import java.util.Optional;

public interface VoteScheduleService {
    public VoteScheduleDTO save(VoteScheduleDTO voteScheduleDTO);
    public Optional<VoteSchedule> findById(Long id);
}
