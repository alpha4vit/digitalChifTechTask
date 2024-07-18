package by.gurinovich.productservice.service;


import by.gurinovich.productservice.entity.MeasurementTypeEntity;

import java.util.List;

public interface MeasurementTypeService {

    MeasurementTypeEntity getById(Long id);

    List<MeasurementTypeEntity> getAll();

}
