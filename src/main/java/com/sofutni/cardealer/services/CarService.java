package com.sofutni.cardealer.services;

import com.sofutni.cardealer.Dtos.CarsSeedDto;
import com.sofutni.cardealer.Dtos.CarsSeedRootDto;

import java.util.List;

public interface CarService  {
    void seedCars(List<CarsSeedDto> carsSeedDtoList);
}
