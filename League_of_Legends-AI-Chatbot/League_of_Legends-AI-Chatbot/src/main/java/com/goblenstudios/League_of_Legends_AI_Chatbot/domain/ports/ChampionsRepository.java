package com.goblenstudios.League_of_Legends_AI_Chatbot.domain.ports;

import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.model.Champion;

import java.util.List;
import java.util.Optional;


// Boas práticas, caso for fazer transição de framework, usar outras ferramentas
public interface ChampionsRepository {
    List<Champion> findAll();

    // Note que não está sendo usado Spring no domain
    // para nao depender de framework (clean architecture)
    Optional<Champion> findById(Long id);
}
