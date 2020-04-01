package com.sofutni.cardealer.repositories;

import com.sofutni.cardealer.entitiess.Car;
import com.sofutni.cardealer.entitiess.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
   Car findById(long id);
   Car findByMakeAndModelAndTravelledDistance(String make,String model, Long travalledDistance);
}
