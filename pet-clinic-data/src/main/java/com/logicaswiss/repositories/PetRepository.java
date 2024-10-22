package com.logicaswiss.repositories;

import com.logicaswiss.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
