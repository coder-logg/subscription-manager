package com.webrise.subscription.manager.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.webrise.subscription.manager.domain.Subscription;

import java.util.Date;

@JsonSerialize
public record SubscriptionDto (
        Long id,
        Long userId,
        Long streamingServiceId,
        String licenceKey,
        Date expirationDate
){
    public SubscriptionDto(Long userId, Long streamingServiceId, String licenceKey, Date expirationDate){
        this(null, userId, streamingServiceId, licenceKey, expirationDate);
    }

    public SubscriptionDto(Subscription subscription){
        this(subscription.getId(),
                subscription.getUserId(),
                subscription.getStreamingServiceId(),
                subscription.getLicenceKey(),
                subscription.getExpirationDate());
    }
}
