package com.webrise.subscription.manager.repository;

import com.webrise.subscription.manager.domain.StreamingService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreamingServiceRepository extends JpaRepository<StreamingService, Long> {
    List<StreamingService> findAllByIdIn(List<Long> serviceId);
}
