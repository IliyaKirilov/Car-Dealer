package com.sofutni.cardealer.repositories;

import com.sofutni.cardealer.entitiess.Part;
import com.sofutni.cardealer.entitiess.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartRepository extends JpaRepository<Part,Long> {
    Part findByName(String name);
    Part findById(long id);
}
