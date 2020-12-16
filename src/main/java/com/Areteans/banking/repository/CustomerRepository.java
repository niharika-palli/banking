package com.Areteans.banking.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;
    public Long getbalance(Long accno){
        Map<String,Object> map2=jdbcTemplate.queryForMap("select initialbal from customer where accno=?",accno);
        return (Long)map2.get("initialbal");
    }

    public void update(Long amount, Long accno){
        jdbcTemplate.update("update customer set initialbal=? where accno=?",amount,accno);
    }
}
