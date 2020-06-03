package org.step.consumer.social.network.notifications;

import lombok.Data;

@Data
public class NotificationEvent {

    private String subject;
    private String text;
    private String notificationType;
    private String id;
}
