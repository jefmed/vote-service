package com.jefmed.voteservice.service.impl;

import com.jefmed.voteservice.model.VoteSchedule;
import com.jefmed.voteservice.model.dto.VoteScheduleDTO;
import com.jefmed.voteservice.model.mapper.VoteScheduleMapper;
import com.jefmed.voteservice.repository.VoteScheduleRepository;
import com.jefmed.voteservice.service.VoteScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteScheduleServiceImpl implements VoteScheduleService {

    private VoteScheduleRepository voteScheduleRepository;
    private VoteScheduleMapper voteScheduleMapper;

    @Autowired
    public VoteScheduleServiceImpl(VoteScheduleRepository voteScheduleRepository, VoteScheduleMapper voteScheduleMapper) {
        this.voteScheduleRepository = voteScheduleRepository;
        this.voteScheduleMapper = voteScheduleMapper;
    }

    @Override
    public VoteScheduleDTO save(VoteScheduleDTO voteScheduleDTO) {
        VoteSchedule voteScheduleToInsert = voteScheduleMapper.entityFromDTO(voteScheduleDTO);
        VoteSchedule voteScheduleInserted = voteScheduleRepository.save(voteScheduleToInsert);
        return voteScheduleMapper.dtoFromEntity(voteScheduleInserted);
    }

    @Override
    public Optional<VoteSchedule> findById(Long id) {
        return voteScheduleRepository.findById(id);
    }
}
