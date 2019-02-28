package com.robert.mentor.exposition.authentication;

public class AuthToken {

    public String token;
    public String username;
    public String userType;

    public AuthToken(String token, String username, String userType) {
        this.token = token;
        this.username = username;
        this.userType = userType;
    }
}
