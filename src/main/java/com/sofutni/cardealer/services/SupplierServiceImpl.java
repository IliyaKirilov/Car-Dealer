package com.sofutni.cardealer.services;

import com.sofutni.cardealer.Dtos.SupplierSeedDto;
import com.sofutni.cardealer.entitiess.Supplier;
import com.sofutni.cardealer.repositories.SupplierRepository;
import com.sofutni.cardealer.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seed(List<SupplierSeedDto> supplierSeedDtoList) {

        for (SupplierSeedDto dto : supplierSeedDtoList) {
            if (!this.validationUtil.isValid(dto)) {
                this.validationUtil.getViolations(dto).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                continue;
            }
            Supplier map = this.modelMapper.map(dto, Supplier.class);
            if (this.supplierRepository.findByName(map.getName()) == null) {
                this.supplierRepository.saveAndFlush(map);
                System.out.println(
                        String.format("Supplier with %s name successfully registered in the db!", map.getName()));
            } else {
                System.out.println(String.format("Supplier with %s name already exists!", map.getName()));
            }
        }

    }

    @Override
    public int getAllSuppliers() {

        return (int) this.supplierRepository.count();
    }

    @Override
    public Supplier getSupplierById(long id) {
        return this.supplierRepository.findById(id);
    }
}
