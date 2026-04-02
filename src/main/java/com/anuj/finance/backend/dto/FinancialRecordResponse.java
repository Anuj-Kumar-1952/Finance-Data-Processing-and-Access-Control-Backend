package com.anuj.finance.backend.dto;

import com.anuj.finance.backend.entity.RecordType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class FinancialRecordResponse {

    private Long id;
    private Double amount;
    private RecordType type;
    private String category;
    private LocalDate date;
    private String description;
    private String createdBy;
}