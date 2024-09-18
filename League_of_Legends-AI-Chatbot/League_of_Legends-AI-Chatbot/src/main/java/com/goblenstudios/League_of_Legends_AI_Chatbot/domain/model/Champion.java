package com.goblenstudios.League_of_Legends_AI_Chatbot.domain.model;

// Classe com nomes e atributos do campeão
public record Champion(
    Long id,
    String name,
    String role,
    String lore,
    String imageUrl

){
}


