package com.uberkautilya.splitwise_lld3.algorithms;

import com.uberkautilya.splitwise_lld3.dtos.Settlement;
import com.uberkautilya.splitwise_lld3.models.Expense;

import java.util.List;

public interface SettlementAlgorithm {
    public List<Settlement> settle(List<Expense> expenses);
}
