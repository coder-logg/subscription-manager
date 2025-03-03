package com.webrise.subscription.manager.controller;

import com.webrise.subscription.manager.dto.UserDto;
import com.webrise.subscription.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto user) {
        return ResponseEntity.ok(new UserDto(userService.create(user)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(new UserDto(userService.find(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto user, @PathVariable Long id) {
        return ResponseEntity.ok(new UserDto(userService.update(id, user)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
