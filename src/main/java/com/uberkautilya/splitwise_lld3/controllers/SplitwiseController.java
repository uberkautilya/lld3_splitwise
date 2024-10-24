package com.uberkautilya.splitwise_lld3.controllers;

import com.uberkautilya.splitwise_lld3.dtos.CalculationStatus;
import com.uberkautilya.splitwise_lld3.dtos.RequestDto;
import com.uberkautilya.splitwise_lld3.dtos.ResponseDto;
import com.uberkautilya.splitwise_lld3.dtos.Settlement;
import com.uberkautilya.splitwise_lld3.exceptions.NoSuchGroupException;
import com.uberkautilya.splitwise_lld3.services.SplitwiseService;

import java.util.List;

public class SplitwiseController {
    SplitwiseService service;

    public SplitwiseController(SplitwiseService service) {
        this.service = service;
    }

    public ResponseDto settleGroup(RequestDto requestDto) {
        ResponseDto response = new ResponseDto();
        Long groupId = requestDto.getGroupId();
        try {
            List<Settlement> settlements = service.getSettlements(groupId);
            response.setSettlements(settlements);
            response.setStatus(CalculationStatus.SUCCESS);
        } catch (NoSuchGroupException e) {
            response.setStatus(CalculationStatus.FAILURE);
        }
        return response;
    }
}
