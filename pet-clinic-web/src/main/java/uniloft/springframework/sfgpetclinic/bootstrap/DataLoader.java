package uniloft.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uniloft.springframework.sfgpetclinic.model.*;
import uniloft.springframework.sfgpetclinic.services.OwnerService;
import uniloft.springframework.sfgpetclinic.services.PetTypeService;
import uniloft.springframework.sfgpetclinic.services.SpecialtyService;
import uniloft.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        var dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType =  petTypeService.save(dog);

        var cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType =  petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty savedSurgery = specialtyService.save(surgery);
        Specialty savedDentistry = specialtyService.save(dentistry);

        var owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Wetson");
        owner1.setAddress("123 Bickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        var owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Bickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123");

        Pet fionnasPet = new Pet();
        fionnasPet.setName("Just cat");
        fionnasPet.setOwner(owner2);
        fionnasPet.setBirthDate(LocalDate.now());
        fionnasPet.setPetType(savedCatPetType);
        owner2.getPets().add(fionnasPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        var vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        var vet2 = new Vet();
        vet2.setFirstName("Sammie");
        vet2.setLastName("Axie");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
