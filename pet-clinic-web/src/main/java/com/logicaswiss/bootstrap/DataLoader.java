package com.logicaswiss.bootstrap;

import com.logicaswiss.model.Owner;
import com.logicaswiss.model.PetType;
import com.logicaswiss.model.Speciality;
import com.logicaswiss.model.Vet;
import com.logicaswiss.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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
        vet.getSpecialities().add(savedRadiology);

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Anu");
        vet1.setLastName("Daniel");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);
        System.out.println("Loaded Vets.....");
    }
}
