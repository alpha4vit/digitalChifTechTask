package by.gurinovich.productservice.repository;

import by.gurinovich.productservice.entity.MeasurementTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementTypeRepository extends JpaRepository<MeasurementTypeEntity, Long> {
}
