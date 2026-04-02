package com.anuj.finance.backend.service;

import com.anuj.finance.backend.dto.FinancialRecordRequest;
import com.anuj.finance.backend.dto.FinancialRecordResponse;

import java.util.List;

public interface FinancialRecordService {

    FinancialRecordResponse createRecord(FinancialRecordRequest request, String userEmail);

    List<FinancialRecordResponse> getAllRecords();

    void deleteRecord(Long id);
}