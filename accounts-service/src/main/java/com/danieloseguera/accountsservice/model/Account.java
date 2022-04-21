package com.danieloseguera.accountsservice.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Data
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "owner_name", length = 100)
    private String ownerName;

    @Column(name = "bank_name", length = 50)
    private String bankName;

    @Column(name = "interbank_key", length = 20, unique = true)
    private String interbankKey;

    @Column(name = "relationship", length = 50)
    private String relationship;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
