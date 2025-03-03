package com.webrise.subscription.manager.domain;

import com.webrise.subscription.manager.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nickname;

    @Column(unique = true)
    private String email;

    private String fio;

    @OneToMany(mappedBy = "userId")
    private List<Subscription> subscriptions;

    public User(UserDto dto) {
        this.nickname = dto.nickname();
        this.email = dto.email();
        this.fio = dto.fio();
    }

    public User(String nickname, String email, String fio) {
        this.nickname = nickname;
        this.email = email;
        this.fio = fio;
    }

    public User(UserDto dto, Long id) {
        this.id = id;
        this.nickname = dto.nickname();
        this.email = dto.email();
        this.fio = dto.fio();
    }
}
