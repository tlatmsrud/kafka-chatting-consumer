package org.ssk.global.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ConsumerAwareRebalanceListener;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.ssk.domain.chatting.record.ChattingRecord;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaListenerConfig {

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, ChattingRecord>> customContainerFactory(){


        DefaultKafkaConsumerFactory<String, ChattingRecord> cf = new DefaultKafkaConsumerFactory<>(
                createProperties(), new StringDeserializer(), createJsonDeserializer());

        ConcurrentKafkaListenerContainerFactory<String, ChattingRecord> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.getContainerProperties().setConsumerRebalanceListener(new ConsumerAwareRebalanceListener() {
            @Override
            public void onPartitionsRevokedBeforeCommit(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
                System.out.println("onPartitionsRevokedBeforeCommit");
            }

            @Override
            public void onPartitionsRevokedAfterCommit(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
                System.out.println("onPartitionsRevokedAfterCommit");
            }

            @Override
            public void onPartitionsLost(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
                System.out.println("onPartitionsLost");
            }

            @Override
            public void onPartitionsAssigned(Consumer<?, ?> consumer, Collection<TopicPartition> partitions) {
                System.out.println("onPartitionsAssigned");
            }
        });

        factory.setBatchListener(false);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
        factory.setConsumerFactory(cf);
        return factory;
    }

    private Map<String, Object> createProperties(){

        Map<String, Object > props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return props;
    }

    private JsonDeserializer<ChattingRecord> createJsonDeserializer(){
        JsonDeserializer<ChattingRecord> jsonDeserializer = new JsonDeserializer<>(ChattingRecord.class);
        jsonDeserializer.setUseTypeMapperForKey(false);
        jsonDeserializer.addTrustedPackages("*");

        return jsonDeserializer;
    }
}
