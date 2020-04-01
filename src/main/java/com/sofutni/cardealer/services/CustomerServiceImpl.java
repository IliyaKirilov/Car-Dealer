package com.sofutni.cardealer.services;

import com.sofutni.cardealer.Dtos.CustomerSeedDto;
import com.sofutni.cardealer.Dtos.SupplierSeedDto;
import com.sofutni.cardealer.entitiess.Customer;
import com.sofutni.cardealer.entitiess.Supplier;
import com.sofutni.cardealer.repositories.CustomerRepository;
import com.sofutni.cardealer.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
        private final ValidationUtil validationUtil;
        private final CustomerRepository customerRepository;
        private final ModelMapper modelMapper;

    public CustomerServiceImpl(ValidationUtil validationUtil, CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCustomers(List<CustomerSeedDto> customerSeedDtos) {
        for (CustomerSeedDto dto : customerSeedDtos) {
            if (!this.validationUtil.isValid(dto)) {
                this.validationUtil.getViolations(dto).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                continue;
            }

            XMLGregorianCalendar xmlGregorianCalendar = dto.getBirthDate();

            LocalDate localDate = xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
            Customer customer = this.modelMapper.map(dto, Customer.class);
            customer.setDateOfBirth(localDate);


            System.out.println();
            if (this.customerRepository.findByName(customer.getName()) == null) {
                this.customerRepository.saveAndFlush(customer);
                System.out.println(
                        String.format("Customer with %s name successfully registered in the db!", customer.getName()));
            } else {
                System.out.println(String.format("Customer with %s name already exists!", customer.getName()));
            }
        }

    }
}
