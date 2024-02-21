package com.soavedev.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity(name = "tb_transaction")
public class Transaction extends PanacheEntity {
        @Column(name = "id")
        Long id;

        @Column(name = "amount")
        int amount;

        @Column(name = "type")
        String type;

        @Column(name = "description")
        String description;

        @Column(name = "created_at")
        ZonedDateTime createdAt;

        @ManyToOne
        @JoinColumn(name = "client_id", nullable = false)
        Client client;

        public static List<Transaction> findLast10TransactionsByClientId(Long clientId) {
                return find("client.id = ?1 ORDER BY createdAt DESC", clientId)
                        .range(0, 9)
                        .list();
        }

        public void setAmount(int amount) {
                this.amount = amount;
        }

        public void setType(String type) {
                this.type = type;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setCreatedAt(ZonedDateTime createdAt) {
                this.createdAt = createdAt;
        }

        public void setClient(Client client) {
                this.client = client;
        }

        public Long getId() {
                return id;
        }

        public int getAmount() {
                return amount;
        }

        public String getType() {
                return type;
        }

        public String getDescription() {
                return description;
        }

        public ZonedDateTime getCreatedAt() {
                return createdAt;
        }

        public Client getClient() {
                return client;
        }
}
