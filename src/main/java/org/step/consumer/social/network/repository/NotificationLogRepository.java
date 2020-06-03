package org.step.consumer.social.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.step.consumer.social.network.model.NotificationLog;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}
