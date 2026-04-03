package com.anuj.finance.backend.service;

import com.anuj.finance.backend.dto.FinancialRecordRequest;
import com.anuj.finance.backend.dto.FinancialRecordResponse;
import com.anuj.finance.backend.dto.PaginatedResponse;

public interface FinancialRecordService {

    FinancialRecordResponse createRecord(FinancialRecordRequest request, String userEmail);

    PaginatedResponse<FinancialRecordResponse> getAllRecords(int page, int size,String type);

    FinancialRecordResponse updateRecord(Long id, FinancialRecordRequest request, String Email);

    void deleteRecord(Long id);
}