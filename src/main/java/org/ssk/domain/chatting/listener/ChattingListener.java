package org.ssk.domain.chatting.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.ssk.domain.chatting.record.ChattingRecord;
import org.ssk.domain.chatting.service.ChattingService;

@Component
@RequiredArgsConstructor
@Slf4j
public class ChattingListener {

    private final ChattingService chattingService;

    @KafkaListener(
            topics = "chatting", groupId = "chatting-group", containerFactory = "customContainerFactory")
    public void listen(ChattingRecord chattingRecord){

        log.info(chattingRecord.toString());
        chattingService.save(chattingRecord);
    }

}
