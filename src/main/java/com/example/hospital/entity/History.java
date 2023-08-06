package com.example.hospital.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String caseId;
}
