package com.uberkautilya.splitwise_lld3.models;

import com.uberkautilya.splitwise_lld3.models.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Expense extends BaseEntity {
    String description;
    Double amount;
    @ManyToOne
    Group group;
    @ManyToOne
    User createdBy;
    @Enumerated(EnumType.STRING)
    ExpenseType type;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "expense")
    List<UserExpense> userExpenses;
}
