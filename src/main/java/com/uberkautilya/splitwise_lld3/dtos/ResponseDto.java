package com.uberkautilya.splitwise_lld3.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDto {
    List<Settlement> settlements;
    CalculationStatus status;
}
