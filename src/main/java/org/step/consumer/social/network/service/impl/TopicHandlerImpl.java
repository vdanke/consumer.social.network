package org.step.consumer.social.network.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.step.consumer.social.network.mapper.NotificationLogMapper;
import org.step.consumer.social.network.mapper.jsonb.JsonMapper;
import org.step.consumer.social.network.model.NotificationLog;
import org.step.consumer.social.network.notifications.NotificationEvent;
import org.step.consumer.social.network.repository.NotificationLogRepository;
import org.step.consumer.social.network.service.TopicHandler;

@Component
@RequiredArgsConstructor
@Slf4j
public class TopicHandlerImpl implements TopicHandler {

    private final JsonMapper jsonMapper;
    private final NotificationLogRepository notificationLogRepository;
    private final NotificationLogMapper notificationLogMapper;

    @Override
    public void handleMessage(String topic) {
        NotificationEvent notificationEvent = jsonMapper.deserializeToNotificationEvent(topic);

        NotificationLog notificationLog = notificationLogMapper.map(notificationEvent);

        NotificationLog save = notificationLogRepository.save(notificationLog);

        log.info(save.toString());
    }
}
