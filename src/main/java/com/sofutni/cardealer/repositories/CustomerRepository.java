package com.sofutni.cardealer.repositories;

import com.sofutni.cardealer.entitiess.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByName(String name);

}
