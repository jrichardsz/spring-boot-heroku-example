package net.therore.kata.zookeeper.simple.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.lang.Long;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class AlumnoRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List executeSimpleSelect() {
        return jdbcTemplate.queryForList("select 1 from dual UNION ALL select 2 from dual");
    }
}
