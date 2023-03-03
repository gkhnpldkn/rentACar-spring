package com.rentacar.springcamp.dataAccess.abstracts;

import com.rentacar.springcamp.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
