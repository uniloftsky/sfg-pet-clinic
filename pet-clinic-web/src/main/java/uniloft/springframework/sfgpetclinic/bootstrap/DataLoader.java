package uniloft.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uniloft.springframework.sfgpetclinic.model.Owner;
import uniloft.springframework.sfgpetclinic.model.Pet;
import uniloft.springframework.sfgpetclinic.model.PetType;
import uniloft.springframework.sfgpetclinic.model.Vet;
import uniloft.springframework.sfgpetclinic.services.OwnerService;
import uniloft.springframework.sfgpetclinic.services.PetTypeService;
import uniloft.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

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

        var dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType =  petTypeService.save(dog);

        var cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType =  petTypeService.save(cat);

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

        vetService.save(vet1);

        var vet2 = new Vet();
        vet2.setFirstName("Sammie");
        vet2.setLastName("Axie");

        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
