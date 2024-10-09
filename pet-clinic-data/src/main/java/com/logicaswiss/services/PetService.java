package com.logicaswiss.services;

import com.logicaswiss.model.Owner;
import com.logicaswiss.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
