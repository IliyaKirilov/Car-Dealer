package com.sofutni.cardealer.repositories;

import com.sofutni.cardealer.entitiess.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Supplier findByName(String name);
    Supplier findById(long id);

}
