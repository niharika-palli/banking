package com.Areteans.banking.service;

import com.Areteans.banking.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerRepository customerRepository;
    public Map<String,Object> save(Map<String,Object> customer){
        jdbcTemplate.update("insert into customer(cname,accno,acctype,initialbal)values(?,?,?,?)returning cid",
                customer.get("name"),
                customer.get("accno"),
                customer.get("acctype"),
                customer.get("initialbal"));
        return customer;
    }

    public Long withdraw(Long amount,Long accno){
        Long initialbal=customerRepository.getbalance(accno);
        initialbal=initialbal-amount;
        customerRepository.update(initialbal,accno);
        return customerRepository.getbalance(accno);
    }

    public Long deposit(Long amount,Long accno){
        Long initialbal=customerRepository.getbalance(accno);
        initialbal=initialbal+amount;
        customerRepository.update(initialbal,accno);
        return customerRepository.getbalance(accno);
    }

}
