package by.gurinovich.productservice.service.impl;

import by.gurinovich.productservice.entity.MeasurementTypeEntity;
import by.gurinovich.productservice.repository.MeasurementTypeRepository;
import by.gurinovich.productservice.service.MeasurementTypeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeasurementTypeServiceImpl implements MeasurementTypeService {

    private final MeasurementTypeRepository measurementTypeRepository;

    @Override
    public MeasurementTypeEntity getById(Long id) {
        return measurementTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Measurement type with this id not found!"));
    }
}
