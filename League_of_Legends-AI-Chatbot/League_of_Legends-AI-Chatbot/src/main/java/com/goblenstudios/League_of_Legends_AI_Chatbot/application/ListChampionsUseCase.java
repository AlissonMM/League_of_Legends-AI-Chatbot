package com.goblenstudios.League_of_Legends_AI_Chatbot.application;
import java.util.*;
import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.model.Champions;
import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.ports.ChampionsRepository;

    // Essa classe não acessa o Spring :P
public record ListChampionsUseCase (ChampionsRepository repository){

    public List<Champions> findAll() {
        return repository.findAll();
    }
}
