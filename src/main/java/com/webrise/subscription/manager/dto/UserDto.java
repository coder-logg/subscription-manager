package com.webrise.subscription.manager.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.webrise.subscription.manager.domain.User;

@JsonSerialize
public record UserDto(
        Long id,
        String nickname,
        String email,
        String fio
) {
    public UserDto(String nickname, String email, String fio) {
        this(null, nickname, email, fio);
    }

    public UserDto(User user) {
        this(user.getId(), user.getNickname(), user.getEmail(), user.getFio());
    }
}
