package org.ssk.domain.chatting.service;

import org.junit.jupiter.api.Test;
import org.ssk.domain.chatting.domain.Chatting;
import org.ssk.domain.chatting.record.ChattingRecord;
import org.ssk.domain.chatting.repository.ChattingRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class ChattingServiceTest {

    private final ChattingRepository chattingRepository = mock(ChattingRepository.class);

    private final ChattingService chattingService = new ChattingService(chattingRepository);

    @Test
    void save() {

        ChattingRecord chattingRecord =  ChattingRecord.of("nickname", "message", "20231204183030000", 1L);
        chattingService.save(chattingRecord);

        verify(chattingRepository).save(any(Chatting.class));

    }
}