package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.grpc.BillingServiceGrpcClient;
import com.pm.patientservice.kafka.KafkaProducer;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    //private final BillingServiceGrpcClient billingServiceGrpcClient;
    //private final KafkaProducer kafkaProducer;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        //this.billingServiceGrpcClient = billingServiceGrpcClient;
        //this.kafkaProducer = kafkaProducer;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

//        List<PatientResponseDTO> patientResponseDTOs =
//                patients.stream().map(PatientMapper::toDTO).toList();

        return patients.stream().map(PatientMapper::toDTO).toList();
    }


}