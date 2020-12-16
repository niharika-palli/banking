package com.Areteans.banking.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private String name;
    private String accno;
    private String accounttype;
    private float initialbal;

    public Customer(String name, String accno, String accounttype, float initialbal) {
        this.name = name;
        this.accno = accno;
        this.accounttype = accounttype;
        this.initialbal = initialbal;
    }
}
