package kz.medet.trello.service;

import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    Boolean signUp(String email, String password, String repeatPassword, String fullName);
    Boolean updatePassword(String oldPassword, String newPassword, String repeatNewPassword);
}
