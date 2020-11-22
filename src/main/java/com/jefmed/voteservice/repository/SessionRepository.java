package com.jefmed.voteservice.repository;

import com.jefmed.voteservice.model.Session;
import com.jefmed.voteservice.model.VoteSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findByVoteSchedule(VoteSchedule voteSchedule);
}
