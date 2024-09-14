package com.goblenstudios.League_of_Legends_AI_Chatbot.domain.ports;

import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
    List<Champions> findAll();

    // Note que não está sendo usado Spring no domain
    // para nao depender de framework (clean architecture)
    Optional<Champions> findById(Long id);
}
