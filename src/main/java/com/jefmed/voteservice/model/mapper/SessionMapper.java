package com.jefmed.voteservice.model.mapper;

import com.jefmed.voteservice.model.Session;
import com.jefmed.voteservice.model.VoteSchedule;
import com.jefmed.voteservice.model.dto.SessionDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class SessionMapper {
    public Session sessionFromDto(VoteSchedule voteSchedule, LocalDateTime startingVoting, SessionDTO sessionDto) {
        Session session = new Session();
        session.setVoteSchedule(voteSchedule);
        session.setStartingVoting(startingVoting);
        session.setFinalVoting(buildFinalVoting(sessionDto.getFinalVoting(), startingVoting));
        return session;
    }

    private LocalDateTime buildFinalVoting(LocalDateTime finalVoting, LocalDateTime startingVoting) {
        if (Objects.isNull(finalVoting)) {
            return startingVoting.plusMinutes(1);
        }
        return finalVoting;
    }

    public SessionDTO dtoFromEntity(Session session) {
        return new SessionDTO(Objects.nonNull(session));
    }
}
