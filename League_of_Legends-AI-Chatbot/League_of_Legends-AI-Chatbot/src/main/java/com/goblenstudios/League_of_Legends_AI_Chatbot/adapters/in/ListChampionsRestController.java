package com.goblenstudios.League_of_Legends_AI_Chatbot.adapters.in;

import com.goblenstudios.League_of_Legends_AI_Chatbot.application.ListChampionsUseCase;
import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.ports.ChampionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.model.Champion;

import java.util.List;
import java.util.Optional;

// Porta de entrada dos dados. Os chegarão do front-end até aqui
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase, ChampionsRepository repository) {
    @GetMapping()
    public List<Champion> findAllChampions(){
            return useCase.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Champion> findAllChampions(@PathVariable("id")Long id){
        return repository.findById(id);
    }
}