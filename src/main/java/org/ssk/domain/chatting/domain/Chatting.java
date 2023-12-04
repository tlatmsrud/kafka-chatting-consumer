package org.ssk.domain.chatting.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "tbl_chatting")
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Chatting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private Long roomId;
    private String nickname;
    private String message;
    private String time;
}
