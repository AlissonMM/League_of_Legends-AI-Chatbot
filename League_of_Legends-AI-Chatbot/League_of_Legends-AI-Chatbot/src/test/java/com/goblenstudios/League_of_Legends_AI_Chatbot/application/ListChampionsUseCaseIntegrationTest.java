package com.goblenstudios.League_of_Legends_AI_Chatbot.application;

import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.model.Champion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ListChampionsUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    @Test
    public void testListChampions() {
        List<Champion> champions = listChampionsUseCase.findAll();

        assertEquals(12, champions.size());
    }
}