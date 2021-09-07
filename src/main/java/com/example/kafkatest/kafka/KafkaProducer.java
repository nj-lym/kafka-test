package com.example.kafkatest.kafka;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;

import java.io.UnsupportedEncodingException;

/**
 * @Description 生产者
 * @Auther lym
 * @Date 2021-09-07 13:37
 * @Version 1.0
 */
@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public final static String TOPIC_TEST = "topic_test";

    public final static String TOPIC_GROUP1 = "group_one";
    public final static String TOPIC_GROUP2 = "group_two";

    /**
     * 发送
     * @param obj
     */
    public void send(Object obj) throws UnsupportedEncodingException {
        String objStr = new String(JSONObject.toJSONString(obj).getBytes("utf-8"), "utf-8");
        log.info("准备发送消息: {}", objStr);
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPIC_TEST, objStr);
        //        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
        //            @Override
        //            public void onFailure(Throwable throwable) {
        //                log.info(TOPIC_TEST + " 消息发送失败原因为: {}", throwable.getMessage());
        //            }
        //
        //            @Override
        //            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
        //                log.info(TOPIC_TEST + " 消息发送成功: " + stringObjectSendResult.toString());
        //            }
        //        });
        // ----------- 方式二---------------
        future.addCallback(new SuccessCallback<SendResult<String, Object>>() {
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info(TOPIC_TEST + " 消息发送成功: " + result.toString());
            }
        }, new FailureCallback() {
            @Override
            public void onFailure(Throwable ex) {
                log.info(TOPIC_TEST + " 消息发送失败原因为: {}", ex.getMessage());
            }
        });
    }
}
