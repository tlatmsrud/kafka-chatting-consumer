package org.ssk.domain.chatting.record;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
public class ChattingRecord {

    private String nickname;
    private String message;
    private String time;
    private Long roomId;

    private ChattingRecord(String nickname, String message, String time, Long roomId){
        this.nickname = nickname;
        this.message = message;
        this.time = time;
        this.roomId = roomId;
    }

    public static ChattingRecord of(String nickname, String message, String time, Long roomId){
        return new ChattingRecord(nickname, message, time, roomId);
    }
}
