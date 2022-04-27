package com.springbank.user.query.api.dto;

import com.springbank.user.core.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserLookupResponse {
    private List<User> users;

    public UserLookupResponse(User user) {
        this.users = List.of(user);
    }
}