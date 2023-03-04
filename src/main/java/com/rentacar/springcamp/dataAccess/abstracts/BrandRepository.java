package com.rentacar.springcamp.dataAccess.abstracts;

import com.rentacar.springcamp.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer > {
    boolean existsByName(String name);

    Brand findByName(String name);
}
