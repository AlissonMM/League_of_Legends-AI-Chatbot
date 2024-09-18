package com.goblenstudios.League_of_Legends_AI_Chatbot.adapters.out;

import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.model.Champion;
import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.ports.ChampionsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


// É uma classe que interage com o banco de dados

@Repository
public class ChampionsJdbcRepository implements ChampionsRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Champion> championsRowMapper;


    // Pega os valores do BD e lança nas variáveis aqui do projeto
    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.championsRowMapper = (rs, rowNum) -> new Champion(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }

    @Override
    public List<Champion> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHAMPIONS", championsRowMapper);
    }

    @Override
    public Optional<Champion> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?";
        Champion champion = jdbcTemplate.queryForObject(sql, championsRowMapper, id);
        return Optional.ofNullable(champion);
    }
}