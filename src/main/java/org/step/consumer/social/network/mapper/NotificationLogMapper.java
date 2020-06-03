package org.step.consumer.social.network.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.step.consumer.social.network.model.NotificationLog;
import org.step.consumer.social.network.notifications.NotificationEvent;

@Mapper
public interface NotificationLogMapper {

    @Mappings({
            @Mapping(target = "userId", source = "event.id"),
            @Mapping(target = "id", ignore = true)
    })
    NotificationLog map(NotificationEvent event);
}
