package com.webrise.subscription.manager.service;

import com.webrise.subscription.manager.domain.StreamingService;
import com.webrise.subscription.manager.repository.SubscriptionRepository;
import com.webrise.subscription.manager.domain.Subscription;
import com.webrise.subscription.manager.dto.SubscriptionDto;
import com.webrise.subscription.manager.repository.StreamingServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private StreamingServiceRepository streamingServiceRepository;

    public Subscription create(SubscriptionDto dto) {
        return subscriptionRepository.save(new Subscription(dto));
    }

    public List<Subscription> getAllByUserId(Long userId) {
        return subscriptionRepository.findAllByUserId(userId);
    }

    public void deleteById(Long userId, Long id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subscription with id = " + id + " not found"));
        if (subscription.getUserId().equals(userId))
            subscriptionRepository.delete(subscription);
        else
            throw new IllegalArgumentException("User can delete only your own subscriptions");
    }

    public List<StreamingService> findTop3PopularServices() {
        var mostPopularServiceIds = subscriptionRepository.findFirst3PopularServices();
        return streamingServiceRepository.findAllByIdIn(mostPopularServiceIds);
    }

}
