package com.logicaswiss.bootstrap;

import com.logicaswiss.model.Owner;
import com.logicaswiss.model.Vet;
import com.logicaswiss.services.OwnerService;
import com.logicaswiss.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("John");
        owner.setLastName("Doe");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Alex");
        owner1.setLastName("Doe");

        ownerService.save(owner1);

        System.out.println("Loaded Owners.....");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Prasad");
        vet.setLastName("P S");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Anu");
        vet1.setLastName("Daniel");

        vetService.save(vet1);
        System.out.println("Loaded Vets.....");
    }
}
