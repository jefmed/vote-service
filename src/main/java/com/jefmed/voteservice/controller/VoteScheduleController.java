package com.jefmed.voteservice.controller;

import com.jefmed.voteservice.exception.Messages;
import com.jefmed.voteservice.model.dto.VoteScheduleDTO;
import com.jefmed.voteservice.service.impl.VoteScheduleServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class VoteScheduleController {
    private VoteScheduleServiceImpl voteScheduleService;

    @Autowired
    public VoteScheduleController(VoteScheduleServiceImpl voteScheduleService) {
        this.voteScheduleService = voteScheduleService;
    }

    @PostMapping("/vote-schedule")
    @ApiOperation(value = "create a new vote schedule")
    public ResponseEntity<VoteScheduleDTO> insertVoteSchedule(@RequestBody VoteScheduleDTO voteScheduleDTO) {
        try {
            VoteScheduleDTO voteSchedule = voteScheduleService.save(voteScheduleDTO);
            return ResponseEntity.ok(voteSchedule);
        }catch (Exception e) {
            System.out.println(">>> VOTE SCHEDULE: " + e);
            throw new IllegalArgumentException(Messages.THE_SCHEDULE_NOT_INSERT);
        }

    }

}
