package com.jefmed.voteservice.repository;

import com.jefmed.voteservice.model.Vote;
import com.jefmed.voteservice.model.VoteSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Long countByVoteScheduleAndVoteTrue(VoteSchedule voteSchedule);
    Long countByVoteScheduleAndVoteFalse(VoteSchedule voteSchedule);
}
