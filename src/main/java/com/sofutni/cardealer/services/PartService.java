package com.sofutni.cardealer.services;

import com.sofutni.cardealer.Dtos.PartSeedDto;
import com.sofutni.cardealer.Dtos.PartSeedRootDto;
import com.sofutni.cardealer.entitiess.Part;

import java.util.List;

public interface PartService {
    void seedParts(List<PartSeedDto> partSeedDtos);
    List<Part> getRandomNumberParts(int number);
}
