package com.Areteans.banking.controller;

import com.Areteans.banking.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="bank")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping(path="insert",consumes= MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> createdetails(@RequestBody Map<String,Object> customer){
        return this.customerService.save(customer);
    }

    @PostMapping(path="depo",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long depoc(@RequestBody Map<String,Object> map){
        return customerService.deposit(Long.valueOf((String)map.get("amount")),Long.valueOf((String)map.get("accno")));
    }

    @PostMapping(path="withdraw",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long withdraw(@RequestBody Map<String,Object> map){
        return customerService.withdraw(Long.valueOf((String)map.get("amount")),
                Long.valueOf((String)map.get("accno")));
    }
}
