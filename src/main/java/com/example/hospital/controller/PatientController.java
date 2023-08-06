package com.example.hospital.controller;

import com.example.hospital.dto.PatientDto;
import com.example.hospital.entity.History;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.HistoryRepository;
import com.example.hospital.repository.PatientRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;


@RestController
public class PatientController {


    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/save")
    @Transactional
    public String save() {
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("karthik");
        patient.setEmail("kkrpcs@gmail.com");
        History history = new History();
        history.setId(1);
        history.setCaseId("2344555");
        patient.setHistory(history);
        patientRepository.save(patient);
        return "Successfully saved";
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<PatientDto> get(@PathVariable Integer id) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Patient patient = patientRepository.findById(id).get();
        PatientDto patientDto = objectMapper.convertValue(patient, PatientDto.class);
        return ResponseEntity.ok(patientDto);
    }
}
