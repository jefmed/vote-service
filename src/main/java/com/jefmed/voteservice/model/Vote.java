package com.jefmed.voteservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private VoteSchedule voteSchedule;

    private Boolean vote;
    private String cpf;

    public Vote(VoteSchedule voteSchedule, Boolean vote, String cpf) {
        this.voteSchedule = voteSchedule;
        this.vote = vote;
        this.cpf = cpf;
    }
}
