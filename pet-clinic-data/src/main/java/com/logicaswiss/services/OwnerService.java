package com.logicaswiss.services;

import com.logicaswiss.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}