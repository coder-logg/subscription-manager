package com.webrise.subscription.manager.domain;

import com.webrise.subscription.manager.dto.SubscriptionDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(name = "streaming_service_id", nullable = false)
    private Long streamingServiceId;

    private String licenceKey;

    @Column(nullable = false)
    private Date expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private StreamingService streamingService;

    public Subscription(Long id, Long userId, Long streamingServiceId, String licenceKey, Date expirationDate) {
        this.id = id;
        this.userId = userId;
        this.streamingServiceId = streamingServiceId;
        this.licenceKey = licenceKey;
        this.expirationDate = expirationDate;
    }

    public Subscription(Long userId, Long streamingServiceId, String licenceKey, Date expirationDate) {
        this.userId = userId;
        this.streamingServiceId = streamingServiceId;
        this.licenceKey = licenceKey;
        this.expirationDate = expirationDate;
    }

    public Subscription(SubscriptionDto dto) {
        this(dto.id(), dto.userId(), dto.streamingServiceId(), dto.licenceKey(), dto.expirationDate());
    }
}
