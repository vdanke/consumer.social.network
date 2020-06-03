package org.step.consumer.social.network.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_log")
@Data
@EntityListeners(value = {AuditingEntityListener.class})
public class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String text;
    private String userId;
    private String notificationType;

    @CreatedDate
    private LocalDateTime createdAt;
}
