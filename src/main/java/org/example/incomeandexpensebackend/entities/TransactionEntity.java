package org.example.incomeandexpensebackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.incomeandexpensebackend.enums.CategoryEnum;
import org.example.incomeandexpensebackend.enums.TransactionTypeEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "amount")
    private double amount;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "debt_id")
    private DebtEntity debt;
}
