package com.anuj.finance.backend.dto;

import com.anuj.finance.backend.entity.RecordType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FinancialRecordRequest {

    @NotNull
    private Double amount;

    @NotNull
    private RecordType type;

    private String category;

    private LocalDate date;

    private String description;
}