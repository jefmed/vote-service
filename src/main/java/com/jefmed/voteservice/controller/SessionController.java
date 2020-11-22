package com.jefmed.voteservice.controller;

import com.jefmed.voteservice.exception.Messages;
import com.jefmed.voteservice.model.dto.SessionDTO;
import com.jefmed.voteservice.service.impl.SessionServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class SessionController {
    private SessionServiceImpl sessionService;

    @Autowired
    public SessionController(SessionServiceImpl sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/vote-schedule/{voteScheduleId}/session")
    @ApiOperation(value = "create a new vote schedule session")
    public ResponseEntity<SessionDTO> openSession(@PathVariable Long voteScheduleId, @RequestBody SessionDTO sessionDTO) {
        try {
            SessionDTO session = sessionService.openSession(sessionDTO);
            return ResponseEntity.ok(session);
        }catch (Exception e) {
            System.out.println(">>> SESSION: " + e);
            throw new IllegalArgumentException(Messages.THE_SESSION_TO_VOTING_CAN_NOT_OPEN);
        }
    }
}
