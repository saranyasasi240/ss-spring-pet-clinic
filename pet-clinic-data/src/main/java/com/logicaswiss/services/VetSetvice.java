package com.logicaswiss.services;

import com.logicaswiss.model.Owner;
import com.logicaswiss.model.Vet;

import java.util.Set;

public interface VetSetvice {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
