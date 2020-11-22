package com.jefmed.voteservice.repository;

import com.jefmed.voteservice.model.VoteSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteScheduleRepository extends JpaRepository<VoteSchedule, Long> {
}
