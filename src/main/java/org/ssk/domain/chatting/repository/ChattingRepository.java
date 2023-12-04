package org.ssk.domain.chatting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ssk.domain.chatting.domain.Chatting;

public interface ChattingRepository extends JpaRepository<Chatting, Long>{
}
