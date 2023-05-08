package com.example.spingsecurity.service;

import com.example.spingsecurity.entity.User;
import com.example.spingsecurity.entity.VerificationToken;
import com.example.spingsecurity.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String oldToken);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
