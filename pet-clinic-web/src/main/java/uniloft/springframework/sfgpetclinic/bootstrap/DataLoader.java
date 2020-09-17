package uniloft.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uniloft.springframework.sfgpetclinic.model.Owner;
import uniloft.springframework.sfgpetclinic.model.PetType;
import uniloft.springframework.sfgpetclinic.model.Vet;
import uniloft.springframework.sfgpetclinic.services.OwnerService;
import uniloft.springframework.sfgpetclinic.services.PetTypeService;
import uniloft.springframework.sfgpetclinic.services.VetService;

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

        ownerService.save(owner1);

        var owner2 = new Owner();
        owner2.setFirstName("Fionna");
        owner2.setLastName("Glenanne");

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
