package com.uberkautilya.splitwise_lld3.algorithms;

import com.uberkautilya.splitwise_lld3.dtos.Settlement;
import com.uberkautilya.splitwise_lld3.models.Expense;
import com.uberkautilya.splitwise_lld3.models.User;
import com.uberkautilya.splitwise_lld3.models.UserExpense;
import com.uberkautilya.splitwise_lld3.models.enums.UserExpenseType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AtMaxNSettlements implements SettlementAlgorithm {
    @Override
    public List<Settlement> settle(List<Expense> expenses) {
        Map<User, Double> userSpent = expenses.stream()
                .flatMap(expense -> expense.getUserExpenses().stream())
                .filter(uE -> uE.getType() == UserExpenseType.PAID_BY)
                .collect(Collectors.toMap(UserExpense::getUser, UserExpense::getAmount));
        Map<User, Double> userExpense = expenses.stream()
                .flatMap(expense -> expense.getUserExpenses().stream())
                .filter(uE -> uE.getType() == UserExpenseType.PAID_FOR)
                .collect(Collectors.toMap(UserExpense::getUser, UserExpense::getAmount));

        return List.of();
    }
}
