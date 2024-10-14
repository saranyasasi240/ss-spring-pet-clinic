package com.logicaswiss.bootstrap;

import com.logicaswiss.model.Owner;
import com.logicaswiss.model.PetType;
import com.logicaswiss.model.Vet;
import com.logicaswiss.services.OwnerService;
import com.logicaswiss.services.PetService;
import com.logicaswiss.services.PetTypeService;
import com.logicaswiss.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("John");
        owner.setLastName("Doe");

        ownerService.save(owner);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alex");
        owner1.setLastName("Manual");

        ownerService.save(owner1);

        System.out.println("Loaded Owners.....");

        Vet vet = new Vet();
        vet.setFirstName("Prasad");
        vet.setLastName("P S");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Anu");
        vet1.setLastName("Daniel");

        vetService.save(vet1);
        System.out.println("Loaded Vets.....");
    }
}
