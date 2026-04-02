package com.anuj.finance.backend.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anuj.finance.backend.dto.FinancialRecordRequest;
import com.anuj.finance.backend.dto.FinancialRecordResponse;
import com.anuj.finance.backend.service.FinancialRecordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class FinancialRecordController {

    private final FinancialRecordService recordService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public FinancialRecordResponse create(@RequestBody FinancialRecordRequest request,
            Authentication authentication) {

        return recordService.createRecord(request, authentication.getName());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public FinancialRecordResponse update(@PathVariable Long id,
            @RequestBody FinancialRecordRequest request) {
        return recordService.updateRecord(id, request);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public List<FinancialRecordResponse> getAll() {
        return recordService.getAllRecords();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long id) {
        recordService.deleteRecord(id);
        return "Deleted successfully";
    }
}