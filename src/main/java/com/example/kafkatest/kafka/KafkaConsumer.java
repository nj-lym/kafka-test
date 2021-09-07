package com.example.kafkatest.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Description 消费者
 * @Auther lym
 * @Date 2021-09-07 14:06
 * @Version 1.0
 */
@Component
@Slf4j
public class KafkaConsumer {

    /**
     * 监听groupId 为 TOPIC_GROUP1的消息 并消费
     * [消费指定 groupId 的消息]
     * @param record
     * @param ack
     * @param topic
     */
    @KafkaListener(topics = KafkaProducer.TOPIC_TEST, groupId = KafkaProducer.TOPIC_GROUP1)
    public void consumer1(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("消费了: topic: " + topic + " message: " + msg);
            ack.acknowledge();
        }
    }

    /**
     * [消费指定 groupId 的消息]
     * @param record
     * @param ack
     * @param topic
     */
    @KafkaListener(topics = KafkaProducer.TOPIC_TEST, groupId = KafkaProducer.TOPIC_GROUP2)
    public void consumer2(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            Object msg = message.get();
            log.info("消费了: topic: " + topic + " message: " + msg);
            ack.acknowledge();
        }
    }
}
