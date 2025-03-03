package com.webrise.subscription.manager.service;

import com.webrise.subscription.manager.domain.User;
import com.webrise.subscription.manager.dto.UserDto;
import com.webrise.subscription.manager.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create(UserDto userDto) {
        return userRepository.save(new User(userDto));
    }

    public User find(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id = " + id + " not found"));
    }

    public User update(Long id, UserDto userDto) {
        return userRepository.save(new User(userDto, id));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
