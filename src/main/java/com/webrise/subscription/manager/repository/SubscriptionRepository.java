package com.webrise.subscription.manager.repository;

import com.webrise.subscription.manager.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findAllByUserId(Long userId);

    @Query(value = """
            SELECT streaming_service_id
            FROM subscription
            GROUP BY streaming_service_id
            ORDER BY COUNT(*) DESC, streaming_service_id
            LIMIT 3;
    """, nativeQuery = true)
    List<Long> findFirst3PopularServices();
}
