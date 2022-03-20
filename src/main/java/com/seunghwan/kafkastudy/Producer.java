package com.seunghwan.kafkastudy;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class Producer {

    public void send(String value){

        Properties configs = new Properties();

        configs.put("bootstrap.servers", "localhost:9092");
        configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);

        ProducerRecord record = new ProducerRecord<String,String>("testData", value);

        producer.send(record);
        producer.close();
    }
}
