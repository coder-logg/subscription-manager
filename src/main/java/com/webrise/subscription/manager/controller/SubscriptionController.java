package com.webrise.subscription.manager.controller;

import com.webrise.subscription.manager.service.SubscriptionService;
import com.webrise.subscription.manager.dto.StreamingServiceDto;
import com.webrise.subscription.manager.dto.SubscriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/users/{id}/subscriptions")
    public ResponseEntity<SubscriptionDto> subscribe(@PathVariable("id") Long userId, @RequestBody SubscriptionDto subscription) {
        return ResponseEntity.ok(new SubscriptionDto(subscriptionService.create(subscription)));
    }

    @GetMapping("/users/{id}/subscriptions")
    public ResponseEntity<List<SubscriptionDto>> getAllForUser(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(subscriptionService.getAllByUserId(userId).stream().map(SubscriptionDto::new).toList());
    }

    @DeleteMapping("/users/{id}/subscriptions/{sub_id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long userId, @PathVariable("sub_id") Long subscriptionId) {
        subscriptionService.deleteById(userId, subscriptionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/subscriptions/top")
    public ResponseEntity<List<StreamingServiceDto>> getTopSubscriptions() {
        return ResponseEntity.ok(subscriptionService.findTop3PopularServices().stream().map(StreamingServiceDto::new).toList());
    }
}
