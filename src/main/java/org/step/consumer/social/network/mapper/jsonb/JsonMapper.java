package org.step.consumer.social.network.mapper.jsonb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.step.consumer.social.network.exception.SerializationJsonException;
import org.step.consumer.social.network.notifications.NotificationEvent;

@Component
public class JsonMapper {

    private final ObjectMapper mapper = new ObjectMapper();

    public NotificationEvent deserializeToNotificationEvent(String notificationEvent) {
        try {
            return mapper.readValue(notificationEvent, NotificationEvent.class);
        } catch (JsonProcessingException e) {
            throw new SerializationJsonException(String.format("Cannot deserialize %s", e.getMessage()), e);
        }
    }

    public String serializeNotificationEventToString(NotificationEvent event) {
        try {
            return mapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new SerializationJsonException(String.format("Cannot serialize %s", e.getMessage()), e);
        }
    }
}
