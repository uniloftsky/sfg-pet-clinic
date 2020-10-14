package uniloft.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.sfgpetclinic.model.Owner;
import uniloft.springframework.sfgpetclinic.model.PetType;
import uniloft.springframework.sfgpetclinic.services.OwnerService;
import uniloft.springframework.sfgpetclinic.services.PetService;
import uniloft.springframework.sfgpetclinic.services.PetTypeService;

import java.util.Collection;

@Controller
@RequestMapping("owners/{owner_id}")
public class PetController {

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable String owner_id) {
        return ownerService.findById(Long.valueOf(owner_id));
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}
