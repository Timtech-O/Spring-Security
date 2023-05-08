package com.example.spingsecurity.event.listener;

import com.example.spingsecurity.entity.User;
import com.example.spingsecurity.event.RegistrationCompleteEvent;
import com.example.spingsecurity.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create the verification for the user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //send mail to user
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;


        //send Verification Email
        log.info("Click the link to verify your account: {}", url);

    }
}
