package org.step.consumer.social.network.configuration.rabbitmq;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.step.consumer.social.network.service.TopicHandler;

@Configuration
public class RabbitMQConfiguration {

    public static final String EXCHANGE = "my-exchange";
    public static final String FIRST_QUEUE = "my-exchange-queue-first";
    public static final String SECOND_QUEUE = "my-exchange-queue-second";

    @Bean
    public MessageListenerAdapter adapter(TopicHandler handler) {
        return new MessageListenerAdapter(handler, "handleMessage");
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory factory,
                                                    MessageListenerAdapter adapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        container.setConnectionFactory(factory);
        container.setQueueNames(FIRST_QUEUE, SECOND_QUEUE);
        container.setMessageListener(adapter);

        return container;
    }
}
