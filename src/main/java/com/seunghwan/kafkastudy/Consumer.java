package com.seunghwan.kafkastudy;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {

    public void listen(){

        Properties configs = new Properties();

        configs.put("bootstrap.servers", "localhost:9092");
        configs.put("group.id", "test");
        configs.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        configs.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configs);
        consumer.subscribe(Arrays.asList("testData"));

        while(true){
            ConsumerRecords<String,String> records = consumer.poll(500);
            for (ConsumerRecord record:
                 records) {
                System.out.println(record.value());
            }
        }
    }
}
