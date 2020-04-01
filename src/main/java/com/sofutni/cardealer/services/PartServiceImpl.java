package com.sofutni.cardealer.services;

import com.sofutni.cardealer.Dtos.PartSeedDto;
import com.sofutni.cardealer.entitiess.Part;
import com.sofutni.cardealer.entitiess.Supplier;
import com.sofutni.cardealer.repositories.PartRepository;
import com.sofutni.cardealer.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class PartServiceImpl implements PartService {
    private final ValidationUtil validationUtil;
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final Random random;
    private final SupplierService supplierService;


    public PartServiceImpl(ValidationUtil validationUtil, PartRepository partRepository, ModelMapper modelMapper, Random random, SupplierService supplierService) {
        this.validationUtil = validationUtil;
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.random = random;

        this.supplierService = supplierService;
    }


    @Override
    public void seedParts(List<PartSeedDto> partSeedDtos) {
        for (PartSeedDto dto : partSeedDtos) {
            if (!this.validationUtil.isValid(dto)) {
                this.validationUtil.getViolations(dto).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                continue;
            }
            Part map = this.modelMapper.map(dto, Part.class);
            int random = this.random.nextInt(this.supplierService.getAllSuppliers()) + 1;

            map.setSupplier(this.supplierService.getSupplierById(random));


            if (this.partRepository.findByName(map.getName()) == null) {
                this.partRepository.saveAndFlush(map);
                System.out.println(
                        String.format("Supplier with %s name successfully registered in the db!", map.getName()));
            } else {
                System.out.println(String.format("Supplier with %s name already exists!", map.getName()));
            }
        }
    }

    @Override
    public List<Part> getRandomNumberParts(int number) {
        List<Part> randomParts = new ArrayList<>();


        for (int i = 0; i <number ; i++) {
            Part one = this.partRepository.findById(number);
            randomParts.add(one);
        }
        return randomParts;
    }
}
