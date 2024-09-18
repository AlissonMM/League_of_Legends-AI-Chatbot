package com.goblenstudios.League_of_Legends_AI_Chatbot.application;

import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.model.Champion;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ListChampionsUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    List<Champion> champions;


    @Test
    @Order(1)
    public void testListChampionsFailure() {
        champions = listChampionsUseCase.findAll();
        assertNotEquals(13, champions.size());
    }
    @Test
    @Order(2)
    public void testListChampions() {
        champions = listChampionsUseCase.findAll();
        assertEquals(12, champions.size());
    }
}
