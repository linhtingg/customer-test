package com.samsung.tddspringboot.repository.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String Number;
    private String Name;
    private Long Money;
}
