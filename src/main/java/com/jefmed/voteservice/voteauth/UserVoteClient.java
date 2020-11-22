package com.jefmed.voteservice.voteauth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://user-info.herokuapp.com/users/", name = "CPFVerify")
public interface UserVoteClient {
    @GetMapping("{status}")
    UserVoteAuth getStatus(@PathVariable("status") String cpf);
}
