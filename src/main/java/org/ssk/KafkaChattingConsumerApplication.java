package org.ssk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaChattingConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaChattingConsumerApplication.class, args);
    }
}
