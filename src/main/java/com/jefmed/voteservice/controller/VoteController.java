package com.jefmed.voteservice.controller;

import com.jefmed.voteservice.exception.Messages;
import com.jefmed.voteservice.model.dto.VoteDTO;
import com.jefmed.voteservice.service.impl.VoteServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class VoteController {
    private VoteServiceImpl voteService;


    @PostMapping("/vote-schedule/{voteScheduleId}/vote")
    @ApiOperation(value = "create a new vote of schedule session")
    public ResponseEntity<VoteDTO> vote(@PathVariable Long topicVotingId, @RequestBody VoteDTO voteDTO) {
        try {
            VoteDTO vote = voteService.vote(voteDTO);
            return ResponseEntity.ok(vote);
        }catch (Exception e) {
            System.out.println(">>> VOTE: " + e);
            throw new IllegalArgumentException(Messages.YOU_CAN_NOT_VOTE);
        }

    }

    @GetMapping("/vote-schedule/{voteScheduleId}/result")
    @ApiOperation(value = "get a result of the session")
    public ResponseEntity<VoteDTO> getResult(@PathVariable Long voteScheduleId) {
        try {
            VoteDTO vote = voteService.result(voteScheduleId);
            return ResponseEntity.ok(vote);
        }catch (Exception e) {
            System.out.println(">>> VOTE RESULT: " + e);
            throw new IllegalArgumentException(Messages.YOU_CAN_NOT_GET_RESULT);
        }
    }




}
