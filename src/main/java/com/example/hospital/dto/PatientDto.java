package com.example.hospital.dto;

import lombok.Data;

@Data
public class PatientDto {
    private String name;
    private String email;

    private HistoryDto history;
}
