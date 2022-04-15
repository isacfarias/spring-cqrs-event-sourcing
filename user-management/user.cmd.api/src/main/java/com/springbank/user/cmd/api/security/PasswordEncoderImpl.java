package com.springbank.user.cmd.api.security;

import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderImpl implements PasswordEncoder {
    @Override
    public String hashPassword(String password) {
        return null;
    }
}
