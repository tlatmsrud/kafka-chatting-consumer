package org.ssk.domain.chatting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ssk.domain.chatting.domain.Chatting;
import org.ssk.domain.chatting.record.ChattingRecord;
import org.ssk.domain.chatting.repository.ChattingRepository;

@Service
@RequiredArgsConstructor
public class ChattingService {

    private final ChattingRepository chattingRepository;

    public void save(ChattingRecord chattingRecord){

        Chatting chatting = Chatting.builder()
                .roomId(chattingRecord.getRoomId())
                .nickname(chattingRecord.getNickname())
                .message(chattingRecord.getMessage())
                .time(chattingRecord.getTime())
                .build();

        chattingRepository.save(chatting);

    }
}
