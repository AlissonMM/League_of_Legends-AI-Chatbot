package com.goblenstudios.League_of_Legends_AI_Chatbot.adapters.out;

import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.model.Champions;
import com.goblenstudios.League_of_Legends_AI_Chatbot.domain.ports.ChampionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChapionsJdbcRepository implements ChampionsRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Champions> rowMapper;

//    @Autowired
//    Champions champions;

    // Injeção de dependência >:)
    public ChapionsJdbcRepository(JdbcTemplate jdbcTemplate) {
        // Mapear dados
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> new Champions(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }

    @Override
    public List<Champions> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHAMPIONS", rowMapper);


    }

    @Override
    public Optional<Champions> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE ID = ?";
        Champions champion = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return Optional.ofNullable(champion);
    }
}
