package com.sofutni.cardealer.services;

import com.sofutni.cardealer.Dtos.SupplierSeedDto;
import com.sofutni.cardealer.entitiess.Supplier;

import java.util.List;

public interface SupplierService {

    void seed(List<SupplierSeedDto> supplierSeedDtoList);
    int getAllSuppliers();
    Supplier getSupplierById(long id);
}
