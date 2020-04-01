package com.sofutni.cardealer.services;

import com.sofutni.cardealer.Dtos.CarsSeedDto;
import com.sofutni.cardealer.entitiess.Car;
import com.sofutni.cardealer.repositories.CarRepository;
import com.sofutni.cardealer.utils.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {
    private final ValidationUtil validationUtil;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Random random;
    private final PartService partService;
    @Autowired
    public CarServiceImpl(ValidationUtil validationUtil, CarRepository carRepository, ModelMapper modelMapper, Random random, PartService partService) {
        this.validationUtil = validationUtil;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.random = random;
        this.partService = partService;
    }

    @Override
    public void seedCars(List<CarsSeedDto> carsSeedDtoList) {
        for (CarsSeedDto dto : carsSeedDtoList) {
            if (!this.validationUtil.isValid(dto)) {
                this.validationUtil.getViolations(dto).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
                continue;
            }
            Car car = this.modelMapper.map(dto, Car.class);
           long distance = dto.getDistance();
            car.setTravelledDistance(distance);
            int randomNumberOfParts = random.nextInt(10) + 10;

            car.setParts(this.partService.getRandomNumberParts(randomNumberOfParts));


            if (this.carRepository.findByMakeAndModelAndTravelledDistance(car.getMake(),car.getModel(),car.getTravelledDistance()) == null){
                this.carRepository.saveAndFlush(car);
                System.out.println(
                        String.format("Car with %s make, %s model and travelledDistance - %s is successfully registered in the db!"
                                , car.getMake(),car.getModel(), car.getTravelledDistance()));
            }else {
                System.out.println(String.format("Car with %s make, %s model and travelledDistance - " +
                        "%s ALREADY EXISTS in the db!",car.getMake(),car.getModel(), car.getTravelledDistance()));
            }


            }
        }


    }

