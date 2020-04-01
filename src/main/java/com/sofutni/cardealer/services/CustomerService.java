package com.sofutni.cardealer.services;

import com.sofutni.cardealer.Dtos.CustomerSeedDto;

import java.util.List;

public interface CustomerService {
    void seedCustomers(List<CustomerSeedDto> customerSeedDtos);
}
