package com.samsung.tddspringboot.repository.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Data
@Builder
public class Account {
    private String Number;

    private String Name;
    private String Email;
    private LocalDateTime CreateAt;
}
