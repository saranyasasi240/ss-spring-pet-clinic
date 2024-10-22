package com.logicaswiss.repositories;

import com.logicaswiss.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
