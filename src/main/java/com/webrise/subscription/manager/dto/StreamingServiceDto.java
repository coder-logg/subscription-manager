package com.webrise.subscription.manager.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.webrise.subscription.manager.domain.StreamingService;

@JsonSerialize
public record StreamingServiceDto(
        Long id,
        String name,
        String url,
        String description
) {
    public StreamingServiceDto(StreamingService streamingService) {
        this(streamingService.getId(), streamingService.getName(), streamingService.getUrl(), streamingService.getDescription());
    }
}