package com.uberkautilya.splitwise_lld3.services;

import com.uberkautilya.splitwise_lld3.algorithms.SettlementAlgorithm;
import com.uberkautilya.splitwise_lld3.dtos.Settlement;
import com.uberkautilya.splitwise_lld3.exceptions.NoSuchGroupException;
import com.uberkautilya.splitwise_lld3.models.Expense;
import com.uberkautilya.splitwise_lld3.models.Group;
import com.uberkautilya.splitwise_lld3.repository.GroupRepository;

import java.util.List;

public class SplitwiseService {
    SettlementAlgorithm algorithm;
    GroupRepository groupRepository;

    public SplitwiseService(SettlementAlgorithm algorithm, GroupRepository groupRepository) {
        this.algorithm = algorithm;
        this.groupRepository = groupRepository;
    }

    public List<Settlement> getSettlements(int groupId) throws NoSuchGroupException {
        Group group = groupRepository.findById(groupId).orElseThrow(NoSuchGroupException::new);
        List<Expense> expenses = group.getExpenses();
        return algorithm.settle(expenses);
    }
}
