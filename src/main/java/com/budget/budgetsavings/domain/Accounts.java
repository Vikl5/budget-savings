package com.budget.budgetsavings.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "accounts")
public class Accounts {

    @Id
    @Column(name = "pk_id")
    private Long id;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "balance")
    private Float balance;

    @Column(name = "currency")
    private String currency;

    @Column(name = "owner")
    private String owner;


}
