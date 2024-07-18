package by.gurinovich.productservice.controller;

import by.gurinovich.productservice.entity.MeasurementTypeEntity;
import by.gurinovich.productservice.service.MeasurementTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/measurement/type")
public class MeasurementTypeController {

    private final MeasurementTypeService measurementTypeService;

    @GetMapping
    public ResponseEntity<List<MeasurementTypeEntity>> getAll(){
        var measurements = measurementTypeService.getAll();
        return ResponseEntity.ok(measurements);
    }
}
