package com.evoting.evotingapp.registration.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class DeleteExpiredTokenScheduler {

    ConfirmationTokenService confirmationTokenService;

    @Autowired
    public DeleteExpiredTokenScheduler(ConfirmationTokenService confirmationTokenService){
        this.confirmationTokenService = confirmationTokenService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void deleteExpiredToken(){
        System.out.println("Deleted");
        confirmationTokenService.deleteExpiredToken();
    }
}
