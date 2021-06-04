package com.bykenyodarz.market.web.security.messages;

import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;
    private static final String TYPE = "Bearer";

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}
