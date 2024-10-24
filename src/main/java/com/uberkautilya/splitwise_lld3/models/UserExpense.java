package com.uberkautilya.splitwise_lld3.models;

import com.uberkautilya.splitwise_lld3.models.enums.UserExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseEntity {
    @ManyToOne
    private User user;
    @ManyToOne
    private Expense expense;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private UserExpenseType type;
}

