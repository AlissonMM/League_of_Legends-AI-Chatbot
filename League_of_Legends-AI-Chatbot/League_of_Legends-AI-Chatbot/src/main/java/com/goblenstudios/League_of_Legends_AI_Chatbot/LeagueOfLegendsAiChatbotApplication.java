package com.goblenstudios.League_of_Legends_AI_Chatbot;

import com.goblenstudios.League_of_Legends_AI_Chatbot.application.ListChampionsUseCase;
import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.ports.ChampionsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication  // This is Spring tag
public class LeagueOfLegendsAiChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueOfLegendsAiChatbotApplication.class, args);
	}
	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository) {
		return new ListChampionsUseCase(repository);
	}

}
