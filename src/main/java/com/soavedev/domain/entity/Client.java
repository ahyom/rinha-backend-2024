package com.soavedev.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;


@Entity(name = "tb_client")
public class Client extends PanacheEntity {

    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "balance")
    int balance;

    @Column(name = "limite")
    int limit;

    public static Client findByIdWithLock(Long id) {
        return find("id", id).withLock(LockModeType.PESSIMISTIC_WRITE).singleResult();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
