package com.example.kafkatest.controller;

import com.example.kafkatest.beans.StuInfo;
import com.example.kafkatest.beans.StuInfoExample;
import com.example.kafkatest.dao.StuInfoDao;
import com.example.kafkatest.kafka.KafkaProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Description kafka 测试
 * @Auther lym
 * @Date 2021-09-07 11:26
 * @Version 1.0
 */

@Slf4j
@Api(value = "/kafka")
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer producer;
    @Autowired
    private StuInfoDao stuInfoDao;

    @GetMapping("/send")
    //    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "get方式发送消息到kafka")
    public String sendTest1() {
        List<StuInfo> list = stuInfoDao.selectByExample(new StuInfoExample());
        try {
            producer.send(list);
        } catch (UnsupportedEncodingException e) {
            log.error("字符串编码格式转换异常....");
        }
        return "success";
    }


    @PostMapping("/send")
    //    @Transactional(rollbackFor = Exception.class)
    @ApiOperation(value = "post方式发送消息到kafka")
    public String sendTest2(@RequestBody @ApiParam StuInfo info) {
        StuInfoExample example = new StuInfoExample();
        example.setOrderByClause("age");
        List<StuInfo> list = stuInfoDao.selectByExample(example);
        try {
            producer.send(list);
        } catch (UnsupportedEncodingException e) {
            log.error("字符串编码格式转换异常....");
        }
        return "success";
    }


}
