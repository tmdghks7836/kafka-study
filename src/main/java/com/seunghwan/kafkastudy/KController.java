package com.seunghwan.kafkastudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
public class KController {

    @Autowired
    Producer producer;

    @PostMapping("/{value}")
    public void topic(@PathVariable String value){

        producer.send(value);
    }
}
