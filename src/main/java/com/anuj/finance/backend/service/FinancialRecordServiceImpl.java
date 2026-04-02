package com.anuj.finance.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anuj.finance.backend.dto.FinancialRecordRequest;
import com.anuj.finance.backend.dto.FinancialRecordResponse;
import com.anuj.finance.backend.entity.FinancialRecord;
import com.anuj.finance.backend.entity.User;
import com.anuj.finance.backend.repository.FinancialRecordRepository;
import com.anuj.finance.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FinancialRecordServiceImpl implements FinancialRecordService {

    private final FinancialRecordRepository recordRepository;
    private final UserRepository userRepository;

    @Override
    public FinancialRecordResponse createRecord(FinancialRecordRequest request, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        FinancialRecord record = FinancialRecord.builder()
                .amount(request.getAmount())
                .type(request.getType())
                .category(request.getCategory())
                .date(request.getDate())
                .description(request.getDescription())
                .createdBy(user)
                .build();

        recordRepository.save(record);

        return mapToResponse(record);
    }

    @Override
    public List<FinancialRecordResponse> getAllRecords() {
        return recordRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void deleteRecord(Long id) {
        recordRepository.deleteById(id);
    }

    private FinancialRecordResponse mapToResponse(FinancialRecord record) {
        return FinancialRecordResponse.builder()
                .id(record.getId())
                .amount(record.getAmount())
                .type(record.getType())
                .category(record.getCategory())
                .date(record.getDate())
                .description(record.getDescription())
                .createdBy(record.getCreatedBy().getEmail())
                .build();
    }
}