package com.sofutni.cardealer.controllers;

import com.sofutni.cardealer.Dtos.*;
import com.sofutni.cardealer.services.CarService;
import com.sofutni.cardealer.services.CustomerService;
import com.sofutni.cardealer.services.PartService;
import com.sofutni.cardealer.services.SupplierService;
import com.sofutni.cardealer.utils.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

import static com.sofutni.cardealer.constants.GlobalConstants.*;

@Component
public class AppController implements CommandLineRunner {
    private final SupplierService supplierService;
    private final XmlUtil xmlUtil;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;

    @Autowired
    public AppController(SupplierService supplierService, XmlUtil xmlUtil, PartService partService, CarService carService, CustomerService customer) {
        this.supplierService = supplierService;
        this.xmlUtil = xmlUtil;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customer;
    }


    @Override
    public void run(String... args) throws Exception {


//        try {
//            this.seedSuppliers();
//        }catch (JAXBException | FileNotFoundException ex){
//            System.out.println("Something went wrong when trying to seed the Suppliers!");
//        }
//
//        try {
//            this.seedParts();
//        }catch (JAXBException | FileNotFoundException ex){
//            System.out.println("Something went wrong when trying to seed the Parts!");
//        }
//
//
//        try {
//            this.seedCars();
//        }catch (JAXBException | FileNotFoundException ex){
//            System.out.println("Something went wrong when trying to seed the Cars!");
//        }

        try {
            this.seedCustomers();
        }catch (JAXBException | FileNotFoundException ex){
            System.out.println("Something went wrong when trying to seed the Customers!");
        }



    }

    private void seedCustomers() throws JAXBException, FileNotFoundException {
        CustomerSeedRootDto customerSeedRootDto
                = this.xmlUtil.unmarshalFromFile(CUSTOMERS_FILE_PATH, CustomerSeedRootDto.class);

            this.customerService.seedCustomers(customerSeedRootDto.getCustomerSeedDtoList());


    }

    private void seedCars() throws JAXBException, FileNotFoundException {
        CarsSeedRootDto carsSeedRootDto =
        this.xmlUtil.unmarshalFromFile(CARS_FILE_PATH,CarsSeedRootDto.class);

        this.carService.seedCars(carsSeedRootDto.getCarsSeedDtoList());

    }

    private void seedParts() throws JAXBException, FileNotFoundException {
        PartSeedRootDto partSeedRootDto =
                this.xmlUtil.unmarshalFromFile(PARTS_FILE_PATH,PartSeedRootDto.class);

        List<PartSeedDto> partsSeedDtos = partSeedRootDto.getPartsSeedDtos();
        this.partService.seedParts(partsSeedDtos);

    }

    private void seedSuppliers() throws JAXBException, FileNotFoundException {

        SupplierSeedRootDto supplierSeedRootDto = this.xmlUtil.
                unmarshalFromFile(SUPPLIERS_FILE_PATH,SupplierSeedRootDto.class);

        List<SupplierSeedDto> supplierSeedDtoList = supplierSeedRootDto.getSupplierSeedDtoList();

        this.supplierService.seed(supplierSeedDtoList);


    }
}
