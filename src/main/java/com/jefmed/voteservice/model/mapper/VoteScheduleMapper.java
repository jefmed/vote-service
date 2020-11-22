package com.jefmed.voteservice.model.mapper;

import com.jefmed.voteservice.model.VoteSchedule;
import com.jefmed.voteservice.model.dto.VoteScheduleDTO;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class VoteScheduleMapper {
    public VoteScheduleDTO dtoFromEntity(VoteSchedule entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        VoteScheduleDTO voteScheduleDTO = new VoteScheduleDTO();
        voteScheduleDTO.setId(entity.getId());
        voteScheduleDTO.setName(entity.getName());
        return voteScheduleDTO;
    }

    public VoteSchedule entityFromDTO(VoteScheduleDTO dto) {
        VoteSchedule voteSchedule = new VoteSchedule();
        voteSchedule.setName(dto.getName());
        return voteSchedule;
    }
}
