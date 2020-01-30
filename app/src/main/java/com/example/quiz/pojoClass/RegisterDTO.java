package com.example.quiz.pojoClass;

import java.util.List;

public class RegisterDTO {
    String name;
    String emailAddress;
    String password;
    String channel;
    String profile;
    String role;
    List<InterestDTO> interest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<InterestDTO> getInterest() {
        return interest;
    }

    public void setInterest(List<InterestDTO> interest) {
        this.interest = interest;
    }
}
